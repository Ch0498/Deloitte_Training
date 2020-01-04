


SET Serveroutput ON

declare
hello varchar(20) := 'Hello World';

a number(5) := 45;

begin
dbms_output.put_line(hello);
a := a+5;
dbms_output.put_line(a);
end;

/
set serveroutput on


declare
    a number := 3;
    
begin
    a := a+1;
    if mod(a,2) = 0 then
        dbms_output.put_line(a);
    else
        dbms_output.put_line(a+1);
    end if;

end;

/

create table t1 (
    a number(5),
    b number(10)
);

declare
    i number := 1;
begin
    
    for i in 101..200 loop
    insert  into t1 values (i,i);
    end loop;

end;

/
    
select * from t1;

declare
    a number := 45;
    
begin
    while (a<50)
    loop
    a:=a+1;
    
    dbms_output.put_line(a);
    
    end loop;

    
end;
/

set serveroutput on size 1000000;

declare
    n_pct employees.commission_pct%type;
    v_eval varchar2(10);
    n_emp_id employees.employee_id%type := 145;
    
begin
    --get commission percentage
    
    select commission_pct
    into n_pct
    from employees
    where employee_id = n_emp_id;
    
    --evaluate commission percentage
    
    case n_pct
        when 0 then
            v_eval := 'N/A';
        when 0.1 then
            v_eval := 'Low';
        when 0.4 then
            v_eval := 'High';
        else
            v_eval := 'Fair';
    end case;
    --print commission evaluation
    
    dbms_output.put_line ('Employee ' || n_emp_id || 'Commission ' || to_char(n_pct) || 'which is ' || v_eval);
    end;
    /
    
    
select * from user1;

declare
    givenName user1.username%type := 'Govind';
    
begin
    dbms_output.put_line('The role of ' || givenName || 'is' || getRole(givenName));
end;
/

create or replace function getRole(givenName in user1.username%type)
return role.role_name%type is
roleName role.role_name%type;

begin
    select role_name into roleName from user1 join role using (role_id) where user1.username = givenName;

    return roleName;
end;
/



DELETE FROM EMPLOYEE_SALARY;
INSERT INTO EMPLOYEE_SALARY VALUES (2, 15000, 4000, 1000, 5000, 15000, 20000);
INSERT INTO EMPLOYEE_SALARY VALUES (1, 31000, 8000, 1000, 5000, 35000, 40000);
INSERT INTO EMPLOYEE_SALARY VALUES (3, 14000, 4000, 1000, 5000, 15000, 19000);
INSERT INTO EMPLOYEE_SALARY VALUES (4, 14000, 4000, 1000, 5000, 15000, 19000);
INSERT INTO EMPLOYEE_SALARY VALUES (5, 13000, 4000, 1000, 5000, 15000, 18000);

select * from employee_salary;

update employee_salary set emp_name = 'Mohit' where emp_no = 2;
update employee_salary set emp_name = 'Mukundh' where emp_no = 1;
update employee_salary set emp_name = 'Rohit' where emp_no = 3;
update employee_salary set emp_name = 'Purohit' where emp_no = 4;
update employee_salary set emp_name = 'Pandya' where emp_no = 5;

select * from employee_salary;



declare
begin
insert into employee_salary values (10, 53000, 4000, 3000, 5222, 8000, 3444, 'Sri');
declare
    ename employee_salary.emp_name%type := '&ename';
    tax_percent Number := 0;
    tax Number := 0;
    grossSal employee_salary.gross_salary%type := 0;
    
begin
    select gross_salary into grossSal from employee_salary where emp_name = ename;
    
    case
        when (grossSal>=15000 and grossSal<25000) then
            tax_percent := 5;
        when (grossSal>=25000 and grossSal<30000) then
            tax_percent := 10;
        when (grossSal>= 30000 and grossSal<35000) then
            tax_percent := 12;
    
    end case;

    tax := tax_percent*grossSal/100;
    dbms_output.put_line('Tax for ' || ename || ' is ' || tax);
    
end;
end;
/


SET SERVEROUTPUT ON SIZE 1000000;
DECLARE
  n_emp_id EMPLOYEES.EMPLOYEE_ID%TYPE := &emp_id1;
