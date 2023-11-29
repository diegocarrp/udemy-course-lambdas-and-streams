package com.debuggeando_ideas.streams;

import com.debuggeando_ideas.util.Database;
import com.debuggeando_ideas.util.Videogame;

import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class ConstructorsStream {

    public static void main(String[] args) {
        Stream<Videogame> games = Database.videogames.stream();
        games.forEach(System.out::println);

        System.out.println("----------------");

        Integer[] myArray = {1, 2, 3, 4, 5};
        Stream<Integer> intStream = Arrays.stream(myArray);
        intStream.forEach(System.out::println);

        System.out.println("----------------");

        Stream.of("Hola", "Mundo").forEach(System.out::println);

        System.out.println("----------------");

        DoubleStream myDoubleStream = DoubleStream.of(20.3, 11.6);
        myDoubleStream.forEach(System.out::println);
    }

}
