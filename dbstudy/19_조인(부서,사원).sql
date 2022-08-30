-- 테이블 삭제
DROP TABLE EMPLOYEE;
DROP TABLE DEPARTMENT;

-- DEPARTMENT 테이블 생성
CREATE TABLE DEPARTMENT(
    DEPT_NO   NUMBER            NOT NULL,
    DEPT_NAME VARCHAR2(15 BYTE) NOT NULL,
    LOCATION  VARCHAR2(15 BYTE) NOT NULL
);

-- EMPLOYEE 테이블 생성
CREATE TABLE EMPLOYEE(
    EMP_NO    NUMBER            NOT NULL,
    NAME      VARCHAR2(20 BYTE) NOT NULL,
    DEPART    NUMBER            NULL,
    POSITION  VARCHAR2(20 BYTE) NULL,
    GENDER    CHAR(2)           NULL,
    HIRE_DATE DATE              NULL,
    SALARY    NUMBER            NULL
);

-- 기본키
ALTER TABLE DEPARTMENT 
    ADD CONSTRAINT PK_DEPARTMENT PRIMARY KEY(DEPT_NO);
ALTER TABLE EMPLOYEE 
    ADD CONSTRAINT PK_EMPLOYEE PRIMARY KEY(EMP_NO);

-- 외래키
ALTER TABLE EMPLOYEE
    ADD CONSTRAINT FK_EMPLOYEE_DEPARTMENT FOREIGN KEY(DEPART) 
        REFERENCES DEPARTMENT(DEPT_NO)
            ON DELETE CASCADE;

-- 부서 테이블에서 사용할 부서_시퀀스
DROP SEQUENCE DEPARTMENT_SEQ;
CREATE SEQUENCE DEPARTMENT_SEQ
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 100
    NOCACHE
    NOCYCLE;

-- 부서 테이블에 행(Row) 삽입
INSERT INTO DEPARTMENT(DEPT_NO, DEPT_NAME, LOCATION) VALUES (DEPARTMENT_SEQ.NEXTVAL, '영업부', '대구');
INSERT INTO DEPARTMENT(DEPT_NO, DEPT_NAME, LOCATION) VALUES (DEPARTMENT_SEQ.NEXTVAL, '인사부', '서울');
INSERT INTO DEPARTMENT(DEPT_NO, DEPT_NAME, LOCATION) VALUES (DEPARTMENT_SEQ.NEXTVAL, '총무부', '대구');
INSERT INTO DEPARTMENT(DEPT_NO, DEPT_NAME, LOCATION) VALUES (DEPARTMENT_SEQ.NEXTVAL, '기획부', '서울');

-- 작업의 완료
COMMIT;

-- 사원 테이블에서 사용할 부서_시퀀스
DROP SEQUENCE EMPLOYEE_SEQ;
CREATE SEQUENCE EMPLOYEE_SEQ
    START WITH 1001
    NOCYCLE;


-- 사원 테이블에 행(Row) 삽입
INSERT INTO EMPLOYEE VALUES (EMPLOYEE_SEQ.NEXTVAL, '구창민', 1, '과장', 'M', '95/05/01', 5000000);
INSERT INTO EMPLOYEE VALUES (EMPLOYEE_SEQ.NEXTVAL, '김민서', 1, '사원', 'F', '17/09/01', 2000000);
INSERT INTO EMPLOYEE VALUES (EMPLOYEE_SEQ.NEXTVAL, '이은영', 2, '부장', NULL, '90-09-01', 5500000);
INSERT INTO EMPLOYEE VALUES (EMPLOYEE_SEQ.NEXTVAL, '한성일', 2, '과장', 'M', '93-04-01', 5000000);
COMMIT;

-- 참조무결성 위배 데이터 삽입을 위해서 외래키 일시중지
ALTER TABLE EMPLOYEE
      DISABLE CONSTRAINT FK_EMPLOYEE_DEPARTMENT;

-- 참조무결성 위배 데이터 삽입
INSERT INTO EMPLOYEE VALUES (EMPLOYEE_SEQ.NEXTVAL, '신현준', 5, '대리', 'M', '98-12-01', 3500000);
COMMIT;


/**************************************************************************************************/

/*
    조인
    
    1. JOIN
    2. 2개 이상의 테이블을 조회하는 방법
    3. 조회할 테이블들은 관계를 줄 수 있어야 함
    4. 종류
       1) 크로스 조인 : 카테젼 곱, 각 테이블의 모든 행을 조인
          - CROSS JOIN
          - 많은 행을 순식간에 만들 수 있음(기초데이터 작성용)
          - 조인 조건을 잘못 지정한 경우
       2) 내부 조인
          - INNER JOIN
          - 각 테이블에 일치하는 모든 행을 조인
       3) 외부 조인
          - OUTER JOIN
          - 한 테이블은 일치하는 행을 조인, 한 테이블은 일치하지 않아도 조인
       4) 셀프 조인
          - SELF JOIN
          - 한 테이블에 참조 관계가 있는 경우
          - 한 테이블의 특정 칼럼과 다른 특정 칼럼을 조인
    5. 형식
       1) JOIN 문법
           SELECT 칼럼
             FROM 테이블1 JOIN 테이블2
               ON 조인조건
       2) 콤마(,) 문법
           SELECT 칼럼
             FROM 테이블1, 테이블2
            WHERE 조인조건
*/


SELECT EMP_NO, NAME, DEPT_NAME
  FROM EMPLOYEE INNER JOIN DEPARTMENT
    ON DEPART = DEPT_NO;