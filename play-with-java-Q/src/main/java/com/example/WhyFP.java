package com.example;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class Apple {
    private int weight;
    private String color;

    public Apple(int weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                ", color='" + color + '\'' +
                '}';
    }
}


public class WhyFP {
    public static void main(String[] args) {

        List<Apple> inventory = List.of(
                new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red")
        );

        // Req-1: Filter green apples
        System.out.println(
                filterApples(inventory, apple -> "green".equals(apple.getColor()))
        );

        // Req-2: Filter red apples
        System.out.println(
                filterApples(inventory, apple -> "red".equals(apple.getColor())));


    }

    // Req-1: Filter by color
    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

}


// Behavior parameterization
