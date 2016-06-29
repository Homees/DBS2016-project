--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.1
-- Dumped by pg_dump version 9.5.1

-- Started on 2016-04-13 15:09:46

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2150 (class 1262 OID 12373)
-- Dependencies: 2149
-- Name: postgres; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON DATABASE postgres IS 'default administrative connection database';


--
-- TOC entry 2 (class 3079 OID 12355)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2153 (class 0 OID 0)
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
-- TOC entry 2154 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION adminpack; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION adminpack IS 'administrative functions for PostgreSQL';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 189 (class 1259 OID 16508)
-- Name: kontrola_zvierata; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE kontrola_zvierata (
    id integer NOT NULL,
    id_lekara integer,
    id_zvierata integer,
    lieky character varying(50),
    liecba character varying(50),
    datum date
);


ALTER TABLE kontrola_zvierata OWNER TO postgres;

--
-- TOC entry 191 (class 1259 OID 16517)
-- Name: kontrola_zvierata_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE kontrola_zvierata_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE kontrola_zvierata_id_seq OWNER TO postgres;

--
-- TOC entry 2155 (class 0 OID 0)
-- Dependencies: 191
-- Name: kontrola_zvierata_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE kontrola_zvierata_id_seq OWNED BY kontrola_zvierata.id;


--
-- TOC entry 186 (class 1259 OID 16493)
-- Name: krmivo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE krmivo (
    id integer NOT NULL,
    nazov character varying(20),
    hmotnost integer,
    typ character varying(50),
    id_objednavky integer
);


ALTER TABLE krmivo OWNER TO postgres;

--
-- TOC entry 190 (class 1259 OID 16511)
-- Name: krmivo_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE krmivo_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE krmivo_id_seq OWNER TO postgres;

--
-- TOC entry 2156 (class 0 OID 0)
-- Dependencies: 190
-- Name: krmivo_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE krmivo_id_seq OWNED BY krmivo.id;


--
-- TOC entry 185 (class 1259 OID 16490)
-- Name: objednavka; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE objednavka (
    id integer NOT NULL,
    datum date,
    objednal integer,
    id_osoby integer,
    id_krmiva integer,
    id_zvierata integer
);


ALTER TABLE objednavka OWNER TO postgres;

--
-- TOC entry 188 (class 1259 OID 16502)
-- Name: objednavka_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE objednavka_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE objednavka_id_seq OWNER TO postgres;

--
-- TOC entry 2157 (class 0 OID 0)
-- Dependencies: 188
-- Name: objednavka_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE objednavka_id_seq OWNED BY objednavka.id;


--
-- TOC entry 184 (class 1259 OID 16487)
-- Name: osoba; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE osoba (
    id integer NOT NULL,
    meno character varying(20),
    priezvisko character varying(20),
    adresa character varying(50),
    vek integer,
    pozicia character varying(20),
    plat integer,
    typ_osoby integer,
    kontakt character varying(30),
    id_objednavky integer,
    id_kontroly integer
);


ALTER TABLE osoba OWNER TO postgres;

--
-- TOC entry 187 (class 1259 OID 16496)
-- Name: osoba_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE osoba_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE osoba_id_seq OWNER TO postgres;

--
-- TOC entry 2158 (class 0 OID 0)
-- Dependencies: 187
-- Name: osoba_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE osoba_id_seq OWNED BY osoba.id;


--
-- TOC entry 182 (class 1259 OID 16478)
-- Name: zviera; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE zviera (
    id integer NOT NULL,
    rasa character varying(20),
    plemeno character varying(20),
    vek integer,
    stav character varying(20),
    meno character varying(20),
    id_objednavky integer,
    id_kontroly integer,
    cena integer,
    rodinne boolean
);


ALTER TABLE zviera OWNER TO postgres;

--
-- TOC entry 183 (class 1259 OID 16481)
-- Name: zviera_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE zviera_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE zviera_id_seq OWNER TO postgres;

--
-- TOC entry 2159 (class 0 OID 0)
-- Dependencies: 183
-- Name: zviera_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE zviera_id_seq OWNED BY zviera.id;


--
-- TOC entry 2010 (class 2604 OID 16519)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY kontrola_zvierata ALTER COLUMN id SET DEFAULT nextval('kontrola_zvierata_id_seq'::regclass);


