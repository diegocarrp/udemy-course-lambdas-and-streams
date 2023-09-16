package com.debuggeando_ideas.reference_methods;

import java.util.Random;
import java.util.UUID;
import java.util.function.Supplier;

public class ConstructorMethodReference {

    public static void main( String[] args ) {
//        Supplier<MyObject> getObject = () -> new MyObject();
        Supplier<MyObject> getObject = MyObject::new;
        System.out.println( getObject.get() );

    }

}