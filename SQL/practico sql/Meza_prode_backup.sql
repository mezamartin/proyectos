--
-- PostgreSQL database dump
--

-- Dumped from database version 10.4
-- Dumped by pg_dump version 10.4

-- Started on 2018-07-09 19:10:29

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2866 (class 0 OID 0)
-- Dependencies: 2865
-- Name: DATABASE postgres; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON DATABASE postgres IS 'default administrative connection database';


--
-- TOC entry 2 (class 3079 OID 12924)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2868 (class 0 OID 0)
-- Dependencies: 2
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


--
-- TOC entry 1 (class 3079 OID 16384)
-- Name: adminpack; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS adminpack WITH SCHEMA pg_catalog;


--
-- TOC entry 2869 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION adminpack; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION adminpack IS 'administrative functions for PostgreSQL';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 199 (class 1259 OID 16408)
-- Name: jugador; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.jugador (
    id_jugador integer NOT NULL,
    edad_jugador bigint,
    club_jugador text NOT NULL,
    pais_jugador text NOT NULL,
    posicion_jugador text NOT NULL,
    nombre_jugador text,
    apellido_jugador text
);


ALTER TABLE public.jugador OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 16406)
-- Name: jugador_id_jugador_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.jugador_id_jugador_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.jugador_id_jugador_seq OWNER TO postgres;

--
-- TOC entry 2870 (class 0 OID 0)
-- Dependencies: 198
-- Name: jugador_id_jugador_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.jugador_id_jugador_seq OWNED BY public.jugador.id_jugador;


--
-- TOC entry 201 (class 1259 OID 16445)
-- Name: jugo_mundial; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.jugo_mundial (
    jugador bigint NOT NULL,
    anho_mundial bigint NOT NULL,
    goles_a_favor bigint,
    goles_en_contra bigint
);


ALTER TABLE public.jugo_mundial OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 16518)
-- Name: jugo_partido; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.jugo_partido (
    id_partido integer NOT NULL,
    jugador bigint NOT NULL,
    goles bigint,
    calificacion bigint
);


ALTER TABLE public.jugo_partido OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 16516)
-- Name: jugo_partido_id_partido_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.jugo_partido_id_partido_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.jugo_partido_id_partido_seq OWNER TO postgres;

--
-- TOC entry 2871 (class 0 OID 0)
-- Dependencies: 204
-- Name: jugo_partido_id_partido_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.jugo_partido_id_partido_seq OWNED BY public.jugo_partido.id_partido;


--
-- TOC entry 200 (class 1259 OID 16422)
-- Name: mundial; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.mundial (
    anho bigint NOT NULL,
    sede text,
    ganador text,
    subcampeon text,
    promedio_entradas_vendidas bigint,
    cantidad_incidetes bigint,
    cantidad_participantes bigint,
    goles_totales bigint,
    partidos_jugados bigint
);


ALTER TABLE public.mundial OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 16393)
-- Name: pais; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pais (
    nombre_pais text NOT NULL,
    cantidad_habitantes bigint,
    barras_registrados bigint,
    clasico text
);


ALTER TABLE public.pais OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 16462)
-- Name: partido; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.partido (
    id integer NOT NULL,
    anho_mundial bigint NOT NULL,
    equipo_local text NOT NULL,
    equipo_visitante text NOT NULL,
    goles_local bigint,
    goles_visitante bigint,
    fase text,
    figura_partido bigint NOT NULL
);


ALTER TABLE public.partido OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 16460)
-- Name: partido_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.partido_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.partido_id_seq OWNER TO postgres;

--
-- TOC entry 2872 (class 0 OID 0)
-- Dependencies: 202
-- Name: partido_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.partido_id_seq OWNED BY public.partido.id;


--
-- TOC entry 2699 (class 2604 OID 16411)
-- Name: jugador id_jugador; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.jugador ALTER COLUMN id_jugador SET DEFAULT nextval('public.jugador_id_jugador_seq'::regclass);


--
-- TOC entry 2701 (class 2604 OID 16521)
-- Name: jugo_partido id_partido; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.jugo_partido ALTER COLUMN id_partido SET DEFAULT nextval('public.jugo_partido_id_partido_seq'::regclass);


--
-- TOC entry 2700 (class 2604 OID 16465)
-- Name: partido id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.partido ALTER COLUMN id SET DEFAULT nextval('public.partido_id_seq'::regclass);


