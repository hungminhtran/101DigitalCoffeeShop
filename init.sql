GRANT ALL PRIVILEGES ON DATABASE coffee_shop TO postgres;
SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: customer_entity; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.customer_entity (
    customer_id bigint NOT NULL,
    address character varying(255),
    full_name character varying(255),
    phone_number character varying(255)
);


ALTER TABLE public.customer_entity OWNER TO postgres;

--
-- Name: menu_item_entity; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.menu_item_entity (
    menu_item_id bigint NOT NULL,
    name character varying(255),
    price bigint,
    status integer
);


ALTER TABLE public.menu_item_entity OWNER TO postgres;

--
-- Name: order_entity; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.order_entity (
    order_id bigint NOT NULL,
    created_at timestamp without time zone,
    order_status integer,
    payment_id bigint,
    shop_id bigint,
    user_id bigint
);


ALTER TABLE public.order_entity OWNER TO postgres;

--
-- Name: order_menu_item_entity; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.order_menu_item_entity (
    relationship_id bigint NOT NULL,
    menu_item_id bigint,
    order_id bigint
);


ALTER TABLE public.order_menu_item_entity OWNER TO postgres;

--
-- Name: order_promotion_entity; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.order_promotion_entity (
    relationship_id bigint NOT NULL,
    order_id bigint,
    promotion_id bigint
);


ALTER TABLE public.order_promotion_entity OWNER TO postgres;

--
-- Name: payment_entity; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.payment_entity (
    payment_id bigint NOT NULL,
    merchandise_sub_total bigint,
    paid_at timestamp without time zone,
    payment_status integer,
    promotion_subtotal bigint
);


ALTER TABLE public.payment_entity OWNER TO postgres;

--
-- Name: promotion_entity; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.promotion_entity (
    promotion_id bigint NOT NULL,
    customer_id bigint,
    promotion_value real,
    shop_id bigint
);


ALTER TABLE public.promotion_entity OWNER TO postgres;

--
-- Name: queue_entity; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.queue_entity (
    queue_id bigint NOT NULL,
    queue_size bigint
);


ALTER TABLE public.queue_entity OWNER TO postgres;

--
-- Name: queue_item_entity; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.queue_item_entity (
    relationship_id bigint NOT NULL,
    order_id bigint,
    queue_item_id bigint
);


ALTER TABLE public.queue_item_entity OWNER TO postgres;

--
-- Name: queue_queue_item_entity; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.queue_queue_item_entity (
    relationship_id bigint NOT NULL,
    queue_id bigint,
    queue_item_id bigint
);


ALTER TABLE public.queue_queue_item_entity OWNER TO postgres;

--
-- Name: shop_employee_entity; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.shop_employee_entity (
    employee_id bigint NOT NULL,
    full_name character varying(255),
    manager_id bigint,
    phone_number character varying(255)
);


ALTER TABLE public.shop_employee_entity OWNER TO postgres;

--
-- Name: shop_entity; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.shop_entity (
    shop_id bigint NOT NULL,
    address character varying(255),
    close_time character varying(255),
    email character varying(255),
    latitude real,
    longitude real,
    open_time character varying(255),
    phone_number character varying(255),
    shop_employee_owner_id bigint
);


ALTER TABLE public.shop_entity OWNER TO postgres;

--
-- Name: shop_menu_item_entity; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.shop_menu_item_entity (
    relationship_id bigint NOT NULL,
    menu_item_id bigint,
    shop_id bigint
);


ALTER TABLE public.shop_menu_item_entity OWNER TO postgres;

--
-- Name: shop_queue_entity; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.shop_queue_entity (
    shop_id bigint NOT NULL,
    queue_id bigint NOT NULL,
    status integer
);


ALTER TABLE public.shop_queue_entity OWNER TO postgres;

--
-- Name: stats_entity; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.stats_entity (
    stats_id bigint NOT NULL,
    menu_item_id bigint,
    shop_id bigint,
    total_complete_orders bigint,
    total_preparing_time bigint
);


ALTER TABLE public.stats_entity OWNER TO postgres;

--
-- Name: user_password_entity; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_password_entity (
    user_id bigint NOT NULL,
    password character varying(255)
);


ALTER TABLE public.user_password_entity OWNER TO postgres;

--
-- Data for Name: customer_entity; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.customer_entity (customer_id, address, full_name, phone_number) FROM stdin;
1	customer address 1	customer 1	012345678
2	customer address 2	customer 2	0123456781
\.


--
-- Data for Name: menu_item_entity; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.menu_item_entity (menu_item_id, name, price, status) FROM stdin;
1	pure water	10	1
2	tonic water	20	1
3	arabica	30	1
\.


--
-- Data for Name: order_entity; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.order_entity (order_id, created_at, order_status, payment_id, shop_id, user_id) FROM stdin;
\.


--
-- Data for Name: order_menu_item_entity; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.order_menu_item_entity (relationship_id, menu_item_id, order_id) FROM stdin;
\.