BEGIN
  DECLARE
    n_emp_id employees.employee_id%TYPE := &emp_id2;
    v_name   employees.first_name%TYPE;
  BEGIN
    SELECT first_name
    INTO v_name
    FROM employees
    WHERE employee_id = n_emp_id;
 
    DBMS_OUTPUT.PUT_LINE('First name of employee ' || n_emp_id || ' ' ||
                                       ' is ' || v_name);
    EXCEPTION
      WHEN no_data_found THEN
        DBMS_OUTPUT.PUT_LINE('Employee ' || n_emp_id || ' not found');
  END;
END;
/
SET SERVEROUTPUT ON SIZE 1000000;
<<parent>>
DECLARE
  n_emp_id EMPLOYEES.EMPLOYEE_ID%TYPE := &emp_id1;
BEGIN
  <<child>>
  DECLARE
    n_emp_id employees.employee_id%TYPE := &emp_id2;
    v_name   employees.first_name%TYPE;
  BEGIN
    SELECT first_name
    INTO v_name
    FROM employees
    WHERE employee_id = parent.n_emp_id;
 
    DBMS_OUTPUT.PUT_LINE('First name of employee ' || parent.n_emp_id || 
                         ' is ' || child.v_name);
 
    EXCEPTION
      WHEN no_data_found THEN
        DBMS_OUTPUT.PUT_LINE('Employee ' || parent.n_emp_id || ' not found');
  END;
END;
/

select * from employee_salary;

delete from employee_salary where emp_no = 10;

rollback;
select * from employee_salary;


-----------

set serveroutput on size 100000;
declare
    cursor cur_chief is
        select u.username, u.role_id, r.role_name from user1 u inner join role r on u.role_id = r.role_id;
        
    r_chief cur_chief%Rowtype;
    
Begin
    open cur_chief;
    loop
        fetch cur_chief into r_chief;
        exit when cur_chief %notfound;
        
        dbms_output.put_line(r_chief.username || '-' || r_chief.role_id || '-' || r_chief.role_name);
    end loop;
    close cur_chief;

end;
/

select * from user1;


delete from t1;

declare
    i number := 1;

begin
    loop
        insert into t1 values (i, i+1);
        i := i+1;
        exit when i>100;
    end loop;
end;
/

select * from t1;

----

--swapping values from col a to col b

update t1 set A = B, B = A;

select * from t1;






declare
    cursor cur_chief1 is
        select A, B from t1 where a<b;
        
    r_chief cur_chief1%Rowtype;
    
Begin
    open cur_chief1;
   
   
   update t1 set a=b, b=a;

   
    close cur_chief1;

end;
/

select * from t1;


--declare
--    cursor cur_chief is select a, b from t1 where a<b for update;
--    r_chief cur_chief%Rowtype;
--    temp t1.a%type;
--    
--begin
--    open cur_chief;
--    loop
--    fetch cur_chief into r_chief;
--    exit when cur_chief%Notfound;
--    temp := r_chief.a


--raise salary of employees to 10% of employees who joined after 2005.


declare
cursor cur_chief is select employee_id,first_name,salary,hire_date from employees where hire_date>TO_DATE('01-01-05');
r_chief cur_chief%ROWTYPE;
begin
OPEN cur_chief;
loop
fetch cur_chief into r_chief;
exit when cur_chief%NOTFOUND;
dbms_output.put_line(r_chief.first_name||q'['s]'||' updated salary is '||(r_chief.salary*0.5+r_chief.salary));

end loop;
end;
/

select * from employees;


-- the oldest employee is <last_name> , <first_name>

declare
    cursor cur_chief is select first_name, last_name, hire_date from  employees where hire_date < to_date('01-01-01');
    r_chief cur_chief%rowtype;

begin
    open cur_chief;
    
    loop
    fetch cur_chief into r_chief;
    exit when cur_chief%notfound;
     dbms_output.put_line('the oldest employee is: ' || r_chief.first_name || r_chief.last_name);
    
    end loop;
   
end;
/


select * from employees;

