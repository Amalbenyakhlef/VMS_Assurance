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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import models.Client;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ListeClientController implements Initializable{
   
    @FXML
    private Button btnsan;

    @FXML
    private Button btnvoi;
    @FXML
    private Button btnAcceuil;

    @FXML
    private TableColumn<Client, String> colEmail;

    @FXML
    private TableColumn<Client, String> colNom;

    @FXML
    private TableColumn<Client, String> colPrenom;

    @FXML
    private TableColumn<Client, String> colTelephone;
        @FXML
    private Button home;
     
     @FXML
    private TableView<Client> table;
       ObservableList<Client> clients =FXCollections.observableArrayList();
    
     Connection con;
    PreparedStatement pat;
    ResultSet rs;
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
            @FXML
    void acceuil(ActionEvent event) throws IOException {

                        Stage stage = new Stage();
        btnAcceuil.getScene().getWindow().hide();
        home.getScene().getWindow().hide();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("/FXML/interfaceAdmin.fxml"));
        Scene scene = new Scene(root);
       stage.setScene(scene);
        stage.show();
         stage.setResizable(false);
    }
        @FXML
    void sante(ActionEvent event) throws IOException {
              Stage stage = new Stage();
     
        btnsan.getScene().getWindow().hide();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("/FXML/listeContratSante.fxml"));
        Scene scene = new Scene(root);
       stage.setScene(scene);
        stage.show();
         stage.setResizable(false);
    }

    @FXML
    void valider(ActionEvent event) {

    }

    @FXML
    void voiture(ActionEvent event) throws IOException {
                Stage stage = new Stage();
     
         btnvoi.getScene().getWindow().hide();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("/FXML/listeContratVoiture.fxml"));
        Scene scene = new Scene(root);
       stage.setScene(scene);
        stage.show();
         stage.setResizable(false);
        

    }
           

                
           @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
             connect();
            table();
            // TODO
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListeClientController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ListeClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
                     colEmail.setCellValueFactory(cellData -> {

    Client s = cellData.getValue();
    if(s instanceof Client){
        return new SimpleObjectProperty(((Client)s).getEmail());
    }
 
    return new SimpleObjectProperty<>(null);
});
                     
                                          colNom.setCellValueFactory(cellData -> {

    Client s = cellData.getValue();
    if(s instanceof Client){
        return new SimpleObjectProperty(((Client)s).getNom());
    }
 
    return new SimpleObjectProperty<>(null);
});
                                          
   colPrenom.setCellValueFactory(cellData -> {

    Client s = cellData.getValue();
    if(s instanceof Client){
        return new SimpleObjectProperty(((Client)s).getPrenom());
    }
 
    return new SimpleObjectProperty<>(null);
});
                                             
  colTelephone.setCellValueFactory(cellData -> {

    Client s = cellData.getValue();
    if(s instanceof Client){
        return new SimpleObjectProperty(((Client)s).getTel());
    }
 
    return new SimpleObjectProperty<>(null);
});
                     
                table.setItems(clients);
    }            

}