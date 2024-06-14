--create a table
CREATE TABLE IF NOT EXISTS dashboard (
    recKey BIGINT PRIMARY KEY,
    bankCode INTEGER NOT NULL,
    brnchCode VARCHAR(10) NOT NULL,
    scanRef VARCHAR(10) NOT NULL,
    scnDate date NOT NULL
);
insert into dashboard (recKey, bankCode, brnchCode, scanRef, scnDate) values (1, 1, 'BR001', 'SR001', '2021-01-01');