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
import models.Client;
import models.ContratSante;

public class ListeContratSanteController implements Initializable{

    @FXML
    private TableColumn<ContratSante, String> cilFin;

    @FXML
    private TableColumn<ContratSante, String> colDeb;

    @FXML
    private TableColumn<ContratSante, String> colGen;

    @FXML
    private TableColumn<ContratSante, String> colHospital;

    @FXML
    private TableColumn<ContratSante, String> colID1;

    @FXML
    private TableColumn<ContratSante, String> colID2;

    @FXML
    private TableColumn<ContratSante, String> colOptique;

    @FXML
    private TableColumn<ContratSante, String> colPrix;

    @FXML
    private TableColumn<ContratSante, String> colSpecial;

    @FXML
    private TableColumn<ContratSante, String> colcreation;

    @FXML
    private TableColumn<ContratSante, String> colnivcouverture;

    @FXML
    private TableView<ContratSante> table;
    
    @FXML
    private Button btnsan;
        @FXML
    private Button btnm;
      @FXML
    private Button btnsinistre;
    
        @FXML
    private TableColumn<ContratSante, String> colvalider;

    @FXML
    private Button btnvoi;
    
      @FXML
    private Button home;
         @FXML
    private Button home1;
             @FXML
    private Button btnvalider;
  
                 @FXML
    private Button btnsupprimer;
     ObservableList<ContratSante> contratsSante=FXCollections.observableArrayList();
    
     Connection con;
    PreparedStatement pat;
    ResultSet rs;
     public void connect() throws ClassNotFoundException, SQLException{
              Class.forName("com.mysql.cj.jdbc.Driver");
         con = DriverManager.getConnection("jdbc:mysql://localhost/vms","root","");}
    
