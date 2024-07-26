package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

class Product implements Comparable<Product> {
    int id;
    String name;
    double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String toString() {
        return "Id: " + id + ", Name: " + name + ", Price: " + price;
    }

    @Override
    public int compareTo(Product o) {
        return this.id - o.id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product product = (Product) obj;
        return id == product.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

}

public class Remove_Duplicate_Elements {
    public static void main(String[] args) {

        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4);
        //System.out.println("List with duplicates: " + list);
        List<Integer> listWithoutDuplicates = list.stream().distinct().toList();
        //System.out.println("List without duplicates: " + listWithoutDuplicates);


        List<Product> products = List.of(
                new Product(1, "Laptop", 50000),
                new Product(2, "Mobile", 20000),
                new Product(3, "Tablet", 10000),
                new Product(1, "Laptop", 50000),
                new Product(2, "Mobile", 20000)
        );
        //System.out.println("Products with duplicates: " + products);
        List<Product> productsWithoutDuplicates = products.stream().distinct().toList();
        //System.out.println("Products without duplicates: " + productsWithoutDuplicates);

        productsWithoutDuplicates
                .forEach(System.out::println);


        //--------------------------------------------------
        // remove duplicates from list of integers
        //--------------------------------------------------

        List<Integer> numberList=new ArrayList<>();
        numberList.add(1);
        numberList.add(2);
        numberList.add(2);
        numberList.add(1);

        Set<Integer> set = Set.copyOf(numberList);
        System.out.println("Set: " + set);



    }
}