--
-- TOC entry 2853 (class 0 OID 16408)
-- Dependencies: 199
-- Data for Name: jugador; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.jugador (id_jugador, edad_jugador, club_jugador, pais_jugador, posicion_jugador, nombre_jugador, apellido_jugador) FROM stdin;
1	28	Tiburones Rojos	Perú	Arquero	Pedro	Gallese
2	26	Deportivo Municipal	Perú	Arquero	Carlos	Caceda
3	32	UTC	Perú	Arquero	Jose	Carvallo
4	34	Junio	Perú	Defensor	Alberto	Rodriguez
5	29	Universitario	Perú	Defensor	Aldo	Corzo
6	26	Puebla	Perú	Defensor	Anderson	Santamaria
7	23	Alianza Lima	Perú	Defensor	Miguel	Araujo
8	25	Flamengo	Perú	Defensor	Miguel	Trauco
9	29	Tiburones Rojos	Perú	Defensor	Christian	Ramos
10	28	Lobos BUAP	Perú	Defensor	Luis	Advincula
11	23	Melgar	Perú	Defensor	Nilson	Loyola
12	27	Vitoria	Perú	Mediocampista	Paolo	Hurtado
13	26	Sao Paulo	Perú	Mediocampista	Christian	Cueva
14	22	Feyenoord	Perú	Mediocampista	Renato	Tapia
15	23	Portland Timbers	Perú	Mediocampista	Andy	Polo
16	23	Tiburones Rojos	Perú	Mediocampista	Wilder	Cartagena
17	28	Orlando City	Perú	Mediocampista	Yoshimar	Yotun
18	23	Leon	Perú	Mediocampista	Pedro	Aquino
19	34	Flamengo	Perú	Mediocampista	Paolo	Guerrero
20	33	Lokomotiv Moscu	Perú	Delantero	Jefferson	Farfan
21	27	Monarcas Morelia	Perú	Delantero	Raul	Ruidiaz
22	27	Watford	Perú	Delantero	André	Carrillo
23	24	Aalborg	Perú	Delantero	Edison	Flores
24	23	Dinamo Zagreb	Croacia	Arquero	Dominik	Livakovic
25	28	KAA Gent	Croacia	Arquero	Lovre	Kalinic
26	33	Monaco	Croacia	Arquero	Danijel	Subasic
27	26	Atletico Madrid	Croacia	Defensor	Sime	Vrsaljko
28	30	Sampdoria	Croacia	Defensor	Ivan	Strinic
29	32	Lokomotiv Moscu	Croacia	Defensor	Vedran	Corluka
30	28	Liverpool FC	Croacia	Defensor	Dejan	Lovren
31	22	BayerLeverkusen	Croacia	Defensor	Tin	Jedvaj
32	21	Red Bull Salzburg	Croacia	Defensor	Duje	Caleta-Car
33	29	Besiktas	Croacia	Defensor	Domagoj	Vida
34	29	Dinamo Kiev	Croacia	Defensor	Josip	Pivaric
35	30	FC Barcelona	Croacia	Mediocampista	Ivan	Rakitic
36	24	Real Madrid	Croacia	Mediocampista	Mateo	Kovacic
37	32	Real Madrid	Croacia	Mediocampista	Luka	Modric
38	25	Inter	Croacia	Mediocampista	Marcelo	Brozovic
39	26	HNK Rijeka	Croacia	Mediocampista	Filip	Bradaric
40	29	Fiorentina	Croacia	Mediocampista	Milan	Badelj
41	29	Inter	Croacia	Delantero	Ivan	Perisic
42	26	TSG Hoffenheim	Croacia	Delantero	Andrej	Kramaric
43	30	Milan	Croacia	Delantero	Nikola	Kalinic
44	32	Juventus FC	Croacia	Delantero	Mario	Mandzukic
45	24	Eintracht Frankfurt	Croacia	Delantero	Ante	Rebic
46	23	Schalke 04	Croacia	Delantero	Marko	Pjaca
47	31	Randers FC	Islandia	Arquero	Hannes	Hallorsson
48	23	FC Roskilde	Islandia	Arquero	Frederik	Schram
49	23	FC Nordsjaelland	Islandia	Arquero	Runar	Runarsson
50	33	Valur Reykjavik	Islandia	Defensor	Birkir	Svarsson
51	24	FC Rostov	Islandia	Defensor	Sverrir	Ingason
52	31	FC Rostov	Islandia	Defensor	Ragnar	Sigurdsson
53	35	Aberdeen	Islandia	Defensor	Kari	Arnason
54	27	Levski Sofia	Islandia	Defensor	Holmar	Eyjolfsson
55	25	Bristol City	Islandia	Defensor	Horour	Magnusson
56	31	KSC Lokeren	Islandia	Defensor	Ari	Skulason
57	22	Valerenga	Islandia	Mediocampista	Samuel	Friojonsson
58	20	PSV Eindhoven	Islandia	Mediocampista	Albert	Gudmundsson
59	27	Burnley	Islandia	Mediocampista	Johann	Bjarnason
60	30	Aston Vila	Islandia	Mediocampista	Birkir	Guomundsson
61	28	Everton FC	Islandia	Mediocampista	Gylfi	Sigurdson
62	35	Kardemir Karabukspor	Islandia	Mediocampista	Olafur	Skulason
63	29	Cadiff City	Islandia	Mediocampista	Aron	Gunnarsson
64	30	SV Sandhausen	Islandia	Mediocampista	Rurik	Gislason
65	33	Udinese	Islandia	Mediocampista	Emil	Hallfredsson
66	25	Malmo	Islandia	Mediocampista	Arnor	Traustason
67	27	FC Rostov	Islandia	Delantero	Bjorn	Sigurdarson
68	29	FC Augsburg	Islandia	Delantero	Alfred	Finnbogason
69	26	Reading	Islandia	Delantero	Jon	Boovarsson
70	29	Enyimba	Nigeria	Arquero	Ikechukwu	Ezenwa
71	32	Chippa United	Nigeria	Arquero	Daniel	Akpeyi
72	19	Deportivo La Coruña	Nigeria	Arquero	Francis	Uzoho
73	26	Amkar Perm	Nigeria	Defensor	Brian	Idowu
74	30	Cercle Brugge	Nigeria	Defensor	Elderson	Echiejile
75	24	Bursaspor	Nigeria	Defensor	William	Troost-Ekong
76	29	FSV Mainz	Nigeria	Defensor	Leon	Balogun
77	25	Bursaspor	Nigeria	Defensor	Abdullahi	Shehu
78	21	FC Nantes	Nigeria	Defensor	Chidozie	Awaziem
79	22	ADO La Haya	Nigeria	Defensor	Tyronne	Ebuehi
80	24	Kasimpasa	Nigeria	Defensor	Kenneth	Omeruo
81	21	Leicester City	Nigeria	Mediocampista	Wilfred	Ndidi
82	22	Las Palmas	Nigeria	Mediocampista	Oghenekaro	Etebo
83	31	Tianjin Teda	Nigeria	Mediocampista	John	Obi Mikel
84	27	Torino	Nigeria	Mediocampista	Joel	Obi
85	25	Trabzonspor	Nigeria	Mediocampista	Ogenyi	Onazi
86	30	Hapoel Beer Sheva	Nigeria	Mediocampista	John	Ogu
87	25	CSKA Moscu	Nigeria	Delantero	Ahmed	Musa
88	28	Changchun Yatai	Nigeria	Delantero	Odion	Ighalo
89	27	Chelsea FC	Nigeria	Delantero	Victor	Moses
90	26	FC Crotone	Nigeria	Delantero	Simeon	Nwankwo
91	22	Leicester City	Nigeria	Delantero	Kelechi	Iheanacho
92	22	Arsenal FC	Nigeria	Delantero	Alex	Iwobi
93	32	Standard Lieje	México	Arquero	Guillermo	Ochoa
94	34	Cruz Azul	México	Arquero	Jose de Jesus	Corona
95	35	Toluca	México	Arquero	Alfredo	Talavera
96	39	Atlas	México	Defensor	Rafael	Marquez
97	30	Real Sociedad	México	Defensor	Hector	Moreno
98	29	Sevilla FC	México	Defensor	Miguel	Layun
99	30	Tigres	México	Defensor	Hugo	Ayala
100	24	Eintracht Frankfurt	México	Defensor	Carlos	Salcedo
101	23	Universidad Nacional	México	Defensor	Jesus	Gallardo
102	20	America	México	Defensor	Edson	Alvarez
103	23	Pachuca	México	Mediocampista	Erick	Gutierrez
104	31	Betis	México	Mediocampista	Andres	Guardado
105	27	Porto	México	Mediocampista	Hector	Herrera
106	28	Tigres	México	Mediocampista	Javier	Aquino
107	28	Eintracht Frankfurt	México	Mediocampista	Marco	Fabian
108	28	Los Angeles Galaxy	México	Mediocampista	Jonathan	Dos Santos
109	29	Los Angeles Galaxy	México	Delantero	Giovani	Dos Santos
110	29	West Ham	México	Delantero	Javier	Hernandez
111	28	Los Angeles FC	México	Delantero	Carlos	Vela
112	34	America	México	Delantero	Orie	Peralta
113	26	Benfica	México	Delantero	Raul	Jimenez
114	25	Porto	México	Delantero	Jesus	Corona
115	22	PSV Eindhoven	México	Delantero	Hirving	Lozano
116	26	Chelsea FC	Bélgica	Arquero	Thibaut	Courtois
117	30	Liverpool FC	Bélgica	Arquero	Simon	Mignolet
118	25	Vlf Wolsburg	Bélgica	Arquero	Koen	Casteels
119	29	Tottenham	Bélgica	Defensor	Toby	Alderweireld
120	32	FC Barcelona	Bélgica	Defensor	Thomas	Vermaelen
121	32	Manchester City	Bélgica	Defensor	Vincent	Kompany
122	31	Tottenham	Bélgica	Defensor	Jan	Vertonghen
123	26	Paris Saint Germain	Bélgica	Defensor	Thomas	Meunier
124	27	Celtic 	Bélgica	Defensor	Dedryck	Boyata
125	23	RSC Anderlecht	Bélgica	Defensor	Leander	Dendoncker
126	29	Tianjin Quanjian	Bélgica	Mediocampista	Axel	Witsel
127	26	Manchester City	Bélgica	Mediocampista	Kevin	De Bruyne
128	30	Manchester United	Bélgica	Mediocampista	Marouane	Fellaini
129	24	Dalian Yifang	Bélgica	Mediocampista	Yannick	Carrasco
130	25	Borussia Monchengladbach	Bélgica	Mediocampista	Thorgan	Hazard
131	21	Monaco	Bélgica	Mediocampista	Youri	Tielemans
132	30	Tottenham	Bélgica	Mediocampista	Mousa	Dembele
133	28	West Bromwich	Bélgica	Mediocampista	Nacer	Chadli
134	25	Manchester United	Bélgica	Delantero	Romelu	Lukaku
135	27	Chelsea FC	Bélgica	Delantero	Eden	Hazard
136	31	Napoli	Bélgica	Delantero	Dries	Mertens
137	23	Real Sociedad	Bélgica	Delantero	Adnan	Januzaj
138	24	Borussia Dortmund	Bélgica	Delantero	Michy	Batshuayi
139	24	Everton FC	Inglaterra	Arquero	Jordan	Pickford
140	25	Stoke City	Inglaterra	Arquero	Jack	Butland
141	26	Burnley	Inglaterra	Arquero	Nick	Pope
142	28	Manchester City	Inglaterra	Defensor	Kyle	Walker
143	27	Tottenham	Inglaterra	Defensor	Danny	Rose
144	24	Manchester City	Inglaterra	Defensor	John	Stones
145	25	Leicester City	Inglaterra	Defensor	Harry	Maguire
146	27	Tottenham	Inglaterra	Defensor	Kieran	Trippier
147	32	Chelsea FC	Inglaterra	Defensor	Gary	Cahill
148	26	Manchester United	Inglaterra	Defensor	Phil	Jones
149	28	Manchester City	Inglaterra	Defensor	Fabian	Delph
150	32	Manchester United	Inglaterra	Defensor	Ashley	Young
151	19	Liverpool FC	Inglaterra	Defensor	Trent	Alexander-Arnold
152	24	Tottenham	Inglaterra	Mediocampista	Eric	Dier
153	25	Manchester United	Inglaterra	Mediocampista	Jesse	Lingard
154	27	Liverpool FC	Inglaterra	Mediocampista	Jordan	Henderson
155	22	Tottenham	Inglaterra	Mediocampista	Dele	Alli
156	22	Crystal Palace	Inglaterra	Mediocampista	Ruben	Loftus-Cheek
157	24	Tottenham	Inglaterra	Delantero	Harry	Kane
158	23	Manchester City	Inglaterra	Delantero	Raheem	Sterling
159	31	Leicester City	Inglaterra	Delantero	Jamie	Vardy
160	27	Arsenal FC	Inglaterra	Delantero	Danny	Welbeck
161	20	Manchester United	Inglaterra	Delantero	Marcus	Rashford
162	29	Arsenal FC	Colombia	Arquero	David	Ospina
163	29	Deportivo Cali	Colombia	Arquero	Camilo	Vargas
164	32	Once Caldas	Colombia	Arquero	Jose Fernando	Cuadrado
165	31	Milan	Colombia	Defensor	Cristian	Zapata
166	30	Pachuca	Colombia	Defensor	Oscar	Murillo
167	26	PSV Eindhoven	Colombia	Defensor	Santiago	Arias
168	23	FC Barcelona	Colombia	Defensor	Yerry	Mina
169	34	Olimpia	Colombia	Defensor	Farid	Diaz
170	22	Tottenham	Colombia	Defensor	Davinson	Sanchez
171	25	Girona	Colombia	Defensor	Johan	Mojica
172	24	Boca Juniors	Colombia	Mediocampista	Wilmar	Barrios
173	32	Espanyol	Colombia	Mediocampista	Carlos	Sanchez
174	33	Deportivo Cali	Colombia	Mediocampista	Abel	Aguilar
175	26	Bayern Munich	Colombia	Mediocampista	James	Rodriguez
176	25	River Plate	Colombia	Mediocampista	Juan Fernando	Quintero
177	27	America	Colombia	Mediocampista	Mateus	Uribe
178	23	Levante	Colombia	Mediocampista	Jefferson	Lerma
179	29	Juventus FC	Colombia	Mediocampista	Juan Guillermo	Cuadrado
180	31	Villareal	Colombia	Delantero	Carlos	Bacca
181	32	Monaco	Colombia	Delantero	Radamel	Falcao
182	27	Sevilla FC	Colombia	Delantero	Luis	Muriel
183	25	Palmeiras	Colombia	Delantero	Miguel	Borja
184	25	Brighton	Colombia	Delantero	Jose	Izquierdo
185	34	Partizan	Serbia	Arquero	Vladimir	Stojkovic
186	22	Maccabi Tel Aviv	Serbia	Arquero	Predrag	Rajkovic
187	26	Eibar	Serbia	Arquero	Marko	Dmitrovic
188	34	Villareal	Serbia	Defensor	Antonio	Rukavina
189	33	Besiktas	Serbia	Defensor	Dusko	Tosic
190	25	RSC Anderlecht	Serbia	Defensor	Uros	Spajic
191	34	Zenit de San Petersburgo	Serbia	Defensor	Branislav	Ivanovic
192	32	Roma	Serbia	Defensor	Aleksandar	Kolarov
193	22	Werder Bremen	Serbia	Defensor	Milos	Veljkovic
194	27	Estrella Roja	Serbia	Defensor	Milan	Rodic
195	20	Fiorentina	Serbia	Defensor	Nikola	Milenkovic
196	27	Crystal Palace	Serbia	Mediocampista	Luka	Milivojevic
197	21	Benfica	Serbia	Mediocampista	Andrija	Zivkovic
198	29	Southampton	Serbia	Mediocampista	Dusan	Tadic
199	22	Cardiff	Serbia	Mediocampista	Marko	Grujic
200	25	Hamburgo	Serbia	Mediocampista	Filip	Kostic
201	23	Lazio	Serbia	Mediocampista	Sergej	Milinkovic-Savic
202	29	Manchester United	Serbia	Mediocampista	Nemanja	Matic
203	26	Torino	Serbia	Mediocampista	Adem	Ljajic
204	28	PAOK Salonica	Serbia	Delantero	Aleksandar	Prijovic
205	23	Fulham	Serbia	Delantero	Aleksandar	Mitrovic
206	22	Estrella Roja	Serbia	Delantero	Nemanja	Radonjic
207	20	Eintracht Frankfurt	Serbia	Delantero	Luka	Jovic
208	28	Juventus FC	Polonia	Arquero	Wojciech	Szczesny
209	30	Ipswich Town	Polonia	Arquero	Bartosz	Bialkowski
210	33	Swansea City	Polonia	Arquero	Lukasz	Fabianski
211	30	Legia Varsovia	Polonia	Defensor	Michal	Pazdan
212	30	Legia Varsovia	Polonia	Defensor	Artur	Jedrzejczyk
213	32	SPAL	Polonia	Defensor	Thiago	Cionek
214	22	Southampton	Polonia	Defensor	Jan	Bednarek
215	30	Monaco	Polonia	Defensor	Kamil	Glik
216	25	Sampdoria	Polonia	Defensor	Bartosz	Bereszynski
217	33	Borussia Dortmund	Polonia	Defensor	Lukasz	Piszczek
218	25	Lodogorets	Polonia	Mediocampista	Jacek	Goralski
219	23	Sampdoria	Polonia	Mediocampista	Karol	Linetty
220	28	West Bromwich	Polonia	Mediocampista	Grzegorz	Krychowiak
221	3	Hull City	Polonia	Mediocampista	Kamil	Grosicki
222	28	Lokomotiv Moscu	Polonia	Mediocampista	Maciej	Rybus
223	32	Vfl Wolfsburg	Polonia	Mediocampista	Jakub	Baszczykowski
224	33	Lechia Gdansk	Polonia	Mediocampista	Slawomir	Peszko
225	24	Napoli	Polonia	Mediocampista	Piotr	Zielinski
226	25	Gornik Zabrze	Polonia	Mediocampista	Rafal	Kurzawa
227	24	Napoli	Polonia	Delantero	Arkadiusz	Milik
228	29	Bayern Munich	Polonia	Delantero	Robert	Lewandowski
229	27	RSC Anderlecht	Polonia	Delantero	Lukasz	Teodorczyk
230	21	Sampdoria	Polonia	Delantero	Dawid	Kownacki
231	35	FC Metz	Japón	Arquero	Eiji	Kawasaki
232	32	Gamba Osaka	Japón	Arquero	Masaaki	Higashiguchi
233	23	Kashiwa Reysol	Japón	Arquero	Kosuke	Nakamura
234	23	Kashima Antlers	Japón	Defensor	Naomichi	Ueda
235	25	Kashima Antlers	Japón	Defensor	Gen	Shoji
236	31	Galatasaray	Japón	Defensor	Yuto	Nagatomo
237	25	Urawa Red Diamonds	Japón	Defensor	Wataru	Endo
238	28	Olympique Marseille	Japón	Defensor	Hiroki	Sakai
239	31	Urawa Red Diamonds	Japón	Defensor	Tomoaki	Makino
240	27	Hamburgo SV	Japón	Defensor	Gotoku	Sakai
241	29	Southampton	Japón	Defensor	Maya	Yoshida
242	32	Pachuca	Japón	Mediocampista	Keisuke	Honda
243	26	Getafe	Japón	Mediocampista	Gaku	Shibasaki
244	27	Fortuna Dusseldorf	Japón	Mediocampista	Genki	Haraguchi
245	29	Borussia Dortmund	Japón	Mediocampista	Shinji	Kagawa
246	26	Fortuna Dusseldorf	Japón	Mediocampista	Takashi	Usami
247	30	Eibar	Japón	Mediocampista	Takashi	Inui
248	27	Cerezo Osaka	Japón	Mediocampista	Hotaru	Yamaguchi
249	34	Eintracht Frankfurt	Japón	Mediocampista	Makoto	Hasebe
250	25	Kawasaki Frontale	Japón	Mediocampista	Ryota	Oshima
251	32	Leicester City	Japón	Delantero	Shinji	Okazaki
252	25	Mainz	Japón	Delantero	Yoshinori	Muto
253	28	FC Koln	Japón	Delantero	Yuya	Osako
254	36	Botafogo	Brasil	Arquero	Jefferson	\N
255	38	Retirado	Brasil	Arquero	Julio Cesar	\N
256	25	Roma	Brasil	Arquero	Alisson	\N
257	31	Corinthians	Brasil	Arquero	Cassio	\N
258	24	Manchester City	Brasil	Arquero	Ederson	\N
259	35	Paris Saint Germain	Brasil	Defensor	Dani	Alves
260	35	Paris Saint Germain	Brasil	Defensor	Thiago	Silva
261	31	Chelsea FC	Brasil	Defensor	David	Luiz
262	30	Real Madrid	Brasil	Defensor	Marcelo	\N
263	34	OGC Niza	Brasil	Defensor	Dante	\N
264	32	Retirado	Brasil	Defensor	Maxwell	\N
265	31	Fluminense	Brasil	Defensor	Henrique	\N
266	33	Inter	Brasil	Defensor	Joao	Miranda
267	32	Gremio	Brasil	Defensor	Geromel	\N
268	32	Atlético Madrid	Brasil	Defensor	Filipe	Luis
269	24	Paris Saint Germain	Brasil	Defensor	Marquinhos	\N
270	26	Manchester City	Brasil	Defensor	Danilo	\N
271	29	Corinthians	Brasil	Defensor	Fagner	\N
272	33	Manchester City	Brasil	Mediocampista	Fernandinho	\N
273	29	FC Barcelona	Brasil	Mediocampista	Paulinho	\N
274	26	Shangai SIPG	Brasil	Mediocampista	Oscar	\N
275	31	Jiangsu Suning	Brasil	Mediocampista	Ramires	\N
276	30	Olympique Marseille	Brasil	Mediocampista	Luiz	Gustavo
277	29	Chelsea FC	Brasil	Mediocampista	Willian	\N
278	26	Real Madrid	Brasil	Mediocampista	Casemiro	\N
279	30	Beijing Guoan	Brasil	Mediocampista	Renato	Augusto
280	26	FC Barcelona	Brasil	Mediocampista	Philippe	Coutinho
281	25	Shaktar Donetsk	Brasil	Mediocampista	Fred	\N
282	31	Shangai SIPG	Brasil	Delantero	Hulk	\N
283	34	Cruzeiro	Brasil	Delantero	Fred	\N
284	26	Paris Saint Germain	Brasil	Delantero	Neymar	\N
285	33	Sao Paulo	Brasil	Delantero	Hernanes	\N
286	25	Shaktar Donetsk	Brasil	Delantero	Bernard	\N
287	27	Juventus FC	Brasil	Delantero	Douglas	Costa
288	21	Manchester City	Brasil	Delantero	Gabriel	Jesus
289	26	Liverpool FC	Brasil	Delantero	Roberto	Firmino
290	30	Shaktar Donetsk	Brasil	Delantero	Taison	\N
291	31	Manchester United	Argentina	Arquero	Sergio	Romero
292	36	Colo-Colo	Argentina	Arquero	Agustín	Orión
293	34	Estudiantes de La Plata	Argentina	Arquero	Mariano	Andújar
294	31	River Plate	Argentina	Arquero	Franco	Armani
295	36	Chelsea FC	Argentina	Arquero	Wilfredo	Caballero
296	32	Tigres	Argentina	Arquero	Nahuel	Guzmán
297	33	West Ham	Argentina	Defensor	Pablo	Zabaleta
298	37	Pescara	Argentina	Defensor	Hugo	Campagnaro
299	31	Valencia	Argentina	Defensor	Ezequiel	Garay
300	37	Retirado	Argentina	Defensor	Martin	Demichelis
301	27	Manchester United	Argentina	Defensor	Marcos	Rojo
302	29	Swansea	Argentina	Defensor	Federico	Fernandez
303	34	Monterrey	Argentina	Defensor	Jose	Basanta
304	30	Manchester City	Argentina	Defensor	Nicolás	Otamendi
305	31	Sevilla FC	Argentina	Defensor	Gabriel	Mercado
306	25	Ajax FC	Argentina	Defensor	Nicolás	Tagliafico
307	27	Torino	Argentina	Defensor	Cristian	Ansaldi
308	31	Roma FC	Argentina	Defensor	Federico	Fazio
309	26	Sporting Lisboa	Argentina	Mediocampista	Marcos	Acuña
310	32	Boca Juniors	Argentina	Mediocampista	Fernando	Gago
311	32	Milan FC	Argentina	Mediocampista	Lucas	Biglia
312	34	Hebei Fortune	Argentina	Mediocampista	Javier	Mascherano
313	30	Paris Saint Germain	Argentina	Mediocampista	Angel	Di María
314	30	Atlas de Guadalajara	Argentina	Mediocampista	Ricardo	Alvarez
315	32	Beijing Renhe	Argentina	Mediocampista	Augusto	Fernandez
316	37	Peñarol	Argentina	Mediocampista	Maximiliano	Rodriguez
317	32	River Plate	Argentina	Mediocampista	Enzo	Perez
318	29	Sevilla FC	Argentina	Mediocampista	Ever	Banega
319	26	Independiente	Argentina	Mediocampista	Maximiliano	Meza
320	28	Benfica	Argentina	Mediocampista	Eduardo	Salvio
321	22	Paris Saint Germain	Argentina	Mediocampista	Giovanni	Lo Celso
322	22	Boca Juniors	Argentina	Mediocampista	Cristian	Pavon
323	30	FC Barcelona	Argentina	Delantero	Lionel	Messi
324	30	Juventus FC	Argentina	Delantero	Gonzalo	Higuain
325	30	Manchester City	Argentina	Delantero	Sergio	Agüero
326	33	Hebei Fortune	Argentina	Delantero	Ezequiel	Lavezzi
327	36	Bologna FC	Argentina	Delantero	Rodrigo	Palacio
328	24	Juventus FC	Argentina	Delantero	Paulo	Dybala
329	25	Inter	Argentina	Delantero	Mauro	Icardi
330	20	Inter	Argentina	Delantero	Lautaro	Martínez
331	25	West Ham	Argentina	Mediocampista	Manuel	Lanzini
332	32	Boca Juniors	Argentina	Mediocampista	Pablo	Perez
333	28	Sevilla FC	Argentina	Mediocampista	Guido	Pizarro
334	27	Everton FC	Argentina	Defensor	Ramiro	Funes Mori
335	26	Fiorentina FC	Argentina	Defensor	Germán	Pezzella
336	32	Bayern Munich	Alemania	Arquero	Manuel	Neuer
337	37	Retirado	Alemania	Arquero	Roman	Weidenfeller
338	29	Stuttgart	Alemania	Arquero	Ron-Robert	Zieler
339	27	Paris Saint Germain	Alemania	Arquero	Kevin	Trapp
340	26	FC Barcelona	Alemania	Arquero	Marc-Andre	ter Stegen
341	29	SV Darmstadt 98	Alemania	Defensor	Kevin	Großkreutz
342	30	Juventus FC	Alemania	Defensor	Benedikt	Howedes
343	29	Bayern Munich	Alemania	Defensor	Mats	Hummels
344	26	Borussia Dortmund	Alemania	Defensor	Erik	Durm
345	34	Retirado	Alemania	Defensor	Philipp	Lahm
346	33	Arsenal FC	Alemania	Defensor	Per	Mertesacker
347	29	Bayern Munich	Alemania	Defensor	Jerome	Boateng
348	26	Arsenal FC	Alemania	Defensor	Shkrodan	Mustafi
349	26	Hertha Berlin	Alemania	Defensor	Marvin	Plattenhardt
350	28	FC Koln	Alemania	Defensor	Jonas	Hector
351	22	Bayern Munich	Alemania	Defensor	Niklas	Sule
352	25	Chelsea FC	Alemania	Defensor	Antonio	Rudiger
353	23	Bayern Munich	Alemania	Defensor	Joshua	Kimmich
354	27	Borussia Monchengladbach	Alemania	Mediocampista	Cristoph	Kramer
355	26	Borussia Dortmund	Alemania	Mediocampista	Mario	Gotze
356	28	Real Madrid	Alemania	Mediocampista	Toni	Kroos
357	24	Paris Saint Germain	Alemania	Mediocampista	Julian	Draxler
358	29	Arsenal FC	Alemania	Mediocampista	Mesut	Ozil
359	32	Chicago Fire	Alemania	Mediocampista	Bastian	Schwensteiger
360	31	Juventus FC	Alemania	Mediocampista	Sami	Khedira
361	24	Borussia Monchengladbach	Alemania	Mediocampista	Matthias	Ginter
362	23	Bayern Munich	Alemania	Mediocampista	Leon	Goretzka
363	28	Bayern Munich	Alemania	Mediocampista	Sebastian	Rudy
364	22	Bayer Leverkusen	Alemania	Mediocampista	Julian	Brandt
365	27	Manchester City	Alemania	Mediocampista	Ilkay	Gundogan
366	28	Bayern Munich	Alemania	Delantero	Thomas	Muller
367	40	Retirado	Alemania	Delantero	Miroslav	Klose
368	33	Vissel Kobe	Alemania	Delantero	Lukas	Podolski
369	27	Borussia Dortmund	Alemania	Delantero	Andre	Schurrle
370	22	RB Leipzig	Alemania	Delantero	Timo	Werner
371	29	Borussia Dortmund	Alemania	Delantero	Marco	Reus
372	32	Stuttgart	Alemania	Delantero	Mario	Gomez
373	30	Sporting Lisboa	Portugal	Arquero	Rui	Patricio
374	27	Olympique Lyon	Portugal	Arquero	Anthony	Lopes
375	36	Goztepe SK	Portugal	Arquero	Beto	\N
376	36	Rangers FC	Portugal	Defensor	Bruno	Alves
377	35	Besiktas	Portugal	Defensor	Pepe	\N
378	24	Borussia Dortmund	Portugal	Defensor	Raphael	Guerreiro
379	34	Dalian Yifang	Portugal	Defensor	Jose	Fonte
380	21	Benfica	Portugal	Defensor	Ruben	Dias
381	24	Leicester City	Portugal	Defensor	Ricardo	Pereira
382	27	Napoli	Portugal	Defensor	Mario	Rui
383	26	Southampton	Portugal	Defensor	Cedric	Soares
384	31	Lokomotiv	Portugal	Mediocampista	Manuel	Fernandes
385	23	Monaco	Portugal	Mediocampista	Joao	Moutinho
386	26	West Ham	Portugal	Mediocampista	Joao	Mario
387	23	Sporting Lisboa	Portugal	Mediocampista	William	Carvalho
388	29	Sporting Lisboa	Portugal	Mediocampista	Bruno	Fernandes
389	11	Leicester City	Portugal	Mediocampista	Adrien	Silva
390	33	Real Madrid	Portugal	Delantero	Cristiano	Ronaldo
391	23	Milan	Portugal	Delantero	André	Silva
392	23	Manchester City	Portugal	Delantero	Bernardo	Silva
393	21	Valencia	Portugal	Delantero	Gonzalo	Guedes
394	25	Sporting Lisboa	Portugal	Delantero	Gelson	Martins
395	34	Besiktas	Portugal	Delantero	Ricardo	Quaresma
396	27	Manchester United	España	Arquero	David	de Gea
397	23	Athletic Club	España	Arquero	Kepa	Arrizabalaga
398	35	Napoli	España	Arquero	José	Reina
399	26	Real Madrid	España	Defensor	Dani	Carvajal
400	31	FC Barcelona	España	Defensor	Gerard	Piqué
401	28	Real Madrid	España	Defensor	Nacho	Fernandez
402	22	Real Sociedad	España	Defensor	Alvaro	Odriozola
403	28	Chelsea FC	España	Defensor	Cesar	Azpillicueta
404	32	Real Madrid	España	Defensor	Sergio	Ramos
405	32	Arsenal FC	España	Defensor	Nacho	Monreal
406	29	FC Barcelona	España	Defensor	Jordi	Alba
407	29	FC Barcelona	España	Mediocampista	Sergio	Busquets
408	34	FC Barcelona	España	Mediocampista	Andres	Iniesta
409	23	Atletico Madrid	España	Mediocampista	Saul	Ñiguez
410	26	Atletico Madrid	España	Mediocampista	Koke	\N
411	27	Bayern Munich	España	Mediocampista	Thiago	Alcantara
412	26	Real Madrid	España	Mediocampista	Lucas	Vazquez
413	21	Real Madrid	España	Mediocampista	Marco	Asensio
414	32	Manchester City	España	Mediocampista	David	Silva
415	26	Real Madrid	España	Mediocampista	Isco	Alarcon
416	27	Valencia	España	Delantero	Rodrigo	\N
417	30	Celta de Vigo	España	Delantero	Iago	Aspas
418	29	Atletico Madrid	España	Delantero	Diego	Costa
419	27	Girona	Marruecos	Arquero	Yassine	Bounou
420	29	Numancia	Marruecos	Arquero	Munir	Mohamedi
421	22	Ittihad Tanger	Marruecos	Arquero	Ahmed	Reda Tagnaouti
422	19	Real Madrid	Marruecos	Defensor	Achraf	Hakimi
423	20	Lille	Marruecos	Defensor	Hamza	Mendyl
424	32	Estambul Basaksehir	Marruecos	Defensor	Manuel	da Costa
425	31	Juventus FC	Marruecos	Defensor	Mehdi	Benatia
426	28	Wolverhampton	Marruecos	Defensor	Romain	Saiss
427	32	Fenerbahce	Marruecos	Defensor	Nabil	Dirar
428	25	Ajax FC	Marruecos	Mediocampista	Hakim	Ziyech
429	33	Feyenoord	Marruecos	Mediocampista	Karim	El Ahmadi
430	28	Galatasaraay	Marruecos	Mediocampista	Younes	Belhanda
431	29	Getafe	Marruecos	Mediocampista	Faycal	Fajr
432	33	Al-Jazira	Marruecos	Mediocampista	Mbark	Boussofa
433	21	Caen	Marruecos	Mediocampista	Youssef	Ait Bennasser
434	31	Leganés	Marruecos	Mediocampista	Nordin	Amrabat
435	20	Schalke 04	Marruecos	Mediocampista	Amine	Harit
436	21	Feyenoord	Marruecos	Mediocampista	Sofyan	Amrabat
437	28	Standard Liege	Marruecos	Mediocampista	Mehdi	Carcela-Gonzalez
438	24	Renaissance de Berkane	Marruecos	Delantero	Ayoub	El Kaabi
439	31	Yeni Malatyaspor	Marruecos	Delantero	Kahlid	Boutaib
440	21	Málaga	Marruecos	Delantero	Youssef	En-Nesyri
441	31	St. Pauli	Marruecos	Delantero	Aziz	Bouhaddouz
442	25	Persepolis	Irán	Arquero	Alireza	Beiranvand
443	29	Zob Ahan	Irán	Arquero	Mohammad	Rashid Mazaheri
444	25	Maritimo	Irán	Arquero	Amir	Abedzadeh
445	28	Olympiacos	Irán	Defensor	Ehsan	Hajsafi
446	24	Esteghlal	Irán	Defensor	Rouzbeh	Cheshmi
447	25	Ajmat Grozni	Irán	Defensor	Milad	Mohammadi
448	27	Padideh	Irán	Defensor	Mohammed	Reza Khanzadeh
449	34	Esteghlal	Irán	Defensor	Pejman	Montazeri
450	21	Esteghlal	Irán	Defensor	Majid	Hosseini
451	28	Oostende	Irán	Defensor	Ramin	Rezaeian
452	23	Saipa	Irán	Mediocampista	Mehdi	Torabi
453	21	Ammkar Perm	Irán	Mediocampista	Saeid	Ezatolahi
454	34	AEK Atenas	Irán	Mediocampista	Masoud	Shojaei
455	30	Esteghlal	Irán	Mediocampista	Omid	Ebrahimi
456	30	Persepolis	Irán	Mediocampista	Vahid	Amiri
457	26	Al-Sadd	Irán	Delantero	Morteza	Pouraliganji
458	28	Olympiacos	Irán	Delantero	Karim	Ansarifard
459	24	Ostersund	Irán	Delantero	Saman	Ghoddos
460	30	Heerenveen	Irán	Delantero	Reza	Ghoochannejhad
461	25	Al-Gharafa	Irán	Delantero	Mehdi	Taremi
462	24	AZ Alkmaar	Irán	Delantero	Alireza	Jahanbakhsh
463	23	Rubin Kazan	Irán	Delantero	Sardar	Azmoun
464	31	Nottingham Forest	Irán	Delantero	Ashkan	Dejagah
465	31	Tottenham	Francia	Arquero	Hugo	Lloris
466	22	Stuttgart	Francia	Defensor	Benjamin	Pavard
467	22	Paris Saint Germain	Francia	Defensor	Presnel	Kimpembe
468	25	Real Madrid	Francia	Defensor	Raphael	Varane
469	24	FC Barcelona	Francia	Defensor	Samuel	Umtiti
470	25	Manchester United	Francia	Mediocampista	Paul	Pogba
471	27	Atletico Madrid	Francia	Delantero	Antoine	Griezmann
472	22	Monaco	Francia	Delantero	Thomas	Lemar
473	31	Chelsea FC	Francia	Delantero	Olivier	Giroud
474	19	Paris Saint Germain	Francia	Delantero	Kylian	Mbappe
475	21	FC Barcelona	Francia	Delantero	Ousmane	Dembelé
476	23	Bayern Munich	Francia	Mediocampista	Corentin	Tolisso
477	27	Chelsea FC	Francia	Mediocampista	NGolo	Kante
478	31	Juventus FC	Francia	Mediocampista	Blaise	Matuidi
479	29	Chelsea FC	Francia	Mediocampista	Steven	NZonzi
480	33	Olympique Marseille	Francia	Arquero	Steve	Mandanda
481	32	Olympique Marseille	Francia	Defensor	Adil	Rami
482	24	Olympique Lyon	Francia	Delantero	Nabil	Fekir
483	25	Monaco	Francia	Defensor	Djibril	Sidibe
484	25	Olympique Marseille	Francia	Delantero	Florian	Thauvin
485	22	Atletico Madrid	Francia	Defensor	Lucas	Hernandez
486	23	Manchester City	Francia	Defensor	Benjamin	Mendy
487	25	Paris Saint Germain	Francia	Arquero	Alphonse	Areola
488	32	CSKA Moscu	Rusia	Arquero	Igor	Akinfeev
489	27	CSKA Moscu	Rusia	Defensor	Mario	Fernandes
490	24	Spartak Moscu	Rusia	Defensor	Ilia	Kutepov
491	38	CSKA Moscu	Rusia	Defensor	Seguei	Ignasevich
492	29	Ajmat Grozni	Rusia	Defensor	Denis	Cheryshev
493	27	Villareal	Rusia	Mediocampista	Daler	Kuziaiev
494	25	Zenit de San Petersburgo	Rusia	Mediocampista	Yuri	Gazinski
495	28	Krasnodar	Rusia	Mediocampista	Alan	Dzagoev
496	27	CSKA Moscu	Rusia	Mediocampista	Fiodor	Smolov
497	28	Krasnodar	Rusia	Delantero	Roman	Zobnin
498	24	Spartak Moscu	Rusia	Arquero	Andrei	Luniov
499	26	Zenit de San Petersburgo	Rusia	Mediocampista	Fiodor	Kudriashov
500	31	Rubin Kazan	Rusia	Defensor	Vladimir	Granat
501	31	Rubin Kazan	Rusia	Defensor	Aleksei	Miranchuk
502	22	Lokomotiv Moscu	Rusia	Mediocampista	Anton	Miranchuk
503	22	Lokomotiv Moscu	Rusia	Mediocampista	Yuri	Zhirkov
504	22	CSKA Moscu	Rusia	Mediocampista	Aleksandr	Samedov
505	34	Zenit de San Petersburgo	Rusia	Mediocampista	Aleksandr	Golovin
506	34	Brugges	Rusia	Arquero	Vladimir	Gabulov
507	28	Zenit de San Petersburgo	Rusia	Mediocampista	Aleksandr	Yerojin
508	29	Arsenal Tula	Rusia	Delantero	Artiom	Dziuba
509	29	Zenit de San Petersburgo	Rusia	Defensor	Igor	Smolnikov
510	31	Galatasaraay	Uruguay	Arquero	Fernando	Muslera
511	29	Independiente	Uruguay	Arquero	Martin	Campaña
512	35	Vasco da Gama	Uruguay	Arquero	Martin	Silva
513	23	Atletico Madrid	Uruguay	Defensor	Jose	Gimenez
514	32	Atletico Madrid	Uruguay	Defensor	Diego	Godin
515	25	Peñarol	Uruguay	Defensor	Guillermo	Varela
516	24	Independiente	Uruguay	Defensor	Gaston	Silva
517	34	Porto	Uruguay	Defensor	Maxi	Pereira
518	27	Sporting Lisboa	Uruguay	Defensor	Sebastian	Coates
519	31	Lazio	Uruguay	Defensor	Martin	Caceres
520	33	Monterrey	Uruguay	Mediocampista	Carlos	Sanchez
521	20	Juventus FC	Uruguay	Mediocampista	Rodrigo	Bentancur
522	32	Peñarol	Uruguay	Mediocampista	Cristian	Rodriguez
523	22	Boca Juniors	Uruguay	Mediocampista	Nahitan	Nandez
524	22	Sampdoria	Uruguay	Mediocampista	Lucas	Torreira
525	26	Inter	Uruguay	Mediocampista	Matias	Vecino
526	25	Genoa	Uruguay	Mediocampista	Diego	Laxalt
527	31	FC Barcelona	Uruguay	Delantero	Luis	Suarez
528	24	Cruzeiro	Uruguay	Delantero	Giorgian	de Arrascaeta
529	31	Girona	Uruguay	Delantero	Christian	Stuani
530	21	Celta de Vigo	Uruguay	Delantero	Maxi	Gomez
531	28	Monterrey	Uruguay	Delantero	Jonathan	Urretaviscaya
532	31	Paris Saint Germain	Uruguay	Delantero	Edinson	Cavani
533	45	Al-Taawoun	Egipto	Arquero	Essam	El-Hadary
534	34	Al-Ahly	Egipto	Arquero	Sherif	Ekramy
535	29	Al-Ahly	Egipto	Arquero	Mohamed	El-Shenawy
536	29	West Bromwich	Egipto	Defensor	Ali	Gabr
537	30	Aston Villa	Egipto	Defensor	Ahmed	Al-Muhammadi
538	27	West Bromwich	Egipto	Defensor	Ahmed	Hegazy
539	33	Al-Ahly	Egipto	Defensor	Ahmed	Fathy
540	27	Al-Ahly	Egipto	Defensor	Ayman	Ashraf
541	32	Al-Fateh	Egipto	Defensor	Mohamed	Abdel-Shafy
542	23	Zamalek	Egipto	Defensor	Mahmoud	Hamdy
543	29	Al-Ahly	Egipto	Defensor	Saad	Samir
544	26	Los Angeles FC	Egipto	Mediocampista	Omar	Gaber
545	25	Wigan Athletic	Egipto	Mediocampista	Sam	Morsy
546	29	Zamalek	Egipto	Mediocampista	Tarek	Ahmed
547	25	Arsenal FC	Egipto	Mediocampista	Mohamed	Elneny
548	32	KuPS Kuopio	Egipto	Mediocampista	Abdallah	Said
549	23	Kasimpasa	Egipto	Mediocampista	Trezeguet	\N
550	29	Al-Ahly	Egipto	Delantero	Marwan	Mohsen
551	25	Liverpool FC	Egipto	Delantero	Mohamed	Salah
552	24	Al-Ittihad	Egipto	Delantero	Kahraba	\N
553	21	Stoke City	Egipto	Delantero	Ramadan	Sobhi
554	32	Al-Raed	Egipto	Delantero	Shikabala	\N
555	24	Atromitos	Egipto	Delantero	Amr	Warda
556	30	Retirado	Uruguay	Delantero	Pedro	Cea
557	29	Retirado	Italia	Delantero	Angelo	Schiavio
558	25	Retirado	Italia	Delantero	Silvio	Piola
559	29	Retirado	Uruguay	Mediocampista	Juan Alberto	Schiaffino
561	29	Retirado	Alemania	Delantero	Max	Morlock
562	24	Retirado	Brasil	Delantero	Vava	\N
563	25	Retirado	Inglaterra	Delantero	Geoff	Hurst
564	34	Retirado	Brasil	Delantero	Jairzinho	\N
565	29	Retirado	Alemania	Delantero	Gerd	Muller
566	24	Retirado	Argentina	Delantero	Mario	Kempes
567	26	Retirado	Italia	Delantero	Paolo	Rossi
568	30	Retirado	Alemania	Mediocampista	Andreas	Brehme
569	26	Retirado	Brasil	Delantero	Romario	\N
570	26	Retirado	Francia	Mediocampista	Zinedine	Zidane
571	28	Retirado	Brasil	Delantero	Ronaldo	\N
572	29	Retirado	Italia	Defensor	Marco	Materazzi
573	30	RB Leipzig	Dinamarca	Delantero	Yussuf	Poulsen
574	28	Helsingborgs	Suecia	Defensor	Andreas	Granqvist
575	32	Retirado	Argentina	Mediocampista	Diego	Maradona
576	39	Atlas	México	Defensor	Rafael	Márquez
560	22	Retirado	Brasil	Delantero	Pele	\N
\.


