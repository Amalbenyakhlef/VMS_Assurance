/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class AssurerSanteController implements Initializable {

      @FXML
    private Button btnHome;

    @FXML
    private Button btnSante;

    @FXML
    private Button btnprevious;
    
      @FXML
    private Label idClient;
      
            public void dispalyidClient(String m){
         idClient.setText(m);
     }

    @FXML
    void DetailsSante(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        btnSante.getScene().getWindow().hide();
        Parent root;
        String id=idClient.getText();
                 FXMLLoader loader=new FXMLLoader(getClass().getResource("/FXML/DetailsSante.fxml"));
         root =loader.load();
          DetailsSanteController v=loader.getController();
       v.dispalyidClient1(id);
        
        stage.setTitle("Santé de VMS assurance");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(true);
        
    }

    @FXML
    void Home(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        btnHome.getScene().getWindow().hide();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("/FXML/loginClient.fxml"));
        stage.setTitle("VMS assurance");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(true);
    }

    @FXML
    void previous(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        btnprevious.getScene().getWindow().hide();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("/FXML/serviceClient.fxml"));
        stage.setTitle("Santé de VMS assurance");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(true);
    }
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
