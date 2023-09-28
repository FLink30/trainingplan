module de.hdmstuttgart.trainingsapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.logging.log4j;
    requires java.desktop;


    exports de.hdmstuttgart.trainingsapp.src.controller;
    opens de.hdmstuttgart.trainingsapp.src.controller to javafx.fxml;
    exports de.hdmstuttgart.trainingsapp.src.model;
    opens de.hdmstuttgart.trainingsapp.src.model to javafx.fxml;
    exports de.hdmstuttgart.trainingsapp.src.view;
    opens de.hdmstuttgart.trainingsapp.src.view to javafx.fxml;
    exports de.hdmstuttgart.trainingsapp.src.model.enums;
    opens de.hdmstuttgart.trainingsapp.src.model.enums to javafx.fxml;

}

