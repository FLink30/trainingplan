package de.hdmstuttgart.trainingsapp.src.model;

import de.hdmstuttgart.trainingsapp.src.model.enums.Fitnesslevel;
import de.hdmstuttgart.trainingsapp.src.model.enums.Goal;
import de.hdmstuttgart.trainingsapp.src.model.enums.Sex;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

public class ProfileTest {

    LocalDate dob = LocalDate.of(2000,1,8);
    Profile profile = new Profile("Mia Musterfrau", Goal.STAY_HEALTHY, Sex.FEMALE, Fitnesslevel.BEGINNER, dob);


    @Test
    void testGetName() {
        assertNotEquals("Michael Mustermann", profile.getName());
        assertEquals("Mia Musterfrau", profile.getName());
    }

    @Test
    void testGetGoal() {
        assertNotEquals(Goal.GAIN_MUSCLE, profile.getGoal());
        assertEquals(Goal.STAY_HEALTHY, profile.getGoal());

    }

    @Test
    void testGetSex() {
        assertNotEquals(Sex.MALE,profile.getSex());
        assertEquals(Sex.FEMALE,profile.getSex());

    }
    @Test
    void testGetDob() {
        LocalDate dobFalse = LocalDate.of(2001,1,8);
        assertNotEquals(dobFalse,profile.getDob());
        assertEquals(dob,profile.getDob());

    }
    @Test
    void testGetFitnesslevel() {
        assertNotEquals(Goal.GAIN_MUSCLE,profile.getGoal());
        assertEquals(Goal.STAY_HEALTHY,profile.getGoal());

    }

    @Test
    void testCalculateAge() {
        assertFalse(10==profile.calculateAge());
        assertTrue(23==profile.calculateAge());
    }

}


   

