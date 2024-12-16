# GameHub - Plateforme de Jeux Vidéo

## Présentation du projet
GameHub est une plateforme permettant aux utilisateurs :

- De créer un compte et de se connecter pour accéder aux fonctionnalités.
- De participer à des tournois organisés pour différents jeux.
- De faire partie d'une communauté liée à chaque jeu et d’interagir via un système de chat dédié en lien sur la page du jeu.
    
Un super administrateur gère la plateforme en ajoutant des jeux et en attribuant un administrateur pour chaque communauté (et donc pour chaque jeu). Ces administrateurs de communauté sont responsables de la création, de la modification et de la suppression des tournois. Les utilisateurs peuvent ainsi s’inscrire aux tournois, rejoindre des communautés et discuter entre eux au sein de l’espace de chat.

🎮 Bonus : Un easter egg caché se trouve sur la page d'erreur, lorsque vous accedez à une page qui n'existe pas 👀! 

⚠️ Compatibilité : Le projet utilise Java 21. Des problèmes de compatibilité peuvent apparaître si vous utilisez une version antérieure de Java.

## Auteurs

- GABIOT Victor
- FONTAINE Nicolas
- BEAUSSART Thomas
- AURÉ Nolhan

## Lancement de l'application

### 1. Prérequis
- Java 21 (OpenJDK recommandé).  
- Maven installé et configuré sur votre machine.

### 2. Lancement via Maven
Placez vous dans `gamehub/` puis utilisez les commandes suivante pour démarrer l'application :  
  ```sh
    ./mvnw clean install
    ./mvnw spring-boot:run
  ```