declare
cursor cur_chief is select last_name,first_name,hire_date from employees;
r_chief cur_chief%ROWTYPE;
oldDate employees.hire_date%TYPE:=sysdate;
first_name employees.first_name%TYPE;
last_name employees.last_name%TYPE;
begin
open cur_chief;
loop
fetch cur_chief into r_chief;
exit when cur_chief%NOTFOUND;
if r_chief.hire_date<oldDate
then
oldDate:=r_chief.hire_date;
first_name:=r_chief.first_name;
last_name:=r_chief.last_name;
end if;
end loop;
dbms_output.put_line(first_name||' '||last_name||' is the oldest employee hired on '||oldDate);
end;



--declare
--    oldest_birth_date date;
--    lname employees.last_name%type;
--    fname employees.first_name%type;
--    
--    cursor find_old_b_day is select min(birth_date) from employees;
--    
--    cursor id_employee is select last_name, first_name from employees where birth_date = oldest_birth_date; --multi cursors implementation
--    
--begin
--    open find_old_b_day;
--    fetch find_old_b_day into oldest_birth_day;
--    close find_old_b_day;
--    
--    open id_employee;
--    fetch id_employee into lname, fname;
--    close id_employee;
--    
--    dbms_output.put_line ('The Oldest Employee Is ' ||lname || ', ' ||fname);
--    
--    end;
--    /


set serveroutput on size 1000000;

Declare
    type t_name is record(
        first_name employees.first_name%type,
        last_name employees.last_name%type
    );
    
    r_name t_name; -- name record.
    
    n_emp_id employees.employee_id%type := 200;
    
Begin
    select first_name, last_name into r_name from employees where employee_id = n_emp_id;
    -- print out the employee's name
    
    dbms_output.put_line(r_name.first_name || ', ' || r_name.last_name );
    
End;
/


declare
cursor cur_chief is select u.username,r.role_name from user1 u join role r on u.role_id=r.role_id;
type t_users is record(
username user1.username%TYPE,
role_name role.role_name%TYPE
);
r_users t_users;
begin
open cur_chief;
loop
fetch cur_chief into r_users;
exit when cur_chief%NOTFOUND;
dbms_output.put_line(r_users.username||' - '||r_users.role_name);
end loop;
end;
/



set serveroutput on size 100000;


DECLARE
  emp_dept_id departments.department_id%TYPE;
 CURSOR curr_dept IS
  SELECT * 
  FROM departments
  WHERE manager_id IS NOT NULL
  ORDER BY department_name;
 CURSOR curr_emp IS
  SELECT * 
  FROM employees
  WHERE department_id = emp_dept_id;
  
BEGIN
    FOR r_dept IN curr_dept
    LOOP
      emp_dept_id := r_dept.department_id;
     
      DBMS_OUTPUT.PUT_LINE('Department Name : '||r_dept.department_name);
      
           FOR r_emp IN curr_emp 
           LOOP
             DBMS_OUTPUT.PUT_LINE('Employee: '||r_emp.last_name);
           END LOOP;   
    END LOOP;
END;
 /
 
 
 set serveroutput on size 100000;
 
 Declare
    type t_name is record (
        first_name employees.first_name%type,
        last_name employees.last_name%type
        );
        
        r_name t_name;
        r_name2 t_name;
        r_name_null t_name;
        n_emp_id employees.employee_id%type := 200;
        
Begin
    select first_name, last_name
    into r_name
    from employees
    where employee_id = n_emp_id;
    
    r_name2 := r_name;
    
    dbms_output.put_line(r_name2.first_name || ', ' || r_name2.last_name);
    
    r_name2 := r_name_null;
    
    if r_name2.first_name is null and r_name2.last_name is null then
    dbms_output.put_line ('Record r_name2 is null');
    end if;
    
end;
/

--composite type of type1 empid, name, salary type2 deptname and location


declare
    cursor cur_chief is select e.first_name, e.last_name, d.department_id,
    d.location_id from employees e join departments d on (e.department_id = d.department_id);
    type t_emp is record(
    first_name employees.first_name%type,
    last_name employees.last_name%type);

    type t_dept is record(
    dept_id departments.department_id%type,
    loc_id departments.location_id%type);

    type t_loc is record(
    dept t_dept, lname t_emp);
    r_loc t_loc;
    
