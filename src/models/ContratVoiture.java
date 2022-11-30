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
    
    private String marque;
    private String modele;
    private int cylindree;
    private Date dateMiseEnCirculation;
    private String niveauCouverture;
    private String typeVehicule;

    public ContratVoiture(String marque, String modele, int cylindree, Date dateMiseEnCirculation, String niveauCouverture, String typeVehicule, int id, Date dc, Date db, Date df, float prix) {
        super(id, dc, db, df, prix);
        this.marque = marque;
        this.modele = modele;
        this.cylindree = cylindree;
        this.dateMiseEnCirculation = dateMiseEnCirculation;
        this.niveauCouverture = niveauCouverture;
        this.typeVehicule = typeVehicule;
    }

    /**
     * @return the marque
     */
    public String getMarque() {
        return marque;
    }

    /**
     * @param marque the marque to set
     */
    public void setMarque(String marque) {
        this.marque = marque;
    }

    /**
     * @return the modele
     */
    public String getModele() {
        return modele;
    }

    /**
     * @param modele the modele to set
     */
    public void setModele(String modele) {
        this.modele = modele;
    }

    /**
     * @return the cylindree
     */
    public int getCylindree() {
        return cylindree;
    }

    /**
     * @param cylindree the cylindree to set
     */
    public void setCylindree(int cylindree) {
        this.cylindree = cylindree;
    }

    /**
     * @return the dateMiseEnCirculation
     */
    public Date getDateMiseEnCirculation() {
        return dateMiseEnCirculation;
    }

    /**
     * @param dateMiseEnCirculation the dateMiseEnCirculation to set
     */
    public void setDateMiseEnCirculation(Date dateMiseEnCirculation) {
        this.dateMiseEnCirculation = dateMiseEnCirculation;
    }

    /**
     * @return the niveauCouverture
     */
    public String getNiveauCouverture() {
        return niveauCouverture;
    }

    /**
     * @param niveauCouverture the niveauCouverture to set
     */
    public void setNiveauCouverture(String niveauCouverture) {
        this.niveauCouverture = niveauCouverture;
    }

    /**
     * @return the typeVehicule
     */
    public String getTypeVehicule() {
        return typeVehicule;
    }

    /**
     * @param typeVehicule the typeVehicule to set
     */
    public void setTypeVehicule(String typeVehicule) {
        this.typeVehicule = typeVehicule;
    }
  
   

    
  
    
}
