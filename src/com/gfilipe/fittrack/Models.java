package com.gfilipe.fittrack;

import java.util.List;

public class Models {

    public static class Exercise {
        public final String name;
        public final String detail;

        public Exercise(String name, String detail) {
            this.name = name;
            this.detail = detail;
        }
    }

    public static class WorkoutDay {
        public final String id;
        public final String title;
        public final String subtitle;
        public final List<Exercise> exercises;

        public WorkoutDay(String id, String title, String subtitle, List<Exercise> exercises) {
            this.id = id;
            this.title = title;
            this.subtitle = subtitle;
            this.exercises = exercises;
        }
    }

    public static class MealOption {
        public final String id;
        public final String name;
        public final List<String> ingredients;
        public final String prep;
        public final String note;

        public MealOption(String id, String name, List<String> ingredients, String prep, String note) {
            this.id = id;
            this.name = name;
            this.ingredients = ingredients;
            this.prep = prep;
            this.note = note;
        }

        public MealOption(String id, String name) {
            this(id, name, null, null, null);
        }

        public MealOption(String id, String name, List<String> ingredients) {
            this(id, name, ingredients, null, null);
        }
    }

    public static class MealSlot {
        public final String id;
        public final String title;
        public final String note;
        public final List<MealOption> options;

        public MealSlot(String id, String title, String note, List<MealOption> options) {
            this.id = id;
            this.title = title;
            this.note = note;
            this.options = options;
        }

        public MealSlot(String id, String title, List<MealOption> options) {
            this(id, title, null, options);
        }
    }

    public static class Recipe {
        public final String id;
        public final String title;
        public final String source;
        public final List<String> ingredients;
        public final String prep;

        public Recipe(String id, String title, String source, List<String> ingredients, String prep) {
            this.id = id;
            this.title = title;
            this.source = source;
            this.ingredients = ingredients;
            this.prep = prep;
        }

        public Recipe(String id, String title, List<String> ingredients, String prep) {
            this(id, title, null, ingredients, prep);
        }
    }

    public static class InfoItem {
        public final String id;
        public final String title;
        public final String text;

        public InfoItem(String id, String title, String text) {
            this.id = id;
            this.title = title;
            this.text = text;
        }
    }
}
