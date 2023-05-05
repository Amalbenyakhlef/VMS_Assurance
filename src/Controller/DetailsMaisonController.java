/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;


import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.io.IOException;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class DetailsMaisonController implements Initializable {

  

    @FXML
    private Button btnEnregistrer;

    @FXML
    private Button btnPrevious;

    @FXML
    private ToggleGroup garantie;

    @FXML
    private RadioButton niveau100;

    @FXML
    private RadioButton niveau50;

    @FXML
    private RadioButton niveau80;
    
        @FXML
    private TextField txtCode;

    @FXML
    private TextField txtRue;

    @FXML
    private TextField txtVille;
    
      @FXML
    private Label code;
    
    
    float niveauCouverture;
    
    Connection con;
    PreparedStatement pat;
    PreparedStatement pst;
    ResultSet rs;
    
      public void connect() throws ClassNotFoundException, SQLException{
         Class.forName("com.mysql.cj.jdbc.Driver");
         con = DriverManager.getConnection("jdbc:mysql://localhost/vms","root","");
    }
      
     
           public void dispalyidClient2(String m){
         code.setText(m);
     }

    

    @FXML
    void Enregistrer(ActionEvent event) throws ClassNotFoundException, SQLException {
        
        connect();
          String CodePostal=txtCode.getText();
        String Ville=txtVille.getText();
        String Rue=txtRue.getText();
        
        float niveau=niveauCouverture;
        int IdContrat =(int) incrementIdContrat();
        int idC=Integer.parseInt(code.getText());
        String dateCreation="14-12-2022";
        String dateDebut="16-12-2022";
        String dateFin="16-12-2023";
        float prix=(float) 20.00;
        String valid="non";
        
        pat = con.prepareStatement("insert into contratmaison(IdContrat,idClient,dateCreation,dateDebut,dateFin,prix,Ville,NumeroRue,CodePostal,niveauDeGarantie,valider) values(?,?,?,?,?,?,?,?,?,?,?)");
        pat.setInt(1, IdContrat);
        pat.setInt(2, idC);
        pat.setString(3,dateCreation);
        pat.setString(4,dateDebut);
        pat.setString(5,dateFin );
        pat.setFloat(6,prix );
        pat.setString(7, Ville);
        pat.setString(8, Rue);
        pat.setString(9, CodePostal);
        pat.setFloat(10, niveau);
        pat.setString(11, valid);
        
        pat.executeUpdate();
        
        
          Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("Contrat Maison  ");
 
alert.setHeaderText("Contrat Maison VMS ");
alert.setContentText("contrat Maison ajouté!");
 
alert.showAndWait();


txtCode.setText("");
txtVille.setText("");
txtRue.setText("");
        
        

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
    void choice(ActionEvent event) {
        if (niveau50.isSelected()){
            niveauCouverture=(float) 50;
        }else if (niveau80.isSelected()){
            niveauCouverture=(float) 80;
        }else if(niveau100.isSelected()){
            niveauCouverture=(float) 100;
        }
    }
    
    public int incrementIdContrat() throws ClassNotFoundException, SQLException
    {
        connect();
        int idcontrat = 0;
    try
        {  
             pst = con.prepareStatement("SELECT COUNT(*) AS countVehicule FROM contratmaison");
             ResultSet rs = pst.executeQuery();
             while(rs.next())
             {
              //int count = rs.getInt("countVehicule");
              idcontrat =(int) rs.getInt("countVehicule")+1;
              //txtmsg.setText(String.valueOf(count));
 
                
             }
        }
           catch (SQLException ex)
          {
            ex.printStackTrace();
           }
        
    return idcontrat;
       
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
