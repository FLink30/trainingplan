package de.hdmstuttgart.trainingsapp.src.model;

import de.hdmstuttgart.trainingsapp.src.model.enums.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.HashMap;
import java.util.Map;

/**
 * Klasse mit dem Namen "DataSingleton" dient zur vorläufigen Datenspeicherung, da Json noch nicht implementiert wurde.
 */
public class DataSingleton {

    private static final Logger log = LogManager.getLogger(DataSingleton.class);

    private static final DataSingleton INSTANCE = new DataSingleton();
    private Profile profile;

    private final Exercise swimming = new Cardio("Schwimming", 20);
    private final Exercise running = new Cardio("Running", 40);
    private final Exercise hiking = new Cardio("Hiking", 120);
    private final Exercise squats = new Strength("Squats", 3, 20, Muscle.QUADRICEPS);
    private final Exercise deadlift =  new Strength("Deadlift", 4, 3, Muscle.BICEPS);
    private final Exercise situps=     new Strength("Situps", 3, 20, Muscle.BICEPS);
    private final Exercise treadmill =      new Cardio("Treadmill", 20);
    private final Exercise stretchTheBack =     new Stretching("Stretch the back", 3, Muscle.LATISSIMUS);
    private final Exercise stretchAbs =     new Stretching("Stretch abs", 2, Muscle.ABS);
    private final Exercise stretchArms =     new Stretching("Stretch arms", 2, Muscle.TRICEPS);
    private final Exercise biking =      new Cardio("Biking", 60);
    private final Exercise pushUp = new Strength("Push-Ups", 4, 15, Muscle.CHEST);
    private final Exercise mountainClimbers =  new Strength("Mountain Climbers", 2, 25, Muscle.LATISSIMUS);
    private final Exercise plank =     new Strength("Plank", 3, 20, Muscle.ABS);


    /**
     * Maps:
     * weekplan enthält Trainingspläne für jeweiligen Tag
     * totalExercises enthält Listen von Exercises für die jeweilige ExerciseCategory
     */
    private Map<Day, ObservableList<Exercise>> weekplan = new HashMap<>();
    private Map<ExerciseCategory, ObservableList<Exercise>> totalExercises = new HashMap<>();

    /**
     * muss private sein, damit nur Objekt davon instanziierbar ist
     */
    private DataSingleton() {
    }

    public static DataSingleton getInstance() {
        log.info("Returned DataSingleton Instance");
        return INSTANCE;
    }



    /**
     * categoryExercise Map wird mit default-Exercises gefüllt
     */

    public void fillTotalExercises(){

        ObservableList<Exercise> strengthExercises = FXCollections.observableArrayList();
        ObservableList<Exercise> cardioExercises = FXCollections.observableArrayList();
        ObservableList<Exercise> stretchingExercises = FXCollections.observableArrayList();

        strengthExercises.addAll(squats, deadlift, situps, pushUp, mountainClimbers, plank);
        cardioExercises.addAll(running, swimming, hiking, treadmill, biking);
        stretchingExercises.addAll(stretchArms, stretchTheBack,stretchAbs);

        totalExercises.put(ExerciseCategory.CARDIO,cardioExercises);
        totalExercises.put(ExerciseCategory.STRENGTH,strengthExercises);
        totalExercises.put(ExerciseCategory.STRETCHING,stretchingExercises);

        log.info("Exercises wurden hinzugefügt zu TotalExercises" );
    }

    private void addToTotalExercises(ExerciseCategory exerciseCategory, Exercise exercise){
        totalExercises.get(exerciseCategory).add(exercise);
    }




    /**
     * Befüllt die Listen
     */
  public void fillDefaultWeekplan(){
      ObservableList<Exercise> monday = FXCollections.observableArrayList();
       ObservableList<Exercise> tuesday = FXCollections.observableArrayList();
       ObservableList<Exercise> wednesday = FXCollections.observableArrayList();
      ObservableList<Exercise> thursday = FXCollections.observableArrayList();
      ObservableList<Exercise> friday = FXCollections.observableArrayList();
       ObservableList<Exercise> saturday = FXCollections.observableArrayList();
      ObservableList<Exercise> sunday = FXCollections.observableArrayList();

        monday.addAll(plank, treadmill, stretchAbs);
        tuesday.addAll(swimming, stretchArms, stretchTheBack);
        wednesday.addAll(squats, situps, mountainClimbers, pushUp, deadlift);
        thursday.add(running);
        friday.add(biking);
        saturday.addAll(situps, plank, treadmill, stretchTheBack);
        sunday.add(hiking);

        weekplan.put(Day.MONDAY, monday);
        weekplan.put(Day.TUESDAY,tuesday);
        weekplan.put(Day.WEDNESDAY,wednesday);
        weekplan.put(Day.THURSDAY,thursday);
        weekplan.put(Day.FRIDAY,friday);
        weekplan.put(Day.SATURDAY,saturday);
        weekplan.put(Day.SUNDAY,sunday);
        log.info("DayLists filled, weekplan filled.");

    }


    public Map <ExerciseCategory, ObservableList<Exercise>> getTotalExercises(){
        Map <ExerciseCategory ,ObservableList<Exercise>> totalExercises;
        totalExercises = this.totalExercises;
        return totalExercises;
    }

    /**
     * gibt die Listen mit Übungen einer Kategorie aus
     * @param exerciseCategory
     * @return Liste mit Exercises einer Kategorie
     */

    public ObservableList<Exercise> getCategoryList(ExerciseCategory exerciseCategory){
      ObservableList<Exercise> categoryList;
      categoryList =  totalExercises.get(exerciseCategory);
      return categoryList;
    }
    private void putCategoryListToTotalExercises(ExerciseCategory exerciseCategory, ObservableList<Exercise> categoryList){
        totalExercises.put(exerciseCategory, categoryList);
    }



    /**
     * Wenn profile noch null ist werden Defaultwerte eingespeichert.
     * @return Kopie von profile
     */

    public Profile getProfile() {
        if (profile == null){
            log.warn("Profile ist null. Zeigt nur default-Werte an");
            String name = "Mia Musterfrau";
            Goal goal = Goal.STAY_HEALTHY;
            Fitnesslevel level = Fitnesslevel.BEGINNER;
            Sex sex = Sex.FEMALE;
            Profile defaultProfile = new Profile(name, goal, sex, level);
            setProfile(defaultProfile);
        }
        Profile profile = this.profile;
        return profile;
    }

    /**
     * neues Profile wird gespeichert
     * @param profile
     */
    public void setProfile(Profile profile) {
        this.profile = profile;
        log.info("Profile set: " + profile);
    }



    public Map<Day, ObservableList<Exercise>> getWeekplan(){
        Map<Day, ObservableList<Exercise>> weekplan = this.weekplan;
        return weekplan;
    }

    private void setWeekplan(Map<Day, ObservableList<Exercise>> weekplan){
        this.weekplan = weekplan;
    }


}










   

