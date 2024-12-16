-- Insérer des plateformes dans la table platform
INSERT INTO platform (name, launch_date, developer_studio) VALUES ('Nintendo Switch', '2017-03-03', 'Nintendo');
INSERT INTO platform (name, launch_date, developer_studio) VALUES ('PlayStation 4', '2013-11-15', 'Sony');
INSERT INTO platform (name, launch_date, developer_studio) VALUES ('PlayStation 5', '2020-11-12', 'Sony');
INSERT INTO platform (name, launch_date, developer_studio) VALUES ('Xbox One', '2013-11-22', 'Microsoft');
INSERT INTO platform (name, launch_date, developer_studio) VALUES ('Xbox Series X', '2020-11-10', 'Microsoft');
INSERT INTO platform (name, launch_date, developer_studio) VALUES ('PC', '1981-08-12', 'IBM');
INSERT INTO platform (name, launch_date, developer_studio) VALUES ('Nintendo 3DS', '2011-02-26', 'Nintendo');
INSERT INTO platform (name, launch_date, developer_studio) VALUES ('PlayStation Vita', '2011-12-17', 'Sony');
INSERT INTO platform (name, launch_date, developer_studio) VALUES ('Mobile', '2007-01-09', 'Various');
INSERT INTO platform (name, launch_date, developer_studio) VALUES ('Mac', '1984-01-24', 'Apple');
INSERT INTO platform (name, launch_date, developer_studio) VALUES ('Linux', '1991-08-25', 'Community');
INSERT INTO platform (name, launch_date, developer_studio) VALUES ('Stadia', '2019-11-19', 'Google');



