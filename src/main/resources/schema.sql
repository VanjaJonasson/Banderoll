CREATE TABLE PLAYER(
ID BIGINT AUTO_INCREMENT PRIMARY KEY,
USERNAME VARCHAR(64),
PASSWORD VARCHAR(64),
CURRENTPOINT BIGINT,
MAXPOINTS BIGINT,
LIVES BIGINT
);