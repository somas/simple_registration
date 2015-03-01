
DROP TABLE users IF EXISTS;

CREATE TABLE users (id VARCHAR(40) PRIMARY KEY,username VARCHAR(40) NOT NULL UNIQUE, email VARCHAR(100), password VARCHAR(40), date_created TIMESTAMP, last_updated TIMESTAMP);

--INSERT INTO user VALUES ('1', 'som', 'som@gmail.com', 'password123', TIMESTAMP '2015-02-28 14:00:00', TIMESTAMP '2015-02-28 14:00:00');

COMMIT;