package com.example;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Dish {

    private String name;
    private boolean vegetarian;
    private int calories;
    private Type type;

    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    public enum Type {MEAT, FISH, OTHER}

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }


}


public class WhyWeNeedStreamsApi {
    public static void main(String[] args) {

        List<Dish> menu = List.of(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH)
        );

        // find low-caloric dish's ( < 400 ) name , sorted by calories
        System.out.println(
                getLowCaloricDishesNamesV1(menu)
        );

        // java 1.8 => streams api -> to build data processing pipelines using declarative style
        // declarative style ( intention based programming )

        System.out.println(
                getLowCaloricDishesNamesV2(menu)
        );

    }

    // imperative style ( solving any problem by step by step )
    // intention + implementation mixed
    private static List<String> getLowCaloricDishesNamesV1(List<Dish> menu) {
        List<Dish> lowCaloricDishes = new ArrayList<>();
        for (Dish dish : menu) {
            if (dish.getCalories() < 400) {
                lowCaloricDishes.add(dish);
            }
        }
        lowCaloricDishes.sort(new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return Integer.compare(o1.getCalories(), o2.getCalories());
            }
        });
        List<String> lowCaloricDishesName = new ArrayList<>();
        for (Dish dish : lowCaloricDishes) {
            lowCaloricDishesName.add(dish.getName());
        }
        return lowCaloricDishesName;

    }

    private static List<String> getLowCaloricDishesNamesV2(List<Dish> menu) {
        return menu.stream()
                .parallel() // parallel stream, to process data in parallel
                .filter(dish -> dish.getCalories() < 400)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(Collectors.toList());
    }
}
