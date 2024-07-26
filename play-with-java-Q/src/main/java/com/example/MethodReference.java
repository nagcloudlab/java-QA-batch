package com.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class FoodUtil {
    public static boolean isVeg(String food) {
        return food.equals("veg");
    }

}

public class MethodReference {
    public static void main(String[] args) {

//        List<String> menu = new ArrayList<>();
//        menu.add("veg");
//        menu.add("non-veg");
//        menu.add("veg");
//        menu.add("non-veg");
//        menu.add("veg");
//        menu.add("non-veg");
//
//
//        // remove all on veg items from the menu
////        menu.removeIf(menuItem -> FoodUtil.isVeg(menuItem));
//        menu.removeIf(FoodUtil::isVeg); // using existing method as function / LE
//        System.out.println(menu);
//
//
//        // ---
//
//        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
//        numbers.forEach(n -> System.out.println(n));
//        numbers.forEach(System.out::println);
//
//
//        List<String> names = List.of("jhon", "jane", "doe", "alice", "bob");
//        List sortedNames = names.stream()
////                .sorted()
////                .sorted((name1, name2) -> name2.compareTo(name1))
//                .sorted(NameComparator::compare)
//                .collect(Collectors.toList());
//
//        System.out.println(sortedNames);


        //--------------------------------------------


//        List<String> names = List.of("jhon", "doe", "alice", "bob");
//
//        System.out.println(
//                names.stream()
////                        .map(name->name.toUpperCase())
////                        .map(String::toUpperCase)
//                        .collect(Collectors.toList())
//        );


        List<String> names = List.of("123", "456", "789", "101112");

        System.out.println(
                names.stream()
//                        .map(s->Integer.parseInt(s))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList())

        );


        List<String> employeeNames = List.of("jhon", "doe", "alice", "bob");

        List<Employee> employees = employeeNames.stream()
//                .map(name -> new Employee(name)
                .map(Employee::new)
                .collect(Collectors.toList());


        List<Integer> salaries = List.of(1000, 2000, 3000, 4000);

        salaries
                .stream()
                //.reduce((total, salary) -> total + salary)
                .reduce(Integer::sum)
                .ifPresent(System.out::println);
    }
}


class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Employee(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';

    }
}


class NameComparator {
    public static int compare(String name1, String name2) {
        return name2.compareTo(name1);
    }
}