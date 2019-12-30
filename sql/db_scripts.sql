create user appuser with encrypted password 'appuser';

create user serviceuser with encrypted password 'serviceuser';

create schema uofu authorization appuser;

GRANT USAGE ON SCHEMA uofu TO serviceuser;

GRANT SELECT, INSERT, UPDATE, DELETE, REFERENCES on ALL TABLES IN SCHEMA uofu to serviceuser;

GRANT  USAGE , SELECT , UPDATE ON ALL SEQUENCES IN SCHEMA uofu TO serviceuser;

SET search_path TO UOFU, public;
-- after this if you create table without schema name, -- it would create the table in UOFU schema

 CREATE TABLE account(
      user_id serial PRIMARY KEY,
      username VARCHAR (50) UNIQUE NOT NULL,
      password VARCHAR (50) NOT NULL,
      email VARCHAR (355) UNIQUE NOT NULL,
      created_on TIMESTAMP NOT NULL,
      last_login TIMESTAMP
   );
   -- SEQUENCE table-generator for account
   CREATE TABLE USER_IDS (
       seq_id varchar(255) not null,
        seq_value INTEGER,
        primary key (seq_id)
    );

 CREATE TABLE STUDENT(
      id serial PRIMARY KEY,
      first_name VARCHAR (50) NOT NULL,
      last_name VARCHAR (50) NOT NULL,
      email VARCHAR (355) UNIQUE NOT NULL,
      created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
      last_updated TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
   );
 CREATE SEQUENCE IF NOT EXISTS STUDENT_SEQ INCREMENT BY 1 MAXVALUE 10000 START WITH 100;

 CREATE TABLE ADDRESS(
      id serial PRIMARY KEY,
      student_id INTEGER not null,
      street VARCHAR (150)  NOT NULL,
      unit_no VARCHAR (50) NOT NULL,
      zip NUMERIC (10)  NOT NULL,
      city VARCHAR (100) NOT NULL,
      state VARCHAR (50) NOT NULL,
      created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
      last_updated TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
   );

   CREATE SEQUENCE IF NOT EXISTS ADDRESS_SEQ INCREMENT BY 1 MAXVALUE 40000 START WITH 100;

alter table address add constraint address_stud_fk foreign key (student_id) references student;


-- many to many mappings
 CREATE TABLE USERS(
      id serial PRIMARY KEY,
      user_name VARCHAR (150) not null,
      created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
      last_updated TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
   );
  CREATE SEQUENCE IF NOT EXISTS USERS_SEQ INCREMENT BY 1 MAXVALUE 40000 START WITH 100;


  CREATE TABLE LISTING(
       id serial PRIMARY KEY,
       item_name VARCHAR (150) not null,
       created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
       last_updated TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
    );
  CREATE SEQUENCE IF NOT EXISTS LISTING_SEQ INCREMENT BY 1 MAXVALUE 40000 START WITH 100;

  CREATE TABLE USER_LISTING(
       user_id INTEGER not null,
       listing_id INTEGER not null,
       created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
       last_updated TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
       primary key (user_id, listing_id),
       foreign key (user_id) references users(id),
       foreign key (listing_id) references listing(id)
    );