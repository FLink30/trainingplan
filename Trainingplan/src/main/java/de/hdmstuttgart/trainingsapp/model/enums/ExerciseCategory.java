package de.hdmstuttgart.trainingsapp.src.model.enums;

/**
 * repräsentiert die Kategorien der Übungen
 */

public enum ExerciseCategory {
    CARDIO("Cardio"),
    STRENGTH("Strength"),
    STRETCHING("Stretching");


    final String value;

    public String getValue(){
        String s = value;
        return s;
    }


    ExerciseCategory(String value){
        this.value = value;
    }

}
