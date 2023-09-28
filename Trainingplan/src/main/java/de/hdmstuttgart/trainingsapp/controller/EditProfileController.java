package de.hdmstuttgart.trainingsapp.src.controller;

import de.hdmstuttgart.trainingsapp.src.model.DataSingleton;
import de.hdmstuttgart.trainingsapp.src.model.Profile;
import de.hdmstuttgart.trainingsapp.src.model.enums.ProfileAttributes;
import de.hdmstuttgart.trainingsapp.src.model.enums.Fitnesslevel;
import de.hdmstuttgart.trainingsapp.src.model.enums.Goal;
import de.hdmstuttgart.trainingsapp.src.model.enums.Sex;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.Character.isLowerCase;
import static java.lang.Character.isWhitespace;


public class EditProfileController extends BaseController implements Initializable {

    private static Logger log = LogManager.getLogger(EditProfileController.class);

    @FXML
    private DatePicker dateBirthday;
    /**
     * Logik fehlt für dateBirthday...
     */

    @FXML
    public ComboBox<String> comboGoal;

    @FXML
    private ComboBox<String> comboLevel;

    @FXML
    private ComboBox<String> comboSex;

    @FXML
    private Button save;
    @FXML
    private TextField userNameInput;

    /**
     * In diesem Objekt sind unsere konkreten Daten gespeichert.
     */

    private DataSingleton data = DataSingleton.getInstance();







    /**
     * Die ComboBoxen laden den String-Array mit den Werten der Enum-Instanzen als Auswahloptionen. Und es wird der
     * default-Wert von den ComboBoxen auf den Wert gestellt, wie er im Profil gespeichert ist. Danach wird bei
     * Click auf save-Button sendData() aufgerufen. Falls diese eine Exception wirft, wird eine runtimeexception
     * geworfen.
     *
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) throws RuntimeException{
        comboGoal.getItems().addAll(Goal.getValueArr());
    comboLevel.getItems().addAll(Fitnesslevel.getValueArr());
    comboSex.getItems().addAll(Sex.getValueArr());

        userNameInput.setText(data.getProfile().getName());
        comboGoal.setValue(data.getProfile().getGoal().getValue());
        comboLevel.setValue(data.getProfile().getFitnessLevel().getValue());
        comboSex.setValue(data.getProfile().getSex().getValue());

    save.setOnAction(event -> {
        try {
            sendData(new ActionEvent());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    });
    }




    /**
     * 1. Zunächst wird die Eingabe des Namens und die Auswahl des Users bei den comoBoxen in Strings gespeichert.
     * 2. Dann werden diese Strings in Enumkonstanten konvertiert (mit der Methode getEnumConstante()).
     * 3. Mit allen Werten wird ein neues Profile erstellt.
     * 4. Das Profil wird in die DataSingleton-Klasse geladen.
     * 5. Die neue Szene ( mit navProfile.fxml) wird geladen.
     *
     * @param event bei mouseclick
     * @throws IOException falls Scene nicht lädt
     */
    private void sendData(ActionEvent event) throws IOException {
        //1
        String userName = userNameInput.getText();
        String goal = comboGoal.getSelectionModel().getSelectedItem();
        String sex = comboSex.getSelectionModel().getSelectedItem();
        String level = comboLevel.getSelectionModel().getSelectedItem();

        //2
        Goal userGoal = (Goal) ProfileAttributes.GOAL.getConstante(goal);
        Sex userSex = (Sex) ProfileAttributes.SEX.getConstante(sex);
        Fitnesslevel userLevel = (Fitnesslevel) ProfileAttributes.FITNESSLEVEL.getConstante(level);

        //3
        Profile profile = new Profile(userName, userGoal, userSex, userLevel);

        //4
        DataSingleton data = DataSingleton.getInstance();
        data.setProfile(profile);

        //5
        try{
            Stage stage = (Stage) save.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/navProfile.fxml"));
            stage.setScene(new Scene(root));

            stage.show();
        } catch (IOException e) {
            log.error("Scene navProfile konnte nicht geladen werden");
           e.printStackTrace();
        }
        }

    }


   