begin
    open cur_chief;
    
    loop
    fetch cur_chief into r_loc.lname.first_name, r_loc.lname.last_name, r_loc.dept.dept_id, r_loc.dept.loc_id;
    exit when cur_chief%NOTFOUND;
    dbms_output.put_line(r_loc.lname.first_name||' - '||r_loc.lname.last_name||' - '||r_loc.dept.loc_id||' - '||r_loc.dept.dept_id);
    end loop;

end;
/

--exception handlers


set serveroutput on;

select * from user1;

declare
    userName user1.username%type;
    pswd user1.password%type;
    
begin
    select username into userName from user1 where password = pswd;
    
    dbms_output.put_line ('Username is ' || userName);
    
    exception
    
        when NO_DATA_FOUND then
            dbms_output.put_line ('Incorrect input');
            
        when TOO_MANY_ROWS then
            dbms_output.put_line ('Excess of rows could be fetched!');
            
end;
/



declare
    max_limit_ended exception;
    pragma exception_init ( max_limit_ended, -20002 );
    uname user1.username%type := 'Mohit';
    pswd user1.password%type := 56242;
    
begin
    
    
    if length(pswd) < 4 then 
        raise_application_error(-20002, 'Length of password is upto 4 characters');
        
    else
        dbms_output.put_line('Code executed by luck :|');
    
    end if;
 
 
    
    
end;
/


declare
    
    salary_limit_too_high exception;
    pragma exception_init ( salary_limit_too_high, -20022);
    empid employees.employee_id%type := &employee_id;
    empname employees.last_name%type;
    max_sal employees.salary%type;
    min_sal employees.salary%type;
    sal employees.salary%type := &salary;
    
begin

    select max(salary),min(salary) into max_sal, min_sal from employees;
    
    dbms_output.put_line( 'Maximum salary is ' || max_sal);
    dbms_output.put_line( 'Minimum salary is ' || min_sal);
    
    if sal > max_sal or sal < min_sal then
        raise salary_limit_too_high;
    else
        update employees set salary = sal where employee_id = empid;
    
        dbms_output.put_line ( 'The updated salary is ' || sal);
    
    end if;
    
    exception
       when salary_limit_too_high then
        dbms_output.put_line ( 'Limit of updating salary must be either > than ' || min_sal || ' or < than ' || max_sal);
    
end;
/

select * from employees where employee_id = 105;
rollback;

--procedures

Create or Replace
Procedure Hello is
Begin
    dbms_output.put_line('Hello World');
End;

/
call Hello();

create or replace
procedure dispn (n int) is
begin
    dbms_output.put_line ('N is ' || N);
end;
/

create or replace procedure 
square (x int) is
begin
    dbms_output.put_line ('Square of x is ' || x*x);
end;
/

declare
    num int := &num;
    
begin
    square(num);
    
end;
/

create or replace procedure
enterId(empid employees.employee_id%type) is

empname employees.last_name%type;
empsal employees.salary%type;

begin

select last_name, salary into empname, empsal from employees where employee_id = empid;

dbms_output.put_line(empname || q'['s salary is]' || empsal);

end;
/

declare
empid employees.employee_id%type := &id;

begin
enterId(empid);

end;
/

--Procedure 'OUT' through which we can return a value


create or replace
procedure sum_ab (a int, b int, c out int) is
begin
    c:= a+b;
    
end;
/

declare
r int;

begin
    sum_ab(425,525, r);
    dbms_output.put_line('sum is: ' || r);
end;
/


create or replace
procedure enterName(emp_id employees.employee_id%TYPE, empname out employees.first_name%TYPE) is
begin
select first_name || ' ' || last_name into empname from employees where employee_id = emp_id;
end;
/

declare
empname employees.first_name%TYPE;
emp_id employees.employee_id%TYPE:=&id;
begin
enterName(emp_id,empname);
dbms_output.put_line(empname);
end;
/


create or replace
procedure showSal(emp_name employees.first_name%type, empsal out employees.salary%type) is
begin
select salary into empsal from employees where first_name = emp_name;
end;
/

declare
emp_name employees.first_name%type := '&firstname';
empsal employees.salary%type;

begin
showSal(emp_name, empsal);
dbms_output.put_line(empsal);
end;
/


create or replace
function add_two (a int, b int) return int is
begin
return (a+b);
end;
/

begin
dbms_output.put_line (add_two(2,5));
end;
/


