package de.hdmstuttgart.trainingsapp.src.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class BaseController {


    private Stage stage;
    private Scene scene;
    private Parent root;


    private static Logger log = LogManager.getLogger(EditProfileController.class);

    /**
     * Alle anderen Controller erben von BaseController
     */
    public BaseController(){

    }

    /**
     *
     * Wir haben jedem UI-Element in der FXML-Datei den Namen des nächsten FXML-files als Id gegeben, damit wir gleich
     * wohin man bei Mouseclick kommt.
     * Diese Methode weist einem String die Id des UI-Elements zu und ruft dann über den String das jeweilige FXML-file auf.
     * @param event
     * @throws IOException
     */

@FXML
    private void switchTo(ActionEvent event) {
        try{
            String placeToGo =((Node)event.getSource()).getId() + ".fxml";
            root = FXMLLoader.load(getClass().getResource("/fxml/" + placeToGo));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            log.debug("Switched to Scene: " + scene);
        }catch(IOException e){
            log.error("Szene " + ((Node) event.getSource()).getId()  + " konnte nicht gestartet werden: " +e);
        }
        }



}



