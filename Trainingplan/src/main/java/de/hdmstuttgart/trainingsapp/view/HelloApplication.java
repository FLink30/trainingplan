package de.hdmstuttgart.trainingsapp.src.view;

import de.hdmstuttgart.trainingsapp.src.controller.BaseController;
import de.hdmstuttgart.trainingsapp.src.model.DataSingleton;
import de.hdmstuttgart.trainingsapp.src.model.BGM;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;


public class HelloApplication extends Application{

    private static Logger log = LogManager.getLogger(BaseController.class);
    public static Stage stage;

    private DataSingleton data = DataSingleton.getInstance();

    @Override
    public void start(Stage stage) throws IOException {
        data.fillTotalExercises();
        data.fillDefaultWeekplan();
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/fxml/weekplan1.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Welcome to your exercise plan");
            stage.setScene(scene);
            stage.show();
            log.info("Application started");
        }catch(IOException e){
            e.printStackTrace();
            log.error("Stage konnte nicht gestartet werden");
        }
        BGM bgm = new BGM();
        bgm.start();
    }

    // immer wenn Programm startet, wird zunächst launch() gestartet
    public static void main(String[] args) {
        launch();

    }

    private void closeProgram(){
        log.info("Program was closed");
        stage.close();
    }
}
