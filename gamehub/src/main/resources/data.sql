-- Insérer des plateformes dans la table platform
INSERT INTO platform (name, launch_date, developer_studio) VALUES ('Nintendo Switch', '2017-03-03', 'Nintendo');
INSERT INTO platform (name, launch_date, developer_studio) VALUES ('PlayStation 4', '2013-11-15', 'Sony');
INSERT INTO platform (name, launch_date, developer_studio) VALUES ('PlayStation 5', '2020-11-12', 'Sony');
INSERT INTO platform (name, launch_date, developer_studio) VALUES ('Xbox One', '2013-11-22', 'Microsoft');
INSERT INTO platform (name, launch_date, developer_studio) VALUES ('Xbox Series X', '2020-11-10', 'Microsoft');
INSERT INTO platform (name, launch_date, developer_studio) VALUES ('PC', '1981-08-12', 'IBM');
INSERT INTO platform (name, launch_date, developer_studio) VALUES ('Nintendo 3DS', '2011-02-26', 'Nintendo');
INSERT INTO platform (name, launch_date, developer_studio) VALUES ('PlayStation Vita', '2011-12-17', 'Sony');


INSERT INTO game (name, release_year, developer_studio, genre, image_url, description)
VALUES (
    'Minecraft',
    2011,
    'Mojang',
    'Sandbox',
    'minecraft.jpg',
    'Minecraft est un jeu bac à sable où les joueurs peuvent explorer, construire et survivre dans un monde généré de manière procédurale.'
);

INSERT INTO game (name, release_year, developer_studio, genre, image_url, description)
VALUES (
    'Fortnite',
    2017,
    'Epic Games',
    'Battle Royale',
    'fortnite.jpg',
    'Fortnite est un jeu d’action et de construction où 100 joueurs s’affrontent pour être le dernier survivant dans un mode Battle Royale.'
);

INSERT INTO game (name, release_year, developer_studio, genre, image_url, description)
VALUES (
    'Overwatch',
    2016,
    'Blizzard Entertainment',
    'FPS',
    'overwatch.jpg',
    'Overwatch est un jeu de tir à la première personne en équipe, avec des héros uniques dotés de capacités spéciales.'
);

INSERT INTO game (name, release_year, developer_studio, genre, image_url, description)
VALUES (
    'Super Smash Bros Ultimate',
    2018,
    'Nintendo',
    'Fighting',
    'ssbu.jpg',
    'Super Smash Bros. est un jeu de combat où des personnages emblématiques de Nintendo et d’autres franchises s’affrontent dans des arènes dynamiques.'
);

INSERT INTO game (name, release_year, developer_studio, genre, image_url, description)
VALUES (
    'Hades',
    2020,
    'Supergiant Games',
    'Roguelike',
    'hades.jpg',
    'Hades est un roguelike d’action rapide où vous incarnez Zagreus, le fils d’Hadès, cherchant à échapper aux Enfers.'
);


