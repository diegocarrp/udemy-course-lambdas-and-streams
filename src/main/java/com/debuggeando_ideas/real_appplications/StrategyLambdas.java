package com.debuggeando_ideas.real_appplications;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.Arrays;

public class StrategyLambdas {

    public static void main( String[] args ) {
        var product1 = Product.builder()
                .id( 1L )
                .name( "Bear" )
                .price( 150.0 )
                .userType( UserType.BASIC )
                .build();
        var product2 = Product.builder()
                .id( 1L )
                .name( "Bear" )
                .price( 150.0 )
                .userType( UserType.PLUS )
                .build();
        var product3 = Product.builder()
                .id( 1L )
                .name( "Bear" )
                .price( 150.0 )
                .userType( UserType.PRIME )
                .build();
        var products = Arrays.asList( product1, product2, product3 );

        products.forEach( product -> {
            switch (product.getUserType()) {
                case BASIC -> product.setDiscountStrategy( Strategies.basicDiscount );
                case PLUS -> product.setDiscountStrategy( Strategies.plusDiscount );
                case PRIME -> product.setDiscountStrategy( Strategies.primeDiscount );
            }
        } );

        products.forEach( product -> {
            System.out.println( "Price: " + product.getPrice()
                    + ", UserType: " + product.getUserType()
                    + ", Discount: " + product.getDiscountStrategy().get( product.getPrice( )));
        } );
    }
}

@FunctionalInterface
interface ApplyDiscountStrategy {
    Double get( Double price );
}

enum UserType{
    BASIC, PLUS, PRIME
}

class Strategies {
    static ApplyDiscountStrategy basicDiscount = p -> p * 0.02;
    static ApplyDiscountStrategy plusDiscount = p -> p * 0.05;
    static ApplyDiscountStrategy primeDiscount = p -> p * 0.1;
}

@Data
@ToString
@Builder
class Product {
    private Long id;
    private UserType userType;
    private String name;
    private Double price;
    private ApplyDiscountStrategy discountStrategy;
}