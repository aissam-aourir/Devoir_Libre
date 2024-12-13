package com.example.exem_blanc.DAO;
import com.example.exem_blanc.models.Incident;
import java.util.Set;

public interface IncidentDao {
    // methode pour inserer un incident
    void inserer(Incident incident);

    // methode pour ajouter un ensemble des incidents a la fois
    void inser(Set<Incident> incidents);
}
