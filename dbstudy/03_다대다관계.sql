/*
    수강신청
    1. 여러 학생이 여러 과목을 신청하는 다대다관계
    2. 학생-과목의 직접적인 다대다관계 설정은 불가능
    3. 학생-수강신청-과목으로 일대다관계 2개 설정으로 진행
    
    외래키 제약조건 무시하고 테이블 삭제
    순서에 상관없이 삭제 가능
    DROP TABLE STUDENT CASCADE CONSTRAINTS;
    DROP TABLE OBJ CASCADE CONSTRAINTS;
    DROP TABLE ABC CASCADE CONSTRAINTS;
*/

-- 테이블 삭제
DROP TABLE ABC;
DROP TABLE OBJ;
DROP TABLE STUDENT;

-- 학생 테이블 생성
CREATE TABLE STUDENT(
    STU_CODE VARCHAR2(5 BYTE) NOT NULL,
    STU_NAME VARCHAR2(15 BYTE) NOT NULL,
    STU_AGE NUMBER(3) NOT NULL,
    CONSTRAINT PK_STUDENT PRIMARY KEY(STU_CODE)
);

-- 과목 테이블 생성
CREATE TABLE OBJ(
    OBJ_CODE VARCHAR2(1 BYTE) NOT NULL,
    OBJ_NAME VARCHAR2(10 BYTE) NOT NULL,
    OBJ_TEAC VARCHAR2(15 BYTE) NOT NULL,
    CONSTRAINT PK_OBJ PRIMARY KEY(OBJ_CODE)
);

-- 수강신청 테이블 생성
CREATE TABLE ABC(
    ABC_CODE NUMBER NOT NULL,
    STU_CODE VARCHAR2(5 BYTE) NOT NULL,
    OBJ_CODE VARCHAR2(1 BYTE) NOT NULL,
    CONSTRAINT PK_ABC PRIMARY KEY(ABC_CODE),
    CONSTRAINT FK_ABC_STUDENT FOREIGN KEY(STU_CODE) REFERENCES STUDENT(STU_CODE),
    CONSTRAINT FK_ABC_OBJ FOREIGN KEY(OBJ_CODE) REFERENCES OBJ(OBJ_CODE)
);

