package com.debuggeando_ideas.streams;

import com.debuggeando_ideas.util.Database;
import com.debuggeando_ideas.util.Videogame;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamFinalOperators {

    public static void main(String[] args) {
        Stream<Videogame> videogames = Database.videogames.stream();
        countOperator(videogames);
        forEach(videogames);
        anyMatch(videogames);
        allMatch(videogames);
        noneMatch(videogames);
        findFirst(videogames);
        findAny(videogames);
        reduce(videogames);
        min(videogames);
        max(videogames);
    }

    static void countOperator(Stream<Videogame> stream) {
        System.out.println(stream.count());
    }

    static void forEach(Stream<Videogame> stream) {
        stream.forEach(System.out::println);
    }

    static void anyMatch(Stream<Videogame> stream) {
        boolean result = stream.anyMatch(v -> v.getTotalSold() > 1_000_000);
        System.out.println(result);
    }

    static void allMatch(Stream<Videogame> stream) {
        boolean result = stream.allMatch(v -> v.getTotalSold() > 1);
        System.out.println(result);
    }

    static void noneMatch(Stream<Videogame> stream) {
        boolean result = stream.noneMatch(v -> v.getReviews().isEmpty());
        System.out.println(result);
    }

    static void findFirst(Stream<Videogame> stream) {
        Optional<Videogame> videogame = stream.findFirst();
        System.out.println(videogame);
    }

    static void findAny(Stream<Videogame> stream) {
        Optional<Videogame> videogame = stream.findAny();
        System.out.println(videogame);
    }

    static void reduce(Stream<Videogame> stream) {
        Optional<Integer> r = stream
                .filter(Videogame::getIsDiscount)
                .map(Videogame::getTotalSold)
                .reduce(Integer::sum);
        System.out.println(r);
    }

    static void max(Stream<Videogame> stream) {
//        Optional<Videogame> r = stream.max((a, b) -> a.getName().compareTo(b.getName()));
        Optional<Videogame> r = stream.max(Comparator.comparing(Videogame::getName));
        System.out.println(r.get().getName());
    }

    static void min(Stream<Videogame> stream) {
//        Optional<Videogame> r = stream.min((a, b) -> a.getName().compareTo(b.getName()));
        Optional<Videogame> r = stream.min(Comparator.comparing(Videogame::getName));
        System.out.println(r.get().getName());
    }
}
