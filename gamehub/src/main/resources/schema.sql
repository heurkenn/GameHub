-- Supprimer les tables existantes
DROP TABLE IF EXISTS user_games;
DROP TABLE IF EXISTS game_platforms;
DROP TABLE IF EXISTS fight;
DROP TABLE IF EXISTS tournament_game;
DROP TABLE IF EXISTS tournament_user;
DROP TABLE IF EXISTS tournament;
DROP TABLE IF EXISTS game;
DROP TABLE IF EXISTS platform;
DROP TABLE IF EXISTS app_user;

-- Créer la table app_user
CREATE TABLE app_user (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    surname VARCHAR(50) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    username VARCHAR(50) NOT NULL
);

-- Créer la table game
CREATE TABLE game (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    release_year INT NOT NULL,
    developer_studio VARCHAR(255) NOT NULL,
    genre VARCHAR(255) NOT NULL,
    image_url VARCHAR(255),
    description TEXT
);

-- Créer la table platform
CREATE TABLE platform (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    launch_date DATE NOT NULL,
    developer_studio VARCHAR(255) NOT NULL
);

-- Créer la table de liaison entre game et platform
CREATE TABLE game_platforms (
    game_id BIGINT,
    platform_id BIGINT,
    PRIMARY KEY (game_id, platform_id),
    FOREIGN KEY (game_id) REFERENCES game(id),
    FOREIGN KEY (platform_id) REFERENCES platform(id)
);

-- Créer la table de liaison entre user et game
CREATE TABLE user_games (
    user_id BIGINT,
    game_id BIGINT,
    PRIMARY KEY (user_id, game_id),
    FOREIGN KEY (user_id) REFERENCES app_user(id),
    FOREIGN KEY (game_id) REFERENCES game(id)
);

CREATE TABLE tournament(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    date_creation DATE NOT NULL,
    date_start DATE NOT NULL,
    date_end DATE NOT NULL,
    date_start_inscription DATE NOT NULL,
    date_end_inscription DATE NOT NULL, 
    categorie VARCHAR(50) NOT NULL,
    is_private BOOLEAN,
    nb_joueur_limite INT, 
    nb_joueur INT 
);

CREATE TABLE tournament_user(
    user_id BIGINT,
    tournament_id BIGINT,
    PRIMARY KEY (user_id,tournament_id),
    FOREIGN KEY (user_id) REFERENCES app_user(id),
    FOREIGN KEY (tournament_id) REFERENCES tournament(id)
);

CREATE TABLE tournament_game(
    game_id BIGINT,
    tournament_id BIGINT,
    PRIMARY KEY (game_id, tournament_id),
    FOREIGN KEY (game_id) REFERENCES game(id),
    FOREIGN KEY (tournament_id) REFERENCES tournament(id)
);

CREATE TABLE fight(
    tournament_id BIGINT,
    user1_id BIGINT,
    user2_id BIGINT,
    PRIMARY KEY (tournament_id, user1_id,user2_id),
    FOREIGN KEY (user1_id) REFERENCES app_user(id),
    FOREIGN KEY (user2_id) REFERENCES app_user(id),
    FOREIGN KEY (tournament_id) REFERENCES tournament(id)
);