-- Insérer des jeux dans la table game
INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, jeu, is_private, nb_joueur_limite)
VALUES ('Minecraft Championship', '2024-12-20 10:00:00', '2024-12-21 18:00:00', '2024-12-19 23:59:59', '2024-12-15 00:00:00', 'Adventure', 'Minecraft', false, 64);

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, jeu, is_private, nb_joueur_limite)
VALUES ('Fortnite Battle Royale Tournament', '2024-12-22 15:00:00', '2024-12-22 22:00:00', '2024-12-21 23:59:59', '2024-12-18 00:00:00', 'Multiplayer', 'Fortnite', false, 100);

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, jeu, is_private, nb_joueur_limite)
VALUES ('Overwatch League', '2024-12-25 14:00:00', '2024-12-25 20:00:00', '2024-12-24 23:59:59', '2024-12-20 00:00:00', 'Fighting', 'Overwatch', false, 32);

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, jeu, is_private, nb_joueur_limite)
VALUES ('Super Smash Bros Ultimate Tournament', '2024-12-26 12:00:00', '2024-12-26 19:00:00', '2024-12-25 23:59:59', '2024-12-21 00:00:00', 'Fighting', 'Super Smash Bros Ultimate', false, 64);

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, jeu, is_private, nb_joueur_limite)
VALUES ('Hades Speedrun Tournament', '2024-12-30 16:00:00', '2024-12-30 23:00:00', '2024-12-29 23:59:59', '2024-12-25 00:00:00', 'Action', 'Hades', true, 32);

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, jeu, is_private, nb_joueur_limite)
VALUES ('Minecraft Adventure Challenge', '2024-12-27 10:00:00', '2024-12-27 18:00:00', '2024-12-26 23:59:59', '2024-12-22 00:00:00', 'Adventure', 'Minecraft', false, 50);

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, jeu, is_private, nb_joueur_limite)
VALUES ('Fortnite Multiplayer Battle', '2024-12-28 14:00:00', '2024-12-28 22:00:00', '2024-12-27 23:59:59', '2024-12-23 00:00:00', 'Multiplayer', 'Fortnite', false, 200);

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, jeu, is_private, nb_joueur_limite)
VALUES ('Overwatch 1v1 Fight Club', '2024-12-29 15:00:00', '2024-12-29 21:00:00', '2024-12-28 23:59:59', '2024-12-24 00:00:00', 'Fighting', 'Overwatch', false, 64);

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, jeu, is_private, nb_joueur_limite)
VALUES ('Super Smash Bros Ultimate Knockout', '2024-12-31 12:00:00', '2024-12-31 18:00:00', '2024-12-30 23:59:59', '2024-12-25 00:00:00', 'Fighting', 'Super Smash Bros. Ultimate', false, 32);

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, jeu, is_private, nb_joueur_limite)
VALUES ('Hades Action Speedrun Tournament', '2024-12-30 14:00:00', '2024-12-30 21:00:00', '2024-12-29 23:59:59', '2024-12-25 00:00:00', 'Action', 'Hades', true, 32);

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, jeu, is_private, nb_joueur_limite)
VALUES ('Minecraft Adventure World Tournament', '2025-01-02 09:00:00', '2025-01-02 17:00:00', '2025-01-01 23:59:59', '2024-12-27 00:00:00', 'Adventure', 'Minecraft', false, 64);

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, jeu, is_private, nb_joueur_limite)
VALUES ('Fortnite Grand Multiplayer Showdown', '2025-01-05 16:00:00', '2025-01-05 23:00:00', '2025-01-04 23:59:59', '2024-12-30 00:00:00', 'Multiplayer', 'Fortnite', true, 100);

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, jeu, is_private, nb_joueur_limite)
VALUES ('Overwatch Hero Brawl', '2025-01-10 18:00:00', '2025-01-10 23:00:00', '2025-01-09 23:59:59', '2025-01-05 00:00:00', 'Fighting', 'Overwatch', false, 32);

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, jeu, is_private, nb_joueur_limite)
VALUES ('Super Smash Bros Team Tournament', '2025-01-15 13:00:00', '2025-01-15 20:00:00', '2025-01-14 23:59:59', '2025-01-10 00:00:00', 'Fighting', 'Super Smash Bros. Ultimate', true, 64);

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, jeu, is_private, nb_joueur_limite)
VALUES ('Hades Action Hero Tournament', '2025-01-20 17:00:00', '2025-01-20 23:00:00', '2025-01-19 23:59:59', '2025-01-15 00:00:00', 'Action', 'Hades', false, 64);

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, jeu, is_private, nb_joueur_limite)
VALUES ('League of Legends Championship', '2025-01-25 14:00:00', '2025-01-25 22:00:00', '2025-01-24 23:59:59', '2025-01-20 00:00:00', 'Multiplayer', 'League of Legends', false, 64);

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, jeu, is_private, nb_joueur_limite)
VALUES ('Dota 2 Tournament', '2025-01-30 15:00:00', '2025-01-30 23:00:00', '2025-01-29 23:59:59', '2025-01-25 00:00:00', 'Multiplayer', 'Dota 2', false, 32);

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, jeu, is_private, nb_joueur_limite)
VALUES ('CS:GO Battle Royale', '2025-02-05 18:00:00', '2025-02-05 23:00:00', '2025-02-04 23:59:59', '2025-01-30 00:00:00', 'Fighting', 'Counter-Strike: Global Offensive', false, 64);

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, jeu, is_private, nb_joueur_limite)
VALUES ('Valorant Competitive Cup', '2025-02-10 16:00:00', '2025-02-10 22:00:00', '2025-02-09 23:59:59', '2025-02-05 00:00:00', 'Fighting', 'Valorant', false, 64);

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, jeu, is_private, nb_joueur_limite)
VALUES ('Fortnite Battle Royale Tournament', '2025-02-12 17:00:00', '2025-02-12 23:00:00', '2025-02-11 23:59:59', '2025-02-07 00:00:00', 'Multiplayer', 'Fortnite', false, 100);

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, jeu, is_private, nb_joueur_limite)
VALUES ('Call of Duty: Warzone Showdown', '2025-02-15 14:00:00', '2025-02-15 20:00:00', '2025-02-14 23:59:59', '2025-02-10 00:00:00', 'Multiplayer', 'Call of Duty: Warzone', false, 64);

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, jeu, is_private, nb_joueur_limite)
VALUES ('PUBG: Battlegrounds Championship', '2025-02-20 15:00:00', '2025-02-20 23:00:00', '2025-02-19 23:59:59', '2025-02-14 00:00:00', 'Multiplayer', 'PUBG: Battlegrounds', false, 100);

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, jeu, is_private, nb_joueur_limite)
VALUES ('Overwatch 2 Arena', '2025-02-25 18:00:00', '2025-02-25 23:00:00', '2025-02-24 23:59:59', '2025-02-20 00:00:00', 'Fighting', 'Overwatch 2', false, 32);

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, jeu, is_private, nb_joueur_limite)
VALUES ('Rocket League World Cup', '2025-03-01 14:00:00', '2025-03-01 20:00:00', '2025-02-28 23:59:59', '2025-02-23 00:00:00', 'Sports', 'Rocket League', false, 64);

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, jeu, is_private, nb_joueur_limite)
VALUES ('Rainbow Six Siege Tactical Showdown', '2025-03-05 16:00:00', '2025-03-05 23:00:00', '2025-03-04 23:59:59', '2025-02-28 00:00:00', 'Multiplayer', 'Rainbow Six Siege', false, 64);

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, jeu, is_private, nb_joueur_limite)
VALUES ('Apex Legends Arena', '2025-03-10 15:00:00', '2025-03-10 22:00:00', '2025-03-09 23:59:59', '2025-03-05 00:00:00', 'Multiplayer', 'Apex Legends', false, 64);

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, jeu, is_private, nb_joueur_limite)
VALUES ('Super Smash Bros. Ultimate Knockout', '2025-03-12 14:00:00', '2025-03-12 20:00:00', '2025-03-11 23:59:59', '2025-03-07 00:00:00', 'Fighting', 'Super Smash Bros. Ultimate', false, 64);

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, jeu, is_private, nb_joueur_limite)
VALUES ('Street Fighter V Championship', '2025-03-15 16:00:00', '2025-03-15 22:00:00', '2025-03-14 23:59:59', '2025-03-10 00:00:00', 'Fighting', 'Street Fighter V', false, 32);

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, jeu, is_private, nb_joueur_limite)
VALUES ('Tekken 7 Showdown', '2025-03-20 17:00:00', '2025-03-20 23:00:00', '2025-03-19 23:59:59', '2025-03-15 00:00:00', 'Fighting', 'Tekken 7', false, 32);

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, jeu, is_private, nb_joueur_limite)
VALUES ('Splatoon 3 Turf War', '2025-03-25 14:00:00', '2025-03-25 20:00:00', '2025-03-24 23:59:59', '2025-03-20 00:00:00', 'Multiplayer', 'Splatoon 3', false, 64);

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, jeu, is_private, nb_joueur_limite)
VALUES ('League of Legends Championship', '2025-02-10 14:00:00', '2025-02-10 22:00:00', '2025-02-09 23:59:59', '2025-02-01 00:00:00', 'Multiplayer', 'League of Legends', false, 64);

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, jeu, is_private, nb_joueur_limite)
VALUES ('Dota 2 Tournament', '2025-03-15 15:00:00', '2025-03-15 23:00:00', '2025-03-14 23:59:59', '2025-03-10 00:00:00', 'Multiplayer', 'Dota 2', false, 32);

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, jeu, is_private, nb_joueur_limite)
VALUES ('CS:GO Battle Royale', '2025-04-05 18:00:00', '2025-04-05 23:00:00', '2025-04-04 23:59:59', '2025-03-30 00:00:00', 'Fighting', 'Counter-Strike: Global Offensive', false, 64);

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, jeu, is_private, nb_joueur_limite)
VALUES ('Valorant Competitive Cup', '2025-04-12 16:00:00', '2025-04-12 22:00:00', '2025-04-11 23:59:59', '2025-04-06 00:00:00', 'Fighting', 'Valorant', false, 64);

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, jeu, is_private, nb_joueur_limite)
VALUES ('Fortnite Battle Royale Tournament', '2025-05-01 17:00:00', '2025-05-01 23:00:00', '2025-04-30 23:59:59', '2025-04-25 00:00:00', 'Multiplayer', 'Fortnite', false, 100);

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, jeu, is_private, nb_joueur_limite)
VALUES ('Call of Duty: Warzone Showdown', '2025-05-10 14:00:00', '2025-05-10 20:00:00', '2025-05-09 23:59:59', '2025-05-05 00:00:00', 'Multiplayer', 'Call of Duty: Warzone', false, 64);

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, jeu, is_private, nb_joueur_limite)
VALUES ('PUBG: Battlegrounds Championship', '2025-06-01 15:00:00', '2025-06-01 23:00:00', '2025-05-31 23:59:59', '2025-05-25 00:00:00', 'Multiplayer', 'PUBG: Battlegrounds', false, 100);

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, jeu, is_private, nb_joueur_limite)
VALUES ('Overwatch 2 Arena', '2025-06-10 18:00:00', '2025-06-10 23:00:00', '2025-06-09 23:59:59', '2025-06-05 00:00:00', 'Fighting', 'Overwatch 2', false, 32);

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, jeu, is_private, nb_joueur_limite)
VALUES ('Rocket League World Cup', '2025-07-15 14:00:00', '2025-07-15 20:00:00', '2025-07-14 23:59:59', '2025-07-10 00:00:00', 'Sports', 'Rocket League', false, 64);

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, jeu, is_private, nb_joueur_limite)
VALUES ('Rainbow Six Siege Tactical Showdown', '2025-07-20 16:00:00', '2025-07-20 23:00:00', '2025-07-19 23:59:59', '2025-07-15 00:00:00', 'Multiplayer', 'Rainbow Six Siege', false, 64);

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, jeu, is_private, nb_joueur_limite)
VALUES ('Apex Legends Arena', '2025-08-01 15:00:00', '2025-08-01 22:00:00', '2025-07-31 23:59:59', '2025-07-25 00:00:00', 'Multiplayer', 'Apex Legends', false, 64);

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, jeu, is_private, nb_joueur_limite)
VALUES ('Super Smash Bros. Ultimate Knockout', '2025-08-15 14:00:00', '2025-08-15 20:00:00', '2025-08-14 23:59:59', '2025-08-10 00:00:00', 'Fighting', 'Super Smash Bros. Ultimate', false, 64);

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, jeu, is_private, nb_joueur_limite)
VALUES ('Street Fighter V Championship', '2025-09-05 16:00:00', '2025-09-05 22:00:00', '2025-09-04 23:59:59', '2025-08-30 00:00:00', 'Fighting', 'Street Fighter V', false, 32);

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, jeu, is_private, nb_joueur_limite)
VALUES ('Tekken 7 Showdown', '2025-09-10 17:00:00', '2025-09-10 23:00:00', '2025-09-09 23:59:59', '2025-09-04 00:00:00', 'Fighting', 'Tekken 7', false, 32);

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, jeu, is_private, nb_joueur_limite)
VALUES ('Splatoon 3 Turf War', '2025-09-20 14:00:00', '2025-09-20 20:00:00', '2025-09-19 23:59:59', '2025-09-15 00:00:00', 'Multiplayer', 'Splatoon 3', false, 64);





