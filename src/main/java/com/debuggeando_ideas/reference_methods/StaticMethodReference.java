package com.debuggeando_ideas.reference_methods;

import java.util.UUID;
import java.util.function.Supplier;

public class StaticMethodReference {

    public static void main( String[] args ) {
        System.out.println( UUID.randomUUID().toString() );
//        Supplier<UUID> getToken = () -> UUID.randomUUID();
        Supplier<UUID> getToken = UUID::randomUUID;
        System.out.println( getToken.get() );
    }

}
