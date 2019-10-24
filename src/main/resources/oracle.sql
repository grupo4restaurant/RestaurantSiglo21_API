
DROP TABLE BOOKS CASCADE CONSTRAINTS;
--DROP TABLE ERRORES CASCADE CONSTRAINTS;
DROP SEQUENCE SEQ_BOOKS;
--DROP SEQUENCE SQ_ERRORES;

CREATE SEQUENCE  SEQ_BOOKS  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--CREATE SEQUENCE  SQ_ERRORES  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

--TABLES
CREATE TABLE BOOKS(
    ID NUMBER not null,
    NAME VARCHAR2(100) NOT NULL,
    PRICE NUMBER(15, 2) NOT NULL,
    CONSTRAINT book_pk PRIMARY KEY (ID)
);

insert into books values(SEQ_BOOKS.nextval,'Pensando en Java',10.5);
insert into books values(SEQ_BOOKS.nextval,'Desarrollando en Android',11.5);
insert into books values(SEQ_BOOKS.nextval,'Desarrollando en Java',12.5);

--TABLE ERRORES
--create table ERRORES (
--   ERROR_ID             NUMBER(7)             not null,
--   ERROR_SUBPROG        VARCHAR2(100),
--   ERROR_DESC           VARCHAR2(200),
--   constraint PK_ERRORES primary key (ERROR_ID)
--);

--SP INSERT  
create or replace PROCEDURE SP_CREAR_BOOK(
  IN_NAME 			IN books.name%type,
  IN_PRICE 			IN books.price%type,
  
  OUT_GLOSA 		OUT books.name%type,
  OUT_ESTADO 		OUT books.id%type,
  OUT_ID_SALIDA 	OUT books.id%type
) AS

/**************************************************************************************************************
   NAME:       SP_CREAR_BOOK
   PURPOSE:

   REVISIONS:
   Ver        Date           Author                    Description
   ---------  ----------     -------------------       ----------------------------------------------
   1.0        xx/xx/xxxx     xxxx@xx.cl       	       1. procedimiento que crea un nuevo BOOKS

***************************************************************************************************************/

BEGIN
--    p_estado := 0;
--    p_glosa := 'SP_CREAR_BOOK ejecutado exitosamente';


    INSERT INTO BOOKS(
      ID,
      NAME,
      PRICE
   )
    VALUES (
       SEQ_BOOKS.nextval,
       IN_NAME,
       IN_PRICE
    )
    RETURNING ID INTO OUT_ID_SALIDA;

    OUT_GLOSA := 'SP_CREAR_BOOK ejecutado exitosamente';
    OUT_ESTADO := 0;    

    EXCEPTION
        WHEN OTHERS THEN
            OUT_ESTADO := -1;
            OUT_GLOSA := FN_GET_GLOSA_ERROR;
END SP_CREAR_BOOK;

--SP UPDATE
CREATE OR REPLACE PROCEDURE SP_UPD_BOOK(
  IN_ID IN NUMBER,
  IN_NAME IN VARCHAR2,
  IN_PRICE IN NUMBER,

  OUT_GLOSA OUT VARCHAR2,
  OUT_ESTADO OUT NUMBER
) AS

/**************************************************************************************************************
   NAME:       SP_UPD_BOOK
   PURPOSE:

   REVISIONS:
   Ver          Date           Author                               Description
   ---------    ----------     -------------------                  ----------------------------------------------
   1.0        XX/XX/XXXX     XX@XX.cl       						1. procedimiento que UPDATEAR  una BOOKS
***************************************************************************************************************/

BEGIN
    OUT_ESTADO := 0;
    OUT_GLOSA := 'SP_UPD_BOOK ejecutado exitosamente';

    UPDATE BOOKS SET 
      NAME = IN_NAME,
      PRICE = IN_PRICE

      WHERE ID = IN_ID;

    EXCEPTION
        WHEN OTHERS THEN
			OUT_ESTADO := -1;
			OUT_GLOSA := FN_GET_GLOSA_ERROR;
END SP_UPD_BOOK;