--
-- TOC entry 2009 (class 2604 OID 16513)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY krmivo ALTER COLUMN id SET DEFAULT nextval('krmivo_id_seq'::regclass);


--
-- TOC entry 2008 (class 2604 OID 16504)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY objednavka ALTER COLUMN id SET DEFAULT nextval('objednavka_id_seq'::regclass);


--
-- TOC entry 2007 (class 2604 OID 16498)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY osoba ALTER COLUMN id SET DEFAULT nextval('osoba_id_seq'::regclass);


--
-- TOC entry 2006 (class 2604 OID 16483)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY zviera ALTER COLUMN id SET DEFAULT nextval('zviera_id_seq'::regclass);


--
-- TOC entry 2142 (class 0 OID 16508)
-- Dependencies: 189
-- Data for Name: kontrola_zvierata; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY kontrola_zvierata (id, id_lekara, id_zvierata, lieky, liecba, datum) FROM stdin;
4	2	4	ziadne	ockovanie a kontrola	\N
5	2	5	lieky na chripku	domaca liecba	\N
6	2	5	lieky na chripku	domaca liecba	\N
9	2	5	lieky na chripku	domaca liecba	\N
10	3	2	antibiorika a ockovanie	vylezat v posteli	\N
7	2	5	nove lieky	domaca liecba	\N
2	2	2	antibiotika	nehat v klietke oddychovat a kontrolovat	2016-02-12
3	2	3	ziadne	ockovanie	2016-03-13
1	2	1	antibiotika	nehat v klietke oddychovat a kontrolovat	2016-01-01
11	10	1	lieky od bolesti	nehat oddychnut	\N
12	11	2	lieky od bolesti	operacia	\N
14	11	4	lieky od bolesti	operacia	\N
15	12	4	lieky na bolest	zasitie rany	2015-11-25
16	12	5	lieky na bolest	zasitie rany	2015-11-30
17	12	6	lieky na bolest	ockovanie	2015-12-03
\.


--
-- TOC entry 2160 (class 0 OID 0)
-- Dependencies: 191
-- Name: kontrola_zvierata_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('kontrola_zvierata_id_seq', 17, true);


--
-- TOC entry 2139 (class 0 OID 16493)
-- Dependencies: 186
-- Data for Name: krmivo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY krmivo (id, nazov, hmotnost, typ, id_objednavky) FROM stdin;
4	krokonay	50	krmivo pre krokodilov	3
1	friskies	20	krmivo pre psov	4
5	whiskas	35	krmivo pre macky	1
6	doggy good	43	krmivo pre psov	8
7	pedigri	25	krmivo pre psov	1
8	pedigri	25	krmivo pre psov	2
9	pedigri	25	krmivo pre macky	3
10	pedigri	60	krmivo pre macky	4
\.


--
-- TOC entry 2161 (class 0 OID 0)
-- Dependencies: 190
-- Name: krmivo_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('krmivo_id_seq', 10, true);


--
-- TOC entry 2138 (class 0 OID 16490)
-- Dependencies: 185
-- Data for Name: objednavka; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY objednavka (id, datum, objednal, id_osoby, id_krmiva, id_zvierata) FROM stdin;
4	2016-02-25	1	2	4	\N
6	2016-04-01	2	4	\N	5
1	2016-04-09	1	1	2	\N
7	2015-03-05	1	1	1	0
8	2016-02-01	3	7	0	9
9	2016-01-02	2	8	5	0
10	2016-01-02	2	8	5	0
11	2016-02-01	3	7	0	9
3	2016-10-13	3	5	\N	1
5	2016-02-25	3	5	\N	1
12	2015-03-02	1	6	6	0
13	2015-03-12	1	1	1	0
14	2015-03-22	1	1	2	2
15	2015-03-22	1	1	3	3
16	2015-03-22	1	12	3	3
17	2015-03-22	1	11	3	3
18	2016-01-31	1	12	4	4
\.


--
-- TOC entry 2162 (class 0 OID 0)
-- Dependencies: 188
-- Name: objednavka_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('objednavka_id_seq', 18, true);


