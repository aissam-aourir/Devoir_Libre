package com.example.exem_blanc.models;
import java.util.ArrayList;
import java.util.List;

public class Membre {
    private String identifiant;
    private String nom;
    private String prenom;
    private String email;
    private String phone;
    private List<Incident> incidents;

    // le constructeur
    public Membre(String identifiant, String nom, String prenom, String email, String phone) {
        this.identifiant = identifiant;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.phone = phone;
        this.incidents=new ArrayList<>();
    }

    // getter et setter de identifiant
    public String getIdentifiant() { return identifiant; }
    public void setIdentifiant(String identifiant) { this.identifiant = identifiant; }

    // getter et setter de nom
    public String getNom(){return this.nom;}
    public void setNom(String nom){this.nom=nom;}

    //getter et setter de prenom
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    //getter et setter de email
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    //getter et setter de phone
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    //existence d'un incident dans la liste des incidents pour un memebre
    public boolean exist(Incident incident) {
        for (Incident i : this.getIncidents()) {
            if (i.equals(incident)) return true;
        }
        return false;
    }

    //getter ,ajout et suppression des incidents
    public List<Incident> getIncidents() {
        return incidents;
    }
    public void ajouterIncident(Incident incident){
        if(!this.exist(incident)) this.getIncidents().add(incident);}
    public void supprimerIncident(Incident incident){
        if(this.exist(incident)) this.getIncidents().remove(incident);}
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Membre membre = (Membre) obj;
        return identifiant.equals(membre.identifiant);
    }
    @Override
    public int hashCode() {
        return identifiant.hashCode();
    }
}
