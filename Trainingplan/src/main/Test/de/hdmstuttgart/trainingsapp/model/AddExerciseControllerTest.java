package de.hdmstuttgart.trainingsapp.src.model;

import de.hdmstuttgart.trainingsapp.src.controller.AddExerciseController;
import de.hdmstuttgart.trainingsapp.src.model.enums.ExerciseCategory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



public class AddExerciseControllerTest{




    AddExerciseController addExerciseControllerCardio = new AddExerciseController(ExerciseCategory.CARDIO);
    AddExerciseController addExerciseControllerStretching = new AddExerciseController(ExerciseCategory.STRETCHING);
    AddExerciseController addExerciseControllerStrength = new AddExerciseController(ExerciseCategory.STRENGTH);



    @Test
    void testGetExerciseCategory(){
        assertNotEquals(ExerciseCategory.STRETCHING,addExerciseControllerCardio.getExerciseCategory());
        assertEquals(ExerciseCategory.CARDIO, addExerciseControllerCardio.getExerciseCategory());

        assertNotEquals(ExerciseCategory.STRENGTH,addExerciseControllerStretching.getExerciseCategory());
        assertEquals(ExerciseCategory.STRETCHING,addExerciseControllerStretching.getExerciseCategory());

        assertNotEquals(ExerciseCategory.CARDIO,addExerciseControllerStrength.getExerciseCategory());
        assertEquals(ExerciseCategory.STRENGTH,addExerciseControllerStrength.getExerciseCategory());
    }


    @Test
    void testSetExerciseCategory(){
        {addExerciseControllerStrength.setExerciseCategory(ExerciseCategory.STRETCHING);
            assertNotEquals(ExerciseCategory.STRENGTH,addExerciseControllerStrength.getExerciseCategory());
            assertEquals(ExerciseCategory.STRETCHING,addExerciseControllerStrength.getExerciseCategory());

        }
        {addExerciseControllerStretching.setExerciseCategory(ExerciseCategory.CARDIO);
            assertNotEquals(ExerciseCategory.STRETCHING,addExerciseControllerStretching.getExerciseCategory());
            assertEquals(ExerciseCategory.CARDIO,addExerciseControllerStretching.getExerciseCategory());
        }
        {addExerciseControllerCardio.setExerciseCategory(ExerciseCategory.STRENGTH);
            assertNotEquals(ExerciseCategory.CARDIO,addExerciseControllerCardio.getExerciseCategory());
            assertEquals(ExerciseCategory.STRENGTH,addExerciseControllerCardio.getExerciseCategory());
        }

    }


}


   

