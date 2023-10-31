package com.debuggeando_ideas.util_function;

import java.io.*;
import java.util.Arrays;
import java.util.function.Function;

public class ExampleFunction2 {

    static Function<Person, ByteArrayOutputStream> serializer = person -> {
        ByteArrayOutputStream inMemoryBytes = new ByteArrayOutputStream(  );

        try (ObjectOutputStream outputStream = new ObjectOutputStream( inMemoryBytes )) {
            outputStream.writeObject( person );
            outputStream.flush();
        } catch (IOException e) {
            System.err.println( e.getMessage() );
            throw new RuntimeException( e );
        }
        return inMemoryBytes;
    };

    static Function<ByteArrayInputStream, Person> deserializer = bytes -> {
        try (ObjectInputStream inputStream = new ObjectInputStream( bytes )) {
            return (Person) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println( e.getMessage() );
            throw new RuntimeException( e );
        }
    };

    public static void main( String[] args ) {
        ByteArrayOutputStream serializedObject = serializer.apply( new Person( "Diego", 31 ) );
        System.out.println( Arrays.toString( serializedObject.toByteArray()) );
        Person deserializedObject = deserializer.apply( new ByteArrayInputStream( serializedObject.toByteArray( ) ) );
        System.out.println( deserializedObject );
    }
}