--
-- TOC entry 2855 (class 0 OID 16445)
-- Dependencies: 201
-- Data for Name: jugo_mundial; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.jugo_mundial (jugador, anho_mundial, goles_a_favor, goles_en_contra) FROM stdin;
556	1930	4	2
557	1934	2	1
558	1938	4	2
559	1950	2	1
561	1954	3	2
560	1958	5	2
562	1962	3	1
563	1966	4	2
564	1970	4	1
565	1974	2	1
566	1978	3	1
567	1982	3	1
575	1986	3	2
568	1990	1	0
569	1994	0	0
570	1998	3	0
571	2002	2	0
572	2006	1	1
408	2010	1	0
355	2014	1	0
356	2014	7	1
492	2018	5	0
513	2018	1	0
435	2018	1	0
390	2018	3	3
470	2018	2	1
573	2018	1	0
37	2018	2	0
192	2018	1	0
280	2018	1	1
115	2018	1	0
574	2018	1	0
134	2018	3	0
356	2018	2	1
356	2006	2	0
356	2010	3	2
576	2006	1	0
576	2010	2	1
576	2014	0	0
323	2006	1	0
323	2010	2	0
323	2014	3	0
284	2014	3	1
367	2006	4	0
367	2010	3	0
367	2014	4	1
47	2018	0	0
312	2006	0	0
312	2010	1	0
312	2014	1	0
312	2018	1	0
\.


