package com.debuggeando_ideas.temp;


public class LambdaApp {

    public static void main( String[] args ) {
        Math substract = new Math( ) {
            @Override
            public Double execute( Double a,
                                   Double b ) {
                return a - b;
            }
        };

        Math multiplication = (a, b) -> a * b;

        Math divide = (a, b) -> {
            System.out.println( "a: " + a  + ", b: " + b );
            return a / b;
        };

    }

}
