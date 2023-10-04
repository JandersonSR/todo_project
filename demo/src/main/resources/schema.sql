CREATE TABLE proposal (
    number integer primary key AUTO_INCREMENT,
    valor NUMERIC(20, 2),
    metaProductBankId varchar(25),
    id varchar(25),
    createdAt TIMESTAMP
);

CREATE TABLE users (
    userCode integer primary key AUTO_INCREMENT,
    nome varchar(100),
    systemId varchar(25),
    createdAt TIMESTAMP
);
