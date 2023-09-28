package de.hdmstuttgart.trainingsapp.src.model;

import de.hdmstuttgart.trainingsapp.src.model.enums.Muscle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Stretching extends Exercise{

 private static final Logger log = LogManager.getLogger(Stretching.class);

 private float exReps;



 public Stretching(String exName, float exReps, Muscle exMuscle) {
  super(exName, 1, exMuscle);
  this.exReps = exReps;

 }
 /**
  * gibt ein String der Variabel exReps zurück, damit es in Tableview durch ObservableList ausgegeben werden kann
  */
 public String getExReps(){
  String exReps = Float.toString(this.exReps) + " min";
  log.info("Returned exReps: " + exReps);
  return exReps;
 }


 public void setExReps(int exReps) {
  this.exReps = exReps;
  log.info("exReps set: " + exReps);
 }
}



   

