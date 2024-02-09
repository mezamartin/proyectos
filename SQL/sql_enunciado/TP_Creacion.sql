CREATE TABLE pais
(
    nombre_pais text COLLATE pg_catalog."default" NOT NULL,
    cantidad_habitantes bigint,
    barras_registrados bigint,
    clasico text COLLATE pg_catalog."default",
    CONSTRAINT "Pais_pkey" PRIMARY KEY (nombre_pais),
    CONSTRAINT "FK_pais_rival" FOREIGN KEY (clasico)
        REFERENCES pais (nombre_pais) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TABLE jugador
(
    id_jugador SERIAL NOT NULL,
    nombre_apellido_jugador text COLLATE pg_catalog."default",
    edad_jugador bigint,
    club_jugador text NOT NULL,
    pais_jugador text COLLATE pg_catalog."default" NOT NULL,
    posicion_jugador text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT "Unique_Jugador" UNIQUE (id_jugador),
    CONSTRAINT "FK_Pais_Jugador" FOREIGN KEY (pais_jugador)
        REFERENCES pais (nombre_pais) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TABLE mundial
(
    anho bigint NOT NULL,
    sede text,
    ganador text,
    subcampeon text,
    promedio_entradas_vendidas bigint,
    cantidad_incidetes bigint,
	cantidad_participantes bigint,
	goles_totales bigint,
	partidos_jugados bigint,
    PRIMARY KEY (anho),
    CONSTRAINT "FK_Sede_Pais" FOREIGN KEY (sede)
        REFERENCES pais (nombre_pais) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT "FK_Campeon_Pais" FOREIGN KEY (ganador)
        REFERENCES pais (nombre_pais) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT "FK_Subcampeon_Pais" FOREIGN KEY (subcampeon)
        REFERENCES pais (nombre_pais) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TABLE jugo_mundial
(
    jugador bigint NOT NULL,
    anho_mundial bigint NOT NULL,
    goles_a_favor bigint,
    goles_en_contra bigint,
    PRIMARY KEY (jugador, anho_mundial),
    CONSTRAINT "FK_Jugo_Jugador" FOREIGN KEY (jugador)
        REFERENCES jugador (id_jugador) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT "FK_Jugo_Mundial" FOREIGN KEY (anho_mundial)
        REFERENCES mundial (anho) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TABLE partido
(
    id SERIAL NOT NULL,
    anho_mundial bigint NOT NULL,
    equipo_local text COLLATE pg_catalog."default" NOT NULL,
    equipo_visitante text COLLATE pg_catalog."default" NOT NULL,
    goles_local bigint,
    goles_visitante bigint,
	fase text,
    figura_partido bigint NOT NULL,
    CONSTRAINT "Partido_pkey" PRIMARY KEY (id),
    CONSTRAINT "FK_Anho_Mundial" FOREIGN KEY (anho_mundial)
        REFERENCES mundial (anho) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT "FK_Figura_Jugador" FOREIGN KEY (figura_partido)
        REFERENCES jugador (id_jugador) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT "FK_Local_Pais" FOREIGN KEY (equipo_local)
        REFERENCES pais (nombre_pais) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT "FK_Visitante_Pais" FOREIGN KEY (equipo_visitante)
        REFERENCES pais (nombre_pais) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE INDEX "fki_FK_Pais_Rival"
    ON pais USING btree
    (clasico COLLATE pg_catalog."default")
    TABLESPACE pg_default;

CREATE INDEX "fki_FK_Club_Jugador"
    ON jugador USING btree
    (club_jugador)
    TABLESPACE pg_default;

CREATE INDEX "fki_FK_Pais_Jugador"
    ON jugador USING btree
    (pais_jugador COLLATE pg_catalog."default")
    TABLESPACE pg_default;