-- Insérer des jeux dans la table game
INSERT INTO game (name, release_year, developer_studio, genre, image_url, description)
VALUES
('League of Legends', 2009, 'Riot Games', 'Multiplayer', 'league_of_legends.jpg', 'Un jeu de stratégie multijoueur en ligne où deux équipes s’affrontent pour détruire la base ennemie.'),
('Dota 2', 2013, 'Valve', 'Multiplayer', 'dota2.jpg', 'Un jeu MOBA compétitif où deux équipes de 5 joueurs s’affrontent dans des batailles stratégiques.'),
('Counter-Strike: Global Offensive', 2012, 'Valve', 'Multiplayer', 'csgo.jpg', 'Un jeu de tir tactique multijoueur avec des équipes terroristes et antiterroristes.'),
('Valorant', 2020, 'Riot Games', 'Multiplayer', 'valorant.jpg', 'Un jeu de tir tactique multijoueur avec des agents ayant des capacités uniques.'),
('Fortnite', 2017, 'Epic Games', 'Multiplayer', 'fortnite.jpg', 'Un Battle Royale multijoueur où 100 joueurs s’affrontent pour être le dernier survivant.'),
('Call of Duty: Warzone', 2020, 'Infinity Ward', 'Multiplayer', 'warzone.jpg', 'Un Battle Royale multijoueur où les joueurs s’affrontent sur des cartes gigantesques.'),
('PUBG: Battlegrounds', 2017, 'Krafton', 'Multiplayer', 'pubg.jpg', 'Un jeu Battle Royale où jusqu’à 100 joueurs se battent pour survivre sur une île.'),
('Overwatch', 2016, 'Blizzard Entertainment', 'Multiplayer', 'overwatch.jpg', 'Un jeu de tir multijoueur basé sur des héros avec des capacités uniques.'),
('Rocket League', 2015, 'Psyonix', 'Multiplayer', 'rocket_league.jpg', 'Un jeu multijoueur où le football est joué avec des voitures équipées de fusées.'),
('Rainbow Six Siege', 2015, 'Ubisoft', 'Multiplayer', 'rainbow_six.jpg', 'Un jeu de tir tactique multijoueur mettant l’accent sur la stratégie et le travail d’équipe.'),
('Apex Legends', 2019, 'Respawn Entertainment', 'Multiplayer', 'apex_legends.jpg', 'Un Battle Royale multijoueur avec des légendes ayant des compétences spécifiques.'),
('Super Smash Bros. Ultimate', 2018, 'Nintendo', 'Multiplayer', 'ssbu.jpg', 'Un jeu de combat multijoueur rassemblant des personnages emblématiques.'),
('Street Fighter V', 2016, 'Capcom', 'Multiplayer', 'street_fighter_v.jpg', 'Un jeu de combat compétitif parfait pour les tournois multijoueurs.'),
('Tekken 7', 2015, 'Bandai Namco', 'Multiplayer', 'tekken7.jpg', 'Un jeu de combat multijoueur où chaque personnage possède son propre style.'),
('Splatoon 3', 2022, 'Nintendo', 'Multiplayer', 'splatoon3.jpg', 'Un jeu multijoueur compétitif où des équipes s’affrontent pour couvrir le terrain de peinture.'),
('Halo Infinite', 2021, '343 Industries', 'Multiplayer', 'halo_infinite.jpg', 'Un jeu de tir multijoueur dans l’univers emblématique de Halo.'),
('Fall Guys: Ultimate Knockout', 2020, 'Mediatonic', 'Multiplayer', 'fall_guys.jpg', 'Un jeu multijoueur amusant où des joueurs s’affrontent dans des mini-jeux chaotiques.'),
('Battlefield 2042', 2021, 'DICE', 'Multiplayer', 'battlefield_2042.jpg', 'Un jeu de tir multijoueur avec des combats massifs et des cartes gigantesques.'),
('FIFA 23', 2022, 'EA Sports', 'Multiplayer', 'fifa23.jpg', 'Un jeu de football multijoueur parfait pour des compétitions en ligne.'),
('NBA 2K23', 2022, 'Visual Concepts', 'Multiplayer', 'nba2k23.jpg', 'Un jeu de basket multijoueur idéal pour les tournois compétitifs.'),
('Mario Kart 8 Deluxe', 2017, 'Nintendo', 'Multiplayer', 'mario_kart8.jpg', 'Un jeu de course multijoueur où des personnages Nintendo s’affrontent sur des circuits variés.'),
('Elden Ring: Colosseum', 2022, 'FromSoftware', 'Multiplayer', 'elden_ring_colosseum.jpg', 'Un mode multijoueur compétitif ajouté à Elden Ring pour les combats PvP.'),
('For Honor', 2017, 'Ubisoft', 'Multiplayer', 'for_honor.jpg', 'Un jeu de combat multijoueur mettant en scène des chevaliers, des samouraïs et des vikings.'),
('Chivalry 2', 2021, 'Torn Banner Studios', 'Multiplayer', 'chivalry2.jpg', 'Un jeu multijoueur de combat médiéval immersif.'),
('Brawlhalla', 2017, 'Blue Mammoth Games', 'Multiplayer', 'brawlhalla.jpg', 'Un jeu de combat multijoueur gratuit dans un style cartoon.'),
('Smite', 2014, 'Hi-Rez Studios', 'Multiplayer', 'smite.jpg', 'Un MOBA où des dieux mythologiques s’affrontent dans des batailles compétitives.'),
('StarCraft II', 2010, 'Blizzard Entertainment', 'Multiplayer', 'starcraft2.jpg', 'Un jeu de stratégie multijoueur en temps réel avec des combats intenses.'),
('Hearthstone', 2014, 'Blizzard Entertainment', 'Multiplayer', 'hearthstone.jpg', 'Un jeu de cartes multijoueur basé sur l’univers de Warcraft.'),
('Team Fortress 2', 2007, 'Valve', 'Multiplayer', 'tf2.jpg', 'Un jeu de tir multijoueur où des équipes s’affrontent dans des modes variés.'),
('Among Us', 2018, 'InnerSloth', 'Multiplayer', 'among_us.jpg', 'Un jeu multijoueur de déduction sociale où des imposteurs sabotent l’équipage.'),
('Minecraft', 2011, 'Mojang', 'Sandbox', 'mincraft.jpg', 'Minecraft est un jeu bac à sable où les joueurs peuvent explorer, construire et survivre dans un monde généré de manière procédurale');


-- Community
INSERT INTO Community (name, game_id)
VALUES
    ('League of Legends', 1),
    ('Dota 2', 2),
    ('Counter-Strike: Global Offensive', 3),
    ('Valorant', 4),
    ('Fortnite', 5),
    ('Call of Duty: Warzone', 6),
    ('PUBG: Battlegrounds', 7),
    ('Overwatch', 8),
    ('Rocket League', 9),
    ('Rainbow Six Siege', 10),
    ('Apex Legends', 11),
    ('Super Smash Bros. Ultimate', 12),
    ('Street Fighter V', 13),
    ('Tekken 7', 14),
    ('Splatoon 3', 15),
    ('Halo Infinite', 16),
    ('Fall Guys: Ultimate Knockout', 17),
    ('Battlefield 2042', 18),
    ('FIFA 23', 19),
    ('NBA 2K23', 20),
    ('Mario Kart 8 Deluxe', 21),
    ('Elden Ring: Colosseum', 22),
    ('For Honor', 23),
    ('Chivalry 2', 24),
    ('Brawlhalla', 25),
    ('Smite', 26),
    ('StarCraft II', 27),
    ('Hearthstone', 28),
    ('Team Fortress 2', 29),
    ('Among Us', 30);





