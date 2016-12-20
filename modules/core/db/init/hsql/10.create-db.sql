-- begin SAMPLE_CUSTOMER
create table SAMPLE_CUSTOMER (
    ID varchar(36) not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    VERSION integer not null,
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255),
    EMAIL varchar(100),
    --
    primary key (ID)
)^
-- end SAMPLE_CUSTOMER
-- begin SAMPLE_ORDER
create table SAMPLE_ORDER (
    ID varchar(36) not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    VERSION integer not null,
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    DATE_ date,
    NUM varchar(100),
    CUSTOMER_ID varchar(36),
    --
    primary key (ID)
)^
-- end SAMPLE_ORDER
-- begin SAMPLE_ORDER_LINE
create table SAMPLE_ORDER_LINE (
    ID varchar(36) not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    VERSION integer not null,
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    ORDER_ID varchar(36),
    PRODUCT_ID varchar(36) not null,
    QUANTITY double precision not null,
    --
    primary key (ID)
)^
-- end SAMPLE_ORDER_LINE
-- begin SAMPLE_PRODUCT
create table SAMPLE_PRODUCT (
    ID varchar(36) not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    VERSION integer not null,
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    CUSTOMER_ID varchar(36),
    --
    primary key (ID)
)^
-- end SAMPLE_PRODUCT
-- begin SAMPLE_AIRPORT
create table SAMPLE_AIRPORT (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255),
    --
    primary key (ID)
)^
-- end SAMPLE_AIRPORT
-- begin SAMPLE_TERMINAL
create table SAMPLE_TERMINAL (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    AIRPORT_ID varchar(36) not null,
    NAME varchar(255),
    --
    primary key (ID)
)^
-- end SAMPLE_TERMINAL
-- begin SAMPLE_MEETING_POINT
create table SAMPLE_MEETING_POINT (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    TERMINAL_ID varchar(36) not null,
    NAME varchar(255),
    --
    primary key (ID)
)^
-- end SAMPLE_MEETING_POINT
-- begin SAMPLE_NOTE
create table SAMPLE_NOTE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    MEETING_POINT_ID varchar(36) not null,
    TEXT varchar(255),
    --
    primary key (ID)
)^
-- end SAMPLE_NOTE
