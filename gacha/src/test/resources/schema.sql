DROP TABLE IF EXISTS users;

CREATE TABLE "users" (
    "id" SERIAL NOT NULL,
    "name" varchar(64) PRIMARY KEY,
    "password" TEXT NOT NULL,
    "coin" int NOT NULL
);

CREATE TABLE "characters" (
	"id" SERIAL NOT NULL primary key,
	"name" TEXT NOT NULL,
	"lank" INTEGER NOT NULL
);

CREATE TABLE "stocks" (
	"id" SERIAL NOT NULL primary key,
	"character_id" INTEGER NOT NULL,
	"user_id" INTEGER NOT NULL
);