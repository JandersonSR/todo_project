CREATE TABLE proposal (
    id integer primary key AUTO_INCREMENT,
    valor NUMERIC(20, 2),
    metaProductBankId varchar(25),
    proposalId varchar(25),
    createdAt TIMESTAMP,
     userId varchar(25) REFERENCES users (userId)
);

CREATE TABLE users (
    id integer primary key AUTO_INCREMENT,
    userId varchar(25),
    nome varchar(100),
    systemId varchar(25),
    createdAt TIMESTAMP
);
