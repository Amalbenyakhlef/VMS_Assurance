/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

//import com.sun.jdi.connect.Transport;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


/**
 * FXML Controller class
 *
 * @author admin
 */
public class ContactUsController implements Initializable {

     @FXML
    private Button btnEnvoyer;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextArea txtMsg;

    @FXML
    private TextField txtNamePrenom;
    
    

    @FXML
    void Envoyer(ActionEvent event){
        
        
       
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