### 3. Ouverture dans le navigateur
Utilisez l'URL suivant dans votre navigateur:  
  ```sh
     localhost:8080
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

- `target/` : Contient les fichiers compilés et les artefacts générés par Maven.

- `.gitignore` : Fichier spécifiant les fichiers à ignorer par Git.

- `pom.xml` : Fichier de configuration Maven gérant les dépendances et les plugins.

- `mvnw` et `mvnw.cmd` : Scripts pour utiliser Maven sans qu'il soit installé globalement sur la machine.

- `testdb.mv.db` : Base de données de test générée par H2 (optionnelle selon la configuration).

Assurez-vous de bien configurer votre environnement (Java 21, Maven) ainsi que les dépendances nécessaires pour exécuter le projet correctement.




## Auto-Évaluation

### Fonctionnalités : 5/5

| Critères                                   | Détails de l'implémentation                                                                                                                                          | Statut |
|--------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------|--------|
| Gestion d'au moins 5 entités               | Plusieurs entités : User, Game, Tournament, Classement, Community, etc.                                                                                               | ✅     |
| Relations variées (1-1, 1-N, N-N)          | Relation 1-1 : Fight avec User, 1-N : Tournament - Classement, N-N : User - Game, User - Tournament.                                                                 | ✅     |
| CRUD complet                                | Insertion, mise à jour, suppression, recherche d'entités en BDD via les méthodes HTTP (GET, POST, PUT, DELETE) et Spring Data JPA.                                    | ✅     |
| Lien entre deux entités                     | Par exemple, liaison User - Tournament pour les inscriptions.                                                                                                         | ✅     |
| Lien dynamique entre entités                | L’administrateur peut associer des tournois à des jeux existants. Les utilisateurs peuvent rejoindre un tournoi via une interface graphique. | ✅     |

### Technique : 5/5

| Critères                                      | Détails de l'implémentation                                                                                                                                     | Statut |
|-----------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------|--------|
| Architecture MVC                              | Utilisation de Spring MVC pour une séparation propre entre la logique métier, les contrôleurs et la vue.                                                         | ✅     |
| Méthodes HTTP                                 | GET, POST, PUT, DELETE implémentés dans les contrôleurs (GameController, TournamentController, etc.)                                                            | ✅     |
| Données dynamiques                            | Les pages Thymeleaf affichent les données transmises par les contrôleurs (ex: listes de jeux, tournois, communautés).                                           | ✅     |
| Utilisation de SpringBoot, SpringData, JPA    | SpringBoot pour le démarrage rapide, SpringData avec JPA pour la persistance, ainsi que des repositories (GameRepository, UserRepository, TournamentRepository). | ✅     |
| SpringMVC et Thymeleaf                        | SpringMVC pour les contrôleurs, Thymeleaf pour la génération des vues HTML, affichage dynamique des données.                                                     | ✅     |

### Association/Dissociation graphique des entités (relations 1-N et N-N)

| Critères                           | Détails de l'implémentation                                                                                                                                     | Statut |
|------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------|--------|
| Association graphique d'entités    | Le super administrateur peut associer des plateformes à un jeu via des checkbox, un utilisateur un tournoi via un bouton.                                       | ✅     |
| Dissociation graphique d'entités   | L'utilisateur peut se retirer d'un tournoi, le super admin peut supprimer une relation entre un jeu et une plateforme.                                          | ✅     |

### Fourniture d'une logique métier

| Critères                           | Détails de l'implémentation                                                                                                                                      | Statut |
|------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------|--------|
| Logique métier au-delà du CRUD     | Gestion dynamique des tournois (horloge pour l'heure de début, calcul du nombre de participants, classements), gestion des communautés et validations personnalisées. | ✅     |

### Fonctionnalités demandées : 

1. **Insérer, mettre à jour, supprimer, chercher une entité en BDD**  
   - **Insérer** : `@PostMapping` pour ajouter de nouvelles entités (ex: créer un nouveau jeu).  
   - **Mettre à jour** : `@PutMapping` pour modifier des entités existantes (ex: modifier un tournoi).  
   - **Supprimer** : `@DeleteMapping` pour retirer une entité (ex: supprimer un jeu, un tournoi ou une communauté).  
   - **Chercher** : `@GetMapping` pour récupérer les entités existantes (ex: afficher tous les jeux disponibles).

2. **Lier deux entités en BDD**  
   - Les relations sont gérées dans les contrôleurs et services (ex: ajouter un tournoi à un jeu existant, associer un utilisateur à un tournoi).

3. **Créer un lien à une autre entité en BDD pour une entité donnée**  
   - Formulaires Thymeleaf et vues HTML pour permettre à un administrateur de lier un tournoi à un jeu, ou à un utilisateur de rejoindre une communauté.

### Qualité : 5/5

| Critères                     | Détails de l'implémentation                                       | Statut |
|------------------------------|---------------------------------------------------------------------|--------|
| Design visuel                | Utilisation de Bootstrap 4.5 et CSS personnalisé pour un rendu esthétique. | ✅     |
| Code source dans un repo Git | Organisation claire, commits réguliers, bonne gestion des branches. | ✅     |
| Code de qualité              | Respect des bonnes pratiques, séparation des responsabilités, commentaires explicites. | ✅     |


## Tests et Comptes de Démonstration

Pour faciliter la correction et les tests, voici une liste de comptes déjà créés avec différents rôles. Vous pouvez vous connecter avec ces identifiants afin de voir le comportement de l’application en fonction du rôle de l’utilisateur.

| Rôle          | Username        | Mot de passe         | Capacités                                                      |
|---------------|-------------------------------|----------------------|----------------------------------------------------------------|
| Super-Admin   | superadmin        | SuperAdminSecret1     | Accès complet : gestion des jeux, tournois, communautés, et nomination d’administrateurs. Accès au tableau de bord super-admin. |
| Utilisateur 1 | user1           | userPass1            | Peut rejoindre un tournoi, accéder aux communautés et discuter via le chat du jeu. Peut rejoindre la communauté directement depuis la liste ou la page du jeu. |
| Utilisateur 2 | user2          | userPass2            | Même capacités que l’utilisateur 1. Peut s’inscrire à des tournois et participer aux chats communautaires. |
| Utilisateur 3 | user3           | userPass3            | Même capacités que l’utilisateur 1 et 2. Peut explorer les différents jeux, communautés et tournois. |

**Note :** Les rôles sont attribués par le super-admin. Si vous modifiez les rôles, pensez à vous déconnecter puis à vous reconnecter pour que les changements soient pris en compte.

## Utilisation de l'application

- **Créer un compte utilisateur** : Inscrivez-vous ou utilisez les comptes de test fournis. Une fois connecté, vous aurez accès à l’ensemble des fonctionnalités.
- **Participer à des tournois** : Depuis la page d’un jeu, vous pouvez consulter les tournois disponibles, leurs dates, le nombre de joueurs inscrits et un compte à rebours dynamique indiquant le temps restant avant la fin des inscriptions. Les utilisateurs peuvent facilement rejoindre un tournoi en cliquant sur le bouton dédié.
- **Discuter via le chat en temps réel** : Rejoignez la communauté d’un jeu depuis la page du jeu lui-même ou depuis la liste des communautés. Le chat en temps réel vous permet d’échanger instantanément avec les autres membres, favorisant ainsi l’interaction entre joueurs.
- **Admins (par jeu)** : Les administrateurs de communauté ont accès à un tableau de bord leur permettant de créer, modifier et supprimer des tournois. Ils peuvent ainsi gérer l’offre de tournois afin de maintenir l’activité et l’intérêt autour d’un jeu.
- **Super-Admin** : Le super-administrateur dispose d’un tableau de bord étendu lui permettant de gérer les jeux, d’ajouter des administrateurs, de superviser les tournois et d’accéder à l’ensemble des fonctionnalités de la plateforme. Le mot de passe du super-admin est indiqué dans le fichier `application.properties`. Après toute modification de rôle, il est nécessaire de se déconnecter puis de se reconnecter pour appliquer les changements.

## Technologies Utilisées

- **Spring Boot & Spring Data JPA** : Pour la logique métier, la gestion des entités, la persistance des données et la sécurité.
- **Spring MVC & Thymeleaf** : Pour la gestion des contrôleurs, le routage des requêtes, et l’affichage dynamique du contenu dans les vues HTML.
- **WebSocket** : Pour la mise en place du chat en temps réel, assurant une communication instantanée entre les utilisateurs.
- **AJAX** : Pour charger et mettre à jour certaines parties de la page sans nécessiter un rechargement complet, améliorant ainsi l’expérience utilisateur (notamment pour l’affichage dynamique du compte à rebours et la mise à jour des chats).
- **Bootstrap & CSS Personnalisé** : Pour un design cohérent, responsive et agréable, permettant une navigation fluide.
- **H2 (Base de données en mémoire)** : Pour un stockage et un chargement rapides des données de test (testdb.mv.db).



## Compatibilité

⚠️ Le projet utilise Java 21. Assurez-vous que votre environnement de développement est configuré correctement :

  ```sh
     java -version
  ```

## Sources et Références

- Spring Boot Documentation : [https://spring.io](https://spring.io)  
- Thymeleaf Templates : [https://www.thymeleaf.org/](https://www.thymeleaf.org/)  
- Spring WebSocket : [WebSocket Documentation](https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#websocket)
