/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class InscriptionClientController {

    @FXML
    private TextField adr;

    @FXML
    private Button button;
    
    @FXML
    private Button btnHome;
   

    @FXML
    private TextField dn;

    @FXML
    private PasswordField mdp;

    @FXML
    private TextField nom;

    @FXML
    private TextField prenom;

    @FXML
    private TextField tel;

    @FXML
    private TextField user;
    
          Connection con;
    PreparedStatement pat;
    ResultSet rs;

        public void connect() throws ClassNotFoundException, SQLException{
              Class.forName("com.mysql.cj.jdbc.Driver");
         con = DriverManager.getConnection("jdbc:mysql://localhost/vms","root","");
    }
        
        
        
    @FXML
    void home(ActionEvent event) throws IOException {
         Stage stage = new Stage();
        btnHome.getScene().getWindow().hide();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("/FXML/loginClient.fxml"));
        stage.setTitle("login de VMS assurance");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(true);
    }

    @FXML
    void inscri(ActionEvent event) throws ClassNotFoundException, SQLException {
     connect();
         String no=nom.getText();
    String preno=prenom.getText();
    String password=mdp.getText();
     String email=user.getText();
    String t=tel.getText();
    String datenaiss=dn.getText();
    int id = 8;//??????????
        
            pat = con.prepareStatement("insert into client(idClient,nom,prenom,tel,email,password,datenaiss) values(?,?,?,?,?,?,?)");
            pat.setInt(1,id);
            pat.setString(2, no);
             pat.setString(3, preno);
             pat.setString(4, t);
             pat.setString(5, email);
             pat.setString(6, password);
           pat.setString(7, datenaiss);
            pat.executeUpdate();
        
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("login");
 
alert.setHeaderText("Student Registation");
alert.setContentText("Record Addedddd!");
 
alert.showAndWait();
        
    }

}