package com.debuggeando_ideas.streams;

import com.debuggeando_ideas.util.BasicVideogame;
import com.debuggeando_ideas.util.Database;
import com.debuggeando_ideas.util.Videogame;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamIntermediateOperators {

    public static void main( String[] args ) {
        Stream<Videogame> videogames = Database.videogames.stream( );

//        distinctOperator( videogames );
//        limitOperator( videogames );
//        skipOperator( videogames );
//        filterOperator( videogames );
//        mapOperator(videogames);
//        flatMapOperator(videogames);
//        peekOperator(videogames);
        sortOperator(videogames);
    }

    private static void dropWhileOperator(Stream<Videogame> stream) {
        List<Videogame> sortedList = stream
                .sorted( Comparator.comparing( Videogame::getName ) )
                .dropWhile( v -> !v.getName( ).startsWith( "M" ) )
                .toList( );

        sortedList.forEach( System.out::println );
    }

    private static void takeWhileOperator(Stream<Videogame> stream) {
        List<Videogame> sortedList = stream
                .sorted( Comparator.comparing( Videogame::getName ) )
                .takeWhile( v -> !v.getName( ).startsWith( "M" ) )
                .toList( );

        sortedList.forEach( System.out::println );
    }

    private static void sortOperator( Stream<Videogame> stream ) {
        List<Videogame> sorted = stream.sorted( Comparator.comparingInt( v -> v.getReviews( ).size( ) ) ).toList();
        sorted.forEach( System.out::println );
    }

    private static void peekOperator( Stream<Videogame> stream ) {
        stream.peek( v -> v.setName( "" ) ).forEach( System.out::println );
    }

    private static void flatMapOperator( Stream<Videogame> stream ) {
        var result = stream.flatMap( v -> v.getReviews().stream() ).toList();
        System.out.println( result );
    }

    private static void mapOperator( Stream<Videogame> stream ) {
        List<BasicVideogame> result = stream.map( v -> BasicVideogame.builder( )
                .name( v.getName( ) )
                .price( v.getPrice( ) )
                .console( v.getConsole( ) )
                .build( ) ).toList();
        result.forEach( System.out::println );

        List<String> titles = result.stream().map( BasicVideogame::getName ).toList();
        titles.forEach( System.out::println );
    }

    private static void filterOperator( Stream<Videogame> stream ) {
        List<Videogame> result = stream
                .filter( v -> v.getPrice( ) > 5.0 )
                .filter( v -> !v.getIsDiscount( ) )
                .filter( v -> v.getOfficialWebsite( ).contains( "forza" ) )
                .toList( );
        result.forEach( System.out::println );
    }

    private static void skipOperator( Stream<Videogame> stream ) {
        List<Videogame> result = stream.skip( 15 ).toList( );
        result.forEach( System.out::println );

    }

    private static void limitOperator( Stream<Videogame> stream ) {
//        List<Videogame> result = stream.limit( 5 ).collect( Collectors.toList( ) );
        List<Videogame> result = stream.limit( 5 ).toList( );
        result.forEach( System.out::println );
    }

    static void distinctOperator( Stream<Videogame> stream ) {
        System.out.println( stream.distinct( ).count( ) );
    }
}
