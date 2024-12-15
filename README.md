# GameHub - Plateforme de Tournois de Jeux Vidéo

## Présentation du projet

GameHub est une plateforme permettant aux utilisateurs :  
- D'avoir un compte utilisateur pour se connecter ou se déconnecter.  
- De participer à des tournois pour différents jeux disponibles sur la plateforme.  
- De communiquer dans une communauté dédiée pour chaque jeu via un système de chat.  
Seuls les administrateurs ont le droit de créer, modifier et supprimer des tournois.

🎮 Bonus : Un easter egg caché se trouve sur la page d'erreur, lorsque vous accedez à une page qui n'existe pas 👀! 

⚠️ Compatibilité : Le projet utilise Java 21. Des problèmes de compatibilité peuvent apparaître si vous utilisez une version antérieure de Java.

## Lancement de l'application

### 1. Prérequis
- Java 21 (OpenJDK recommandé).  
- Maven installé et configuré sur votre machine.

### 2. Lancement via l'IDE
Exécutez la classe principale GameHubApplication.java :  
`GameHub/gamehub/src/main/java/fr/gamehub/gamehub/GameHubApplication.java`

### 3. Lancement via Maven
Utilisez la commande suivante pour démarrer l'application :  
  ```sh
     ./mvnw spring-boot:run
  ```

## Arborescence du projet

gamehub/  
├── src/  
│   ├── main/  
│   │   ├── java/                            **# Code source Java** 
│   │   │   └── fr/gamehub/gamehub/  
│   │   │       ├── controller/              # Contrôleurs (Spring MVC)  
│   │   │       ├── model/                   # Modèles (Entités JPA)  
│   │   │       ├── repository/              # Interfaces pour accéder à la BDD  
│   │   │       ├── service/                 # Logique métier  
│   │   │       └── GameHubApplication.java  
│   │   └── resources/                       # Ressources statiques et templates  
│   │       ├── templates/                   # Pages Thymeleaf  
│   │       ├── static/                      # CSS, JS, Images  
│   │       └── application.properties       # Configuration Spring Boot  
│   └── test/                                # Tests unitaires  
├── pom.xml                                  # Configuration Maven  
└── README.md                                # Documentation




## Auto-Évaluation

### Fonctionnalités : 5/5

| Critères                 | Détails de l'implémentation                              | Statut |
|--------------------------|----------------------------------------------------------|--------|
| Fonctionnalités demandées| Création de comptes, participation à des tournois, chat actif. | ✅   |
| CRUD sur une entité      | Utilisation de Spring Data JPA pour gérer les entités.   | ✅     |
| Lien entre deux entités  | Liaison entre User et Tournoi pour les inscriptions.     | ✅     |
| Lien dynamique entre entités | Les admins peuvent associer des tournois à des jeux existants. | ✅ |

### Technique : 5/5

| Critères        | Détails de l'implémentation                                     | Statut |
|-----------------|-----------------------------------------------------------------|--------|
| Architecture MVC| Utilisation de Spring MVC pour une séparation propre.           | ✅     |
| Méthodes HTTP   | GET, POST, PUT, DELETE implémentés dans les contrôleurs.        | ✅     |
| Données dynamiques | Les pages Thymeleaf affichent les données transmises.        | ✅     |

### Qualité : 5/5

| Critères              | Détails de l'implémentation                       | Statut |
|-----------------------|---------------------------------------------------|--------|
| Design visuel         | Utilisation de Bootstrap 4.5 et CSS personnalisé. | ✅     |
| Code source dans un repo Git | Organisation claire avec des commits réguliers. | ✅  |
| Code de qualité       | Clean code, séparation des responsabilités, commentaires. | ✅ |

## Fonctionnalités notables

- Authentification sécurisée :  
  Utilisation de Spring Security avec chiffrement des mots de passe (BCrypt).

- CRUD complet :  
  Gestion des utilisateurs, jeux, tournois et communautés.

- Communautés avec chat en temps réel :  
  Utilisation de WebSocket pour un chat interactif dans chaque communauté.

- Easter Egg Snake :  
  Mini-jeu Snake intégré sur la page d'erreur pour une touche d'humour.

- Pages dynamiques :  
  Affichage des jeux et tournois en utilisant des templates Thymeleaf.

## Sources et Références

- Spring Boot Documentation : [https://spring.io](https://spring.io)  
- Thymeleaf Templates : [https://www.thymeleaf.org/](https://www.thymeleaf.org/)  
- Spring WebSocket : [WebSocket Documentation](https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#websocket)

## Utilisation de l'application

- Créer un compte utilisateur pour accéder aux fonctionnalités.
- Participer à des tournois et rejoindre des communautés pour discuter via le chat.
- Admins : Gérer les jeux et les tournois depuis un tableau de bord sécurisé.

## Compatibilité

⚠️ Le projet utilise Java 21. Assurez-vous que votre environnement de développement est configuré correctement :

  ```sh
     java -version
  ```
