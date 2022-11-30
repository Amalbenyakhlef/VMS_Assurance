/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

//import java.io.ObjectInputFilter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.UUID;

/**
 *
 * @author admin
 */

public abstract class Contrat {
    private int IdContrat;
    private Date dateCreation;
    private Date dateDebut;
    private Date dateFin ;
    private float prix;          // not yet ***************** 
 
    
    
    public Contrat (int id,Date dc, Date db,Date df, float prix){  //ObjectInputFilter.Status st
        IdContrat= id;//a verifier dans le main ??????
        dateCreation=dc;
        dateDebut=db;
        dateFin=df;
        this.prix=prix;
    
        
    }

    /**
     * @return the IdContrat
     */
    public int getIdContrat() {
        return IdContrat;
    }

    /**
     * @param IdContrat the IdContrat to set
     */
    public void setIdContrat(int IdContrat) {
        this.IdContrat = IdContrat;
    }

    /**
     * @return the dateCreation
     */
    public Date getDateCreation() {
        return dateCreation;
    }

    /**
     * @param dateCreation the dateCreation to set
     */
    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    /**
     * @return the dateDebut
     */
    public Date getDateDebut() {
        return dateDebut;
    }

    /**
     * @param dateDebut the dateDebut to set
     */
    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    /**
     * @return the dateFin
     */
    public Date getDateFin() {
        return dateFin;
    }

    /**
     * @param dateFin the dateFin to set
     */
    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    /**
     * @return the prix
     */
    public float getPrix() {
        return prix;
    }

    /**
     * @param prix the prix to set
     */
    public void setPrix(float prix) {
        this.prix = prix;
    }
    
    
    
    
  

 
    
    
}
