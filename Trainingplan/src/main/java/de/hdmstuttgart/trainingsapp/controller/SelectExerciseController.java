package de.hdmstuttgart.trainingsapp.src.controller;

import de.hdmstuttgart.trainingsapp.src.model.*;
import de.hdmstuttgart.trainingsapp.src.model.enums.ExerciseCategory;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;
import java.util.ResourceBundle;


public class SelectExerciseController extends BaseController implements Initializable {

    private final static Logger log = LogManager.getLogger(SelectExerciseController.class);

    private final DataSingleton data = DataSingleton.getInstance();

    private ExerciseCategory exerciseCategory;
    @FXML
    private TableView exerciseCategoryTable;



    public TableColumn<Exercise, String> colname = new TableColumn<>("Name");
    public TableColumn<Exercise, String> colset = new TableColumn<>("Set");
    public TableColumn<Exercise, String> colMuscle =new TableColumn<>("Muscle");
    public TableColumn<Stretching, String> colRepsStretching =new TableColumn<>("Duration");
    public TableColumn<Strength, String> colRepsStrength =new TableColumn<>("Reps");
    public TableColumn<Cardio, String> colRepsCardio =new TableColumn<>("Duration");




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }


    /**
     * Der Tabelle exerciseCategoryTable werden Spalten gesetzt und die gewünschte CategoryList wird geladen
     * @param exerciseCategory
     */
    public void displayTable(ExerciseCategory exerciseCategory){
        setExerciseCategory(exerciseCategory);
        try {
                ObservableList<Exercise> categoryExerciseList = data.getCategoryList(exerciseCategory);

            colname.setCellValueFactory(new PropertyValueFactory<>("exName"));
            colset.setCellValueFactory(new PropertyValueFactory<>("exSet"));

            exerciseCategoryTable.getColumns().add(colname);
            exerciseCategoryTable.getColumns().add(colset);

            if (exerciseCategory == ExerciseCategory.STRENGTH) {
                colRepsStrength.setCellValueFactory(new PropertyValueFactory<>("exReps"));
                exerciseCategoryTable.getColumns().add(colRepsStrength);

            } else if (exerciseCategory == ExerciseCategory.STRETCHING) {
                colRepsStretching.setCellValueFactory(new PropertyValueFactory<>("exReps"));
                exerciseCategoryTable.getColumns().add(colRepsStretching);

            } else {
                colRepsCardio.setCellValueFactory(new PropertyValueFactory<>("exReps"));
                exerciseCategoryTable.getColumns().add(colRepsCardio);
            }

            colMuscle.setCellValueFactory(new PropertyValueFactory<>("exMuscle"));

            exerciseCategoryTable.getColumns().add(colMuscle);

            exerciseCategoryTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
            exerciseCategoryTable.setStyle("-fx-font-size: 16.0");

            exerciseCategoryTable.setItems(categoryExerciseList);
        }catch(NullPointerException e){
            log.error("Die CategoryList aus TotalExercises ist null"+ e);
        }

        }

        public TableView getExerciseCategoryTable(){
        TableView exerciseCategoryTable = this.exerciseCategoryTable;
        return exerciseCategoryTable;
        }

        public void setExerciseCategory(ExerciseCategory exerciseCategory){
        this.exerciseCategory = exerciseCategory;
        }

    }







   

