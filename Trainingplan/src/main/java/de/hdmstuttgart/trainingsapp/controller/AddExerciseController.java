package de.hdmstuttgart.trainingsapp.src.controller;
import de.hdmstuttgart.trainingsapp.src.model.enums.ExerciseCategory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;


public class AddExerciseController extends BaseController implements Initializable {

    private static final Logger log = LogManager.getLogger(AddExerciseController.class);

    @FXML
    private Button categoryCardio;

    @FXML
    private Button categoryStrength;

    @FXML
    private Button categoryStretching;


    private ExerciseCategory exerciseCategory;


    public AddExerciseController(ExerciseCategory exerciseCategory){
        this.exerciseCategory = exerciseCategory;
    }

    public AddExerciseController(){}


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        buttonClicked();
    }


    @FXML
    public void buttonClicked(){
        categoryCardio.setOnAction(e -> {
            // die exerciseCategory (abhängig von Event das durch buttonclick ausgelöst wurde) in
            // SelectExerciseController zuweisen
            setExerciseCategory(ExerciseCategory.CARDIO);
            try {
                switchToSelectExercise(e);
            } catch (IOException ex) {
                log.fatal("Bei Buttonklick auf " + ExerciseCategory.CARDIO.getValue() + " hat switchToSelectExercise() die Exception: " + ex + "geworfen");
            }

        });

        categoryStrength.setOnAction(e -> {
            setExerciseCategory(ExerciseCategory.STRENGTH);
            try {
                switchToSelectExercise(e);
            } catch (IOException ex) {
                log.fatal("Bei Buttonklick auf " + ExerciseCategory.STRENGTH.getValue() + " hat switchToSelectExercise() die Exception: " + ex + "geworfen");
            }
        });


        categoryStretching.setOnAction(e -> {

            setExerciseCategory(ExerciseCategory.STRETCHING);
            try {
                switchToSelectExercise(e);
            } catch (IOException ex) {
                log.fatal("Bei Buttonklick auf " + ExerciseCategory.STRETCHING.getValue() + " hat switchToSelectExercise() die Exception: " + ex + "geworfen");
            }
        });
    }

    /**
     * Methode wird aufgerufen, wenn user auf einen ExerciseCategory-Button drückt. Dies ist nötig, da wir die
     * switchTo()-Methode im BaseController nicht verwenden können, da dort die id des jeweiligen Buttons benötigt wird,
     * um die gleichnamige Scene zu laden. Wir können allerdings den drei Buttons nicht die gleiche id geben.
     *
     * Hier haben wir die Controller über ihre Instanzen kommunizieren lassen und nicht über die DataSingletonklasse. Dies
     * hat den Vorteil, dass AddExerciseController mit der Instanz von SelectExerciseController die Methode displayTable()
     * aufrufen kann und der Methode die exerciseCategory, die in diesem Controller gespeichert wird, übergeben kann.
     *
     * @param event MouseClick
     * @throws IOException wird geworfen, falls FXMLLoader FXML-Datei nicht laden kann
     */

    @FXML
    public void switchToSelectExercise(ActionEvent event) throws IOException {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/fxml/SelectExercise.fxml"));
            Parent root =fxmlLoader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            // controller von selectExercise aus FXMLLoader bekommen
            SelectExerciseController selectExerciseController = fxmlLoader.getController();
            // mit Instanz auf Methode displayTable() zugreifen und die jeweilige exerciseCategory übergeben
            selectExerciseController.displayTable(exerciseCategory);
            stage.setScene(scene);
            stage.show();
            log.debug("Switched to Scene: " + scene);
        } catch (IOException e) {
            log.fatal("Die neue Szene SelectExercise konnte nicht geladen werden. Exception: " + e);
        }
    }

    public void setExerciseCategory(ExerciseCategory exerciseCategory){
        this.exerciseCategory = exerciseCategory;
    }

    public ExerciseCategory getExerciseCategory() {
        ExerciseCategory exerciseCategory = this.exerciseCategory;
        return exerciseCategory;
    }
}


   

