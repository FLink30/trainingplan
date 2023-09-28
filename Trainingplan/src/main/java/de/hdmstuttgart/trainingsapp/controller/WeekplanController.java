package de.hdmstuttgart.trainingsapp.src.controller;

import de.hdmstuttgart.trainingsapp.src.model.*;
import de.hdmstuttgart.trainingsapp.src.model.enums.Day;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class WeekplanController extends BaseController implements Initializable {

    private static Logger log = LogManager.getLogger(WeekplanController.class);



    /**
     * 1. View:
     * FXML Loader schaut in FXML-file nach fx:id-Attribut von einem Element und wenn dies übereinstimmt
     * wird diese Objektreferenz von FXML automatisch in die Controller Instanzvariable gespeichert
     */

    @FXML
    private Button monday;
    @FXML
    private Button tuesday;
    @FXML
    private Button wednesday;
    @FXML
    private Button thursday;
    @FXML
    private Button friday;
    @FXML
    private Button saturday;
    @FXML
    private Button sunday;

    @FXML
    private TableView exTable;
    private TableColumn<Exercise, String> colName = new TableColumn<Exercise, String>("Name");
    private TableColumn<Exercise, String> colSet = new TableColumn<Exercise, String>("Set");
    private TableColumn<Exercise, String> colReps =new TableColumn<Exercise, String>("Duration/Reps");
    private TableColumn<Exercise, String> colMuscle =new TableColumn<Exercise,String>("Muscle");

    private DataSingleton data = DataSingleton.getInstance();

    private Stage stage;
    private Scene scene;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //1.

        colName.setCellValueFactory(new PropertyValueFactory<Exercise, String>("exName"));
        colSet.setCellValueFactory(new PropertyValueFactory<Exercise, String>("exSet"));
        colReps.setCellValueFactory(new PropertyValueFactory<Exercise, String>("exReps"));
        colMuscle.setCellValueFactory(new PropertyValueFactory<Exercise, String>("exMuscle"));

        //2.

        exTable.getColumns().add(colName);
        exTable.getColumns().add(colSet);
        exTable.getColumns().add(colReps);
        exTable.getColumns().add(colMuscle);

        //3.

        exTable.getItems().clear();
        exTable.setItems(data.getWeekplan().get(Day.MONDAY));

        // 4.

        exTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        exTable.setStyle("-fx-font-size: 16.0");

    }

    /**
     * Wird benötigt um auf EditExercises weitergeleitet zu werden
     * Damit kann Applikation erweitert werden
     * @param event
     */
   @FXML
   public void switchToEditExercise(ActionEvent event){
       try{
           Parent root = FXMLLoader.load(getClass().getResource("/fxml/EditExercise.fxml"));
           stage = (Stage)((Node)event.getSource()).getScene().getWindow();
           scene = new Scene(root);
           stage.setScene(scene);
           stage.show();
       }catch(IOException e){
           log.error("EditExercise konnte nicht geladen werden");
       }
   }


    /**
     *
     * Methode die, die Opacity von allen anderen nicht gedrückten Buttons auf 0.4 setzt
     *
     * @param day1
     * @param day2
     * @param day3
     * @param day4
     * @param day5
     * @param day6
     */

    private void setOpacityLow(Button day1, Button day2, Button day3, Button day4, Button day5, Button day6){
        day1.setOpacity(0.4);
        day2.setOpacity(0.4);
        day3.setOpacity(0.4);
        day4.setOpacity(0.4);
        day5.setOpacity(0.4);
        day6.setOpacity(0.4);
    }

    @FXML
    private void dayButtonClicked(ActionEvent event){
        if(event.getSource() == monday){
            setOpacityLow(tuesday, wednesday, thursday, friday, saturday, sunday);
            monday.setOpacity(1);
            displayTrainingplan(Day.MONDAY);
        } else if (event.getSource() == tuesday){
            setOpacityLow(monday, wednesday, thursday, friday, saturday, sunday);
            tuesday.setOpacity(1);
            displayTrainingplan(Day.TUESDAY);
        }else if(event.getSource() == wednesday){
            setOpacityLow(tuesday,monday,thursday,friday,saturday,sunday);
            wednesday.setOpacity(1);
            displayTrainingplan(Day.WEDNESDAY);
        }else if(event.getSource() == thursday){
            setOpacityLow(tuesday,wednesday,monday,friday,saturday,sunday);
            thursday.setOpacity(1);
            displayTrainingplan(Day.THURSDAY);
        }else if(event.getSource() == friday){
            setOpacityLow(tuesday,wednesday,thursday,monday,saturday,sunday);
            friday.setOpacity(1);
            displayTrainingplan(Day.FRIDAY);
        }else if(event.getSource() == saturday) {
            setOpacityLow(tuesday, wednesday, thursday, friday, monday, sunday);
            saturday.setOpacity(1);
            displayTrainingplan(Day.SATURDAY);
        }else{
            setOpacityLow(tuesday,wednesday,thursday,friday,saturday,monday);
            sunday.setOpacity(1);
            displayTrainingplan(Day.SUNDAY);
        }
    }


    private void displayTrainingplan(Day day){
        exTable.setItems(data.getWeekplan().get(day));
    }

}


   

