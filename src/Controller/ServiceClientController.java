package Controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ServiceClientController {

    @FXML
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    private Button btn3;

    @FXML
    private Button home0;
        @FXML
    private Label lab1;
            public void dispalyMatricule1(String m){
         lab1.setText(m);
     }

    @FXML
    void home(ActionEvent event) throws IOException {
   
        
                 Stage stage = new Stage();
        home0.getScene().getWindow().hide();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("/FXML/home0.fxml"));
        Scene scene = new Scene(root);
       stage.setScene(scene);
        stage.show();
         stage.setResizable(false);

    }

    @FXML
    void maison(ActionEvent event) throws IOException {
        Stage stage = new Stage();
       btn3.getScene().getWindow().hide();
        Parent root;
        String id=lab1.getText();
                 FXMLLoader loader=new FXMLLoader(getClass().getResource("/FXML/AssurerMaison.fxml"));
         root =loader.load();
          AssurerMaisonController v=loader.getController();
       v.dispalyidClient(id);
        
    
        Scene scene = new Scene(root);
       stage.setScene(scene);
        stage.show();
         stage.setResizable(false);

    }

    @FXML
    void sante(ActionEvent event) throws IOException {

                    Stage stage = new Stage();
       btn1.getScene().getWindow().hide();
        Parent root;
        String id=lab1.getText();
                 FXMLLoader loader=new FXMLLoader(getClass().getResource("/FXML/AssurerSante.fxml"));
         root =loader.load();
          AssurerSanteController v=loader.getController();
       v.dispalyidClient(id);
        
    
        Scene scene = new Scene(root);
       stage.setScene(scene);
        stage.show();
         stage.setResizable(false);
    }

    @FXML
    void voiture(ActionEvent event) throws IOException {
        
                 Stage stage = new Stage();
       btn2.getScene().getWindow().hide();
        Parent root;
        String id=lab1.getText();
                 FXMLLoader loader=new FXMLLoader(getClass().getResource("/FXML/MatriculeVoiture.fxml"));
         root =loader.load();
          VoitureController v=loader.getController();
       v.dispalyMatricule2(id);
        
    
        Scene scene = new Scene(root);
       stage.setScene(scene);
        stage.show();
         stage.setResizable(false);

    }

}
