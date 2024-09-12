CREATE SEQUENCE SEQ_POST;

CREATE TABLE TBL_POST(
    ID NUMBER CONSTRAINT PK_POST PRIMARY KEY,
    POST_TITLE VARCHAR2(255) NOT NULL,
    POST_CONTENT VARCHAR2(255) NOT NULL,
    POST_READ_COUNT NUMBER DEFAULT 0,
    STATUS NUMBER DEFAULT 1,
    CREATED_DATE DATE DEFAULT CURRENT_TIMESTAMP,
    UPDATED_DATE DATE DEFAULT CURRENT_TIMESTAMP,
    MEMBER_ID NUMBER,
    CONSTRAINT FK_POST_MEMBER FOREIGN KEY(MEMBER_ID)
    REFERENCES TBL_MEMBER(ID)
);

ALTER TABLE TBL_POST ADD MEMBER_ID NUMBER;
ALTER TABLE TBL_POST ADD CONSTRAINT FK_POST_MEMBER FOREIGN KEY(MEMBER_ID)
REFERENCES TBL_MEMBER(ID);

SELECT * FROM TBL_POST;