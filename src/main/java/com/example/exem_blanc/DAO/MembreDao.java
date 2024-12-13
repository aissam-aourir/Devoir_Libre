package com.example.exem_blanc.DAO;
import com.example.exem_blanc.models.Membre;
import com.example.exem_blanc.models.Incident;
import java.util.List;

public interface MembreDao {

    // Méthode pour ajouter un membre
    void inserer(Membre membre);

    // on fait charger une liste des incidents pour un memebre donne
    List<Incident> chargerListIncidents(String identifiantMembre); }