--
-- TOC entry 2859 (class 0 OID 16518)
-- Dependencies: 205
-- Data for Name: jugo_partido; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.jugo_partido (id_partido, jugador, goles, calificacion) FROM stdin;
348	492	2	8
349	513	1	7
350	435	1	5
351	390	3	9
352	470	1	7
353	573	1	8
354	47	0	8
355	37	1	7
356	192	1	6
357	280	1	8
358	115	1	6
359	574	1	7
360	134	2	8
347	356	2	9
365	134	2	8
366	492	1	7
354	323	0	4
346	323	0	4
361	576	0	5
362	576	0	6
363	576	0	7
364	576	0	6
346	355	1	7
345	408	1	8
344	570	1	4
343	571	2	8
342	571	0	6
342	570	2	10
341	569	1	6
340	575	0	6
339	575	0	6
338	567	2	5
337	566	2	6
336	565	2	8
335	564	0	5
334	563	2	6
333	562	1	6
332	560	3	10
331	561	1	6
330	559	1	6
329	558	0	4
328	557	1	6
327	556	2	6
\.


--
-- TOC entry 2854 (class 0 OID 16422)
-- Dependencies: 200
-- Data for Name: mundial; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.mundial (anho, sede, ganador, subcampeon, promedio_entradas_vendidas, cantidad_incidetes, cantidad_participantes, goles_totales, partidos_jugados) FROM stdin;
1930	Uruguay	Uruguay	Argentina	590549	0	13	70	18
1934	Italia	Italia	Checoslovaquia	358000	2	16	70	17
1938	Francia	Italia	Hungría	375700	1	15	84	18
1950	Brasil	Uruguay	Brasil	1045246	1	13	88	22
1954	Suiza	Alemania	Hungría	768607	0	16	140	26
1958	Suecia	Brasil	Suecia	819810	0	16	126	35
1962	Chile	Brasil	Checoslovaquia	893172	3	16	89	32
1966	Inglaterra	Inglaterra	Alemania	1563135	1	16	89	32
1970	México	Brasil	Italia	1604065	0	16	95	32
1974	Alemania	Alemania	Holanda	1865762	5	16	97	38
1978	Argentina	Argentina	Holanda	1545791	3	16	102	38
1982	España	Italia	Alemania	2109723	0	24	146	52
1986	México	Argentina	Alemania	2394031	0	24	132	52
1990	Italia	Alemania	Argentina	2516215	1	24	115	52
1994	Estados Unidos	Brasil	Italia	3587538	0	24	141	52
1998	Francia	Francia	Brasil	2784687	0	32	171	64
2002	Japón	Brasil	Alemania	2705197	2	32	161	64
2006	Alemania	Italia	Francia	3359439	0	32	147	64
2010	Sudáfrica	España	Holanda	3178856	3	32	145	64
2014	Brasil	Alemania	Argentina	3429873	0	32	171	64
2018	Rusia	\N	\N	\N	\N	32	\N	64
2022	Catar	\N	\N	\N	\N	32	\N	64
\.


