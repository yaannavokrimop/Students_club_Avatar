CREATE SCHEMA avatar AUTHORIZATION postgres;

create table avatar.Event
(
    id                  uuid primary key,
    organiser_id        integer      not null, //айди клуба
    name                varchar(255) not null,
    short_name          varchar(255),
    type                varchar(255),
    status              varchar(255),
--     main_language varchar(255),
    activity_type       varchar(255),
--     category varchar(255),
--     publicity varchar(255),
--     format varchar(255),
    date_time_start     timestamp    not null,
    date_time_finish    timestamp    not null,
    is_date_approximate boolean      not null,
--     comment text,
    event_status        varchar(255) not null,
    site                varchar(255)
);

/*create table avatar.Characteristics
(
    id       uuid primary key,
    name     varchar(255) not null,
    values   varchar(255)[],
    required boolean      not null
);

create table avatar.Event_Characteristics
(
    id         uuid primary key,
    event_id   uuid references avatar.Event           not null,
    charact_id uuid references avatar.Characteristics not null,
    value      varchar(255)                    not null
);*/

create table avatar.Characteristic
(
    event_id       uuid primary key references avatar.Event,
    members_number int,
    periodicity    varchar(255),
    category       varchar(255),
    publicity      varchar(255),
    format         varchar(255),
    language       varchar(255)
);


create table avatar.Preview
(
    event_id       uuid primary key references avatar.Event,
    announcement   varchar(255),
    description    varchar(255),
    aim            varchar(255),
    tasks          varchar(255),
    participants   varchar(255),
    organisers     varchar(255),
    contact_person varchar(255),
    comment        varchar(255)
);

create table avatar.Resume
(
    event_id               uuid primary key references avatar.Event,
    number_of_participants int,
    results                varchar(255),
    short_results          varchar(255)
);

create table avatar.Participants
(
    id       uuid primary key,
    isu_id   varchar(6)                   not null,
    event_id uuid references avatar.Event not null,
    name     varchar(255)                 not null,
    role     varchar(255),
    comment  varchar(255)
);

create table avatar.Address
(
    id uuid primary key,
    event_id uuid references avatar.Event not null ,
    address  varchar(255),
    building varchar(255),
    room     varchar(100),
    dateFrom timestamp,
    dateTo   timestamp
);

/*create table avatar.Address
(
    id          uuid primary key,
    event_id    uuid references avatar.Event not null,
    name        varchar(255),
    country     varchar(255),
    index       varchar(20),
    city        varchar(255),
    region      varchar(255),
    street      varchar(255),
    house       int,
    building    int,
    letter      varchar(1),
    room        varchar(255),
    date_start  date,
    date_finish date,
    comment     varchar(255)
);*/

create table avatar.Claim_Transport (
    id UUID primary key ,
    organiser varchar(100),
    contact_info varchar(255),
    aim varchar(255),
    car varchar(255),
    cargo_type varchar(50),
    date date,
    time_start time,
    time_finish time,
    route text
);
