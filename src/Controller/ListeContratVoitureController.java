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
import models.Client;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import models.ContratSante;
import models.ContratVoiture;
public class ListeContratVoitureController implements Initializable{
    
    @FXML
    private Button btnsan;

    @FXML
    private Button btnvoi;
    @FXML
    private Button home;
     @FXML
    private Button home1;

    @FXML
    private TableColumn<ContratVoiture, String> colcreation;

    @FXML
    private TableColumn<ContratVoiture, String> coldeb;

    @FXML
    private TableColumn<ContratVoiture, String> colfin;

    @FXML
    private TableColumn<ContratVoiture, String> colid1;

    @FXML
    private TableColumn<ContratVoiture, String> colid2;

    @FXML
    private TableColumn<ContratVoiture, String> colmarque;

    @FXML
    private TableColumn<ContratVoiture, String> colmatricule;

    @FXML
    private TableColumn<ContratVoiture, String> colmodele;

    @FXML
    private TableColumn<ContratVoiture, String> colnivCouverture;

    @FXML
    private TableColumn<ContratVoiture, String> colprix;

    @FXML
    private TableView<ContratVoiture> table;
    
    @FXML
    private TableColumn<ContratVoiture, String> colvalider;
        @FXML
    private Button btnvalider;
           @FXML
    private Button  btnsinistre;
               @FXML
    private Button  btnm;
            @FXML
    private Button btnsupprimer;

    
           ObservableList<ContratVoiture> contratsvoiture =FXCollections.observableArrayList();
    
     Connection con;
    PreparedStatement pat;
    ResultSet rs;
     public void connect() throws ClassNotFoundException, SQLException{
              Class.forName("com.mysql.cj.jdbc.Driver");
         con = DriverManager.getConnection("jdbc:mysql://localhost/vms","root","");}
     
        public void table() throws ClassNotFoundException, SQLException
      {
           pat = con.prepareStatement("select * from contratvehicule");  
           ResultSet rs = pat.executeQuery();
      
        while (rs.next())


            contratsvoiture.add(new ContratVoiture(rs.getString("matricule"),rs.getString("marque"),rs.getString("modele"),
                    rs.getString("niveauCouverture"),rs.getInt("idClient"),rs.getInt("IdContrat"),rs.getString("dateCreation"),
                    rs.getString("dateDebut"),rs.getString("dateFin"),rs.getFloat("prix"),rs.getString("valider")));
            
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
    void valider(ActionEvent event) throws SQLException, IOException {
             
          int myIndex = table.getSelectionModel().getSelectedIndex();
       int idContrat= parseInt(String.valueOf(table.getItems().get(myIndex).getIdContrat()));
          
        String valider="oui";
       
            pat = con.prepareStatement("update contratvehicule set valider = ? where idContrat = ? ");
            pat.setString(1, valider);
           pat.setInt(2, idContrat);
         
            pat.executeUpdate();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

 
alert.setHeaderText("validation");
alert.setContentText("le contrat selectionné est validé");
 
alert.showAndWait();
          Stage stage = new Stage();
     
        btnvalider.getScene().getWindow().hide();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("/FXML/listeContratVoiture.fxml"));
        Scene scene = new Scene(root);
       stage.setScene(scene);
        stage.show();
         stage.setResizable(false);
           

    }
       @FXML
    void delete(ActionEvent event) throws SQLException, IOException {

            int myIndex = table.getSelectionModel().getSelectedIndex();
       int idContrat= parseInt(String.valueOf(table.getItems().get(myIndex).getIdContrat()));
 
        
            pat = con.prepareStatement("delete from contratvehicule where idContrat = ? ");
              pat.setInt(1, idContrat);
            pat.executeUpdate();
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
     
alert.setHeaderText("suppression");
alert.setContentText("le contrat selectionné est supprimé");
alert.showAndWait();
  Stage stage = new Stage();
     
        btnsupprimer.getScene().getWindow().hide();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("/FXML/listeContratVoiture.fxml"));
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
                     colid1.setCellValueFactory(cellData -> {

    ContratVoiture s = cellData.getValue();
    if(s instanceof ContratVoiture){
        return new SimpleObjectProperty(((ContratVoiture)s).getIdContrat());
    }
 
    return new SimpleObjectProperty<>(null);});
                                      colid2.setCellValueFactory(cellData -> {

    ContratVoiture s = cellData.getValue();
    if(s instanceof ContratVoiture){
        return new SimpleObjectProperty(((ContratVoiture)s).getIdClient());
    }
 
    return new SimpleObjectProperty<>(null);});
                  colcreation.setCellValueFactory(cellData -> {

    ContratVoiture s = cellData.getValue();
    if(s instanceof ContratVoiture){
        return new SimpleObjectProperty(((ContratVoiture)s).getDateCreation());
    }
 
    return new SimpleObjectProperty<>(null);});
                              coldeb.setCellValueFactory(cellData -> {

    ContratVoiture s = cellData.getValue();
    if(s instanceof ContratVoiture){
        return new SimpleObjectProperty(((ContratVoiture)s).getDateDebut());
    }
 
    return new SimpleObjectProperty<>(null);});
                              colfin.setCellValueFactory(cellData -> {

    ContratVoiture s = cellData.getValue();
    if(s instanceof ContratVoiture){
        return new SimpleObjectProperty(((ContratVoiture)s).getDateFin());
    }
 
    return new SimpleObjectProperty<>(null);});  
                         colprix.setCellValueFactory(cellData -> {

    ContratVoiture s = cellData.getValue();
    if(s instanceof ContratVoiture){
        return new SimpleObjectProperty(((ContratVoiture)s).getPrix());
    }
 
    return new SimpleObjectProperty<>(null);});
                             colmatricule.setCellValueFactory(cellData -> {

    ContratVoiture s = cellData.getValue();
    if(s instanceof ContratVoiture){
        return new SimpleObjectProperty(((ContratVoiture)s).getMatricule());
    }
 
    return new SimpleObjectProperty<>(null);});
                            colmarque.setCellValueFactory(cellData -> {

    ContratVoiture s = cellData.getValue();
    if(s instanceof ContratVoiture){
        return new SimpleObjectProperty(((ContratVoiture)s).getMarque());
    }
 
    return new SimpleObjectProperty<>(null);});
                                   colmodele.setCellValueFactory(cellData -> {

    ContratVoiture s = cellData.getValue();
    if(s instanceof ContratVoiture){
        return new SimpleObjectProperty(((ContratVoiture)s).getModele());
    }
 
    return new SimpleObjectProperty<>(null);});
                                  colnivCouverture.setCellValueFactory(cellData -> {

    ContratVoiture s = cellData.getValue();
    if(s instanceof ContratVoiture){
        return new SimpleObjectProperty(((ContratVoiture)s).getNiveauCouverture());
    }
 
    return new SimpleObjectProperty<>(null);});  
                                                                    colvalider.setCellValueFactory(cellData -> {

    ContratVoiture s = cellData.getValue();
    if(s instanceof ContratVoiture){
        return new SimpleObjectProperty(((ContratVoiture)s).getValider());
    }
 
    return new SimpleObjectProperty<>(null);}); 
                     

              table.setItems(contratsvoiture);
    }            

}
    



