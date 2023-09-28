package de.hdmstuttgart.trainingsapp.src.model;

import de.hdmstuttgart.trainingsapp.src.model.enums.Muscle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Strength extends Exercise{
//Logger
        private static final Logger log = LogManager.getLogger(Strength.class);
        private int exReps;

    public Strength(String exName, int exSet, int exReps, Muscle exMuscle) {
        super(exName, exSet, exMuscle);
        this.exReps = exReps;

    }


    /**
     * Methoden für die Rückgabe der Anzahl der Wiederholungen getReps()
     **/

    /**
     * gibt ein String der Variabel exReps zurück, damit es in Tableview durch ObservableList ausgegeben werden kann
     */
    public String getExReps() {
        String exReps = Integer.toString(this.exReps) + " Reps";
        log.info("Returned exReps: " + exReps);
        return exReps;
    }

        private void setReps(int exReps){
        this.exReps = exReps;
        log.info("exReps set: " + exReps);
    }

    }

