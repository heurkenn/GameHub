## Présentation du projet
	-Notre projet est une plateforme de jeu, dans celle-ci on peut avoir un compte, se connecter/déconnecter participer à des tournois et communiquer sur une plateforme "communauté" pour chaque jeu. 
	Seuls les admins ont le droit de créer des tournois et les modifier.
	Le projet contient un petit Easter Egg sur la page d'erreur où la personne arrivant dessus peut jouer au snake

	-L'application à été codée en Java 21, donc des problèmes de compatibilité peuvent avoir lieu en utilisant des versions antérieures.


## Lancement de l'application

	-Afin de lancer l'application il faut run la classe GameHubApplication.java qui se situe : GameHub/gamehub/src/main/java/fr/gamehub/gamehub/GameHubApplication.java.
	-Ou faire la commande : ./mvnw spring-boot:run

## Grille d'évaluation 

	Fonctionnalités : 5/5 

	-L'application contient bien les fonctionnalités demandées : 1
	-L'application permet d'insérer, mettre à jour, supprimer, chercher une entité en BDD : 1
	-L'application permet de lier deux entités en BDD : 1
	-L'application permet, pour une entité donnée, de créer un lien à une autre entité en BDD. : 1

	Technique : 5/5 

	-L'application utilise le design pattern MVC pour chaque fonctionnalité : 1
	-Les controlleurs utilisent les méthodes HTTP: GET,POST,PUT,DELETE : 1
	-Chaque vue manipule des données transmises par son controlleur : 1

	Qualité: 5/5
	-L'application est jolie / utilise un framework CSS : 1
	-Le code source est livré dans un repo Github/Gitlab. Il est de bonne qualité : 1
	-Le repo comporte des commits réguliers de chaque membre du groupe : 1

	Soutenance: Ne peut être noté dessus
