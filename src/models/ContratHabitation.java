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
    private int niveauDeGarantie ;

    public ContratHabitation(int id, Date dc, Date db, Date df, float prix) {
        super(id, dc, db, df, prix);
    }
    
    

    /**
     * @return the niveauDeGarantie
     */
    public int getNiveauDeGarantie() {
        return niveauDeGarantie;
    }

    /**
     * @param niveauDeGarantie the niveauDeGarantie to set
     */
    public void setNiveauDeGarantie(int niveauDeGarantie) {
        this.niveauDeGarantie = niveauDeGarantie;
    }
    
    
 
   
    
}
