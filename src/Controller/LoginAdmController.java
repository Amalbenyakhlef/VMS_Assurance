/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;




import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

public class LoginAdmController {

    @FXML
    private Button button;

    @FXML
    private PasswordField pass;

    @FXML
    private TextField user;
    
       Connection con;
    PreparedStatement pat;
    PreparedStatement pst1;
    PreparedStatement pst2;
    PreparedStatement pst3;
    ResultSet rs;

        public void connect() throws ClassNotFoundException, SQLException{
              Class.forName("com.mysql.cj.jdbc.Driver");
         con = DriverManager.getConnection("jdbc:mysql://localhost/vms","root","");
    }

    @FXML
    void login2(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
              connect();
              String h = null;
              String v = null;
              String s = null;
              
                        pst1 = con.prepareStatement("SELECT COUNT(*) AS counts FROM contratsante");
                ResultSet rs1 = pst1.executeQuery();
             while(rs1.next())
             {
              //int count = rs.getInt("countVehicule");
             s =Integer.toString(rs1.getInt("counts"));
              //txtmsg.setText(String.valueOf(count));
 
                
             }
             pst2 = con.prepareStatement("SELECT COUNT(*) AS countv FROM contratvehicule");
                ResultSet rs2 = pst2.executeQuery();
             while(rs2.next())
             {
              //int count = rs.getInt("countVehicule");
              v =Integer.toString(rs2.getInt("countv"));
              //txtmsg.setText(String.valueOf(count));
 
                
             }
             pst3 = con.prepareStatement("SELECT COUNT(*) AS counth FROM contratmaison");
             
             ResultSet rs3 = pst3.executeQuery();
             while(rs3.next())
             {
              //int count = rs.getInt("countVehicule");
              h = Integer.toString(rs3.getInt("counth"));
              //txtmsg.setText(String.valueOf(count));
 
                
             }
              
        String email=user.getText();
        String password=pass.getText();
      pat = con.prepareStatement("select * from admin where email=? and password=?");
      pat.setString(1, email);
      pat.setString(2, password);
      rs= pat.executeQuery();
      if (rs.next()){
             Stage stage = new Stage();
        button.getScene().getWindow().hide();
        
          Parent root;
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/FXML/interfaceAdmin.fxml"));
        root=loader.load();
        InterfaceAdminController v1 =loader.getController();
     v1.dispaly(h, s, v);
        
        
     
        Scene scene = new Scene(root);
       stage.setScene(scene);
        stage.show();
         stage.setResizable(false);
         
         
   
         
          
      }
      else
          JOptionPane.showMessageDialog(null,"login failed");
         user.setText("");
       pass.setText("");
    }

}