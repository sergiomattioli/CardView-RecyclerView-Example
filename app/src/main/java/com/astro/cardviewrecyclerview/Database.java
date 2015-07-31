package com.astro.cardviewrecyclerview;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergio Mattioli on 30/07/2015.
 */
public class Database {

    /**
     * An array of sample (dummy) items.
     */
    public static List<Person> PERSONS = new ArrayList<Person>();

    static {
        // Add 3 sample items.
        addItem(new Person("Emma Wilson", "23 years old", R.drawable.emma));
        addItem(new Person("Lavery Maiss", "25 years old", R.drawable.lavery));
        addItem(new Person("Lillie Watts", "35 years old", R.drawable.lillie));
    }

    private static void addItem(Person item) {
        PERSONS.add(item);
    }

    public static class Person {

        private String name;
        private String age;
        private int photoId;

        public Person(String name, String age, int photoId) {
            this.name = name;
            this.age = age;
            this.photoId = photoId;
        }

        public String getName() {
            return name;
        }

        public String getAge() {
            return age;
        }

        public int getPhotoId() {
            return photoId;
        }


        @Override
        public String toString() {
            return name;
        }
    }
}

