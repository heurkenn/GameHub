-- Insérer des utilisateurs dans la table app_user
INSERT INTO app_user (username, email, password) VALUES ('JohnDoe', 'johndoe@example.com', 'password123');
INSERT INTO app_user (username, email, password) VALUES ('JaneSmith', 'janesmith@example.com', 'password456');

-- Insérer des plateformes dans la table platform
INSERT INTO platform (name, launch_date, developer_studio) VALUES ('Nintendo Switch', '2017-03-03', 'Nintendo');
INSERT INTO platform (name, launch_date, developer_studio) VALUES ('PlayStation 4', '2013-11-15', 'Sony');
INSERT INTO platform (name, launch_date, developer_studio) VALUES ('PlayStation 5', '2020-11-12', 'Sony');
INSERT INTO platform (name, launch_date, developer_studio) VALUES ('Xbox One', '2013-11-22', 'Microsoft');
INSERT INTO platform (name, launch_date, developer_studio) VALUES ('PC', '1981-08-12', 'IBM');

-- Insérer des jeux dans la table game
INSERT INTO game (name, release_year, developer_studio, genre) VALUES ('The Legend of Zelda: Breath of the Wild', 2017, 'Nintendo', 'Action/Aventure');
INSERT INTO game (name, release_year, developer_studio, genre) VALUES ('God of War', 2018, 'Santa Monica Studio', 'Action');
INSERT INTO game (name, release_year, developer_studio, genre) VALUES ('The Witcher 3: Wild Hunt', 2015, 'CD Projekt Red', 'RPG');

-- Associer des jeux aux plateformes dans la table game_platforms
INSERT INTO game_platforms (game_id, platform_id) VALUES (1, 1); -- Zelda sur Switch
INSERT INTO game_platforms (game_id, platform_id) VALUES (2, 2); -- God of War sur PS4
INSERT INTO game_platforms (game_id, platform_id) VALUES (2, 3); -- God of War sur PS5
INSERT INTO game_platforms (game_id, platform_id) VALUES (3, 5); -- The Witcher 3 sur PC

