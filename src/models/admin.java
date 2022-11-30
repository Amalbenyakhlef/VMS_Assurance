/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;
import java.util.Date;

/**
 *
 * @author Acer
 */
public class admin extends personne{
    private int nbSinistres;
    private int nbContratsValides;
    
    
    public admin(String nom,String prenom,String password,String email,String tel,Date datenaiss,int nbSinistres,int nbContratsValides){
        super( nom, prenom, password, email,tel,datenaiss);
        this.nbContratsValides=nbContratsValides;
        this.nbSinistres=nbSinistres;
    }
  
}