         public void table() throws ClassNotFoundException, SQLException
      {
           pat = con.prepareStatement("select * from contratsante");  
           ResultSet rs = pat.executeQuery();
      
        while (rs.next())
        {

            contratsSante.add(new ContratSante(rs.getFloat("medicauxGeneraliste"),rs.getFloat("medicauxSpecialiste"),rs.getFloat("optique"),rs.getFloat("hospitaliers"),
                    rs.getFloat("niveauCouverture"),rs.getInt("idClient"),rs.getInt("IdContrat"),rs.getString("dateCreation"),
                    rs.getString("dateDebut"),rs.getString("dateFin"),rs.getFloat("prix"),rs.getString("valider")));
       }}
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
    void valider(ActionEvent event) throws SQLException, IOException {
              int myIndex = table.getSelectionModel().getSelectedIndex();
       int idContrat= parseInt(String.valueOf(table.getItems().get(myIndex).getIdContrat()));
          
        String valider="oui";
       
            pat = con.prepareStatement("update contratsante set valider = ? where idContrat = ? ");
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
        root = FXMLLoader.load(getClass().getResource("/FXML/listeContratSante.fxml"));
        Scene scene = new Scene(root);
       stage.setScene(scene);
        stage.show();
         stage.setResizable(false);
           

    }
           @FXML
    void delete(ActionEvent event) throws SQLException, IOException {

            int myIndex = table.getSelectionModel().getSelectedIndex();
       int idContrat= parseInt(String.valueOf(table.getItems().get(myIndex).getIdContrat()));
 
        
            pat = con.prepareStatement("delete from contratsante where idContrat = ? ");
              pat.setInt(1, idContrat);
            pat.executeUpdate();
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
     
alert.setHeaderText("suppression");
alert.setContentText("le contrat selectionné est supprimé");
alert.showAndWait();
  Stage stage = new Stage();
     
        btnvalider.getScene().getWindow().hide();
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
                colID1.setCellValueFactory(cellData -> {

    ContratSante s = (ContratSante) cellData.getValue();
    if(s instanceof ContratSante){
        return new SimpleObjectProperty(((ContratSante)s).getIdContrat());
    }
 
    return new SimpleObjectProperty<>(null);
});
                    colID2.setCellValueFactory(cellData -> {

    ContratSante s = (ContratSante) cellData.getValue();
    if(s instanceof ContratSante){
        return new SimpleObjectProperty(((ContratSante)s).getIdClient());
    }
 
    return new SimpleObjectProperty<>(null);
});
                 colID1.setCellValueFactory(cellData -> {

    ContratSante s = (ContratSante) cellData.getValue();
    if(s instanceof ContratSante){
        return new SimpleObjectProperty(((ContratSante)s).getIdContrat());
    }
 
    return new SimpleObjectProperty<>(null);
});
                              colID1.setCellValueFactory(cellData -> {

    ContratSante s = (ContratSante) cellData.getValue();
    if(s instanceof ContratSante){
        return new SimpleObjectProperty(((ContratSante)s).getIdContrat());
    }
 
    return new SimpleObjectProperty<>(null);
});
                                colcreation.setCellValueFactory(cellData -> {

    ContratSante s = (ContratSante) cellData.getValue();
    if(s instanceof ContratSante){
        return new SimpleObjectProperty(((ContratSante)s).getDateCreation());
    }
 
    return new SimpleObjectProperty<>(null);
});
                            colDeb.setCellValueFactory(cellData -> {

    ContratSante s = (ContratSante) cellData.getValue();
    if(s instanceof ContratSante){
        return new SimpleObjectProperty(((ContratSante)s).getDateDebut());
    }
 
    return new SimpleObjectProperty<>(null);
});
                         cilFin.setCellValueFactory(cellData -> {

    ContratSante s = (ContratSante) cellData.getValue();
    if(s instanceof ContratSante){
        return new SimpleObjectProperty(((ContratSante)s).getDateFin());
    }
 
    return new SimpleObjectProperty<>(null);
});
                              colPrix.setCellValueFactory(cellData -> {

    ContratSante s = (ContratSante) cellData.getValue();
    if(s instanceof ContratSante){
        return new SimpleObjectProperty(((ContratSante)s).getPrix());
    }
 
    return new SimpleObjectProperty<>(null);
}); 
                             colGen.setCellValueFactory(cellData -> {

    ContratSante s = (ContratSante) cellData.getValue();
    if(s instanceof ContratSante){
        return new SimpleObjectProperty(((ContratSante)s).getMedicauxGeneraliste());
    }
 
    return new SimpleObjectProperty<>(null);
});     
                                colSpecial.setCellValueFactory(cellData -> {

    ContratSante s = (ContratSante) cellData.getValue();
    if(s instanceof ContratSante){
        return new SimpleObjectProperty(((ContratSante)s).getMedicauxSpecialiste());
    }
 
    return new SimpleObjectProperty<>(null);
});
                               colOptique.setCellValueFactory(cellData -> {

    ContratSante s = (ContratSante) cellData.getValue();
    if(s instanceof ContratSante){
        return new SimpleObjectProperty(((ContratSante)s).getOptique());
    }
 
    return new SimpleObjectProperty<>(null);
});
                               colHospital.setCellValueFactory(cellData -> {

    ContratSante s = (ContratSante) cellData.getValue();
    if(s instanceof ContratSante){
        return new SimpleObjectProperty(((ContratSante)s).getHospitaliers());
    }
 
    return new SimpleObjectProperty<>(null);
});                         
                                       colnivcouverture.setCellValueFactory(cellData -> {

    ContratSante s = (ContratSante) cellData.getValue();
    if(s instanceof ContratSante){
        return new SimpleObjectProperty(((ContratSante)s).getNiveauCouverture());
    }
 
    return new SimpleObjectProperty<>(null);
});      
         colvalider.setCellValueFactory(cellData -> {

    ContratSante s = (ContratSante) cellData.getValue();
    if(s instanceof ContratSante){
        return new SimpleObjectProperty(((ContratSante)s).getValider());
    }
 
    return new SimpleObjectProperty<>(null);
});                        
                                       
         table.setItems(contratsSante);
         
    }

}
