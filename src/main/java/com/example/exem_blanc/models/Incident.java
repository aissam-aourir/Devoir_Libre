package com.example.exem_blanc.models;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Incident implements Serializable {
    private String reference;
    private LocalDateTime time;
    private String status;
    private String identifiant_membre;

    // Constructeur avec identifiant_membre a null par défaut
    public Incident(String reference, LocalDateTime time, String status) {
        this.reference = reference;
        this.time = time;
        this.status = status;
        this.identifiant_membre = null; // Par défaut
    }

    // Constructeur avec identifiant_membre
    public Incident(String reference, LocalDateTime time, String status, String identifiant_membre) {
        this.reference = reference;
        this.time = time;
        this.status = status;
        this.identifiant_membre = identifiant_membre;
    }

    // les getters et les settres
    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIdentifiant_membre() {
        return identifiant_membre;
    }

    public void setIdentifiant_membre(String identifiant_membre) {
        this.identifiant_membre = identifiant_membre;
    }

    // Redéfinir equals pour comparer les incidents par leur référence
    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Incident incident = (Incident) obj;
        return reference.equals(incident.reference);
    }

    // Redéfinir hashCode en fonction de la référence
    @Override
    public int hashCode() {
        return reference.hashCode();
    }

    // Méthode toString pour faciliter l'affichage
    @Override
    public String toString() {
        return "Incident{" +
                "reference='" + reference + '\'' +
                ", time=" + time +
                ", status='" + status + '\'' +
                ", identifiant_membre='" + identifiant_membre + '\'' +
                '}';
    }
}
