create database empdb;

use empdb;

create table tblemployee(
                    empId integer AUTO_INCREMENT primary key,
                    empName varchar(64),
                    dob date,
                    designation varchar(64)
);

insert into  tblemployee(empId,empName,dob,designation) values (default,'Adam','1998-08-15','Manager');
insert into  tblemployee(empId,empName,dob,designation) values (default,'Smith','2001-01-11','Clerk');
insert into  tblemployee(empId,empName,dob,designation) values (default,'James','1996-03-13','Officer');

select * from tblemployee;
