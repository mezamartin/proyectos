﻿INSERT INTO partido ( anho_mundial, equipo_local, equipo_visitante, goles_local, goles_visitante, fase, figura_partido)
VALUES  (1930, 'Uruguay', 'Argentina', 4, 2, 'Final', (SELECT id_jugador FROM jugador WHERE nombre_jugador = 'Pedro' AND apellido_jugador = 'Cea')),
		(1934, 'Italia', 'Checoslovaquia', 2, 1, 'Final', (SELECT id_jugador FROM jugador WHERE nombre_jugador = 'Angelo' AND apellido_jugador = 'Schiavio')),
		(1938, 'Italia', 'Hungría', 4, 2, 'Final', (SELECT id_jugador FROM jugador WHERE nombre_jugador = 'Silvio' AND apellido_jugador = 'Piola')),
		(1950, 'Uruguay', 'Brasil', 2, 1, 'Final', (SELECT id_jugador FROM jugador WHERE nombre_jugador = 'Juan Alberto' AND apellido_jugador = 'Schiaffino')),
		(1954, 'Alemania', 'Hungría', 3, 2, 'Final', (SELECT id_jugador FROM jugador WHERE nombre_jugador = 'Max' AND apellido_jugador = 'Morlock')),
		(1958, 'Brasil', 'Suecia', 5, 2, 'Final', (SELECT id_jugador FROM jugador WHERE nombre_jugador = 'Pele' AND apellido_jugador is null)),
		(1962, 'Brasil', 'Checoslovaquia', 3, 1, 'Final', (SELECT id_jugador FROM jugador WHERE nombre_jugador = 'Vava' AND apellido_jugador is null)),
		(1966, 'Inglaterra', 'Alemania', 4, 2, 'Final', (SELECT id_jugador FROM jugador WHERE nombre_jugador = 'Geoff' AND apellido_jugador = 'Hurst')),
		(1970, 'Brasil', 'Italia', 4, 1, 'Final', (SELECT id_jugador FROM jugador WHERE nombre_jugador = 'Jairzinho' AND apellido_jugador  is NULL)),
		(1974, 'Holanda', 'Alemania', 1, 2, 'Final', (SELECT id_jugador FROM jugador WHERE nombre_jugador = 'Gerd' AND apellido_jugador = 'Muller')),
		(1978, 'Argentina', 'Holanda', 3, 1, 'Final', (SELECT id_jugador FROM jugador WHERE nombre_jugador = 'Mario' AND apellido_jugador = 'Kempes')),
		(1982, 'Italia', 'Alemania', 3, 1, 'Final', (SELECT id_jugador FROM jugador WHERE nombre_jugador = 'Paolo' AND apellido_jugador = 'Rossi')),
		(1986, 'Argentina', 'Alemania', 3, 2, 'Final', (SELECT id_jugador FROM jugador WHERE nombre_jugador = 'Diego' AND apellido_jugador = 'Maradona')),
		(1990, 'Alemania', 'Argentina', 1, 0, 'Final', (SELECT id_jugador FROM jugador WHERE nombre_jugador = 'Andreas' AND apellido_jugador = 'Brehme')),
		(1994, 'Brasil', 'Italia', 0, 0, 'Final', (SELECT id_jugador FROM jugador WHERE nombre_jugador = 'Romario' AND apellido_jugador  is NULL)),
		(1998, 'Brasil', 'Francia', 0, 3, 'Final', (SELECT id_jugador FROM jugador WHERE nombre_jugador = 'Zinedine' AND apellido_jugador = 'Zidane')),
		(2002, 'Alemania', 'Brasil', 0, 2, 'Final', (SELECT id_jugador FROM jugador WHERE nombre_jugador = 'Ronaldo' AND apellido_jugador  is NULL)),
		(2006, 'Italia', 'Francia', 1, 1, 'Final', (SELECT id_jugador FROM jugador WHERE nombre_jugador = 'Marco' AND apellido_jugador = 'Materazzi')),
		(2010, 'España', 'Holanda', 1, 0, 'Final', (SELECT id_jugador FROM jugador WHERE nombre_jugador = 'Andres' AND apellido_jugador = 'Iniesta')),
		(2014, 'Alemania', 'Argentina', 1, 0, 'Final', (SELECT id_jugador FROM jugador WHERE nombre_jugador = 'Mario' AND apellido_jugador = 'Gotze')),
		(2014, 'Brasil', 'Alemania', 1, 7, 'Semifinal', (SELECT id_jugador FROM jugador WHERE nombre_jugador = 'Toni' AND apellido_jugador = 'Kroos')),
		(2018, 'Rusia', 'Arabia Saudita', 5, 0, 'Grupo A', (SELECT id_jugador FROM jugador WHERE nombre_jugador = 'Denis' AND apellido_jugador = 'Cheryshev')),
		(2018, 'Egipto', 'Uruguay', 0, 1, 'Grupo A', (SELECT id_jugador FROM jugador WHERE nombre_jugador = 'Jose' AND apellido_jugador = 'Gimenez')),
		(2018, 'Marruecos', 'Irán', 0, 1, 'Grupo B', (SELECT id_jugador FROM jugador WHERE nombre_jugador = 'Amine' AND apellido_jugador = 'Harit')),
		(2018, 'Portugal', 'España', 3, 3, 'Grupo B', (SELECT id_jugador FROM jugador WHERE nombre_jugador = 'Cristiano' AND apellido_jugador = 'Ronaldo')),
		(2018, 'Francia', 'Australia', 2, 1, 'Grupo C', (SELECT id_jugador FROM jugador WHERE nombre_jugador = 'Paul' AND apellido_jugador = 'Pogba')),
		(2018, 'Perú', 'Dinamarca', 0, 1, 'Grupo C', (SELECT id_jugador FROM jugador WHERE nombre_jugador = 'Yussuf' AND apellido_jugador = 'Poulsen')),
		(2018, 'Argentina', 'Islandia', 1, 1, 'Grupo D', (SELECT id_jugador FROM jugador WHERE nombre_jugador = 'Hannes' AND apellido_jugador = 'Hallorsson')),
		(2018, 'Croacia', 'Nigeria', 2, 0, 'Grupo D', (SELECT id_jugador FROM jugador WHERE nombre_jugador = 'Luka' AND apellido_jugador = 'Modric')),
		(2018, 'Costa Rica', 'Serbia', 0, 1, 'Grupo E', (SELECT id_jugador FROM jugador WHERE nombre_jugador = 'Aleksandar' AND apellido_jugador = 'Kolarov')),
		(2018, 'Brasil', 'Suiza', 1, 1, 'Grupo E', (SELECT id_jugador FROM jugador WHERE nombre_jugador = 'Philippe' AND apellido_jugador = 'Coutinho')),
		(2018, 'Alemania', 'México', 0, 1, 'Grupo F', (SELECT id_jugador FROM jugador WHERE nombre_jugador = 'Hirving' AND apellido_jugador = 'Lozano')),
		(2018, 'Suecia', 'Corea del Sur', 1, 0, 'Grupo F', (SELECT id_jugador FROM jugador WHERE nombre_jugador = 'Andreas' AND apellido_jugador = 'Granqvist')),
		(2018, 'Bélgica', 'Panamá', 3, 0, 'Grupo G', (SELECT id_jugador FROM jugador WHERE nombre_jugador = 'Romelu' AND apellido_jugador = 'Lukaku'))
                (2018, 'Bélgica', 'Tunez', 5, 2, 'Grupo G', (SELECT id_jugador FROM jugador WHERE nombre_jugador = 'Romelu' AND apellido_jugador = 'Lukaku'));