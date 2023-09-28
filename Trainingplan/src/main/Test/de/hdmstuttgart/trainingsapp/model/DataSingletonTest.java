package de.hdmstuttgart.trainingsapp.src.model;

import de.hdmstuttgart.trainingsapp.src.model.enums.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class DataSingletonTest {
    DataSingleton data = DataSingleton.getInstance();


    @Test
    void testGetInstance() {
        assertNotEquals(new Profile(), DataSingleton.getInstance());
    assertEquals(data, DataSingleton.getInstance());
    }

    @Test
    void testFillTotalExercises() {
        Exercise swimming = new Cardio("Schwimming", 30);
       Exercise running = new Cardio("Running", 40);
        Exercise hiking = new Cardio("Hiking", 60);
        Exercise treadmill =      new Cardio("Treadmill", 10);
        Exercise stretchTheBack =     new Stretching("Stretch the back", 4, Muscle.LATISSIMUS);
        Exercise stretchAbs =     new Stretching("Stretch abs", 3, Muscle.ABS);
         Exercise stretchArms =     new Stretching("Stretch arms", 10, Muscle.TRICEPS);
        Exercise biking =      new Cardio("Biking", 120);

        ObservableList<Exercise> cardioExercises = data.getTotalExercises().get(ExerciseCategory.CARDIO);
        assertNotEquals(cardioExercises, FXCollections.observableArrayList(stretchArms, stretchTheBack, stretchAbs));
    }

    @Test
    void testGetProfile() {
        Profile profile = data.getProfile();
        if(profile == null){
            assertTrue(data.getProfile().equals(new Profile("Mia Musterfrau", Goal.STAY_HEALTHY, Sex.FEMALE, Fitnesslevel.BEGINNER)));
        }
    }

    @Test
    void testSetProfile() {
        Profile profile = new Profile("Max Mustermann", Goal.GET_MORE_ENDURANCE,Sex.MALE,Fitnesslevel.GIGACHAD);
        data.setProfile(profile);
        assertNotEquals(new Profile("Mia Musterfrau", Goal.STAY_HEALTHY, Sex.FEMALE, Fitnesslevel.BEGINNER), data.getProfile());
        assertEquals( new Profile("Max Mustermann", Goal.GET_MORE_ENDURANCE,Sex.MALE,Fitnesslevel.GIGACHAD), data.getProfile());
        }
    }




