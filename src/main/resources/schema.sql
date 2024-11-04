-- DROP SCHEMA public;

CREATE SCHEMA public AUTHORIZATION pg_database_owner;

-- DROP SEQUENCE public."Game_id_seq";

CREATE SEQUENCE public."Game_id_seq"
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.user_id_seq;

CREATE SEQUENCE public.user_id_seq
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
	CACHE 1
	NO CYCLE;-- public.game definition

-- Drop table

-- DROP TABLE public.game;

CREATE TABLE public.game (
                             id int8 GENERATED ALWAYS AS IDENTITY( INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1 NO CYCLE) NOT NULL,
                             title varchar(255) NULL,
                             "year" varchar(255) NULL,
                             rating float8 NULL,
                             "cost" float8 NULL,
                             CONSTRAINT "Game_pkey" PRIMARY KEY (id)
);


-- public.usersteam definition

-- Drop table

-- DROP TABLE public.usersteam;

CREATE TABLE public.usersteam (
                                  id int8 GENERATED ALWAYS AS IDENTITY( INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1 NO CYCLE) NOT NULL,
                                  username varchar(255) NULL,
                                  emailaddress varchar(255) NULL,
                                  phonenumber varchar(255) NULL,
                                  "password" varchar(255) NULL,
                                  CONSTRAINT user_pkey PRIMARY KEY (id),
                                  CONSTRAINT username UNIQUE (username)
);


-- public.hasfriend definition

-- Drop table

-- DROP TABLE public.hasfriend;

CREATE TABLE public.hasfriend (
                                  iduser int8 NOT NULL,
                                  idfriend int8 NOT NULL,
                                  CONSTRAINT "hasFriend_pkey" PRIMARY KEY (iduser, idfriend),
                                  CONSTRAINT idfriend FOREIGN KEY (idfriend) REFERENCES public.usersteam(id),
                                  CONSTRAINT iduser FOREIGN KEY (iduser) REFERENCES public.usersteam(id)
);


-- public.play definition

-- Drop table

-- DROP TABLE public.play;

CREATE TABLE public.play (
                             iduser int8 NOT NULL,
                             idgame int8 NOT NULL,
                             totalhours float8 DEFAULT 0 NULL,
                             CONSTRAINT play_pkey PRIMARY KEY (iduser, idgame),
                             CONSTRAINT idgame FOREIGN KEY (idgame) REFERENCES public.game(id),
                             CONSTRAINT iduser FOREIGN KEY (iduser) REFERENCES public.usersteam(id)
);