package de.hdmstuttgart.trainingsapp.src.model.enums;

import java.util.stream.Stream;

/**
 * repräsentiert die Geschlechter
 */
public enum Sex {
    MALE("Male"),
    FEMALE("Female"),
    DIVERS("Divers");

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
        return Stream.of(Sex.values()).map(Sex::getValue).toArray(String[]::new);
    }

    Sex(String sex) {value = sex;}
}