create or replace
function increSal (emp_id employees.employee_id%type, x int) return employees.salary%type is
m_sal employees.salary%type;
begin
select salary into m_sal from employees where employee_id = emp_id;
return m_sal+(m_sal*x/100);
end;
/


declare
begin
dbms_output.put_line(Incresal(183,12));
end;
/


create or replace
function sumSal return employees.salary%type is

sum_sal employees.salary%type;

begin
select sum(salary) into sum_sal from employees where department_id = 50;
return sum_sal;
end;
/

begin
dbms_output.put_line(sumSal());
end;
/

create or replace trigger nameChange
before update of first_name, last_name on employees for each row
declare
begin
dbms_output.put_line('Employee names cannot be updated');
end;
/

update employees set first_name = 'Albert' where employee_id = 121;

rollback;

CREATE TABLE audits (
      audit_id         NUMBER(12),
      table_name       VARCHAR2(255),
      transaction_name VARCHAR2(10),
      by_user          VARCHAR2(30),
      transaction_date DATE
);

CREATE OR REPLACE TRIGGER customers_audit_trg
    AFTER 
    UPDATE OR DELETE 
    ON audits
    FOR EACH ROW    
DECLARE
   l_transaction VARCHAR2(10);
BEGIN
   -- determine the transaction type
   l_transaction := CASE  
         WHEN UPDATING THEN 'UPDATE'
         WHEN DELETING THEN 'DELETE'
   END;
 
   -- insert a row into the audit table   
   INSERT INTO audits (table_name, transaction_name, by_user, transaction_date)
   VALUES('CUSTOMERS', l_transaction, USER, SYSDATE);
END;
/


select * from audits;

insert into audits values (101, 'audit1', 'dr', 'mahesh', to_date('01-01-03'));

desc audits;

rollback;

create table audits (
    audit_id NUMBER PRIMARY KEY,
    table_name VARCHAR2(255),
    transaction_name VARCHAR2(10),
    by_user VARCHAR2(30),
    transaction_date DATE
);

create or replace trigger users_audit_trg
after 
update or delete
on  user1 
for each row
declare
l_transaction VARCHAR2(10);
begin
l_transaction:=CASE
when updating then 'UPDATE'
when deleting then 'DELETE'
end;
insert into audits(audit_id,table_name,transaction_name,by_user,transaction_date) values(ROLE_ROLE_ID_SEQ3.nextval,'USER1',l_transaction,USER,sysdate);
end;
/

create sequence role_role_id_seq3 increment by 1 start with 101 maxvalue 1100 nocache nocycle;


update user1 set username = 'Hasan' where user_id = 1002;
select * from audits;

--create or replace package personnel as 
--function get_fullname (n_emp_id number)
--return varchar2;
--
--function get_salary(n_emp_id

create or REPLACE PACKAGE personnel AS
  -- get employee's fullname
  FUNCTION get_fullname(n_emp_id NUMBER)
    RETURN VARCHAR2;
  -- get employee's salary
  FUNCTION get_salary(n_emp_id NUMBER)
    RETURN NUMBER;
END personnel;


CREATE OR REPLACE PACKAGE BODY personnel AS
  -- get employee's fullname
  FUNCTION get_fullname(n_emp_id NUMBER) RETURN VARCHAR2 IS
      v_fullname VARCHAR2(46);
  BEGIN
    SELECT first_name || ',' ||  last_name
    INTO v_fullname
    FROM employees
    WHERE employee_id = n_emp_id;
 
    RETURN v_fullname;
 
  EXCEPTION
  WHEN NO_DATA_FOUND THEN
    RETURN NULL;
  WHEN TOO_MANY_ROWS THEN
    RETURN NULL;
  END; -- end get_fullname
 
  -- get salary
  FUNCTION get_salary(n_emp_id NUMBER) RETURN NUMBER IS
    n_salary NUMBER(8,2);
  BEGIN
    SELECT salary
    INTO n_salary
    FROM employees
    WHERE employee_id = n_emp_id;
 
    RETURN n_salary;
 
    EXCEPTION
      WHEN NO_DATA_FOUND THEN
        RETURN NULL;
      WHEN TOO_MANY_ROWS THEN
        RETURN NULL;
  END;
END personnel;