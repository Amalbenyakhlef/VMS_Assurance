/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

/*import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;*/

import com.mysql.cj.protocol.Message;
import com.mysql.cj.xdevapi.Session;
import com.sun.jdi.connect.Transport;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.time.LocalDate;
//import java.util.Properties;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
//import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.ProgressIndicator;
//import org.w3c.dom.Document;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class SinistreVoitureController implements Initializable {

        @FXML
    private Button btnHsinistre;
        
  @FXML
    private TextField Degat;

    @FXML
    private TextField IdConstat;

    @FXML
    private TextField Tel;

    @FXML
    private Button btnEnvoyer;

    @FXML
    private Button btnPdf;

    @FXML
    private TextField dateDéclar;

    @FXML
    private TextField idClient;

    @FXML
    private TextField typeAccident;
    
    /* @FXML
    private DatePicker dateDéclar;*/

    
       @FXML
    private ProgressIndicator progressIndicator;
       
    
    
     Connection con;
    PreparedStatement pat;
    PreparedStatement pst;
    ResultSet rs;
    
    public void connect() throws ClassNotFoundException, SQLException{
         Class.forName("com.mysql.cj.jdbc.Driver");
         con = DriverManager.getConnection("jdbc:mysql://localhost/vms","root","");
    }
    
    @FXML
    void serviceClient(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        btnHsinistre.getScene().getWindow().hide();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("/FXML/serviceClient.fxml"));
        stage.setTitle("Service de VMS assurance");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(true);
    }
    
    
    // On va utiliser num pour numeroté les fiches de constats lors de l'affichage 
    public int NumeroConstat() throws ClassNotFoundException, SQLException
    {
        connect();
        int Num = 0;
    try
        {  
             pst = con.prepareStatement("SELECT COUNT(*) AS countConstat FROM sinistrevoiture");
             ResultSet rs = pst.executeQuery();
             while(rs.next())
             {
              //int count = rs.getInt("countVehicule");
              Num =(int) rs.getInt("countConstat")+1;
              //txtmsg.setText(String.valueOf(count));
 
                
             }
        }
           catch (SQLException ex)
          {
            ex.printStackTrace();
           }
        
    return Num;
       
    }
    
         /*** the progress indicator that the pdf file is already genereated   **/
    public void progress(ProgressIndicator p){
        double value = p.getProgress();
        /*if(value < 0){
            value = 0.1;
        }else{
            value = value + 0.1;
            if(value >= 1.0){
                value = 1.0;
            }
        }*/
        value=1.0;
        p.setProgress(value);
        
    }
    
    
    @FXML
    void Constat(ActionEvent event) throws SQLException, ClassNotFoundException {
        connect();
        
        int idC=Integer.parseInt(idClient.getText());
        // get the date picker value
        //LocalDate DateD = dateDéclar.getValue();
        String DateD=dateDéclar.getText();
        float deg=Float.parseFloat(Degat.getText());
        int idConst=Integer.parseInt(IdConstat.getText());
        String ty=typeAccident.getText();
        String tel=Tel.getText();
        
        
        
        
        pat = con.prepareStatement("insert into sinistrevoiture(idClient,dateDéclaration,Dégats,idConstat,TypeAccident,tel) values(?,?,?,?,?,?)");
        pat.setInt(1, idC);
        pat.setString(2,DateD);
        pat.setFloat(3,deg);
        pat.setInt(4,idConst );
        pat.setString(5,ty );
        pat.setString(6, tel);
       
            pat.executeUpdate();
            
     
      
            
            
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
       alert.setTitle("Constat Voiture N°"+NumeroConstat()+"!!!");

        alert.setHeaderText("Sinistre Voiture Déclaré");
        alert.setContentText("ajouté avec succes");

        alert.showAndWait();
        
        
        // the indicator of the progress sign 
        progress(progressIndicator);
        
        
        idClient.setText("");
        dateDéclar.setText("");
        Degat.setText("");
        IdConstat.setText("");
        typeAccident.setText("");
        Tel.setText("");
        
        
        
    }

    
    
    @FXML
    void ConstatPdf(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        /*
        int idC=Integer.parseInt(idClient.getText());
        String DateD=dateDéclar.getText();
        float deg=Float.parseFloat(Degat.getText());
        int idConst=Integer.parseInt(idClient.getText());
        String ty=typeAccident.getText();
        String tel=Tel.getText();
        
//        System.out.println(x);
//        nom.setText(x );

        connect();  // to establish the connection with the data base
        Document document = new Document();
        try{
            PdfWriter.getInstance(document, new FileOutputStream("Constat de Voiture N°"+idConst+".pdf"));
            document.open();
            
            //add image to pdf file
            document.add(Image.getInstance("/images/AssuranceIcon.png"));  //for the test*****************************
            
            
            
            pat=con.prepareStatement("SELECT * FROM sinistrevoiture");
            rs=pat.executeQuery();
            
            while (rs.next()){
                Paragraph p = new Paragraph(rs.getString("DateD")+""+rs.getString("tel"));
                document.add(p);
                document.add(new Paragraph(" "));
               
            }
            
            //Font.UNDERLINE
            
           Font f=new Font(FontFactory.getFont(FontFactory.TIMES_BOLD,24,Font.BOLDITALIC));
            f.setColor(0,153,255);
            
           Font f2=new Font(FontFactory.getFont(FontFactory.TIMES_BOLD,20,Font.BOLD));
           f2.setColor(0,0,0);
           
           // Paragraph p1 = new Paragraph("Facture numéro :  "+ inumFact ,f);
          //  p1.setAlignment(Paragraph.ALIGN_CENTER);
            Paragraph p0 = new Paragraph("     ");
                 
            Paragraph p2 = new Paragraph("__________________________________________________________________________");
          //  Paragraph p4 = new Paragraph("   -   Montant :   " +"                       "+imontant);
            //p4.add(sage);
            //Paragraph p5 = new Paragraph("   -   Identifiant du patient :  "+"          "+iid_patient);
            //p5.add(stel);
            Paragraph p9 = new Paragraph("Bienvenue au clinique JOKER INFO ❤ ");
            p9.setAlignment(Paragraph.ALIGN_RIGHT);
            
	    
            document.add(p0);
           // document.add(p1);
            document.add(p0);
            document.add(p2);
            document.add(p0);
            document.add(p0);
           // document.add(p4);
            document.add(p0);
            //document.add(p5);
            document.add(p0);
            document.add(p2);
            document.add(p0);
            document.add(p0);
            document.add(p9);
            
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("VMS Assurance Voiture");
                alert.setContentText("Constat ( "+ idConst + " ) du CLIENT  ( " + idC + " )   génerée avec succés !");
                alert.showAndWait();
        }
        catch(DocumentException | FileNotFoundException e){
            System.out.println(e);
        }
        document.close();*/
    }
    
  
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    }