--
-- TOC entry 2137 (class 0 OID 16487)
-- Dependencies: 184
-- Data for Name: osoba; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY osoba (id, meno, priezvisko, adresa, vek, pozicia, plat, typ_osoby, kontakt, id_objednavky, id_kontroly) FROM stdin;
3	marian	sikovny	stefanikova 93	26	\N	\N	2	0915 135 367	\N	\N
4	peter	suchy	krizna cesta 1247	31	\N	\N	2	0915 222 333	\N	\N
1	filip	galis	topolcany	22	manazer	30000	1	01244	3	1
2	jozef	galis	topolcany	22	manazer	30000	1	01244	4	2
6	ondrej	skaredy	molecova 354	32	pracovnik	800	1	08154267	5	3
8	dusan	sikovny	stare grunty 53	39	zverolekar	1200	2	0915 359 741	0	10
5	ondrej	suchy	krizna cesta 1247	31	\N	\N	3	0915 222 333	5	3
7	martin	pekny	borusova 357	29	\N	\N	3	0915 351 247	8	\N
9	matus	strapaty	bosanova 354	35	pracovnik	850	1	0917 324 123	9	0
10	denis	illes	roznavska 35	42	zverolekar	1500	2	0918 246 321	0	1
11	denis	illes	roznavska 35	42	zverolekar	1500	2	0918 246 321	0	2
12	denis	pozeravy	krusovska 123	42	zverolekar	1500	2	0918 246 321	0	3
\.


--
-- TOC entry 2163 (class 0 OID 0)
-- Dependencies: 187
-- Name: osoba_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('osoba_id_seq', 13, true);


--
-- TOC entry 2135 (class 0 OID 16478)
-- Dependencies: 182
-- Data for Name: zviera; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY zviera (id, rasa, plemeno, vek, stav, meno, id_objednavky, id_kontroly, cena, rodinne) FROM stdin;
3	pes	nemecky ovciar	2	super	tery	\N	\N	\N	\N
6	macka	egyptska	1	ok	winy	\N	\N	\N	\N
7	macka	perska	1	super	cica	\N	\N	\N	\N
8	bla	bla	3	bla	bla	\N	\N	\N	\N
9	nieco	nieco	5	nieco	nieco	\N	\N	\N	\N
2	pes	nemecky ovciar	2	super	tery	\N	2	\N	\N
4	pes	nemecky ovciar	2	super	tery	\N	3	\N	\N
10	pes	labrador	2	dobry	boby	8	0	55	t
11	pes	labrador	2	dobry	rudolf	11	0	65	t
1	pes	kokerspaniel	3	zly	rony	5	1	\N	\N
12	medved	hnedy tatransky	3	dobry	bersi	0	1	250	t
13	medved	grizzly	4	ok	bersi	2	2	5000	f
14	pes	vlciak	2	ok	bersi	3	3	50	t
15	pes	vlciak	2	ok	tobino	4	4	500	t
16	pes	vlciak	2	dobry	lesly	4	4	500	t
\.


--
-- TOC entry 2164 (class 0 OID 0)
-- Dependencies: 183
-- Name: zviera_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('zviera_id_seq', 16, true);


--
-- TOC entry 2020 (class 2606 OID 24686)
-- Name: kontrola_zvierata_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY kontrola_zvierata
    ADD CONSTRAINT kontrola_zvierata_pkey PRIMARY KEY (id);


--
-- TOC entry 2018 (class 2606 OID 24684)
-- Name: krmivo_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY krmivo
    ADD CONSTRAINT krmivo_pkey PRIMARY KEY (id);


--
-- TOC entry 2016 (class 2606 OID 24688)
-- Name: objednavka_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY objednavka
    ADD CONSTRAINT objednavka_pkey PRIMARY KEY (id);


--
-- TOC entry 2014 (class 2606 OID 24680)
-- Name: osoba_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY osoba
    ADD CONSTRAINT osoba_pkey PRIMARY KEY (id);


--
-- TOC entry 2012 (class 2606 OID 24682)
-- Name: zviera_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY zviera
    ADD CONSTRAINT zviera_pkey PRIMARY KEY (id);


--
-- TOC entry 2152 (class 0 OID 0)
-- Dependencies: 7
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2016-04-13 15:09:47

--
-- PostgreSQL database dump complete
--

