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
