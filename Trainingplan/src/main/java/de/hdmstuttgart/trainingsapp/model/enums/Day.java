package de.hdmstuttgart.trainingsapp.src.model.enums;

import java.util.stream.Stream;

/**
 * enum mit dem Namen "Day", der die Wochentage repräsentiert
 */
public enum Day{

    MONDAY("monday"),
    TUESDAY("tuesday"),
    WEDNESDAY("wednesday"),
    THURSDAY("thursday"),
    FRIDAY("friday"),
    SATURDAY("saturday"),
    SUNDAY("sunday");

    public final String value;

    public String getValue(){
        String s = value;
        return s;
    }

    /**
     * Stream aus Array welcher Enumkonstanten beinhaltet, wird erstellt. Dann werden die Enumkonstanten mit map() auf ihre Werte
     * abgebildet, welche den neuen Stream bilden. Diese werden dann in einem String-Array gespeichert.
     * Aus zeitlichen Gründen wird die methode noch nicht eingebunden.
     *
     * @return String-Array mit allen Values der Konstanten
     */
    public static String[] getValueArr() {
        return Stream.of(Day.values()).map(Day::getValue).toArray(String[]::new);
    }


    Day(String day){
         value = day;
    }


}
