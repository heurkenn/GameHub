# GameHub - Plateforme de Jeux Vidéo

## Présentation du projet
GameHub est une plateforme permettant aux utilisateurs :

- De créer un compte et de se connecter pour accéder aux fonctionnalités.
- De participer à des tournois organisés pour différents jeux.
- De rejoindre une communauté liée à chaque jeu et d’interagir via un système de chat dédié.
  
Un super administrateur gère la plateforme en ajoutant des jeux et en attribuant un administrateur pour chaque communauté (et donc pour chaque jeu). Ces administrateurs de communauté sont responsables de la création, de la modification et de la suppression des tournois. Les utilisateurs peuvent ainsi s’inscrire aux tournois, rejoindre des communautés et discuter entre eux au sein de l’espace de chat.

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

Voici une description de l'arborescence du projet, en expliquant le rôle de chaque répertoire et fichier important :

- `src/main/java/fr/gamehub/gamehub/` :
  - `config/` : Contient les classes de configuration Spring.
  - `controller/` : Contient les contrôleurs Spring MVC gérant les requêtes HTTP.
  - `model/` : Contient les entités JPA représentant les données manipulées par l'application.
  - `repository/` : Contient les interfaces pour accéder aux données dans la base (Spring Data JPA).
  - `service/` : Contient la logique métier, séparant le code des contrôleurs et des dépôts.
  - `validator/` : Contient les classes de validation personnalisées.
  - `GamehubApplication.java` : Classe principale Spring Boot permettant de lancer l'application.

- `src/main/resources/` :
  - `static/` : Contient les ressources statiques (CSS, JS, images).
  - `templates/` : Contient les pages Thymeleaf pour afficher les données dynamiques.
  - `application.properties` : Fichier de configuration pour l'application Spring Boot.
  - `data.sql` : Script SQL pour insérer des données initiales dans la base.

- `src/test/java/fr/gamehub/gamehub/` : Contient les tests unitaires et d'intégration de l'application.

- `target/` : Contient les fichiers compilés et les artefacts générés par Maven.

- `.gitignore` : Fichier spécifiant les fichiers à ignorer par Git.

- `pom.xml` : Fichier de configuration Maven gérant les dépendances et les plugins.

- `mvnw` et `mvnw.cmd` : Scripts pour utiliser Maven sans qu'il soit installé globalement sur la machine.

- `testdb.mv.db` : Base de données de test générée par H2 (optionnelle selon la configuration).

Assurez-vous de bien configurer votre environnement (Java 21, Maven) ainsi que les dépendances nécessaires pour exécuter le projet correctement.





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


## Sources et Références

- Spring Boot Documentation : [https://spring.io](https://spring.io)  
- Thymeleaf Templates : [https://www.thymeleaf.org/](https://www.thymeleaf.org/)  
- Spring WebSocket : [WebSocket Documentation](https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#websocket)

## Utilisation de l'application

- Créer un compte utilisateur pour accéder aux fonctionnalités.
- Participer à des tournois et rejoindre des communautés pour discuter via le chat.
- Admins : Gérer les tournois depuis un tableau de bord.
- Super-Admin : Gérer les jeux, les tournois et les admins "simples" dans un tableau de bord.

## Compatibilité

⚠️ Le projet utilise Java 21. Assurez-vous que votre environnement de développement est configuré correctement :

  ```sh
     java -version
  ```
