-- Table: public.m_bike

-- DROP TABLE public.m_bike;

CREATE TABLE public.m_bike
(
    bike_id character varying(20) COLLATE pg_catalog."default" NOT NULL,
    name character varying(128) COLLATE pg_catalog."default",
    color character varying(128) COLLATE pg_catalog."default",
    model character varying(128) COLLATE pg_catalog."default",
    update_time timestamp without time zone,
    create_time timestamp without time zone,
    CONSTRAINT bike_pkey PRIMARY KEY (bike_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.m_bike
    OWNER to postgres;
	
	
-- Table: public.s_role

-- DROP TABLE public.s_role;

CREATE TABLE public.s_role
(
    role_id character varying(20) COLLATE pg_catalog."default" NOT NULL,
    role_name character varying(128) COLLATE pg_catalog."default",
    description character varying(256) COLLATE pg_catalog."default",
    CONSTRAINT role_pkey PRIMARY KEY (role_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.s_role
    OWNER to postgres;

	
-- Table: public.m_user

-- DROP TABLE public.m_user;

CREATE TABLE public.m_user
(
    user_id character varying(20) COLLATE pg_catalog."default" NOT NULL,
    username character varying(128) COLLATE pg_catalog."default",
    password character varying(256) COLLATE pg_catalog."default",
	full_name character varying(128) COLLATE pg_catalog."default",
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    CONSTRAINT user_pkey PRIMARY KEY (user_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.m_user
    OWNER to postgres;
	
-- Table: public.m_user_role

-- DROP TABLE public.m_user_role;

CREATE TABLE public.m_user_role
(
    user_id character varying(20) COLLATE pg_catalog."default" NOT NULL,
    role_id character varying(20) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT user_role_pkey PRIMARY KEY (user_id, role_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.m_user_role
    OWNER to postgres;