-- Associer des jeux aux plateformes dans la table game_platforms
-- League of Legends
INSERT INTO game_platforms (game_id, platform_id) VALUES (1, 6); -- PC

-- Dota 2
INSERT INTO game_platforms (game_id, platform_id) VALUES (2, 6); -- PC

-- Counter-Strike: Global Offensive
INSERT INTO game_platforms (game_id, platform_id) VALUES (3, 6); -- PC
-- Valorant
INSERT INTO game_platforms (game_id, platform_id) VALUES (4, 6); -- PC

-- Fortnite
INSERT INTO game_platforms (game_id, platform_id) VALUES (5, 6); -- PC
INSERT INTO game_platforms (game_id, platform_id) VALUES (5, 4); -- Xbox One
INSERT INTO game_platforms (game_id, platform_id) VALUES (5, 5); -- Xbox Series X
INSERT INTO game_platforms (game_id, platform_id) VALUES (5, 1); -- Nintendo Switch

-- Call of Duty: Warzone
INSERT INTO game_platforms (game_id, platform_id) VALUES (6, 6); -- PC
INSERT INTO game_platforms (game_id, platform_id) VALUES (6, 4); -- Xbox One
INSERT INTO game_platforms (game_id, platform_id) VALUES (6, 5); -- Xbox Series X
INSERT INTO game_platforms (game_id, platform_id) VALUES (6, 2); -- PlayStation 4
INSERT INTO game_platforms (game_id, platform_id) VALUES (6, 3); -- PlayStation 5

-- PUBG: Battlegrounds
INSERT INTO game_platforms (game_id, platform_id) VALUES (7, 6); -- PC
INSERT INTO game_platforms (game_id, platform_id) VALUES (7, 4); -- Xbox One
INSERT INTO game_platforms (game_id, platform_id) VALUES (7, 1); -- Nintendo Switch

-- Overwatch 2
INSERT INTO game_platforms (game_id, platform_id) VALUES (8, 6); -- PC
INSERT INTO game_platforms (game_id, platform_id) VALUES (8, 4); -- Xbox One
INSERT INTO game_platforms (game_id, platform_id) VALUES (8, 5); -- Xbox Series X
INSERT INTO game_platforms (game_id, platform_id) VALUES (8, 2); -- PlayStation 4
INSERT INTO game_platforms (game_id, platform_id) VALUES (8, 3); -- PlayStation 5

-- Rocket League
INSERT INTO game_platforms (game_id, platform_id) VALUES (9, 6); -- PC
INSERT INTO game_platforms (game_id, platform_id) VALUES (9, 4); -- Xbox One
INSERT INTO game_platforms (game_id, platform_id) VALUES (9, 5); -- Xbox Series X
INSERT INTO game_platforms (game_id, platform_id) VALUES (9, 1); -- Nintendo Switch
INSERT INTO game_platforms (game_id, platform_id) VALUES (9, 2); -- PlayStation 4
INSERT INTO game_platforms (game_id, platform_id) VALUES (9, 3); -- PlayStation 5

-- Rainbow Six Siege
INSERT INTO game_platforms (game_id, platform_id) VALUES (10, 6); -- PC
INSERT INTO game_platforms (game_id, platform_id) VALUES (10, 4); -- Xbox One
INSERT INTO game_platforms (game_id, platform_id) VALUES (10, 5); -- Xbox Series X
INSERT INTO game_platforms (game_id, platform_id) VALUES (10, 2); -- PlayStation 4
INSERT INTO game_platforms (game_id, platform_id) VALUES (10, 3); -- PlayStation 5

-- Apex Legends
INSERT INTO game_platforms (game_id, platform_id) VALUES (11, 6); -- PC
INSERT INTO game_platforms (game_id, platform_id) VALUES (11, 4); -- Xbox One
INSERT INTO game_platforms (game_id, platform_id) VALUES (11, 5); -- Xbox Series X
INSERT INTO game_platforms (game_id, platform_id) VALUES (11, 2); -- PlayStation 4
INSERT INTO game_platforms (game_id, platform_id) VALUES (11, 3); -- PlayStation 5

-- Super Smash Bros. Ultimate
INSERT INTO game_platforms (game_id, platform_id) VALUES (12, 1); -- Nintendo Switch

-- Street Fighter V
INSERT INTO game_platforms (game_id, platform_id) VALUES (13, 6); -- PC
INSERT INTO game_platforms (game_id, platform_id) VALUES (13, 2); -- PlayStation 4

