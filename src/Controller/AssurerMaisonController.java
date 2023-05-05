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
public class AssurerMaisonController implements Initializable {

   
    @FXML
    private Button btnHome;

    @FXML
    private Button btnMaison;

    @FXML
    private Button btnPrevious;
    
    
      @FXML
    private Label lab1;
            public void dispalyidClient(String m){
         lab1.setText(m);
     }

    @FXML
    void AssurerMaison(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        btnMaison.getScene().getWindow().hide();
        Parent root;
         String id=lab1.getText();
                 FXMLLoader loader=new FXMLLoader(getClass().getResource("/FXML/DetailsMaison.fxml"));
         root =loader.load();
          DetailsMaisonController v=loader.getController();
       v.dispalyidClient2(id);
       
        //root = FXMLLoader.load(getClass().getResource("/FXML/DetailsMaison.fxml"));
        stage.setTitle("Maison de VMS assurance");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(true);
    }

    @FXML
    void GoService(ActionEvent event) throws IOException {
         Stage stage = new Stage();
        btnPrevious.getScene().getWindow().hide();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("/FXML/serviceClient.fxml"));
        stage.setTitle("Service de VMS assurance");
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
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
