CREATE TABLE user (
   ID INT auto_increment primary key,
   NAME VARCHAR(255) NOT NULL
);
CREATE TABLE task (
   ID INT auto_increment primary key,
   NAME VARCHAR(255) NOT NULL,
   created_at DATETIME NOT NULL
);
CREATE TABLE task_detail (
   ID INT auto_increment primary key,
   task_id INT NOT NULL,
   user_id INT NOT NULL,
   content VARCHAR(255) NOT NULL,
   created_at DATETIME NOT NULL
);

--マスタデータ
INSERT INTO user (name) VALUES ('yamane');
INSERT INTO user (name) VALUES ('masahiro');
INSERT INTO user (name) VALUES ('yamanda');
INSERT INTO user (name) VALUES ('taro');
INSERT INTO user (name) VALUES ('sato');
INSERT INTO user (name) VALUES ('takuya');