-- Associer des jeux aux plateformes dans la table game_platforms
INSERT INTO game_platforms (game_id, platform_id) VALUES (1, 6); -- Minecraft sur PC
INSERT INTO game_platforms (game_id, platform_id) VALUES (1, 4); -- Minecraft sur Xbox One
INSERT INTO game_platforms (game_id, platform_id) VALUES (1, 1); -- Minecraft sur Nintendo Switch

INSERT INTO game_platforms (game_id, platform_id) VALUES (2, 6); -- Fortnite sur PC
INSERT INTO game_platforms (game_id, platform_id) VALUES (2, 4); -- Fortnite sur Xbox One
INSERT INTO game_platforms (game_id, platform_id) VALUES (2, 5); -- Fortnite sur Xbox Series X

INSERT INTO game_platforms (game_id, platform_id) VALUES (3, 6); -- Overwatch sur PC
INSERT INTO game_platforms (game_id, platform_id) VALUES (3, 4); -- Overwatch sur Xbox One
INSERT INTO game_platforms (game_id, platform_id) VALUES (3, 2); -- Overwatch sur PlayStation 4

INSERT INTO game_platforms (game_id, platform_id) VALUES (4, 1); -- Super Smash Bros. sur Nintendo Switch

INSERT INTO game_platforms (game_id, platform_id) VALUES (5, 1); -- Hades sur Nintendo Switch
INSERT INTO game_platforms (game_id, platform_id) VALUES (5, 6); -- Hades sur PC

