/**
 *This script is for user table creation
 */

CREATE SCHEMA IF NOT EXISTS user_management;

DROP TABLE IF EXISTS user_management.user;

CREATE TABLE IF NOT EXISTS user_management.user(

user_id UUID NOT NULL,

first_name VARCHAR(50) NOT NULL,

last_name VARCHAR(50) NOT NULL,

mobile_number VARCHAR(20) NOT NULL,

PRIMARY KEY (user_id));