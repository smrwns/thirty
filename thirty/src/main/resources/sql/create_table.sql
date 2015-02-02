CREATE SEQUENCE BOARD_SEQ;

CREATE TABLE BOARD (
  ID int NOT NULL,
  TITLE varchar(200) NOT NULL,
  DESC varchar(4000) NOT NULL,
  CREATE_DT TIMESTAMP,
  PRIMARY KEY (ID)
);

INSERT INTO BOARD(ID, TITLE, DESC, CREATE_DT) VALUES(BOARD_SEQ.NEXTVAL, '제목1', '내용1', CURRENT_TIMESTAMP());
INSERT INTO BOARD(ID, TITLE, DESC, CREATE_DT) VALUES(BOARD_SEQ.NEXTVAL, '제목2', '내용2', CURRENT_TIMESTAMP());
INSERT INTO BOARD(ID, TITLE, DESC, CREATE_DT) VALUES(BOARD_SEQ.NEXTVAL, '제목3', '내용3', CURRENT_TIMESTAMP());
INSERT INTO BOARD(ID, TITLE, DESC, CREATE_DT) VALUES(BOARD_SEQ.NEXTVAL, '제목4', '내용4', CURRENT_TIMESTAMP());
INSERT INTO BOARD(ID, TITLE, DESC, CREATE_DT) VALUES(BOARD_SEQ.NEXTVAL, '제목5', '내용5', CURRENT_TIMESTAMP());
INSERT INTO BOARD(ID, TITLE, DESC, CREATE_DT) VALUES(BOARD_SEQ.NEXTVAL, '제목6', '내용6', CURRENT_TIMESTAMP());
INSERT INTO BOARD(ID, TITLE, DESC, CREATE_DT) VALUES(BOARD_SEQ.NEXTVAL, '제목7', '내용7', CURRENT_TIMESTAMP());
INSERT INTO BOARD(ID, TITLE, DESC, CREATE_DT) VALUES(BOARD_SEQ.NEXTVAL, '제목8', '내용8', CURRENT_TIMESTAMP());
INSERT INTO BOARD(ID, TITLE, DESC, CREATE_DT) VALUES(BOARD_SEQ.NEXTVAL, '제목9', '내용9', CURRENT_TIMESTAMP());
INSERT INTO BOARD(ID, TITLE, DESC, CREATE_DT) VALUES(BOARD_SEQ.NEXTVAL, '제목10', '내용10', CURRENT_TIMESTAMP());
INSERT INTO BOARD(ID, TITLE, DESC, CREATE_DT) VALUES(BOARD_SEQ.NEXTVAL, '제목10', '내용11', CURRENT_TIMESTAMP());