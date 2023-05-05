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
import javafx.stage.Stage;
import models.ContratVoiture;
import models.sinistre;

public class ListeSinistreController implements Initializable {

    @FXML
    private Button btnsan;

    @FXML
    private Button btnsinistre;

    @FXML
    private Button btnvoi;

    @FXML
    private TableColumn<sinistre, String> coldec;

    @FXML
    private TableColumn<sinistre, String> coldeg;

    @FXML
    private TableColumn<sinistre, String> colid;

    @FXML
    private TableColumn<sinistre, String> colidConstat;

    @FXML
    private TableColumn<sinistre, String> coltel;

    @FXML
    private TableColumn<sinistre, String> coltype;

    @FXML
    private Button home;
     @FXML
    private Button btnm;

    @FXML
    private Button home1;

    @FXML
    private TableView<sinistre> table;
     ObservableList<sinistre> sinistres =FXCollections.observableArrayList();
         Connection con;
    PreparedStatement pat;
    ResultSet rs;
     public void connect() throws ClassNotFoundException, SQLException{
              Class.forName("com.mysql.cj.jdbc.Driver");
         con = DriverManager.getConnection("jdbc:mysql://localhost/vms","root","");}
     
        public void table() throws ClassNotFoundException, SQLException
      {
           pat = con.prepareStatement("select * from sinistrevoiture");  
           ResultSet rs = pat.executeQuery();
      
        while (rs.next())


            sinistres.add(new sinistre(rs.getString("dateDéclaration"),rs.getFloat("Dégats"),rs.getInt("idConstat"),
                    rs.getString("TypeAccident"),rs.getString("tel")));
            
        
       }
        

                      @FXML
    void home(ActionEvent event) throws IOException {

                        Stage stage = new Stage();
    
       home1.getScene().getWindow().hide();
        home.getScene().getWindow().hide();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("/FXML/interfaceAdmin.fxml"));
        Scene scene = new Scene(root);
       stage.setScene(scene);
        stage.show();
         stage.setResizable(false);
    }
           @FXML
    void maison(ActionEvent event) throws IOException {
                    Stage stage = new Stage();
        btnm.getScene().getWindow().hide();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("/FXML/listeMaison.fxml"));
        Scene scene = new Scene(root);
       stage.setScene(scene);
        stage.show();
         stage.setResizable(false);

    }

               @FXML
    void sante(ActionEvent event) throws IOException {
              Stage stage = new Stage();
     
        btnsinistre.getScene().getWindow().hide();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("/FXML/listeContratSante.fxml"));
        Scene scene = new Scene(root);
       stage.setScene(scene);
        stage.show();
         stage.setResizable(false);
    }
    
    @FXML
    void sinistre(ActionEvent event) throws IOException {

             Stage stage = new Stage();
     
        btnsan.getScene().getWindow().hide();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("/FXML/listeSinistre.fxml"));
        Scene scene = new Scene(root);
       stage.setScene(scene);
        stage.show();
         stage.setResizable(false);
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
                               colid.setCellValueFactory(cellData -> {

    sinistre s = cellData.getValue();
    if(s instanceof sinistre){
        return new SimpleObjectProperty(((sinistre)s).getIdConstat());
    }
 
    return new SimpleObjectProperty<>(null);});
     coldec.setCellValueFactory(cellData -> {

    sinistre s = cellData.getValue();
    if(s instanceof sinistre){
        return new SimpleObjectProperty(((sinistre)s).getDateDéclaration());
    }
 
    return new SimpleObjectProperty<>(null);});
                            coldeg.setCellValueFactory(cellData -> {

    sinistre s = cellData.getValue();
    if(s instanceof sinistre){
        return new SimpleObjectProperty(((sinistre)s).getDégats());
    }
 
    return new SimpleObjectProperty<>(null);});
                                                   colidConstat.setCellValueFactory(cellData -> {

    sinistre s = cellData.getValue();
    if(s instanceof sinistre){
        return new SimpleObjectProperty(((sinistre)s).getIdConstat());
    }
 
    return new SimpleObjectProperty<>(null);});
                                        coldec.setCellValueFactory(cellData -> {

    sinistre s = cellData.getValue();
    if(s instanceof sinistre){
        return new SimpleObjectProperty(((sinistre)s).getDateDéclaration());
    }
 
    return new SimpleObjectProperty<>(null);});
                                         coltel.setCellValueFactory(cellData -> {

    sinistre s = cellData.getValue();
    if(s instanceof sinistre){
        return new SimpleObjectProperty(((sinistre)s).getTel());
    }
 
    return new SimpleObjectProperty<>(null);});                    
            coltype.setCellValueFactory(cellData -> {

    sinistre s = cellData.getValue();
    if(s instanceof sinistre){
        return new SimpleObjectProperty(((sinistre)s).getTypeAccident());
    }
 
    return new SimpleObjectProperty<>(null);});  
            
            
                   
            table.setItems(sinistres);                                    
                             
        // TODO
    }   }




