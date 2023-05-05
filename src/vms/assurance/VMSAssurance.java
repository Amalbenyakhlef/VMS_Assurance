/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package vms.assurance;
import java.io.IOException;
import java.text.ParseException;
import models.*;

//import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;





/**
 *
 * @author admin
 */
public class VMSAssurance extends Application {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        launch(args);
      
       
         
        
        
        
    }
    
    
    @Override
    public void start(Stage stage) throws Exception,IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/FXML/home0.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
         stage.setResizable(true);
    }

    
}
