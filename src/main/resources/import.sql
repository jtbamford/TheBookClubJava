CREATE DATABASE IF NOT EXISTS TheBookClub;

use TheBookClub;

CREATE TABLE IF NOT EXISTS books (
bookID INT NOT NULL AUTO_INCREMENT,
PRIMARY KEY(bookID),
title VARCHAR(255),
author VARCHAR(255)
 );
 
 INSERT INTO books (title,author)
 VALUES ('The Fellowship of the Ring','J.R.R Tolkein');

-- SELECT * FROM books;

CREATE TABLE IF NOT EXISTS users (
userID INT NOT NULL AUTO_INCREMENT,
PRIMARY KEY(userID),
username VARCHAR(255)
 );
 
 INSERT INTO users (username)
 VALUES ('Tom Bamford');

-- SELECT * FROM users;

CREATE TABLE IF NOT EXISTS libraries (
userID INT NOT NULL,
FOREIGN KEY(userID) REFERENCES users(userID) ON DELETE CASCADE,
bookID INT NOT NULL,
FOREIGN KEY(bookID) REFERENCES books(bookID) ON DELETE CASCADE,
 rating BIT(5),
 review VARCHAR(1000),
PRIMARY KEY(userID,bookID)
 );
 
 INSERT INTO libraries (userID,bookID,rating,review)
  VALUES (1, 1,5,'Good book');


 SELECT * FROM libraries;

-- DROP DATABASE TheBookClub;