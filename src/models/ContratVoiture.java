/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.Date;

/**
 *
 * @author admin
 */
public class ContratVoiture extends Contrat {
    private String matricule;
    
    private String marque;
    private String modele;
 
  
    private String niveauCouverture;

    public ContratVoiture(String matricule, String marque, String modele, String niveauCouverture, int idClient, int IdContrat, String dateCreation, String dateDebut, String dateFin, float prix, String valider) {
        super(idClient, IdContrat, dateCreation, dateDebut, dateFin, prix, valider);
        this.matricule = matricule;
        this.marque = marque;
        this.modele = modele;
        this.niveauCouverture = niveauCouverture;
    }

 
 

  
 

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

 


    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }



 

    public String getNiveauCouverture() {
        return niveauCouverture;
    }

    public void setNiveauCouverture(String niveauCouverture) {
        this.niveauCouverture = niveauCouverture;
    }




  
   

    
  
    
}
