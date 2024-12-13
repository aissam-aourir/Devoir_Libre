package com.example.exem_blanc.DAO.Impl;

import com.example.exem_blanc.DAO.MembreDao;
import com.example.exem_blanc.models.Membre;
import com.example.exem_blanc.models.Incident;
import com.example.exem_blanc.utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.util.HashSet;
public class MembreDaoImpl implements MembreDao {
    // Méthode d'insertion d'un membre dans la table membres dans la base de données
    @Override
    public void inserer(Membre m) {
        String query = "INSERT INTO membres (identifiant, nom, prenom, email, phone) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, m.getIdentifiant());
            ps.setString(2, m.getNom());
            ps.setString(3, m.getPrenom());
            ps.setString(4, m.getEmail());
            ps.setString(5, m.getPhone());
            ps.executeUpdate();
            System.out.println("Membre inséré avec succès !");
        } catch (SQLException e) {
            System.out.println("Echec d'insertion!");
            e.printStackTrace();
        }
    }

    // Charger les incidents pour un membre donné
    @Override
    public List<Incident> chargerListIncidents(String membreId) {
        String query = "SELECT i.reference, i.time, i.status FROM incidents i WHERE i.membre_id = ?";
        List<Incident> incidents = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();//pour verifier la connexion a la base de donnees
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, membreId);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Incident incident = new Incident();
                incident.setReference(resultSet.getString("reference"));
                incident.setTime(resultSet.getTimestamp("time").toLocalDateTime());
                incident.setStatus(resultSet.getString("status"));
                incidents.add(incident);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return incidents;
    }

    @Override
    public Set<Membre> chargerListeMembre(String nomFichier) {
        Set<Membre> membres = new HashSet<>();
       //moi j'ai mis le fichier csv dans le package resssource
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("ressources/" + nomFichier);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

            if (inputStream == null) {
                throw new IllegalArgumentException("Fichier non trouvé: " + nomFichier);
            }

            String ligne;
            reader.readLine();
       //on fait une boucle pour passer par toutes les lignes dans le fichier
            while ((ligne = reader.readLine()) != null) {
                String[] details = ligne.split(",");

                if (details.length == 5) {
                    String identifiant = details[0].trim();
                    String nom = details[1].trim();
                    String prenom = details[2].trim();
                    String email = details[3].trim();
                    String phone = details[4].trim();

                    Membre membre = new Membre(identifiant, nom, prenom, email, phone);
                    membres.add(membre);  // Ajouter le membre au Set, ce qui élimine les doublons automatiquement
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return membres;
    }
}
