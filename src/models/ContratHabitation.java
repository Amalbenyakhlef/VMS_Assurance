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
public class ContratHabitation extends Contrat {
    private float niveauDeGarantie ;
    private String Ville;
    private String NumeroRue;
    private String CodePostal;

    public ContratHabitation(float niveauDeGarantie, String Ville, String NumeroRue, String CodePostal, int idClient, int IdContrat, String dateCreation, String dateDebut, String dateFin, float prix, String valider) {
        super(idClient, IdContrat, dateCreation, dateDebut, dateFin, prix, valider);
        this.niveauDeGarantie = niveauDeGarantie;
        this.Ville = Ville;
        this.NumeroRue = NumeroRue;
        this.CodePostal = CodePostal;
    }




    public float getNiveauDeGarantie() {
        return niveauDeGarantie;
    }

    public void setNiveauDeGarantie(float niveauDeGarantie) {
        this.niveauDeGarantie = niveauDeGarantie;
    }

    public String getVille() {
        return Ville;
    }

    public void setVille(String Ville) {
        this.Ville = Ville;
    }

    public String getNumeroRue() {
        return NumeroRue;
    }

    public void setNumeroRue(String NumeroRue) {
        this.NumeroRue = NumeroRue;
    }

    public String getCodePostal() {
        return CodePostal;
    }

    public void setCodePostal(String CodePostal) {
        this.CodePostal = CodePostal;
    }

   

   

   
  

    
 
   
    
}
