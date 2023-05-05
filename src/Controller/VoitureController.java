/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.beans.Statement;
import java.io.IOException;
//import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
/**
 *
 * @author admin
 */
public class VoitureController implements Initializable {
     @FXML
    private Button btnAssurer;
     
     @FXML
    private Button btnSinistre;
     
      @FXML
    private Button btnHome1;

    @FXML
    private TextField matricule0;
    
    @FXML
    private TextField idClient;
       @FXML
    private Button btnservice;
      @FXML
    private Label lab2;
      public void dispalyMatricule2(String m){
         lab2.setText(m);
     }
     @FXML
    private Label lab;
     public void dispalyMatricule(String m){
         lab.setText(m);
     }

    
    
    @FXML
    private Button btnEnregistrer;
    
     @FXML
    private ImageView Home;
     
         @FXML
    private Button btnHome2;
         
         @FXML
    private ImageView previousImg;
         
          @FXML
    private Button btnprevious;


    @FXML
    private ToggleGroup choices;

    @FXML
    private TextField marque;

    @FXML
    private Label matricule;

    @FXML
    private TextField modele;

    @FXML
    private RadioButton niveau100;

    @FXML
    private RadioButton niveau50;

    @FXML
    private RadioButton niveau80;

    
    
    Connection con;
    PreparedStatement pat;
    PreparedStatement pat1;

