📋 GameHub - Plateforme de Jeux en Ligne
🚀 Présentation du Projet

GameHub est une plateforme communautaire dédiée aux amateurs de jeux vidéo. Elle propose diverses fonctionnalités pour les utilisateurs et les administrateurs :

    Gestion des comptes : Inscription, connexion, déconnexion.
    Participation aux tournois : Les joueurs peuvent rejoindre des tournois organisés par les administrateurs.
    Communautés par jeu : Un espace de discussion dédié à chaque jeu pour échanger avec d'autres joueurs.
    Administration : Les administrateurs peuvent créer, modifier et gérer les tournois.
    Easter Egg 🎮 : Sur la page d'erreur, les utilisateurs peuvent jouer à Snake, ajoutant une touche ludique au projet.

    ⚠️ Note : L'application a été développée en Java 21. Des problèmes de compatibilité peuvent survenir avec des versions antérieures.

⚙️ Lancement de l'Application
Prérequis

Assurez-vous d'avoir :

    Java 21 installé.
    Maven configuré.

Méthodes de Lancement

    Depuis un IDE :
    Lancez la classe GameHubApplication.java située dans :

GameHub/gamehub/src/main/java/fr/gamehub/gamehub/GameHubApplication.java

Depuis le terminal :
Exécutez la commande suivante à la racine du projet :

    ./mvnw spring-boot:run

📝 Auto-évaluation
🛠 Fonctionnalités : 5/5
Critères	Réalisations
L'application contient bien les fonctionnalités demandées	Les utilisateurs peuvent s'inscrire, se connecter, rejoindre des tournois et discuter dans la communauté. Les admins peuvent gérer les tournois.
CRUD sur les entités	Il est possible d'insérer, modifier, supprimer et rechercher des entités telles que les utilisateurs, les jeux et les tournois en base de données (BDD).
Relation entre entités	Les relations sont bien établies : chaque tournoi est lié à un jeu, et chaque communauté appartient à un jeu spécifique.
Lien dynamique entre entités	Pour chaque communauté, les commentaires sont associés à un jeu spécifique et gérés dynamiquement via des relations SQL.
🏗 Technique : 5/5
Critères	Réalisations
Architecture MVC	L'application respecte le pattern MVC pour chaque fonctionnalité : les contrôleurs, services et vues sont bien séparés.
Méthodes HTTP	Les contrôleurs utilisent efficacement les méthodes GET, POST, PUT, DELETE pour gérer les requêtes.
Données dynamiques	Chaque vue manipule des données envoyées par le contrôleur à travers Thymeleaf.
🎨 Qualité : 5/5
Critères	Réalisations
Esthétique de l'application	L'interface utilisateur est soignée et moderne grâce à Bootstrap et des styles CSS personnalisés.
Gestion du code source	Le code source est hébergé sur un dépôt GitHub propre avec une structure claire et organisée.
Travail collaboratif	Le dépôt montre des commits réguliers et bien documentés de chaque membre de l'équipe.
📊 Grille d'Évaluation
Catégorie	Score	Commentaires
Fonctionnalités	5/5	Toutes les fonctionnalités demandées sont remplies et fonctionnelles.
Technique	5/5	Utilisation rigoureuse de MVC, des méthodes HTTP et des relations entité-BDD.
Qualité	5/5	UI élégante, code source propre et gestion collaborative du projet.
🎮 Démonstration des Fonctionnalités

    Inscription et connexion des utilisateurs
        Création d'un compte et authentification sécurisée.

    Tournois
        Affichage des tournois par statut : en cours, à venir, passés.
        Les administrateurs peuvent créer, modifier et supprimer des tournois.

    Communautés et chat en temps réel
        Une communauté dédiée à chaque jeu avec un chat interactif utilisant WebSocket pour une expérience en temps réel.

    Easter Egg Snake 🎮
        Sur la page d'erreur 404, un mini-jeu Snake est intégré pour ajouter une touche de fun.

💡 Technologies Utilisées

    Backend : Java 21, Spring Boot, Spring Data JPA.
    Base de données : H2 (en développement), SQL.
    Frontend : Thymeleaf, HTML5, CSS3, Bootstrap.
    WebSocket : Pour le chat en temps réel.
    Outils : Maven, GitHub.

👥 Équipe de Développement

    Membre 1 : Nom - Tâches principales réalisées.
    Membre 2 : Nom - Tâches principales réalisées.
    Membre 3 : Nom - Tâches principales réalisées.

Améliorations Possibles

    Intégrer une base de données MySQL pour la production.
    Ajouter une pagination pour les tournois et commentaires.
    Améliorer le système de notifications pour les utilisateurs.

🌟 Merci d'avoir exploré GameHub ! 🌟