--
-- TOC entry 2851 (class 0 OID 16393)
-- Dependencies: 197
-- Data for Name: pais; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.pais (nombre_pais, cantidad_habitantes, barras_registrados, clasico) FROM stdin;
India	1331793000	0	\N
Indonesia	260238000	0	\N
Pakistán	201576000	0	\N
Nigeria	191182000	0	\N
Bangladés	162039000	0	\N
Filipinas	103456000	0	\N
Etiopía	93296000	0	\N
Vietnam	93201000	0	\N
Egipto	92216000	0	\N
Irán	80310000	0	\N
Turquía	79806000	0	\N
República Democrática del Congo	74185000	0	\N
Tailandia	67526000	0	\N
Reino Unido	65893000	0	\N
Sudáfrica	56084000	0	\N
Birmania	53247000	0	\N
Tanzania	50869000	0	\N
Kenia	45958000	0	\N
Ucrania	42594000	35000	\N
Argelia	41323000	0	\N
Sudán	40197000	0	\N
Irak	38370000	0	\N
Uganda	37151000	0	\N
Canadá	36477000	0	\N
Marruecos	34310000	0	\N
Uzbekistán	32707000	0	\N
Arabia Saudita	32620000	0	\N
Malasia	31723000	0	\N
Ghana	28635000	0	\N
Nepal	28633000	0	\N
Angola	28276000	0	\N
Yemen	27943000	0	\N
Afganistán	27611000	0	\N
Mozambique	26780000	0	\N
Costa de Marfil	24230000	0	\N
Siria	24136000	0	\N
Madagascar	23990000	0	\N
Camerún	23372000	0	\N
Sri Lanka	21337000	0	\N
Níger	19989000	0	\N
Rumanía	19659000	0	\N
Burkina Faso	19344000	0	\N
Malí	18955000	0	\N
Kazajistán	17926000	0	\N
Malaui	17098000	0	\N
Guatemala	16896000	0	\N
Zambia	16170000	0	\N
Camboya	15402000	0	\N
Senegal	15029000	0	\N
Chad	14415000	0	\N
Zimbabue	13741000	0	\N
Sudán del Sur	13657000	0	\N
Somalia	13095000	0	\N
Ruanda	11772000	0	\N
Grecia	11548000	0	\N
Benín	11362000	0	\N
Túnez	11334000	0	\N
Haití	11284000	0	\N
Cuba	11240000	0	\N
Guinea	11187000	0	\N
República Checa	10573000	0	\N
Burundi	10261000	0	\N
Jordania	10131000	0	\N
República Dominicana	1012300	0	\N
Azerbaiyán	9829000	0	\N
Bielorrusia	9508000	0	\N
Emiratos Árabes Unidos	9082000	0	\N
Austria	8787000	0	\N
Tayikistán	8747000	0	\N
Israel	8630000	0	\N
Suiza	8402000	0	\N
Papúa Nueva Guinea	8246000	0	\N
Eritrea	7472000	0	\N
Togo	7374000	0	\N
Sierra Leona	7323000	0	\N
Bulgaria	7110000	0	\N
Serbia	7056000	0	\N
Paraguay	6905000	0	\N
Laos	6666000	0	\N
El Salvador	6551000	0	\N
Libia	6365000	0	\N
Nicaragu	6361000	0	\N
Kirguistn	6123000	0	\N
Dinamarc	5753000	0	\N
Líbano	708000	0	\N
Singapur	5644000	0	\N
Finlandi	5505000	0	\N
Eslovaquia	5433000	0	\N
Noruega	5265000	0	\N
República Centroafricana	5048000	0	\N
Turkmenistán	4996000	0	\N
República del Congo	4920000	0	\N
Nueva Zelanda	4731000	0	\N
Omán	4575000	0	\N
Kuwait	4406000	0	\N
Liberia	4176000	0	\N
Panamá	3842000	0	\N
Mauritania	3763000	0	\N
Georgia	3713000	0	\N
Moldavia	3569000	0	\N
Bosnia y Herzegovina	3424000	0	\N
Mongolia	3131000	0	\N
Armenia	2993000	0	\N
Albania	2874000	0	\N
Lituania	2851000	0	\N
Jamaica	2735000	0	\N
Catar	2651000	0	\N
Namibia	2350000	0	\N
Botsuana	2247000	0	\N
Gambia	2124000	0	\N
Macedonia	2073000	0	\N
Eslovenia	2066000	0	\N
Baréin	1981000	0	\N
Letonia	1953000	0	\N
Gabón	1920000	0	\N
Lesoto	1913000	0	\N
Guinea-Bisáu	1575000	0	\N
Trinidad y Tobago	1357000	0	\N
Estonia	1316000	0	\N
Mauricio	1266000	0	\N
Guinea Ecuatorial	1247000	0	\N
Timor Oriental	1221000	0	\N
Suazilandia	1139000	0	\N
Yibuti	1006000	0	\N
Fiyi	883000	0	\N
Chipre	850000	0	\N
Comoras	817000	0	\N
Bután	781000	0	\N
Guyana	746000	0	\N
Islas Salomón	663000	0	\N
Montenegro	622000	0	\N
Luxemburgo	590000	0	\N
Surinam	570000	0	\N
Cabo Verde	536000	0	\N
Malta	437000	0	\N
Brunéi	425000	0	\N
Belice	382000	0	\N
Bahamas	375000	0	\N
Maldivas	354000	0	\N
Islandia	336000	0	\N
Vanuatu	294000	0	\N
Barbados	284000	0	\N
Santo Tomé y Príncipe	201000	0	\N
Samoa	196000	0	\N
Santa Lucía	173000	0	\N
Kiribati	117000	0	\N
San Vicente y las Granadinas	110000	0	\N
Micronesia	105000	0	\N
Granada	104000	0	\N
Tonga	100000	0	\N
Seychelles	97000	0	\N
Antigua y Barbuda	91000	0	\N
Andorra	79000	0	\N
Dominica	71000	0	\N
Islas Marshall	55000	0	\N
San Cristóbal y Nieves	46000	0	\N
Mónaco	39000	0	\N
Liechtenstein	38000	0	\N
San Marino	33000	0	\N
Palaos	18000	0	\N
Nauru	11000	0	\N
Tuvalu	10000	0	\N
Ciudad del Vaticano	800	0	\N
Checoslovaquia	5433000	0	\N
Honduras	8795000	0	El Salvador
Costa Rica	4949000	0	Honduras
Estados Unidos	325318000	20500	México
México	122916000	0	Estados Unidos
Brasil	207012000	600000	Argentina
Argentina	43823000	900000	Brasil
Bolivia	11066000	0	Chile
Chile	18286000	0	Argentina
Uruguay	3487000	0	Argentina
Venezuela	31236000	0	Colombia
Colombia	49067000	0	Venezuela
Perú	31660000	0	Chile
Ecuador	16656000	0	Perú
Corea del Norte	24284000	0	Corea del Sur
Corea del Sur	51670000	0	Corea del Norte
Japón	126905000	0	Corea del Sur
China	1380996000	300	Corea del Sur
Inglaterra	146823000	650000	Irlanda
Irlanda	4809000	0	Inglaterra
Alemania	82605000	450000	Inglaterra
Rusia	146823000	650000	Polonia
Polonia	38370000	0	Rusia
Croacia	4175000	0	Serbia
Portugal	10265000	0	España
España	46491000	0	Portugal
Italia	60674000	0	Francia
Francia	64765000	0	Italia
Bélgica	11359000	0	Holanda
Holanda	17095000	0	Bélgica
Suecia	9977000	0	Noruega
Hungría	9805000	0	Austria
Australia	24260000	0	Nueva Zelanda
Dinamarca	5627235	0	\N
\.


