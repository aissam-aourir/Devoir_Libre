package com.example.exem_blanc.DAO.Impl;

import com.example.exem_blanc.DAO.IncidentDao;
import com.example.exem_blanc.models.Incident;
import com.example.exem_blanc.utils.DBConnection;

import java.sql.*;
import java.util.Set;

public class IncidentDaoImpl implements IncidentDao {

    @Override
    public void inserer(Incident i) {
        String query = "INSERT INTO incidents (reference, time, status, membre_id) VALUES (?, ?, ?, ?)";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, i.getReference());
            ps.setTimestamp(2, Timestamp.valueOf(i.getTime()));  // Convertir LocalDateTime en Timestamp
            ps.setString(3, i.getStatus());
            ps.setString(4, i.getIdentifiant_membre());
            ps.executeUpdate();
            System.out.println("insertion effectue avec succe !");
        } catch (SQLException e) {
            System.out.println("echec d'insertion !");
            e.printStackTrace();
        }
    }

    @Override
    public void inserer(Set<Incident> incidents) {
        for (Incident i : incidents) {
            inserer(i);  // Appel de la méthode inserer pour chaque incident
        }
    }
}
