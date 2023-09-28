package de.hdmstuttgart.trainingsapp.src.model;

import de.hdmstuttgart.trainingsapp.src.model.enums.Muscle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Objects;

/**
 * abstrakte Klasse mit dem Namen "Exercise", die Klassen Cardio, Strength und Stretching beschreibt.
 **/
public abstract class Exercise {

    private static final Logger log = LogManager.getLogger(Exercise.class);

    private String exName;
    private int exSet;
    private Muscle exMuscle;


    public Exercise(String exName, int exSet, Muscle exMuscle) {
        this.exName = exName;
        this.exSet = exSet;
        this.exMuscle = exMuscle;
        log.info("Exercise " + getClass().getSimpleName() + " " + exName + " created");
    }

    /**
     * Methoden für die Rückgabe der Anzahl der Sätze (getSets()),
     * den Muskel der bei der Übung belastet wird (getReps()) und den Namen des Trainings (getExName())
     **/

    /**
     * gibt ein String der Variabel zurück, damit es in Tableview durch ObservableList ausgegeben werden kann
     */
    public String getExName() {
        String exName = this.exName;
        log.info("Returned exName: " + exName);
        return exName;
    }
    public String getExMuscle() {
        String exMuscle = this.exMuscle.getValue();
        log.info("Returned exMuscle: " + exMuscle);
        return exMuscle;
    }
    public int getExSet() {
        int exSet = this.exSet;
        log.info("Returned exSet: " + exSet);
        return exSet;
    }

    public void setExName(String exName) {
        this.exName = exName;
        log.info("exName set: " +  exName);
    }
    public void setExSet(int exSet) {
        this.exSet = exSet;
        log.info("exSet set: " +exSet);
    }
    public void setExMuscle(Muscle exMuscle) {
        this.exMuscle = exMuscle;
        log.info("exMuscle set: " + exMuscle);
    }

    /**
     * überprüft, ob das Objekt bereits existiert. Damit eine Übung nur ein Mal vorkommt.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exercise exercise = (Exercise) o;
        return exSet == exercise.exSet && Objects.equals(exName, exercise.exName) && exMuscle == exercise.exMuscle;
    }

    @Override
    public int hashCode() {
        return Objects.hash(exName, exSet, exMuscle);
    }
}
