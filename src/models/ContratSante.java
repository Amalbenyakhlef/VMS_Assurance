/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;
/**
 *
 * @author admin
 */
public class ContratSante extends Contrat {
    private float medicauxGeneraliste;
    private float medicauxSpecialiste;
    private float optique;
    private float hospitaliers;
    private float niveauCouverture;  //juste pour des informations supplémentaires au niveau d'affichage !!!!

    public ContratSante(float medicauxGeneraliste, float medicauxSpecialiste, float optique, float hospitaliers, float niveauCouverture, int idClient, int IdContrat, String dateCreation, String dateDebut, String dateFin, float prix, String valider) {
        super(idClient, IdContrat, dateCreation, dateDebut, dateFin, prix, valider);
        this.medicauxGeneraliste = medicauxGeneraliste;
        this.medicauxSpecialiste = medicauxSpecialiste;
        this.optique = optique;
        this.hospitaliers = hospitaliers;
        this.niveauCouverture = niveauCouverture;
    }

  
   



    /**
     * @return the medicauxGeneraliste
     */
    public float getMedicauxGeneraliste() {
        return medicauxGeneraliste;
    }

    /**
     * @param medicauxGeneraliste the medicauxGeneraliste to set
     */
    public void setMedicauxGeneraliste(float medicauxGeneraliste) {
        this.medicauxGeneraliste = medicauxGeneraliste;
    }

    /**
     * @return the medicauxSpecialiste
     */
    public float getMedicauxSpecialiste() {
        return medicauxSpecialiste;
    }

    /**
     * @param medicauxSpecialiste the medicauxSpecialiste to set
     */
    public void setMedicauxSpecialiste(float medicauxSpecialiste) {
        this.medicauxSpecialiste = medicauxSpecialiste;
    }

    /**
     * @return the optique
     */
    public float getOptique() {
        return optique;
    }

    /**
     * @param optique the optique to set
     */
    public void setOptique(float optique) {
        this.optique = optique;
    }

    /**
     * @return the hospitaliers
     */
    public float getHospitaliers() {
        return hospitaliers;
    }

    /**
     * @param hospitaliers the hospitaliers to set
     */
    public void setHospitaliers(float hospitaliers) {
        this.hospitaliers = hospitaliers;
    }

    /**
     * @return the niveauCouverture
     */
    public float getNiveauCouverture() {
        return niveauCouverture;
    }

    /**
     * @param niveauCouverture the niveauCouverture to set
     */
    public void setNiveauCouverture(float niveauCouverture) {
        this.niveauCouverture = niveauCouverture;
    }
    
    
   

    
    
}