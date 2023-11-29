package com.debuggeando_ideas.util_function;

import java.util.function.BiPredicate;

public class ExampleBiPredicate {

    static BiPredicate<String, String> myEquals = (s1, s2) -> s1.concat(s2).equals("HelloWorld");

    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "World";

        System.out.println(myEquals.test(str1, str2));
    }
}