--
-- TOC entry 2857 (class 0 OID 16462)
-- Dependencies: 203
-- Data for Name: partido; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.partido (id, anho_mundial, equipo_local, equipo_visitante, goles_local, goles_visitante, fase, figura_partido) FROM stdin;
327	1930	Uruguay	Argentina	4	2	Final	556
328	1934	Italia	Checoslovaquia	2	1	Final	557
329	1938	Italia	Hungría	4	2	Final	558
330	1950	Uruguay	Brasil	2	1	Final	559
331	1954	Alemania	Hungría	3	2	Final	561
332	1958	Brasil	Suecia	5	2	Final	560
333	1962	Brasil	Checoslovaquia	3	1	Final	562
334	1966	Inglaterra	Alemania	4	2	Final	563
335	1970	Brasil	Italia	4	1	Final	564
336	1974	Holanda	Alemania	1	2	Final	565
337	1978	Argentina	Holanda	3	1	Final	566
338	1982	Italia	Alemania	3	1	Final	567
339	1986	Argentina	Alemania	3	2	Final	575
340	1990	Alemania	Argentina	1	0	Final	568
341	1994	Brasil	Italia	0	0	Final	569
342	1998	Brasil	Francia	0	3	Final	570
343	2002	Alemania	Brasil	0	2	Final	571
344	2006	Italia	Francia	1	1	Final	572
345	2010	España	Holanda	1	0	Final	408
346	2014	Alemania	Argentina	1	0	Final	355
347	2014	Brasil	Alemania	1	7	Semifinal	356
348	2018	Rusia	Arabia Saudita	5	0	Grupo A	492
349	2018	Egipto	Uruguay	0	1	Grupo A	513
350	2018	Marruecos	Irán	0	1	Grupo B	435
351	2018	Portugal	España	3	3	Grupo B	390
352	2018	Francia	Australia	2	1	Grupo C	470
353	2018	Perú	Dinamarca	0	1	Grupo C	573
354	2018	Argentina	Islandia	1	1	Grupo D	47
355	2018	Croacia	Nigeria	2	0	Grupo D	37
356	2018	Costa Rica	Serbia	0	1	Grupo E	192
357	2018	Brasil	Suiza	1	1	Grupo E	280
358	2018	Alemania	México	0	1	Grupo F	115
359	2018	Suecia	Corea del Sur	1	0	Grupo F	574
360	2018	Bélgica	Panamá	3	0	Grupo G	134
361	2014	Brasil	México	0	0	Grupo A	576
362	2010	México	Argentina	1	3	Octavos de Final	576
363	2006	México	Argentina	1	2	Octavos de Final	576
364	2002	México	Estados Unidos	0	2	Octavos de Final	576
365	2018	Bélgica	Túnez	5	2	Grupo G	134
366	2018	Rusia	Egipto	3	1	Grupo A	492
\.