    PreparedStatement pst;
    ResultSet rs;
    String mat;
    float niveauCouverture;
    
    
     public void connect() throws ClassNotFoundException, SQLException{
         Class.forName("com.mysql.cj.jdbc.Driver");
         con = DriverManager.getConnection("jdbc:mysql://localhost/vms","root","");
    }
     
    
         @FXML
    void pageMatricule(ActionEvent event) throws IOException {
        Stage matricule = new Stage();
        btnprevious.getScene().getWindow().hide();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("/FXML/MatriculeVoiture.fxml"));
        matricule.setTitle("Déclaration d'un Sinistre");
        Scene scene = new Scene(root);
        matricule.setScene(scene);
        matricule.show();
        matricule.setResizable(true);
    }
    
    @FXML
    void serviceClient(ActionEvent event) throws IOException {
        Stage service = new Stage();
        btnservice.getScene().getWindow().hide();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("/FXML/serviceClient.fxml"));  //******rgereredee
        Scene scene = new Scene(root);
        service.setScene(scene);
        service.show();
        service.setResizable(true);
    }
     

     
     //Scene of matricule voiture
    @FXML
    void assurerVoiture(ActionEvent event) throws IOException, ClassNotFoundException, SQLException {
        
        connect();
        //mat=matricule0.getText();
        
        //static_matri.setText(mat);
        
       /* try{
            mat=matricule0.getText();
            System.out.println(mat);
        }
        catch(NumberFormatException e){
            System.out.println("Enter plz only numbers !!!");
        } 
        catch(Exception e) {
            System.out.println(e);
        }*/
       int IdContrat=incrementIdContrat();   //id contrat 
       String matr=matricule0.getText();
      
 
       
       
       int idC =Integer.parseInt(lab2.getText());
      
       String mar="";
       String mod="";
       float niveau=0;
        
       
        
        String dateCreation="";
        String dateDebut="";
        String dateFin="";
        float prix=(float) 00.00; 
        String val="non";
       
        // verification de l'existance de client dans la table client !!!!
        //pat2=con.prepareStatement();
        
        pat = con.prepareStatement("insert into contratvehicule(IdContrat,idClient,dateCreation,dateDebut,dateFin,prix,matricule,marque,modele,niveauCouverture,valider) values(?,?,?,?,?,?,?,?,?,?,?)");
        pat.setInt(1, IdContrat);
        pat.setInt(2, idC);
        pat.setString(3,dateCreation);
        pat.setString(4,dateDebut);
        pat.setString(5,dateFin );
        pat.setFloat(6,prix );
        pat.setString(7, matr);
        pat.setString(8, mar);
        pat.setString(9, mod);
        pat.setFloat(10, niveau);
         pat.setString(11, val);
        pat.executeUpdate();
        
        
        Stage matriculeVoiture = new Stage();
        btnAssurer.getScene().getWindow().hide();
        Parent root1;
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/FXML/DetailsVoiture.fxml"));
        root1=loader.load();
        VoitureController v=loader.getController();
       v.dispalyMatricule(matr);
  
        
        matriculeVoiture.setTitle("Détails de votre Voiture");
        Scene scene = new Scene(root1);
        matriculeVoiture.setScene(scene);
        matriculeVoiture.show();
        matriculeVoiture.setResizable(true);
        
        
        
       /*
        String matrr;
        pat2=con.prepareStatement("select matricule from contratvehicule ");
        ResultSet rs3 = pat1.executeQuery();
        while (rs3.next()){
            matrr= rs3.getString("matricule");
               lab.setText(matrr);*/
            
        
        
     
    }
    
    
    
    @FXML
    void Constat(ActionEvent event) throws IOException {
        Stage declarerSinistre = new Stage();
        btnSinistre.getScene().getWindow().hide();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("/FXML/SinistreVoiture.fxml"));
        declarerSinistre.setTitle("Vms assurance voitures");
        Scene scene = new Scene(root);
        declarerSinistre.setScene(scene);
        declarerSinistre.show();
        declarerSinistre.setResizable(true);
    }
    
      @FXML
    void homeMatricule(ActionEvent event) throws IOException {
        Stage homeMatricule = new Stage();
        btnHome1.getScene().getWindow().hide();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("/FXML/loginClient.fxml"));
        homeMatricule.setTitle("Vms assurance ");
        Scene scene = new Scene(root);
        homeMatricule.setScene(scene);
        homeMatricule.show();
        homeMatricule.setResizable(true);
    }
    
   
    @FXML
    void home(ActionEvent event) throws IOException {
        
        Stage home = new Stage();
        btnHome2.getScene().getWindow().hide();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("/FXML/loginClient.fxml"));
        home.setTitle("Vms assurance ");
        Scene scene = new Scene(root);
        home.setScene(scene);
        home.show();
        home.setResizable(true);
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
             pst = con.prepareStatement("SELECT COUNT(*) AS countVehicule FROM contratvehicule");
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
    
    /* public void displayMatricule(){
         matricule.setText(mat);
     }*/
     
     //public static Label static_matri;
    
    
    // scene of details voiture
     @FXML
    void enregistrer(ActionEvent event) throws ClassNotFoundException, SQLException  {
        
        
        connect();
      /*  String matr;
        
        pat1=con.prepareStatement("select matricule from contratvehicule ");
        ResultSet rs2 = pat1.executeQuery();
        while (rs2.next()){
            matr= rs2.getString("matricule");
            
        }*/
      
        
        
        
    
        
        
        int IdContrat =(int) incrementIdContrat()-1;
        String mar=marque.getText();
        String mod=modele.getText();
        float niveau=niveauCouverture;
        String dateCreation="12-02-2000";
        String dateDebut="13-02-2000";
        String dateFin="23-02-2010";
        float prix=(float) 20.00; 
       
        pat = con.prepareStatement("update contratvehicule set dateCreation = ? ,dateDebut = ?, dateFin = ? , prix = ?, marque = ?, modele = ?, niveauCouverture = ? where IdContrat = ? ");
        pat.setInt(8, IdContrat);
        pat.setString(1,dateCreation);
        pat.setString(2,dateDebut);
        pat.setString(3,dateFin );
        pat.setFloat(4,prix );
        pat.setString(5, mar);
        pat.setString(6, mod);
        pat.setFloat(7, niveau);

            pat.executeUpdate();
            
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("Contrat voiture ");
 
alert.setHeaderText("Contrat voiture");
alert.setContentText("contrat ajouté!");
 
alert.showAndWait();
                
        
       /* matricule.setText(mat);  /// how to retrive the value of matricule from matricule Voiture !!!!
        
        //String matr=(String)matricule0.getSelectedText();
        
        String matr=matricule.getText();
        String mar=marque.getText();
        String mod=modele.getText();
        float niveau=niveauCouverture;
     
        //displayMatricule();
        
        int IdContrat=incrementIdContrat();
        String dateCreation="12-02-2000";
        String dateDebut="13-02-2000";
        String dateFin="23-02-2010";
        float prix=(float) 20.00; 
        
        
        pat = con.prepareStatement("insert into contratvehicule(IdContrat,dateCreation,dateDebut,dateFin,prix,matricule,marque,modele,niveauCouverture) values(?,?,?,?,?,?,?,?,?)");
        pat.setInt(1, IdContrat);
        pat.setString(2,dateCreation);
        pat.setString(3,dateDebut);
        pat.setString(4,dateFin );
        pat.setFloat(5,prix );
        pat.setString(6, matr);
        pat.setString(7, mar);
        pat.setString(8, mod);
        pat.setFloat(9, niveau);

        pat.executeUpdate();*/
        
        
        
        
        /*Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Validation");
        alert.setHeaderText("Voiture Registration");
        alert.setContentText("Ajout Validé!");
        alert.showAndWait();*/

         
          matricule.setText("");
          modele.setText("");
          marque.setText("");
          niveauCouverture=(float) 0.0;
          
        
    }
    
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         try {
              connect();
         
              //static_matri=matricule;
          } catch (ClassNotFoundException ex) {
              java.util.logging.Logger.getLogger(VoitureController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (SQLException ex) {
              java.util.logging.Logger.getLogger(VoitureController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }
    }    
  
    

}
