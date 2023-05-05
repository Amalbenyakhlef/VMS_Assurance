/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Home0Controller {

    @FXML
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    void admin(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        btn2.getScene().getWindow().hide();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("/FXML/loginAdm.fxml"));
        Scene scene = new Scene(root);
       stage.setScene(scene);
        stage.show();
         stage.setResizable(false);

    }

    @FXML
    void client(ActionEvent event) throws IOException {
          Stage stage = new Stage();
        btn1.getScene().getWindow().hide();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("/FXML/loginClient.fxml"));
        Scene scene = new Scene(root);
       stage.setScene(scene);
        stage.show();
         stage.setResizable(false);

    }

}