--
-- TOC entry 2873 (class 0 OID 0)
-- Dependencies: 198
-- Name: jugador_id_jugador_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.jugador_id_jugador_seq', 555, true);


--
-- TOC entry 2874 (class 0 OID 0)
-- Dependencies: 204
-- Name: jugo_partido_id_partido_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.jugo_partido_id_partido_seq', 1, false);


--
-- TOC entry 2875 (class 0 OID 0)
-- Dependencies: 202
-- Name: partido_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.partido_id_seq', 360, true);


--
-- TOC entry 2703 (class 2606 OID 16400)
-- Name: pais Pais_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pais
    ADD CONSTRAINT "Pais_pkey" PRIMARY KEY (nombre_pais);


--
-- TOC entry 2714 (class 2606 OID 16470)
-- Name: partido Partido_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.partido
    ADD CONSTRAINT "Partido_pkey" PRIMARY KEY (id);


--
-- TOC entry 2706 (class 2606 OID 16416)
-- Name: jugador Unique_Jugador; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.jugador
    ADD CONSTRAINT "Unique_Jugador" UNIQUE (id_jugador);


--
-- TOC entry 2712 (class 2606 OID 16449)
-- Name: jugo_mundial jugo_mundial_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.jugo_mundial
    ADD CONSTRAINT jugo_mundial_pkey PRIMARY KEY (jugador, anho_mundial);


