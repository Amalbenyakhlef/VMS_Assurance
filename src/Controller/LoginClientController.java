/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

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
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;


public class LoginClientController implements Initializable {
        @FXML
    private Button button;

    @FXML
    private PasswordField mdp;

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
    void login(ActionEvent event) throws ClassNotFoundException, SQLException {

            connect();
        String email=user.getText();
        String password=mdp.getText();
      pat = con.prepareStatement("select * from client where email=? and password=?");
      pat.setString(1, email);
      pat.setString(2, password);
      rs= pat.executeQuery();
      if (rs.next()){
          JOptionPane.showMessageDialog(null,"login success");
          
      }
      else
          JOptionPane.showMessageDialog(null,"login failed");
         user.setText("");
       mdp.setText("");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
