package de.hdmstuttgart.trainingsapp.src.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

import de.hdmstuttgart.trainingsapp.src.model.enums.Fitnesslevel;
import de.hdmstuttgart.trainingsapp.src.model.enums.Goal;
import de.hdmstuttgart.trainingsapp.src.model.enums.Sex;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Klasse mit dem Namen "Profile", die ein Profil einer Person darstellt.
 */
public class Profile {
    //logger
    private static final Logger log = LogManager.getLogger(Profile.class);
    private String name;
    private Goal goal;
    private Sex sex;
    private LocalDate dob;
    private Fitnesslevel fitnessLevel;


    public Profile(String name, Goal goal, Sex sex, Fitnesslevel fitnesslevel) {
        this.name = name;
        this.goal = goal;
        this.sex = sex;
        this.fitnessLevel = fitnesslevel;
        log.info("Profile " + name + " been created");

    }
    public Profile(String name, Goal goal, Sex sex, Fitnesslevel fitnesslevel, LocalDate dob) {
        this.name = name;
        this.goal = goal;
        this.sex = sex;
        this.fitnessLevel = fitnesslevel;
        this.dob = dob;
        log.info("Profile " + name + " been created");

    }

    public Profile(){
        log.info("Profile, which is null, been created");
    }




    public String getName(){
        log.info("Returned name: " +  name);
        return this.name;
    }
    private void setName(String name){
        this.name = name;
        log.info("Name set: " + name);
    }

    public Goal getGoal(){
        log.info("Returned goal: " + goal);
        return goal;
    }
    private void setGoal(Goal goal){
        this.goal = goal;
        log.info("Goal set: " + goal);
    }

    public Sex getSex(){
        log.info("Returned sex: " + sex);
        return this.sex;
    }
    private void setSex(Sex sex){
        this.sex = sex;
        log.info("Sex set: " + sex);
    }

    public LocalDate getDob(){
        log.info("Returned dob: " + dob);
        return this.dob;
    }
    private void setDob(LocalDate date){
        this.dob = date;
        log.info("Date set: " + date);
    }

    public Fitnesslevel getFitnessLevel(){
        log.info("Returned fitnesslevel: " + fitnessLevel);
        return this.fitnessLevel;
    }
    private void setFitnessLevel(Fitnesslevel fitnessLevel){
        this.fitnessLevel = fitnessLevel;
        log.info("fitnesslevel set: " + fitnessLevel);
    }

    /**
     * Die Methode berechnet das Alter der Person basierend auf dem Geburtsdatum,
     * das in der Variable "dob" gespeichert ist. Es verwendet die Klasse "LocalDate"
     * um das aktuelle Datum zu bekommen und die Methode "Period.between" um den Unterschied
     * zwischen Geburtsdatum und aktuellem Datum zu erhalten.
     */
    public int calculateAge(){
        LocalDate curDate = LocalDate.now();
        if ((this.dob != null))
        {
            log.info("Age calculated");
            return Period.between(this.dob, curDate).getYears();
        }
        else
        {
            log.error("No birthdate found.");
            return 0;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return name.equals(profile.name) && goal == profile.goal && sex == profile.sex && fitnessLevel == profile.fitnessLevel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, goal, sex, fitnessLevel);
    }
}
