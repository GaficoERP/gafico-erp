-- Database: gafico_erp

-- DROP DATABASE gafico_erp;

CREATE DATABASE gafico_erp
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'French_France.1252'
    LC_CTYPE = 'French_France.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;
    
INSERT INTO public.user_info (id, enabled, password, username) VALUES (1, NULL, '$2a$10$gi.EMFUzuIasFOniz0qjYOephRaFL.SBvvI6SdOhgsRcFPwkvSue6', 'admin');

INSERT INTO public.user_role (id, name) VALUES (1, 'USER');
INSERT INTO public.user_role (id, name) VALUES (2, 'ADMIN');

INSERT INTO public.users_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO public.users_roles (user_id, role_id) VALUES (1, 2);