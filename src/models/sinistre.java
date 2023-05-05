/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;
import java.util.*;
/**
 *
 * @author Acer
 */
public class sinistre {
    private String dateDéclaration;
    private float Dégats;
    private int idConstat;
    private String TypeAccident;
    private String tel;

    public sinistre(String dateDéclaration, float Dégats, int idConstat, String TypeAccident, String tel) {
        this.dateDéclaration = dateDéclaration;
        this.Dégats = Dégats;
        this.idConstat = idConstat;
        this.TypeAccident = TypeAccident;
        this.tel = tel;
    }

    public String getDateDéclaration() {
        return dateDéclaration;
    }

    public void setDateDéclaration(String dateDéclaration) {
        this.dateDéclaration = dateDéclaration;
    }

    public float getDégats() {
        return Dégats;
    }

    public void setDégats(float Dégats) {
        this.Dégats = Dégats;
    }

    public int getIdConstat() {
        return idConstat;
    }

    public void setIdConstat(int idConstat) {
        this.idConstat = idConstat;
    }

    public String getTypeAccident() {
        return TypeAccident;
    }

    public void setTypeAccident(String TypeAccident) {
        this.TypeAccident = TypeAccident;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
    
    
   
 
}
