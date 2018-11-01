CREATE DATABASE IF NOT EXISTS TheBookClub;

use TheBookClub;

CREATE TABLE IF NOT EXISTS book (
bookID INT NOT NULL AUTO_INCREMENT,
PRIMARY KEY(bookID),
title VARCHAR(255),
author VARCHAR(255)
 );
 
 INSERT INTO book (title,author)
 VALUES ('The Fellowship of the Ring','J.R.R Tolkein');

-- SELECT * FROM books;

CREATE TABLE IF NOT EXISTS user (
userID INT NOT NULL AUTO_INCREMENT,
PRIMARY KEY(userID),
username VARCHAR(255)
 );
 
 INSERT INTO user (username)
 VALUES ('Tom Bamford');

-- SELECT * FROM users;

CREATE TABLE IF NOT EXISTS library (
userID INT NOT NULL,
FOREIGN KEY(userID) REFERENCES users(userID) ON DELETE CASCADE,
bookID INT NOT NULL,
FOREIGN KEY(bookID) REFERENCES books(bookID) ON DELETE CASCADE,
 rating BIT(5),
 review VARCHAR(1000),
PRIMARY KEY(userID,bookID)
 );
 
 INSERT INTO library (userID,bookID,rating,review)
  VALUES (1, 1,5,'Good book');


 SELECT * FROM library;

-- DROP DATABASE TheBookClub;