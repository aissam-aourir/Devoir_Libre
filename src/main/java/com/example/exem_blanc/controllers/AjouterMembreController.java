package com.example.exem_blanc.controllers;
import javafx.event.ActionEvent;
import com.example.exem_blanc.DAO.MembreDao;
import com.example.exem_blanc.models.Membre;
import com.example.exem_blanc.DAO.Impl.MembreDaoImpl;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;

public class AjouterMembreController {

    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField email;
    @FXML
    private TextField phone;
    //ici on va creer l'attribu membreDao pour manager les interactions avec la base
    // de donnees avec un seul attribut de ce type
    private final MembreDaoImpl membreDao = new MembreDaoImpl();


    // Méthode qui sera appelée lors du clic sur le bouton "Insérer"
    @FXML
    private void AjouterMembre() {
        // recuperer les informations saisies par utulisateur
        String nomValue = nom.getText();
        String prenomValue = prenom.getText();
        String emailValue = email.getText();
        String phoneValue = phone.getText();

        // on fait la verification si tous les champs sont remplis
        if (nomValue.isEmpty() || prenomValue.isEmpty() || emailValue.isEmpty() || phoneValue.isEmpty()) {
            //on fait afficher une erreur pour resaisr
            showAlert("Erreur", "Tous les champs doivent être remplis.", AlertType.ERROR);
            return;
        }

        //ici on verifie si le gmail saisi est valide en forme
        if (!isValidEmail(emailField.getText())) {
            showAlert(Alert.AlertType.ERROR, "erruer de validation", "forme de gmail non respectee!");
            return;
        }
        //ici on va creer une instance de memebre ou on va stoker les inforamtions qu'on a recuperers de la page d'insertion
        // Créer un objet Membre
        Membre membre = new Membre(generateIdentifiant(), nomValue, prenomValue, emailValue, phoneValue);

        // appeler la méthode inserer par l'attribut membreDao

        membreDao.inserer(membre);

        // Afficher un message de succès
        showAlert("Succès", "Membre ajouté avec succès.", AlertType.INFORMATION);

        // renitilaisre le formulaire en supprimamt les elements saisis de fentre
        Renitilaiser();

    }
    // ici car j'ai mis l'identifiant qui est la cle primaire sous forme de Sttring donc je ne peux pas l
    // a faire incrementer automatiquement,je dois faire une methode pour guenerer une cle primaire unique
    private String generateIdentifiant() {
        //on peut choisir la logique pour que cet identifiant soit unique
        //ici ,je choisis de combiner entre le gmail saisi et le temps actule d'isertion et d'autres indicateurs
        return "ID" +email + "@" + System.currentTimeMillis();

    }

    // ici on fait afficher les alerts et les erruers
    private void showAlert(String title, String message, AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    //pouc renitialiser les champs saisis
    private void Renitilaiser() {
        nomField.clear();
        prenomField.clear();
        emailField.clear();
        phoneField.clear();
    }
}