-- Tekken 7
INSERT INTO game_platforms (game_id, platform_id) VALUES (14, 6); -- PC
INSERT INTO game_platforms (game_id, platform_id) VALUES (14, 4); -- Xbox One
INSERT INTO game_platforms (game_id, platform_id) VALUES (14, 2); -- PlayStation 4

-- Splatoon 3
INSERT INTO game_platforms (game_id, platform_id) VALUES (15, 1); -- Nintendo Switch

-- Halo Infinite
INSERT INTO game_platforms (game_id, platform_id) VALUES (16, 6); -- PC
INSERT INTO game_platforms (game_id, platform_id) VALUES (16, 5); -- Xbox Series X
INSERT INTO game_platforms (game_id, platform_id) VALUES (16, 4); -- Xbox One

-- Fall Guys: Ultimate Knockout
INSERT INTO game_platforms (game_id, platform_id) VALUES (17, 6); -- PC
INSERT INTO game_platforms (game_id, platform_id) VALUES (17, 1); -- Nintendo Switch
INSERT INTO game_platforms (game_id, platform_id) VALUES (17, 4); -- Xbox One
INSERT INTO game_platforms (game_id, platform_id) VALUES (17, 5); -- Xbox Series X
INSERT INTO game_platforms (game_id, platform_id) VALUES (17, 2); -- PlayStation 4
INSERT INTO game_platforms (game_id, platform_id) VALUES (17, 3); -- PlayStation 5

-- Battlefield 2042
INSERT INTO game_platforms (game_id, platform_id) VALUES (18, 6); -- PC
INSERT INTO game_platforms (game_id, platform_id) VALUES (18, 4); -- Xbox One
INSERT INTO game_platforms (game_id, platform_id) VALUES (18, 5); -- Xbox Series X
INSERT INTO game_platforms (game_id, platform_id) VALUES (18, 2); -- PlayStation 4
INSERT INTO game_platforms (game_id, platform_id) VALUES (18, 3); -- PlayStation 5

-- FIFA 23
INSERT INTO game_platforms (game_id, platform_id) VALUES (19, 6); -- PC
INSERT INTO game_platforms (game_id, platform_id) VALUES (19, 4); -- Xbox One
INSERT INTO game_platforms (game_id, platform_id) VALUES (19, 5); -- Xbox Series X
INSERT INTO game_platforms (game_id, platform_id) VALUES (19, 2); -- PlayStation 4
INSERT INTO game_platforms (game_id, platform_id) VALUES (19, 3); -- PlayStation 5

-- NBA 2K23
INSERT INTO game_platforms (game_id, platform_id) VALUES (20, 6); -- PC
INSERT INTO game_platforms (game_id, platform_id) VALUES (20, 4); -- Xbox One
INSERT INTO game_platforms (game_id, platform_id) VALUES (20, 5); -- Xbox Series X
INSERT INTO game_platforms (game_id, platform_id) VALUES (20, 2); -- PlayStation 4
INSERT INTO game_platforms (game_id, platform_id) VALUES (20, 3); -- PlayStation 5

-- Mario Kart 8 Deluxe
INSERT INTO game_platforms (game_id, platform_id) VALUES (21, 1); -- Nintendo Switch

-- Elden Ring: Colosseum
INSERT INTO game_platforms (game_id, platform_id) VALUES (22, 6); -- PC
INSERT INTO game_platforms (game_id, platform_id) VALUES (22, 4); -- Xbox One
INSERT INTO game_platforms (game_id, platform_id) VALUES (22, 5); -- Xbox Series X
INSERT INTO game_platforms (game_id, platform_id) VALUES (22, 2); -- PlayStation 4
INSERT INTO game_platforms (game_id, platform_id) VALUES (22, 3); -- PlayStation 5

-- For Honor
INSERT INTO game_platforms (game_id, platform_id) VALUES (23, 6); -- PC
INSERT INTO game_platforms (game_id, platform_id) VALUES (23, 4); -- Xbox One
INSERT INTO game_platforms (game_id, platform_id) VALUES (23, 5); -- Xbox Series X
INSERT INTO game_platforms (game_id, platform_id) VALUES (23, 2); -- PlayStation 4
INSERT INTO game_platforms (game_id, platform_id) VALUES (23, 3); -- PlayStation 5

