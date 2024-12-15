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

