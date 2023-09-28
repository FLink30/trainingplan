package de.hdmstuttgart.trainingsapp.src.model.enums;

import java.util.stream.Stream;

/**
 * repräsentiert verschiedene Fitnessslevel
 */
public enum Fitnesslevel{
    BEGINNER("Beginner"),
    INTERMEDIATE("Intermediate"),
    ADVANCED("Advanced"),
    FITNESS_MONSTER("Fitness Monster"),
    GIGACHAD("Gigachad");

    final String value;
    public String getValue(){
        return value;
    }

    /**
     * Stream aus Array welcher Enumkonstanten beinhaltet, wird erstellt. Dann werden die Enumkonstanten mit map() auf ihre Werte
     * abgebildet, welche den neuen Stream bilden. Diese werden dann in einem String-Array gespeichert.
     *
     * @return String-Array mit allen Values der Konstanten
     */
    public static String[] getValueArr() {
        return Stream.of(Fitnesslevel.values()).map(Fitnesslevel::getValue).toArray(String[]::new);
    }


    Fitnesslevel(String fitnesslevel){value = fitnesslevel;}
}