--SP DELETE
CREATE OR REPLACE PROCEDURE SP_DEL_BOOK(
  IN_ID 	IN NUMBER,

  OUT_GLOSA 	OUT VARCHAR2,
  OUT_ESTADO 	OUT NUMBER
) AS


/**************************************************************************************************************
   NAME:       SP_DEL_BOOK
   PURPOSE:

   REVISIONS:
   Ver        Date           Author                               Description
   ---------  ----------     -------------------                  ----------------------------------------------
   1.0        XX/XX/XXXX     XX@XX.cl       						1. procedimiento que eliminar una BOOK
***************************************************************************************************************/

BEGIN
    OUT_ESTADO := 0;
    OUT_GLOSA := 'SP_DEL_BOOK ejecutado exitosamente';

    DELETE FROM BOOKS 
      WHERE ID = IN_ID;


    EXCEPTION
        WHEN OTHERS THEN
           OUT_ESTADO := -1;
            OUT_GLOSA := FN_GET_GLOSA_ERROR;

END SP_DEL_BOOK;

--SP GET
CREATE OR REPLACE PROCEDURE SP_GET_BOOK(
  IN_ID IN NUMBER,
  OUT_GLOSA OUT VARCHAR2,
  OUT_ESTADO OUT NUMBER,
  OUT_PC_GET_BOOK OUT SYS_REFCURSOR
) 
AS
/**************************************************************************************************************
   NAME:       SP_GET_BOOK
   PURPOSE:

   REVISIONS:
   Ver                Date           Author                               Description
   ---------          ----------     -------------------                  ----------------------------------------------
    1.0        XX/XX/XXXX     XX@XX.cl       						       1. procedimiento que RECUPERAR  una BOOK
***************************************************************************************************************/

BEGIN
    OUT_ESTADO := 0;
    OUT_GLOSA := 'SP_GET_BOOK ejecutado exitosamente';

    OPEN OUT_PC_GET_BOOK FOR
    SELECT 
    ID,
    NAME,
    PRICE
    FROM BOOKS WHERE ID = IN_ID;

    EXCEPTION
        WHEN OTHERS THEN
           OUT_ESTADO := -1;
           OUT_GLOSA := FN_GET_GLOSA_ERROR;		

END SP_GET_BOOK;

--get function
CREATE OR REPLACE FUNCTION FN_GET_GLOSA_ERROR RETURN VARCHAR2
AS

/***********************************************************************************************************************
   NAME:    FN_GET_GLOSA_ERROR
   PURPOSE: Funcion que retorna glosa de error, incluye stacktrace con nombre del SP y linea donde se produce el error

   REVISIONS:
   Ver          Date           Author                       Description
   ---------    ----------     -------------------          -------------------------------------------------------------
   1.0          XX/XX/XXXX     XXX.cl       				1. Funcion que retorna detalles del error ocurrido

************************************************************************************************************************/

LV_BACKTRACE VARCHAR2(4000) := DBMS_UTILITY.format_error_backtrace;
LV_MENSAJE VARCHAR2(4000) := '';

BEGIN

    LV_MENSAJE := CONCAT(LV_BACKTRACE, SUBSTR(SQLERRM, 1, 255));

    RETURN SUBSTR(LV_MENSAJE, 1, 4000);

EXCEPTION
    WHEN OTHERS THEN
        RETURN NULL;
END FN_GET_GLOSA_ERROR;









/* Stored Procedure - Single result */
CREATE OR REPLACE PROCEDURE get_book_by_id(
    p_id IN BOOKS.ID%TYPE,
    o_name OUT BOOKS.NAME%TYPE,
    o_price OUT BOOKS.PRICE%TYPE)
AS
BEGIN

    SELECT NAME , PRICE INTO o_name, o_price from BOOKS WHERE ID = p_id;

END;

/* Stored Procedure - REF Cursor for result set */
CREATE OR REPLACE PROCEDURE get_book_by_name(
   p_name IN BOOKS.NAME%TYPE,
   o_c_book OUT SYS_REFCURSOR)
AS
BEGIN

  OPEN o_c_book FOR
  SELECT * FROM BOOKS WHERE NAME LIKE '%' || p_name || '%';

END;
