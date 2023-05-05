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
import javafx.fxml.Initializable;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


public class LoginClientController implements Initializable {
        @FXML
    private Button btn;
        @FXML
    private Button button;
        
        
    @FXML
    private Button btnContact;

    @FXML
    private PasswordField mdp;

    @FXML
    private TextField user;
    public int idClientLogin;
    
        Connection con;
    PreparedStatement pat;
    ResultSet rs;

        public void connect() throws ClassNotFoundException, SQLException{
              Class.forName("com.mysql.cj.jdbc.Driver");
         con = DriverManager.getConnection("jdbc:mysql://localhost/vms","root","");
    }
        
        
        
    @FXML
    void contact(ActionEvent event) throws IOException {
           Stage stage = new Stage();
        btnContact.getScene().getWindow().hide();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("/FXML/ContactUs.fxml"));
        Scene scene = new Scene(root);
       stage.setScene(scene);
        stage.show();
         stage.setResizable(false);
    }
        
    @FXML
    void login(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {

            connect();
        String email=user.getText();
        String password=mdp.getText();
      pat = con.prepareStatement("select idClient from client where email=? and password=?");
      pat.setString(1, email);
      pat.setString(2, password);
      rs= pat.executeQuery();
      
    

      if (rs.next()){
          
         int id =(int) rs.getInt("idClient");
      
       
          System.out.println(id);
          JOptionPane.showMessageDialog(null,"login success");
          
                 Stage stage = new Stage();
        button.getScene().getWindow().hide();
        Parent root;
         FXMLLoader loader=new FXMLLoader(getClass().getResource("/FXML/serviceClient.fxml"));
         root =loader.load();
          ServiceClientController s=loader.getController();
       s.dispalyMatricule1(Integer.toString(id));
        Scene scene = new Scene(root);
       stage.setScene(scene);
        stage.show();
         stage.setResizable(false);
      }
      else
          JOptionPane.showMessageDialog(null,"login failed");
         user.setText("");
       mdp.setText("");
    }
    
        @FXML
    void inscrii(ActionEvent event) throws IOException {

          Stage stage = new Stage();
        btn.getScene().getWindow().hide();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("/FXML/inscriptionClient.fxml"));
        Scene scene = new Scene(root);
       stage.setScene(scene);
        stage.show();
         stage.setResizable(false);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