-- Chivalry 2
INSERT INTO game_platforms (game_id, platform_id) VALUES (24, 6); -- PC
INSERT INTO game_platforms (game_id, platform_id) VALUES (24, 4); -- Xbox One
INSERT INTO game_platforms (game_id, platform_id) VALUES (24, 5); -- Xbox Series X
INSERT INTO game_platforms (game_id, platform_id) VALUES (24, 2); -- PlayStation 4
INSERT INTO game_platforms (game_id, platform_id) VALUES (24, 3); -- PlayStation 5

-- Brawlhalla
INSERT INTO game_platforms (game_id, platform_id) VALUES (25, 6); -- PC
INSERT INTO game_platforms (game_id, platform_id) VALUES (25, 4); -- Xbox One
INSERT INTO game_platforms (game_id, platform_id) VALUES (25, 5); -- Xbox Series X
INSERT INTO game_platforms (game_id, platform_id) VALUES (25, 1); -- Nintendo Switch
INSERT INTO game_platforms (game_id, platform_id) VALUES (25, 2); -- PlayStation 4
INSERT INTO game_platforms (game_id, platform_id) VALUES (25, 3); -- PlayStation 5

-- Smite
INSERT INTO game_platforms (game_id, platform_id) VALUES (26, 6); -- PC
INSERT INTO game_platforms (game_id, platform_id) VALUES (26, 4); -- Xbox One
INSERT INTO game_platforms (game_id, platform_id) VALUES (26, 5); -- Xbox Series X
INSERT INTO game_platforms (game_id, platform_id) VALUES (26, 2); -- PlayStation 4
INSERT INTO game_platforms (game_id, platform_id) VALUES (26, 3); -- PlayStation 5

-- StarCraft II
INSERT INTO game_platforms (game_id, platform_id) VALUES (27, 6); -- PC

-- Hearthstone
INSERT INTO game_platforms (game_id, platform_id) VALUES (28, 6); -- PC

-- Team Fortress 2
INSERT INTO game_platforms (game_id, platform_id) VALUES (29, 6); -- PC

-- Among Us
INSERT INTO game_platforms (game_id, platform_id) VALUES (30, 6); -- PC
INSERT INTO game_platforms (game_id, platform_id) VALUES (30, 4); -- Xbox One
INSERT INTO game_platforms (game_id, platform_id) VALUES (30, 5); -- Xbox Series X
INSERT INTO game_platforms (game_id, platform_id) VALUES (30, 1); -- Nintendo Switch
INSERT INTO game_platforms (game_id, platform_id) VALUES (30, 2); -- PlayStation 4
INSERT INTO game_platforms (game_id, platform_id) VALUES (30, 3); -- PlayStation 5

-- Minecraft
INSERT INTO game_platforms (game_id, platform_id) VALUES (31, 6); -- PC
INSERT INTO game_platforms (game_id, platform_id) VALUES (31, 4); -- Xbox One
INSERT INTO game_platforms (game_id, platform_id) VALUES (31, 5); -- Xbox Series X
INSERT INTO game_platforms (game_id, platform_id) VALUES (31, 1); -- Nintendo Switch
INSERT INTO game_platforms (game_id, platform_id) VALUES (31, 2); -- PlayStation 4
INSERT INTO game_platforms (game_id, platform_id) VALUES (31, 3); -- PlayStation 5

