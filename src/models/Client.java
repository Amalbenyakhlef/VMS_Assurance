/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;
import java.util.Date;
import java.util.ArrayList;
import java.util.stream.Stream;
import models.Contrat;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author Acer
 */
public class Client extends personne {
    private int idClient;

    public Client(int idClient, String nom, String prenom, String password, String email, String tel, String datenaiss) {
        super(nom, prenom, password, email, tel, datenaiss);
        this.idClient = idClient;
    }

  

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }
   
    
    
    
  
    
    
    
}
