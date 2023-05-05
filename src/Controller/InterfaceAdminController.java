/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import models.*;

/**
 * FXML Controller class
 *
 * @author Acer
 */


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class InterfaceAdminController implements Initializable{
    



    @FXML
    private Button btn1home;

    @FXML
    private Button btn2sante;

    @FXML
    private Button btn3voiture;

    @FXML
    private Button btn4habitation;

    @FXML
    private Button btn5valider;

    @FXML
    private Button btn6home;

      @FXML
    private Button btn7Client;
          @FXML
    private Button btnSan;

    @FXML
    private Button btnha;

    @FXML
    private Button btnm;
    @FXML
    private Button btnm1;
    @FXML
    private Button btnvoi;
    @FXML
    private Button btnsinistre;
    
    @FXML
    private Label maison;

    @FXML
    private Label sante;

    @FXML
    private Label voiture;
     public void dispaly(String m1,String m2,String m3){
         maison.setText(m1);
         sante.setText(m2);
         voiture.setText(m3);
     }
    
         Connection con;
    PreparedStatement pat;
    ResultSet rs;
      ObservableList<Client> clients =FXCollections.observableArrayList();

    @FXML
    void client(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
        

               Stage stage = new Stage();
        btn7Client.getScene().getWindow().hide();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("/FXML/listeClient.fxml"));
        Scene scene = new Scene(root);
       stage.setScene(scene);
        stage.show();
         stage.setResizable(false);

    }

        @FXML
    void maison(ActionEvent event) throws IOException {
                    Stage stage = new Stage();
        btnm.getScene().getWindow().hide();
        btnm1.getScene().getWindow().hide();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("/FXML/listeMaison.fxml"));
        Scene scene = new Scene(root);
       stage.setScene(scene);
        stage.show();
         stage.setResizable(false);

    }

    @FXML
    void home(ActionEvent event) throws IOException {
             Stage stage = new Stage();
        btn1home.getScene().getWindow().hide();
       btn6home.getScene().getWindow().hide();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("/FXML/home0.fxml"));
        Scene scene = new Scene(root);
       stage.setScene(scene);
        stage.show();
         stage.setResizable(false);

    }

    @FXML
    void sante(ActionEvent event) throws IOException {
              Stage stage = new Stage();
        btn2sante.getScene().getWindow().hide();
        btnSan.getScene().getWindow().hide();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("/FXML/listeContratSante.fxml"));
        Scene scene = new Scene(root);
       stage.setScene(scene);
        stage.show();
         stage.setResizable(false);
    }



    @FXML
    void voiture(ActionEvent event) throws IOException {
                Stage stage = new Stage();
        btn3voiture.getScene().getWindow().hide();
         btnvoi.getScene().getWindow().hide();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("/FXML/listeContratVoiture.fxml"));
        Scene scene = new Scene(root);
       stage.setScene(scene);
        stage.show();
         stage.setResizable(false);
        

    }
        @FXML
    void sinistre(ActionEvent event) throws IOException {

             Stage stage = new Stage();
     
        btnsinistre.getScene().getWindow().hide();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("/FXML/listeSinistre.fxml"));
        Scene scene = new Scene(root);
       stage.setScene(scene);
        stage.show();
         stage.setResizable(false);
    }
     public void connect() throws ClassNotFoundException, SQLException{
              Class.forName("com.mysql.cj.jdbc.Driver");
         con = DriverManager.getConnection("jdbc:mysql://localhost/vms","root","");}
    
     public void table() throws ClassNotFoundException, SQLException
      {
           pat = con.prepareStatement("select * from client");  
           ResultSet rs = pat.executeQuery();
      
        while (rs.next())
        { 
            clients.add(new Client(rs.getInt("idClient"),rs.getString("nom"),rs.getString("prenom"),rs.getString("email"),rs.getString("tel"),rs.getString("password"),rs.getString("datenaiss")));
           
       }      
      }
     
     
        @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 

}