--
-- TOC entry 2716 (class 2606 OID 16523)
-- Name: jugo_partido jugo_partido_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.jugo_partido
    ADD CONSTRAINT jugo_partido_pkey PRIMARY KEY (id_partido, jugador);


--
-- TOC entry 2710 (class 2606 OID 16429)
-- Name: mundial mundial_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mundial
    ADD CONSTRAINT mundial_pkey PRIMARY KEY (anho);


--
-- TOC entry 2707 (class 1259 OID 16492)
-- Name: fki_FK_Club_Jugador; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX "fki_FK_Club_Jugador" ON public.jugador USING btree (club_jugador);


--
-- TOC entry 2708 (class 1259 OID 16493)
-- Name: fki_FK_Pais_Jugador; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX "fki_FK_Pais_Jugador" ON public.jugador USING btree (pais_jugador);


--
-- TOC entry 2704 (class 1259 OID 16491)
-- Name: fki_FK_Pais_Rival; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX "fki_FK_Pais_Rival" ON public.pais USING btree (clasico);


--
-- TOC entry 2724 (class 2606 OID 16471)
-- Name: partido FK_Anho_Mundial; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.partido
    ADD CONSTRAINT "FK_Anho_Mundial" FOREIGN KEY (anho_mundial) REFERENCES public.mundial(anho);


--
-- TOC entry 2720 (class 2606 OID 16435)
-- Name: mundial FK_Campeon_Pais; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mundial
    ADD CONSTRAINT "FK_Campeon_Pais" FOREIGN KEY (ganador) REFERENCES public.pais(nombre_pais);


--
-- TOC entry 2725 (class 2606 OID 16476)
-- Name: partido FK_Figura_Jugador; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.partido
    ADD CONSTRAINT "FK_Figura_Jugador" FOREIGN KEY (figura_partido) REFERENCES public.jugador(id_jugador);


--
-- TOC entry 2722 (class 2606 OID 16450)
-- Name: jugo_mundial FK_Jugo_Jugador; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.jugo_mundial
    ADD CONSTRAINT "FK_Jugo_Jugador" FOREIGN KEY (jugador) REFERENCES public.jugador(id_jugador);


--
-- TOC entry 2728 (class 2606 OID 16524)
-- Name: jugo_partido FK_Jugo_Jugador; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.jugo_partido
    ADD CONSTRAINT "FK_Jugo_Jugador" FOREIGN KEY (jugador) REFERENCES public.jugador(id_jugador);


--
-- TOC entry 2723 (class 2606 OID 16455)
-- Name: jugo_mundial FK_Jugo_Mundial; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.jugo_mundial
    ADD CONSTRAINT "FK_Jugo_Mundial" FOREIGN KEY (anho_mundial) REFERENCES public.mundial(anho);


--
-- TOC entry 2729 (class 2606 OID 16529)
-- Name: jugo_partido FK_Jugo_Mundial; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.jugo_partido
    ADD CONSTRAINT "FK_Jugo_Mundial" FOREIGN KEY (id_partido) REFERENCES public.partido(id);


--
-- TOC entry 2726 (class 2606 OID 16481)
-- Name: partido FK_Local_Pais; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.partido
    ADD CONSTRAINT "FK_Local_Pais" FOREIGN KEY (equipo_local) REFERENCES public.pais(nombre_pais);


--
-- TOC entry 2718 (class 2606 OID 16417)
-- Name: jugador FK_Pais_Jugador; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.jugador
    ADD CONSTRAINT "FK_Pais_Jugador" FOREIGN KEY (pais_jugador) REFERENCES public.pais(nombre_pais);


--
-- TOC entry 2719 (class 2606 OID 16430)
-- Name: mundial FK_Sede_Pais; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mundial
    ADD CONSTRAINT "FK_Sede_Pais" FOREIGN KEY (sede) REFERENCES public.pais(nombre_pais);


--
-- TOC entry 2721 (class 2606 OID 16440)
-- Name: mundial FK_Subcampeon_Pais; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mundial
    ADD CONSTRAINT "FK_Subcampeon_Pais" FOREIGN KEY (subcampeon) REFERENCES public.pais(nombre_pais);


--
-- TOC entry 2727 (class 2606 OID 16486)
-- Name: partido FK_Visitante_Pais; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.partido
    ADD CONSTRAINT "FK_Visitante_Pais" FOREIGN KEY (equipo_visitante) REFERENCES public.pais(nombre_pais);


--
-- TOC entry 2717 (class 2606 OID 16401)
-- Name: pais FK_pais_rival; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pais
    ADD CONSTRAINT "FK_pais_rival" FOREIGN KEY (clasico) REFERENCES public.pais(nombre_pais);


-- Completed on 2018-07-09 19:10:35

--
-- PostgreSQL database dump complete
--

