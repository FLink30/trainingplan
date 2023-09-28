package de.hdmstuttgart.trainingsapp.src.model.enums;

import java.util.stream.Stream;

/**
 * repräsentiert verschiedene Muskelgruppen
 */
public enum Muscle {
    TRICEPS("Triceps"),
    BICEPS("Biceps"),
    ABS("Abs"),
    CHEST("Chest"),
    TRAPS("Traps"),
    DELTOIDS("Deltoids"),
    LATISSIMUS("Latissimus"),
    OBLIQUES("Obliques"),
    HAMSTRINGS("Hamstrings"),
    QUADRICEPS("Quadriceps"),
    FULLBODY("Fullbody"),
    HEART("Heart");


    final String value;

    public String getValue(){
        String s = value;
        return s;
    }

    /**
     * Stream aus Array welcher Enumkonstanten beinhaltet, wird erstellt. Dann werden die Enumkonstanten mit map() auf ihre Werte
     * abgebildet, welche den neuen Stream bilden. Diese werden dann in einem String-Array gespeichert.
     *
     * @return String-Array mit allen Values der Konstanten
     */
    public static String[] getValueArr() {
        return Stream.of(Muscle.values()).map(Muscle::getValue).toArray(String[]::new);
    }

    Muscle(String muscle) {
        value = muscle;
    }



}





