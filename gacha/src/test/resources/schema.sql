DROP TABLE IF EXISTS users;

CREATE TABLE "users" (
    "id" SERIAL NOT NULL,
    "name" varchar(64) PRIMARY KEY,
    "password" TEXT NOT NULL,
    "coin" int NOT NULL
);