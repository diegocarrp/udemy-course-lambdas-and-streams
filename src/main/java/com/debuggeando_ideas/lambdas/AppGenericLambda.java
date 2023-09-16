package com.debuggeando_ideas.lambdas;

import com.debuggeando_ideas.fundamentals.Product;

public class AppGenericLambda {

    public static void main( String[] args ) {
        Printer<String> stringPrinter = string -> System.out.println( string );
        Printer<Product> productPrinter = product -> System.out.println( product.toString() );

        stringPrinter.print("Hola mundo!");

        Product myProduct = new Product();
        myProduct.setId( 1L );
        myProduct.setName( "gato" );
        myProduct.setPrice( 1000.0 );

        productPrinter.print( myProduct );

    }

}
