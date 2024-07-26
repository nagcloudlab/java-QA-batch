package com.example;

import java.util.List;

public class Map_vs_Flatmap {
    public static void main(String[] args) {


        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        // Map
        numbers
                .stream()
                .map(number -> number * 20)
                .forEach(System.out::println);


        // FlatMap
        numbers
                .stream()
                .flatMap(n->List.of(n,n*n,n*n*n).stream())
                .forEach(System.out::println);

//        Map vs FlatMap
        // Map: It transforms one value to another value.
        // FlatMap: It transforms one value to zero or more values.
    }
}
