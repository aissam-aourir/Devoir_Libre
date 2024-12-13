-- creation de la table des memebres
CREATE TABLE membres (
                         identifiant VARCHAR(70) PRIMARY KEY, -- Clé primaire
                         nom VARCHAR(100) NOT NULL,
                         prenom VARCHAR(100) NOT NULL,
                         email VARCHAR(150) UNIQUE NOT NULL,
                         phone VARCHAR(15)
);

-- creation de la table des icidents
CREATE TABLE incidents (
                           reference VARCHAR(50) PRIMARY KEY, -- Clé primaire
                           time DATETIME NOT NULL,            -- Date et heure de l'incident
                           status VARCHAR(50) NOT NULL,       -- Statut de l'incident (e.g., "En cours", "Résolu")
                           membre_id VARCHAR(50),             -- Clé étrangère pour lier à un membre
                           CONSTRAINT fk_membre_id FOREIGN KEY (membre_id) REFERENCES membres(identifiant) ON DELETE CASCADE
);
