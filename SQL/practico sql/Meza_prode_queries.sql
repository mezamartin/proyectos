--1. Obtener el año y la sede de los mundiales en los que el país ganador haya sido el anfitrión del mismo.

SELECT anho, sede
FROM mundial
WHERE sede = ganador;


--2. Obtener el año y la sede de los mundiales en los que el país ganador le haya ganado la final a su clásico
--rival. Devolver también el nombre de los países y el resultado del partido.

SELECT anho, sede, nombre_pais, goles_local, goles_visitante
FROM mundial
JOIN pais ON mundial.ganador = pais.nombre_pais
JOIN partido ON partido.anho_mundial = mundial.anho
WHERE mundial.subcampeon = pais.clasico
AND fase = 'Final';


--3. Obtener los jugadores que hayan jugado más de tres mundiales. Devolver el nombre del jugador, el total
--de goles efectivos (a favor - en contra), la sede y el ganador de cada uno de esos mundiales.

SELECT jugador, nombre_jugador, apellido_jugador, goles_a_favor - goles_en_contra AS goles_efectivos,
sede, ganador
FROM jugo_mundial
JOIN jugador ON jugo_mundial.jugador = jugador.id_jugador
JOIN mundial ON mundial.anho = jugo_mundial.anho_mundial
WHERE jugador IN (SELECT jugador
				  FROM jugo_mundial
                 GROUP BY (jugador)
                 HAVING COUNT (anho_mundial) > 3);
				 
--Por los valores que asigne, Mascherano y Kroos son
--los unicos en jugar mas de 3 mundiales.

--4. Obtener los nombres de los jugadores que hayan marcado goles en finales (ordenados por importancia,
--considerando la importancia como la cantidad total de goles de cada jugador), la cantidad de goles agregando
--una columna que indique si gano ese mundial.

SELECT DISTINCT anho_mundial,nombre_jugador, apellido_jugador, goles, fase,
jugador.pais_jugador = mundial.ganador AS gano
FROM jugador
JOIN jugo_partido ON jugador.id_jugador = jugo_partido.jugador
JOIN partido ON jugador.id_jugador = partido.figura_partido
JOIN mundial ON  mundial.anho = partido.anho_mundial
WHERE fase = 'Final'
AND goles > 0
ORDER BY goles DESC;


--5. Obtener la lista de jugadores y el total de goles a favor y en contra en todos los mundiales, agregando una
--columna con la diferencia de goles.

SELECT jugador, goles_a_favor, goles_en_contra, goles_a_favor - goles_en_contra AS diferencia_de_gol
FROM jugo_mundial;

--6. Obtener el listado de todos los jugadores campeones hasta 1950, indicando mundial (sede y año), país
--campeón y nombre del jugador.

SELECT id_jugador, nombre_jugador, apellido_jugador, anho, sede, ganador
FROM jugador
JOIN jugo_mundial ON jugador.id_jugador = jugo_mundial.jugador
JOIN mundial ON jugo_mundial.anho_mundial = mundial.anho
WHERE (jugador.pais_jugador = mundial.ganador)
AND (anho <= 1950);


--7. Obtener los nombres de los jugadores que hicieron goles en mundiales jugados en su país.

SELECT DISTINCT nombre_jugador, apellido_jugador
FROM jugador
JOIN jugo_partido ON jugador.id_jugador = jugo_partido.jugador
JOIN partido ON jugo_partido.id_partido = partido.id
JOIN mundial ON partido.anho_mundial = mundial.anho
WHERE goles > 0
AND jugador.pais_jugador = mundial.sede;

--uso el DISTINCT ya que Zidane hizo 2 goles en el mundial jugado en Francia


--8. Obtener los nombres de los jugadores que jugaron más de un mundial y que NO hayan salido
--campeón nunca.

SELECT nombre_jugador, apellido_jugador
FROM jugo_mundial
JOIN jugador ON jugo_mundial.jugador = jugador.id_jugador
JOIN mundial ON mundial.anho = jugo_mundial.anho_mundial
WHERE jugador IN (SELECT jugador
				  FROM jugo_mundial
                 GROUP BY (jugador)
                 HAVING COUNT (anho_mundial) > 1)
EXCEPT (SELECT nombre_jugador, apellido_jugador
                      FROM jugador
                      JOIN jugo_mundial ON jugador.id_jugador = jugo_mundial.jugador
                      JOIN mundial ON jugo_mundial.anho_mundial = mundial.anho
                      WHERE pais_jugador = ganador);
					  
--Primero se obtienen todos los jugadores que jugaron mas de un mundial,
--con la operación EXCEPT se hace la "resta" con los jugadores ganadores
--de un mundial
					  
--9. Obtener los nombres de los jugadores que hayan salido goleadores de un mundial y que no sean delanteros.

SELECT nombre_jugador, apellido_jugador, SUM(goles)
FROM jugador
JOIN jugo_partido ON jugador.id_jugador = jugo_partido.jugador
JOIN partido ON jugo_partido.id_partido = partido.id
JOIN mundial ON partido.anho_mundial = mundial.anho
GROUP BY (nombre_jugador, apellido_jugador,posicion_jugador)
HAVING SUM (goles) > 1
AND posicion_jugador <> 'Delantero';

--Se asume que los maximos goleadores de un mundial hicieron mas de 1 gol en
--la competición


--10. Obtener la sede y el año de los tres mundiales con más incidentes

SELECT sede, anho
FROM mundial
WHERE cantidad_incidetes > 0
ORDER BY cantidad_incidetes DESC
LIMIT (3);


--11. Obtener la sede y el año de los dos mundiales con menos incidentes.

SELECT sede, anho
FROM mundial
WHERE cantidad_incidetes > 0
ORDER BY cantidad_incidetes
LIMIT (2);


--12. Obtener, de los países que ganaron mundiales, el porcentaje de barras en función de su población

SELECT DISTINCT nombre_pais, (CAST(barras_registrados AS decimal) / cantidad_habitantes * 100) AS porcentaje_barras
FROM pais
JOIN mundial ON pais.nombre_pais = mundial.ganador;



--13. Obtener el listado de las 3 mayores goleadas de todos los mundiales, ornedados por goleada, indicando:
--país ganador, país perdedor, resultado, nombre de la figura y su nacionalidad. (Una goleada es mayor que
--otra si: 1. la diferencia de gol es mayor, 2. a igualdad de diferencia de gol, mayor cantidad de goles a
--favor, 3. a igualdad de las anteriores, cualquiera. Ej: 7 a 1 es mayor que 6 a 0.)

SELECT equipo_local, equipo_visitante, goles_local, goles_visitante, figura_partido, pais_jugador
FROM pais
JOIN partido ON pais.nombre_pais = partido.equipo_local
JOIN jugador ON jugador.pais_jugador = partido.equipo_local
ORDER BY ABS(goles_local - goles_visitante)DESC
CASE goles_local WHEN goles_local > goles_visitante
THEN goles_local
;

--el ejercicio no salio


--14. Obtener la sede, el año, la cantidad de entradas vendidas, la cantidad de participantes, la cantidad de
--espectadores y el promedio de espectadores por partido de todos los mundiales, ordendos por año.

SELECT anho, sede, cantidad_participantes,(promedio_entradas_vendidas * partidos_jugados) AS cantidad_entradas_vendidas,
(promedio_entradas_vendidas * partidos_jugados) AS cantidad_espectadores,
promedio_entradas_vendidas AS promedio_espectadores
FROM mundial
ORDER BY anho;
	

