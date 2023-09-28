package de.hdmstuttgart.trainingsapp.src.controller;

import de.hdmstuttgart.trainingsapp.src.model.DataSingleton;
import de.hdmstuttgart.trainingsapp.src.model.Profile;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.net.URL;
import java.util.ResourceBundle;



public class NavProfileController extends BaseController implements Initializable {



    @FXML
    private Label fitnessLevelUserInput;

    @FXML
    private Label sexUserInput;


    @FXML
    private Label trainingGoalUserInput;

    @FXML
    private Label userName;



    private static Logger log = LogManager.getLogger(NavProfileController.class);

    private DataSingleton data = DataSingleton.getInstance();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        receiveData();
    }



    /**
     * This method displays the Input of the User (in EditProfile)
     * @param
     */
    public void receiveData(){
        userName.setText(data.getProfile().getName());
        trainingGoalUserInput.setText(data.getProfile().getGoal().getValue());
        sexUserInput.setText(data.getProfile().getSex().getValue());
        fitnessLevelUserInput.setText(data.getProfile().getFitnessLevel().getValue());
        log.info("NavProfileController got profile info.");

    }



}


   

