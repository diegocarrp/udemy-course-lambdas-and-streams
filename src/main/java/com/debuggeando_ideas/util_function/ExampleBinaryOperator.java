package com.debuggeando_ideas.util_function;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class ExampleBinaryOperator {

    public static void main(String[] args) {
        BiFunction<String, String, String> normalizerFunc = (a, b) -> a.toUpperCase().concat("-").concat(b.toLowerCase());
        System.out.println(normalizerFunc.apply("hello", "WORLD"));

        BinaryOperator<String> normalizerOper = (a, b) -> a.toUpperCase().concat("-").concat(b.toLowerCase());
        System.out.println(normalizerOper.apply("hello", "WORLD"));
    }


}
