package de.hdmstuttgart.trainingsapp.src.model.enums;

import java.util.stream.Stream;
/**
 * repräsentiert verschiedene Ziele
 */
public enum Goal {
    STAY_HEALTHY("Stay healthy"),
    GAIN_MUSCLE("Gain muscle"),
    GET_RIPPED("Get ripped"),
    LOSE_WEIGHT("Lose weight"),
    GET_MORE_ENDURANCE("Get more endurance");

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
        return Stream.of(Goal.values()).map(Goal::getValue).toArray(String[]::new);
    }



    Goal(String goal){value = goal;}
}
