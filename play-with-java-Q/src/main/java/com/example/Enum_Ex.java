package com.example;


enum Day {

    MONDAY("Monday"),
    TUESDAY("Tuesday"),
    WEDNESDAY("Wednesday"),
    THURSDAY("Thursday"),
    FRIDAY("Friday");

    private String displayName;

    Day(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }


}

public class Enum_Ex {
    public static void main(String[] args) {


        Day day = Day.MONDAY;
        System.out.println(day.getDisplayName());

        day = Day.TUESDAY;
        System.out.println(day.getDisplayName());

        day = Day.WEDNESDAY;
        System.out.println(day.getDisplayName());

        day = Day.THURSDAY;
        System.out.println(day.getDisplayName());

        day = Day.FRIDAY;
        System.out.println(day.getDisplayName());

    }
}
