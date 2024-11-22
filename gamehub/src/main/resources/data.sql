-- Insérer des utilisateurs dans la table app_user
INSERT INTO app_user (name,surname,birthdate, email, password,username) VALUES ('John','Doe','1990-05-29','johndoe@example.com', 'password123', 'JohnDoe');
INSERT INTO app_user (name,surname,birthdate, email, password,username) VALUES ('Jane','Smith','2005-11-07','janesmith@example.com','password456', 'JaneSmith');
-- Insérer des plateformes dans la table platform
INSERT INTO platform (name, launch_date, developer_studio) VALUES ('Nintendo Switch', '2017-03-03', 'Nintendo');
INSERT INTO platform (name, launch_date, developer_studio) VALUES ('PlayStation 4', '2013-11-15', 'Sony');
INSERT INTO platform (name, launch_date, developer_studio) VALUES ('PlayStation 5', '2020-11-12', 'Sony');
INSERT INTO platform (name, launch_date, developer_studio) VALUES ('Xbox One', '2013-11-22', 'Microsoft');
INSERT INTO platform (name, launch_date, developer_studio) VALUES ('Xbox Series X', '2020-11-10', 'Microsoft');
INSERT INTO platform (name, launch_date, developer_studio) VALUES ('PC', '1981-08-12', 'IBM');
INSERT INTO platform (name, launch_date, developer_studio) VALUES ('Nintendo 3DS', '2011-02-26', 'Nintendo');
INSERT INTO platform (name, launch_date, developer_studio) VALUES ('PlayStation Vita', '2011-12-17', 'Sony');

-- Insérer des jeux dans la table game
INSERT INTO game (name, release_year, developer_studio, genre) VALUES ('The Legend of Zelda: Breath of the Wild', 2017, 'Nintendo', 'Action/Aventure');
INSERT INTO game (name, release_year, developer_studio, genre) VALUES ('God of War', 2018, 'Santa Monica Studio', 'Action');
INSERT INTO game (name, release_year, developer_studio, genre) VALUES ('The Witcher 3: Wild Hunt', 2015, 'CD Projekt Red', 'RPG');
INSERT INTO game (name, release_year, developer_studio, genre) VALUES ('Red Dead Redemption 2', 2018, 'Rockstar Games', 'Action/Aventure');
INSERT INTO game (name, release_year, developer_studio, genre) VALUES ('Super Mario Odyssey', 2017, 'Nintendo', 'Platformer');
INSERT INTO game (name, release_year, developer_studio, genre) VALUES ('Horizon Zero Dawn', 2017, 'Guerrilla Games', 'Action/RPG');
INSERT INTO game (name, release_year, developer_studio, genre) VALUES ('Spider-Man', 2018, 'Insomniac Games', 'Action');
INSERT INTO game (name, release_year, developer_studio, genre) VALUES ('Bloodborne', 2015, 'FromSoftware', 'Action/RPG');
INSERT INTO game (name, release_year, developer_studio, genre) VALUES ('Persona 5', 2016, 'Atlus', 'JRPG');
INSERT INTO game (name, release_year, developer_studio, genre) VALUES ('The Elder Scrolls V: Skyrim', 2011, 'Bethesda', 'RPG');
INSERT INTO game (name, release_year, developer_studio, genre) VALUES ('Minecraft', 2011, 'Mojang', 'Sandbox');
INSERT INTO game (name, release_year, developer_studio, genre) VALUES ('Grand Theft Auto V', 2013, 'Rockstar Games', 'Action');
INSERT INTO game (name, release_year, developer_studio, genre) VALUES ('Final Fantasy XV', 2016, 'Square Enix', 'RPG');
INSERT INTO game (name, release_year, developer_studio, genre) VALUES ('Assassin''s Creed Odyssey', 2018, 'Ubisoft', 'Action/RPG');
INSERT INTO game (name, release_year, developer_studio, genre) VALUES ('Fortnite', 2017, 'Epic Games', 'Battle Royale');
INSERT INTO game (name, release_year, developer_studio, genre) VALUES ('Overwatch', 2016, 'Blizzard Entertainment', 'FPS');
INSERT INTO game (name, release_year, developer_studio, genre) VALUES ('Stardew Valley', 2016, 'ConcernedApe', 'Simulation');
INSERT INTO game (name, release_year, developer_studio, genre) VALUES ('Animal Crossing: New Horizons', 2020, 'Nintendo', 'Simulation');
INSERT INTO game (name, release_year, developer_studio, genre) VALUES ('Cyberpunk 2077', 2020, 'CD Projekt', 'RPG');
INSERT INTO game (name, release_year, developer_studio, genre) VALUES ('Hades', 2020, 'Supergiant Games', 'Roguelike');

-- Associer des jeux aux plateformes dans la table game_platforms
INSERT INTO game_platforms (game_id, platform_id) VALUES (1, 1); -- Zelda sur Nintendo Switch
INSERT INTO game_platforms (game_id, platform_id) VALUES (2, 2); -- God of War sur PS4
INSERT INTO game_platforms (game_id, platform_id) VALUES (2, 3); -- God of War sur PS5
INSERT INTO game_platforms (game_id, platform_id) VALUES (3, 5); -- The Witcher 3 sur PC
INSERT INTO game_platforms (game_id, platform_id) VALUES (4, 4); -- Red Dead Redemption 2 sur Xbox One
INSERT INTO game_platforms (game_id, platform_id) VALUES (4, 6); -- Red Dead Redemption 2 sur PC
INSERT INTO game_platforms (game_id, platform_id) VALUES (5, 1); -- Super Mario Odyssey sur Nintendo Switch
INSERT INTO game_platforms (game_id, platform_id) VALUES (6, 2); -- Horizon Zero Dawn sur PS4
INSERT INTO game_platforms (game_id, platform_id) VALUES (7, 2); -- Spider-Man sur PS4
INSERT INTO game_platforms (game_id, platform_id) VALUES (8, 2); -- Bloodborne sur PS4
INSERT INTO game_platforms (game_id, platform_id) VALUES (9, 2); -- Persona 5 sur PS4
INSERT INTO game_platforms (game_id, platform_id) VALUES (10, 6); -- Skyrim sur PC
INSERT INTO game_platforms (game_id, platform_id) VALUES (11, 6); -- Minecraft sur PC
INSERT INTO game_platforms (game_id, platform_id) VALUES (11, 4); -- Minecraft sur Xbox One
INSERT INTO game_platforms (game_id, platform_id) VALUES (12, 4); -- GTA V sur Xbox One
INSERT INTO game_platforms (game_id, platform_id) VALUES (12, 6); -- GTA V sur PC
INSERT INTO game_platforms (game_id, platform_id) VALUES (13, 2); -- Final Fantasy XV sur PS4
INSERT INTO game_platforms (game_id, platform_id) VALUES (14, 4); -- Assassin's Creed Odyssey sur Xbox One
INSERT INTO game_platforms (game_id, platform_id) VALUES (15, 6); -- Fortnite sur PC
INSERT INTO game_platforms (game_id, platform_id) VALUES (16, 6); -- Overwatch sur PC
INSERT INTO game_platforms (game_id, platform_id) VALUES (17, 6); -- Stardew Valley sur PC
INSERT INTO game_platforms (game_id, platform_id) VALUES (18, 1); -- Animal Crossing sur Nintendo Switch
INSERT INTO game_platforms (game_id, platform_id) VALUES (19, 6); -- Cyberpunk 2077 sur PC
INSERT INTO game_platforms (game_id, platform_id) VALUES (20, 1); -- Hades sur Nintendo Switch

