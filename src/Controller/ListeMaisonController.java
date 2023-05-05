/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import java.io.IOException;
import static java.lang.Integer.parseInt;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import models.ContratHabitation;
import models.ContratSante;

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class ListeMaisonController implements Initializable {
   @FXML
    private Button btnm;

    @FXML
    private Button btnsan;

    @FXML
    private Button btnsinistre;

    @FXML
    private Button btnvoi;

    @FXML
    private TableColumn<ContratHabitation, String> cilid;

    @FXML
    private TableColumn<ContratHabitation, String> colRue;

    @FXML
    private TableColumn<ContratHabitation, String> colclient;

    @FXML
    private TableColumn<ContratHabitation, String> colcrea;

    @FXML
    private TableColumn<ContratHabitation, String> coldeb;

    @FXML
    private TableColumn<ContratHabitation, String> colfin;

    @FXML
    private TableColumn<ContratHabitation, String> colgarantie;

    @FXML
    private TableColumn<ContratHabitation, String> colpostal;

    @FXML
    private TableColumn<ContratHabitation, String> colprix;

    @FXML
    private TableColumn<ContratHabitation, String> colvalider;

    @FXML
    private TableColumn<ContratHabitation, String> colville;

    @FXML
    private Button home;

    @FXML
    private Button home1;
    @FXML
    private Button btnvalider;
    @FXML
    private Button btnsupprimer;
    
    
    @FXML
    private TableView<ContratHabitation> table;

    ObservableList<ContratHabitation> maisons=FXCollections.observableArrayList();
    
     Connection con;
    PreparedStatement pat;
    ResultSet rs;
     public void connect() throws ClassNotFoundException, SQLException{
              Class.forName("com.mysql.cj.jdbc.Driver");
         con = DriverManager.getConnection("jdbc:mysql://localhost/vms","root","");}
    
         public void table() throws ClassNotFoundException, SQLException
      {
           pat = con.prepareStatement("select * from contratmaison");  
           ResultSet rs = pat.executeQuery();
      
        while (rs.next())
        {

           maisons.add(new ContratHabitation(rs.getFloat("niveauDeGarantie"),rs.getString("Ville"),rs.getString("NumeroRue"),rs.getString("CodePostal")
                    ,rs.getInt("idClient"),rs.getInt("IdContrat"),rs.getString("dateCreation"),
                    rs.getString("dateDebut"),rs.getString("dateFin"),rs.getFloat("prix"),rs.getString("valider")));
       }}
             @FXML
    void valider(ActionEvent event) throws SQLException, IOException {
              int myIndex = table.getSelectionModel().getSelectedIndex();
       int idContrat= parseInt(String.valueOf(table.getItems().get(myIndex).getIdContrat()));
          
        String valider="oui";
       
            pat = con.prepareStatement("update contratmaison set valider = ? where idContrat = ? ");
            pat.setString(1, valider);
           pat.setInt(2, idContrat);
         
            pat.executeUpdate();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

 
alert.setHeaderText("validation");
alert.setContentText("le contrat selectionné est validé");
 
alert.showAndWait();
          Stage stage = new Stage();
     
        btnsupprimer.getScene().getWindow().hide();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("/FXML/listeMaison.fxml"));
        Scene scene = new Scene(root);
       stage.setScene(scene);
        stage.show();
         stage.setResizable(false);
           

    }
           @FXML
    void delete(ActionEvent event) throws SQLException, IOException {

            int myIndex = table.getSelectionModel().getSelectedIndex();
       int idContrat= parseInt(String.valueOf(table.getItems().get(myIndex).getIdContrat()));
 
        
            pat = con.prepareStatement("delete from contratmaison where idContrat = ? ");
              pat.setInt(1, idContrat);
            pat.executeUpdate();
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
     
alert.setHeaderText("suppression");
alert.setContentText("le contrat selectionné est supprimé");
alert.showAndWait();
  Stage stage = new Stage();
     
        btnvalider.getScene().getWindow().hide();
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
        home.getScene().getWindow().hide();
       home1.getScene().getWindow().hide();
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
        btnsan.getScene().getWindow().hide();
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
     
        btnsinistre.getScene().getWindow().hide();
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
            
            
            
                  colvalider.setCellValueFactory(cellData -> {

    ContratHabitation s = (ContratHabitation) cellData.getValue();
    if(s instanceof ContratHabitation){
        return new SimpleObjectProperty(((ContratHabitation)s).getValider());
    }
 
    return new SimpleObjectProperty<>(null);
});                        
                   
                  cilid.setCellValueFactory(cellData -> {

    ContratHabitation s = (ContratHabitation) cellData.getValue();
    if(s instanceof ContratHabitation){
        return new SimpleObjectProperty(((ContratHabitation)s).getIdContrat());
    }
 
    return new SimpleObjectProperty<>(null);
});
     colRue.setCellValueFactory(cellData -> {

    ContratHabitation s = (ContratHabitation) cellData.getValue();
    if(s instanceof ContratHabitation){
        return new SimpleObjectProperty(((ContratHabitation)s).getNumeroRue());
    }
 
    return new SimpleObjectProperty<>(null);
});
      colclient.setCellValueFactory(cellData -> {

    ContratHabitation s = (ContratHabitation) cellData.getValue();
    if(s instanceof ContratHabitation){
         return new SimpleObjectProperty(((ContratHabitation)s).getIdClient());
    }
 
    return new SimpleObjectProperty<>(null);
});
                        colcrea.setCellValueFactory(cellData -> {

    ContratHabitation s = (ContratHabitation) cellData.getValue();
    if(s instanceof ContratHabitation){
        return new SimpleObjectProperty(((ContratHabitation)s).getDateCreation());
    }
 
    return new SimpleObjectProperty<>(null);
});
                                       coldeb.setCellValueFactory(cellData -> {

    ContratHabitation s = (ContratHabitation) cellData.getValue();
    if(s instanceof ContratHabitation){
        return new SimpleObjectProperty(((ContratHabitation)s).getDateDebut());
    }
 
    return new SimpleObjectProperty<>(null);
});
       colfin.setCellValueFactory(cellData -> {

    ContratHabitation s = (ContratHabitation) cellData.getValue();
    if(s instanceof ContratHabitation){
        return new SimpleObjectProperty(((ContratHabitation)s).getDateFin());
    }
 
    return new SimpleObjectProperty<>(null);
});
          colgarantie.setCellValueFactory(cellData -> {

    ContratHabitation s = (ContratHabitation) cellData.getValue();
    if(s instanceof ContratHabitation){
        return new SimpleObjectProperty(((ContratHabitation)s).getNiveauDeGarantie());
    }
 
    return new SimpleObjectProperty<>(null);
});
                          colpostal.setCellValueFactory(cellData -> {

    ContratHabitation s = (ContratHabitation) cellData.getValue();
    if(s instanceof ContratHabitation){
        return new SimpleObjectProperty(((ContratHabitation)s).getCodePostal());
    }
 
    return new SimpleObjectProperty<>(null);
});
       colprix.setCellValueFactory(cellData -> {

    ContratHabitation s = (ContratHabitation) cellData.getValue();
    if(s instanceof ContratHabitation){
        return new SimpleObjectProperty(((ContratHabitation)s).getPrix());
    }
 
    return new SimpleObjectProperty<>(null);
});
                        colville.setCellValueFactory(cellData -> {

    ContratHabitation s = (ContratHabitation) cellData.getValue();
    if(s instanceof ContratHabitation){
        return new SimpleObjectProperty(((ContratHabitation)s).getVille());
    }
 
    return new SimpleObjectProperty<>(null);
});
          table.setItems(maisons);  
        
    }

}