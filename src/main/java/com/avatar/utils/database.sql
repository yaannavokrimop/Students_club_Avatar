-- create database avatar;
-- create user test_usr with password '123';
-- grant all on database avatar to test_usr;

create table Event (
    id uuid primary key,
    organiser_id integer not null,
    name varchar(255) not null,
    short_name varchar(255),
    type varchar(255),
    status varchar(255),
    main_language varchar(255),
    activity_type varchar(255),
    category varchar(255),
    publicity varchar(255),
    format varchar(255),
    date_time_start timestamp not null ,
    date_time_finish timestamp not null ,
    is_date_approximate boolean not null,
    comment text,
    event_status varchar(255) not null
);