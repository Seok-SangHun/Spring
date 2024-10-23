CREATE SEQUENCE SEQ_MEMBER;
CREATE TABLE TBL_MEMBER(
    ID NUMBER CONSTRAINT PK_MEMBER PRIMARY KEY,
    MEMBER_EMAIL VARCHAR2(255) NOT NULL,
    MEMBER_PASSWORD VARCHAR2(255) NOT NULL,
    MEMBER_NAME VARCHAR2(255) NOT NULL
);

SELECT * FROM TBL_MEMBER;