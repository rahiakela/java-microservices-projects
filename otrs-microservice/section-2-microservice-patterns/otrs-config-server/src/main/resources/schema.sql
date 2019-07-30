CREATE TABLE IF NOT EXISTS PROPERTIES (
    ID            IDENTITY PRIMARY KEY,
    APPLICATION   VARCHAR(128),
    PROFILE       VARCHAR(128),
    LABEL         VARCHAR(128),
    KEY           VARCHAR(512),
    VALUE         VARCHAR(512)
);