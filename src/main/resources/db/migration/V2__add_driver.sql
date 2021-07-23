CREATE TABLE driver
(
    id        INTEGER NOT NULL PRIMARY KEY,
    firstName TEXT,
    lastName  TEXT,
    team_id   INTEGER NOT NULL REFERENCES team (id)
);