-- Insérer des jeux dans la table game
INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, game_id, is_private, nb_joueur_limite, nb_joueur, datecreation)
VALUES ('Minecraft Championship', '2024-12-20 10:00:00', '2024-12-21 18:00:00', '2024-12-19 23:59:59', '2024-12-15 00:00:00', 'Adventure', 31, false, 64, 0, '2024-12-15 00:00:00');

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, game_id, is_private, nb_joueur_limite, nb_joueur, datecreation)
VALUES ('Fortnite Battle Royale Tournament', '2024-12-22 15:00:00', '2024-12-22 22:00:00', '2024-12-21 23:59:59', '2024-12-18 00:00:00', 'Multiplayer', 5, false, 100, 0, '2024-12-15 00:00:00');

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, game_id, is_private, nb_joueur_limite, nb_joueur, datecreation)
VALUES ('Overwatch League', '2024-12-25 14:00:00', '2024-12-25 20:00:00', '2024-12-24 23:59:59', '2024-12-20 00:00:00', 'Fighting', 8, false, 32, 0, '2024-12-15 00:00:00');

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, game_id, is_private, nb_joueur_limite, nb_joueur, datecreation)
VALUES ('Super Smash Bros Ultimate Tournament', '2024-12-26 12:00:00', '2024-12-26 19:00:00', '2024-12-25 23:59:59', '2024-12-21 00:00:00', 'Fighting', 12, false, 64, 0, '2024-12-15 00:00:00');

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, game_id, is_private, nb_joueur_limite, nb_joueur, datecreation)
VALUES ('Minecraft Adventure Challenge', '2024-12-27 10:00:00', '2024-12-27 18:00:00', '2024-12-26 23:59:59', '2024-12-22 00:00:00', 'Adventure', 31, false, 50, 0, '2024-12-15 00:00:00');

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, game_id, is_private, nb_joueur_limite, nb_joueur, datecreation)
VALUES ('Fortnite Multiplayer Battle', '2024-12-28 14:00:00', '2024-12-28 22:00:00', '2024-12-27 23:59:59', '2024-12-23 00:00:00', 'Multiplayer', 12, false, 200, 0, '2024-12-15 00:00:00');

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, game_id, is_private, nb_joueur_limite, nb_joueur, datecreation)
VALUES ('Overwatch 1v1 Fight Club', '2024-12-29 15:00:00', '2024-12-29 21:00:00', '2024-12-28 23:59:59', '2024-12-24 00:00:00', 'Fighting', 8, false, 64, 0, '2024-12-15 00:00:00');

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, game_id, is_private, nb_joueur_limite, nb_joueur, datecreation)
VALUES ('Super Smash Bros Ultimate Knockout', '2024-12-31 12:00:00', '2024-12-31 18:00:00', '2024-12-30 23:59:59', '2024-12-25 00:00:00', 'Fighting', 12, false, 32, 0, '2024-12-15 00:00:00');

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, game_id, is_private, nb_joueur_limite, nb_joueur, datecreation)
VALUES ('Minecraft Adventure World Tournament', '2025-01-02 09:00:00', '2025-01-02 17:00:00', '2025-01-01 23:59:59', '2024-12-27 00:00:00', 'Adventure', 31, false, 64, 0, '2024-12-15 00:00:00');

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, game_id, is_private, nb_joueur_limite, nb_joueur, datecreation)
VALUES ('Fortnite Grand Multiplayer Showdown', '2025-01-05 16:00:00', '2025-01-05 23:00:00', '2025-01-04 23:59:59', '2024-12-30 00:00:00', 'Multiplayer', 5, true, 100, 0, '2024-12-15 00:00:00');

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, game_id, is_private, nb_joueur_limite, nb_joueur, datecreation)
VALUES ('Overwatch Hero Brawl', '2025-01-10 18:00:00', '2025-01-10 23:00:00', '2025-01-09 23:59:59', '2025-01-05 00:00:00', 'Fighting', 8, false, 32, 0, '2024-12-15 00:00:00');

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, game_id, is_private, nb_joueur_limite, nb_joueur, datecreation)
VALUES ('Super Smash Bros Team Tournament', '2025-01-15 13:00:00', '2025-01-15 20:00:00', '2025-01-14 23:59:59', '2025-01-10 00:00:00', 'Fighting', 12, true, 64, 0, '2024-12-15 00:00:00');

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, game_id, is_private, nb_joueur_limite, nb_joueur, datecreation)
VALUES ('League of Legends Championship', '2025-01-25 14:00:00', '2025-01-25 22:00:00', '2025-01-24 23:59:59', '2025-01-20 00:00:00', 'Multiplayer', 1, false, 64, 0, '2024-12-15 00:00:00');

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, game_id, is_private, nb_joueur_limite, nb_joueur, datecreation)
VALUES ('Dota 2 Tournament', '2025-01-30 15:00:00', '2025-01-30 23:00:00', '2025-01-29 23:59:59', '2025-01-25 00:00:00', 'Multiplayer', 2, false, 32, 0, '2024-12-15 00:00:00');

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, game_id, is_private, nb_joueur_limite, nb_joueur, datecreation)
VALUES ('CS:GO Battle Royale', '2025-02-05 18:00:00', '2025-02-05 23:00:00', '2025-02-04 23:59:59', '2025-01-30 00:00:00', 'Fighting', 3, false, 64, 0, '2024-12-15 00:00:00');

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, game_id, is_private, nb_joueur_limite, nb_joueur, datecreation)
VALUES ('Valorant Competitive Cup', '2025-02-10 16:00:00', '2025-02-10 22:00:00', '2025-02-09 23:59:59', '2025-02-05 00:00:00', 'Fighting', 4, false, 64, 0, '2024-12-15 00:00:00');

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, game_id, is_private, nb_joueur_limite, nb_joueur, datecreation)
VALUES ('Fortnite Battle Royale Tournament', '2025-02-12 17:00:00', '2025-02-12 23:00:00', '2025-02-11 23:59:59', '2025-02-07 00:00:00', 'Multiplayer', 5, false, 100, 0, '2024-12-15 00:00:00');

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, game_id, is_private, nb_joueur_limite, nb_joueur, datecreation)
VALUES ('Call of Duty: Warzone Showdown', '2025-02-15 14:00:00', '2025-02-15 20:00:00', '2025-02-14 23:59:59', '2025-02-10 00:00:00', 'Multiplayer', 6, false, 64, 0, '2024-12-15 00:00:00');

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, game_id, is_private, nb_joueur_limite, nb_joueur, datecreation)
VALUES ('PUBG: Battlegrounds Championship', '2025-02-20 15:00:00', '2025-02-20 23:00:00', '2025-02-19 23:59:59', '2025-02-14 00:00:00', 'Multiplayer', 7, false, 100, 0, '2024-12-15 00:00:00');

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, game_id, is_private, nb_joueur_limite, nb_joueur, datecreation)
VALUES ('Overwatch Arena', '2025-02-25 18:00:00', '2025-02-25 23:00:00', '2025-02-24 23:59:59', '2025-02-20 00:00:00', 'Fighting', 8, false, 32, 0, '2024-12-15 00:00:00');

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, game_id, is_private, nb_joueur_limite, nb_joueur, datecreation)
VALUES ('Rocket League World Cup', '2025-03-01 14:00:00', '2025-03-01 20:00:00', '2025-02-28 23:59:59', '2025-02-23 00:00:00', 'Sports', 9, false, 64, 0, '2024-12-15 00:00:00');

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, game_id, is_private, nb_joueur_limite, nb_joueur, datecreation)
VALUES ('Rainbow Six Siege Tactical Showdown', '2025-03-05 16:00:00', '2025-03-05 23:00:00', '2025-03-04 23:59:59', '2025-02-28 00:00:00', 'Multiplayer', 10, false, 64, 0, '2024-12-15 00:00:00');

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, game_id, is_private, nb_joueur_limite, nb_joueur, datecreation)
VALUES ('Apex Legends Arena', '2025-03-10 15:00:00', '2025-03-10 22:00:00', '2025-03-09 23:59:59', '2025-03-05 00:00:00', 'Multiplayer', 11, false, 64, 0, '2024-12-15 00:00:00');

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, game_id, is_private, nb_joueur_limite, nb_joueur, datecreation)
VALUES ('Super Smash Bros. Ultimate Knockout', '2025-03-12 14:00:00', '2025-03-12 20:00:00', '2025-03-11 23:59:59', '2025-03-07 00:00:00', 'Fighting', 12, false, 64, 0, '2024-12-15 00:00:00');

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, game_id, is_private, nb_joueur_limite, nb_joueur, datecreation)
VALUES ('Street Fighter V Championship', '2025-03-15 16:00:00', '2025-03-15 22:00:00', '2025-03-14 23:59:59', '2025-03-10 00:00:00', 'Fighting', 13, false, 32, 0, '2024-12-15 00:00:00');

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, game_id, is_private, nb_joueur_limite, nb_joueur, datecreation)
VALUES ('Tekken 7 Showdown', '2025-03-20 17:00:00', '2025-03-20 23:00:00', '2025-03-19 23:59:59', '2025-03-15 00:00:00', 'Fighting', 14, false, 32, 0, '2024-12-15 00:00:00');

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, game_id, is_private, nb_joueur_limite, nb_joueur, datecreation)
VALUES ('Splatoon 3 Turf War', '2025-03-25 14:00:00', '2025-03-25 20:00:00', '2025-03-24 23:59:59', '2025-03-20 00:00:00', 'Multiplayer', 15, false, 64, 0, '2024-12-15 00:00:00');

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, game_id, is_private, nb_joueur_limite, nb_joueur, datecreation)
VALUES ('League of Legends Championship', '2025-02-10 14:00:00', '2025-02-10 22:00:00', '2025-02-09 23:59:59', '2025-02-01 00:00:00', 'Multiplayer', 1, false, 64, 0, '2024-12-15 00:00:00');

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, game_id, is_private, nb_joueur_limite, nb_joueur, datecreation)
VALUES ('Dota 2 Tournament', '2025-03-15 15:00:00', '2025-03-15 23:00:00', '2025-03-14 23:59:59', '2025-03-10 00:00:00', 'Multiplayer', 2, false, 32, 0, '2024-12-15 00:00:00');

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, game_id, is_private, nb_joueur_limite, nb_joueur, datecreation)
VALUES ('CS:GO Battle Royale', '2025-04-05 18:00:00', '2025-04-05 23:00:00', '2025-04-04 23:59:59', '2025-03-30 00:00:00', 'Fighting', 3, false, 64, 0, '2024-12-15 00:00:00');

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, game_id, is_private, nb_joueur_limite, nb_joueur, datecreation)
VALUES ('Valorant Competitive Cup', '2025-04-12 16:00:00', '2025-04-12 22:00:00', '2025-04-11 23:59:59', '2025-04-06 00:00:00', 'Fighting', 4, false, 64, 0, '2024-12-15 00:00:00');

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, game_id, is_private, nb_joueur_limite, nb_joueur, datecreation)
VALUES ('Fortnite Battle Royale Tournament', '2025-05-01 17:00:00', '2025-05-01 23:00:00', '2025-04-30 23:59:59', '2025-04-25 00:00:00', 'Multiplayer', 5, false, 100, 0, '2024-12-15 00:00:00');

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, game_id, is_private, nb_joueur_limite, nb_joueur, datecreation)
VALUES ('Call of Duty: Warzone Showdown', '2025-05-10 14:00:00', '2025-05-10 20:00:00', '2025-05-09 23:59:59', '2025-05-05 00:00:00', 'Multiplayer', 6, false, 64, 0, '2024-12-15 00:00:00');

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, game_id, is_private, nb_joueur_limite, nb_joueur, datecreation)
VALUES ('PUBG: Battlegrounds Championship', '2025-06-01 15:00:00', '2025-06-01 23:00:00', '2025-05-31 23:59:59', '2025-05-25 00:00:00', 'Multiplayer', 7, false, 100, 0, '2024-12-15 00:00:00');

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, game_id, is_private, nb_joueur_limite, nb_joueur, datecreation)
VALUES ('Overwatch Arena', '2025-06-10 18:00:00', '2025-06-10 23:00:00', '2025-06-09 23:59:59', '2025-06-05 00:00:00', 'Fighting', 8, false, 32, 0, '2024-12-15 00:00:00');

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, game_id, is_private, nb_joueur_limite, nb_joueur, datecreation)
VALUES ('Rocket League World Cup', '2025-07-15 14:00:00', '2025-07-15 20:00:00', '2025-07-14 23:59:59', '2025-07-10 00:00:00', 'Sports', 9, false, 64, 0, '2024-12-15 00:00:00');

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, game_id, is_private, nb_joueur_limite, nb_joueur, datecreation)
VALUES ('Rainbow Six Siege Tactical Showdown', '2025-07-20 16:00:00', '2025-07-20 23:00:00', '2025-07-19 23:59:59', '2025-07-15 00:00:00', 'Multiplayer', 10, false, 64, 0, '2024-12-15 00:00:00');

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, game_id, is_private, nb_joueur_limite, nb_joueur, datecreation)
VALUES ('Apex Legends Arena', '2025-08-01 15:00:00', '2025-08-01 22:00:00', '2025-07-31 23:59:59', '2025-07-25 00:00:00', 'Multiplayer', 11, false, 64, 0, '2024-12-15 00:00:00');

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, game_id, is_private, nb_joueur_limite, nb_joueur, datecreation)
VALUES ('Super Smash Bros. Ultimate Knockout', '2025-08-15 14:00:00', '2025-08-15 20:00:00', '2025-08-14 23:59:59', '2025-08-10 00:00:00', 'Fighting', 12, false, 64, 0, '2024-12-15 00:00:00');

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, game_id, is_private, nb_joueur_limite, nb_joueur, datecreation)
VALUES ('Street Fighter V Championship', '2025-09-05 16:00:00', '2025-09-05 22:00:00', '2025-09-04 23:59:59', '2025-08-30 00:00:00', 'Fighting', 13, false, 32, 0, '2024-12-15 00:00:00');

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, game_id, is_private, nb_joueur_limite, nb_joueur, datecreation)
VALUES ('Tekken 7 Showdown', '2025-09-10 17:00:00', '2025-09-10 23:00:00', '2025-09-09 23:59:59', '2025-09-04 00:00:00', 'Fighting', 14, false, 32, 0, '2024-12-15 00:00:00');

INSERT INTO tournament (name, date_start, date_end, date_end_inscription, date_start_inscription, categorie, game_id, is_private, nb_joueur_limite, nb_joueur, datecreation)
VALUES ('Splatoon 3 Turf War', '2025-09-20 14:00:00', '2025-09-20 20:00:00', '2025-09-19 23:59:59', '2025-09-15 00:00:00', 'Multiplayer', 15, false, 64, 0, '2024-12-15 00:00:00');
