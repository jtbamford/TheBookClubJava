CREATE DATABASE IF NOT EXISTS TheBookClub;

use TheBookClub;

CREATE TABLE IF NOT EXISTS book (
bookID INT NOT NULL AUTO_INCREMENT,
PRIMARY KEY(bookID),
title VARCHAR(255),
author VARCHAR(255)
 );
 
 INSERT INTO book (title,author)
 VALUES ('The Fellowship of the Ring','J.R.R Tolkien');

-- SELECT * FROM books;

CREATE TABLE IF NOT EXISTS user (
userID INT NOT NULL AUTO_INCREMENT,
PRIMARY KEY(userID),
username VARCHAR(255)
 );
 
 INSERT INTO user (username)
 VALUES ('Tom');

-- SELECT * FROM users;

CREATE TABLE IF NOT EXISTS bookownership (
bookownershipID INT NOT NULL AUTO_INCREMENT,
PRIMARY KEY(bookownershipID),
userID INT NOT NULL,
FOREIGN KEY(userID) REFERENCES users(userID) ON DELETE CASCADE,
bookID INT NOT NULL,
FOREIGN KEY(bookID) REFERENCES books(bookID) ON DELETE CASCADE,
 rating BIT(5),
 review VARCHAR(1000)
 );
 
 INSERT INTO bookownership (bookownershipID,userID,bookID,rating,review)
  VALUES (1, 1,5,'Good book');


 SELECT * FROM bookownership;

-- DROP DATABASE TheBookClub;