--
-- Data for Name: order_promotion_entity; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.order_promotion_entity (relationship_id, order_id, promotion_id) FROM stdin;
\.


--
-- Data for Name: payment_entity; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.payment_entity (payment_id, merchandise_sub_total, paid_at, payment_status, promotion_subtotal) FROM stdin;
\.


--
-- Data for Name: promotion_entity; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.promotion_entity (promotion_id, customer_id, promotion_value, shop_id) FROM stdin;
1	1	5	1
2	1	3	1
\.


--
-- Data for Name: queue_entity; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.queue_entity (queue_id, queue_size) FROM stdin;
1	1
2	2
3	3
\.


--
-- Data for Name: queue_item_entity; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.queue_item_entity (relationship_id, order_id, queue_item_id) FROM stdin;
\.


--
-- Data for Name: queue_queue_item_entity; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.queue_queue_item_entity (relationship_id, queue_id, queue_item_id) FROM stdin;
\.


--
-- Data for Name: shop_employee_entity; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.shop_employee_entity (employee_id, full_name, manager_id, phone_number) FROM stdin;
1	employee 1	0	1234
\.


--
-- Data for Name: shop_entity; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.shop_entity (shop_id, address, close_time, email, latitude, longitude, open_time, phone_number, shop_employee_owner_id) FROM stdin;
1	shop address 1	10:30	shop1@email.com	1.23	1.24	5:30	1234	1
\.


--
-- Data for Name: shop_menu_item_entity; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.shop_menu_item_entity (relationship_id, menu_item_id, shop_id) FROM stdin;
1	1	1
3	3	1
2	2	1
\.


--
-- Data for Name: shop_queue_entity; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.shop_queue_entity (shop_id, queue_id, status) FROM stdin;
1	3	1
1	2	1
1	1	1
\.


--
-- Data for Name: stats_entity; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.stats_entity (stats_id, menu_item_id, shop_id, total_complete_orders, total_preparing_time) FROM stdin;
\.


--
-- Data for Name: user_password_entity; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.user_password_entity (user_id, password) FROM stdin;
\.


--
-- Name: customer_entity customer_entity_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customer_entity
    ADD CONSTRAINT customer_entity_pkey PRIMARY KEY (customer_id);


--
-- Name: menu_item_entity menu_item_entity_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.menu_item_entity
    ADD CONSTRAINT menu_item_entity_pkey PRIMARY KEY (menu_item_id);


--
-- Name: order_entity order_entity_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.order_entity
    ADD CONSTRAINT order_entity_pkey PRIMARY KEY (order_id);


--
-- Name: order_menu_item_entity order_menu_item_entity_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.order_menu_item_entity
    ADD CONSTRAINT order_menu_item_entity_pkey PRIMARY KEY (relationship_id);


--
-- Name: order_promotion_entity order_promotion_entity_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.order_promotion_entity
    ADD CONSTRAINT order_promotion_entity_pkey PRIMARY KEY (relationship_id);


--
-- Name: payment_entity payment_entity_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.payment_entity
    ADD CONSTRAINT payment_entity_pkey PRIMARY KEY (payment_id);


--
-- Name: promotion_entity promotion_entity_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.promotion_entity
    ADD CONSTRAINT promotion_entity_pkey PRIMARY KEY (promotion_id);


--
-- Name: queue_entity queue_entity_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.queue_entity
    ADD CONSTRAINT queue_entity_pkey PRIMARY KEY (queue_id);


--
-- Name: queue_item_entity queue_item_entity_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.queue_item_entity
    ADD CONSTRAINT queue_item_entity_pkey PRIMARY KEY (relationship_id);


--
-- Name: queue_queue_item_entity queue_queue_item_entity_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.queue_queue_item_entity
    ADD CONSTRAINT queue_queue_item_entity_pkey PRIMARY KEY (relationship_id);


--
-- Name: shop_employee_entity shop_employee_entity_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.shop_employee_entity
    ADD CONSTRAINT shop_employee_entity_pkey PRIMARY KEY (employee_id);


--
-- Name: shop_entity shop_entity_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.shop_entity
    ADD CONSTRAINT shop_entity_pkey PRIMARY KEY (shop_id);


--
-- Name: shop_menu_item_entity shop_menu_item_entity_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.shop_menu_item_entity
    ADD CONSTRAINT shop_menu_item_entity_pkey PRIMARY KEY (relationship_id);


--
-- Name: shop_queue_entity shop_queue_entity_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.shop_queue_entity
    ADD CONSTRAINT shop_queue_entity_pkey PRIMARY KEY (shop_id, queue_id);


--
-- Name: stats_entity stats_entity_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.stats_entity
    ADD CONSTRAINT stats_entity_pkey PRIMARY KEY (stats_id);


--
-- Name: user_password_entity user_password_entity_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_password_entity
    ADD CONSTRAINT user_password_entity_pkey PRIMARY KEY (user_id);


--
-- PostgreSQL database dump complete
--
