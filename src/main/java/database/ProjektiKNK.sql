create
database HospitalManagementSystem;
use
HospitalManagementSystem;
create table doctors
(
    doctor_id             int primary key auto_increment,
    doctor_firstName      nvarchar(100),
    doctor_lastName       nvarchar(100),
    doctor_birthdate      date,
    doctor_phone          nvarchar(100),
    doctor_email          nvarchar(100) not null,
    doctor_hashPassword   nvarchar(64) not null,
    doctor_salt           nvarchar(32) not null,
    doctor_address        nvarchar(150),
    doctor_department     nvarchar(100),
    doctor_specialization nvarchar(100),
    doctor_start          date,
    doctor_end            date,
    bankName              nvarchar(100),
    bankAccount           nvarchar(100),
    routingNumber         nvarchar(100)
);
create table receptionists
(
    receptionist_id             int primary key auto_increment,
    receptionist_firstName      nvarchar(100),
    receptionist_lastName       nvarchar(100),
    receptionist_birthdate      date,
    receptionist_phone          nvarchar(100),
    receptionist_email          nvarchar(100) not null,
    receptionist_hashPassword   nvarchar(64) not null,
    receptionist_salt           nvarchar(32) not null,
    receptionist_address        nvarchar(150),
    receptionist_department     nvarchar(100),
    receptionist_specialization nvarchar(100),
    receptionist_start          date,
    receptionist_end            date,
    bankName                    nvarchar(100),
    bankAccount                 nvarchar(100),
    routingNumber               nvarchar(100)
);
create table nurses
(
    nurse_id             int primary key auto_increment,
    nurse_firstName      nvarchar(100),
    nurse_lastName       nvarchar(100),
    nurse_birthdate      date,
    nurse_phone          nvarchar(100),
    nurse_email          nvarchar(100) not null,
    nurse_hashPassword   nvarchar(64) not null,
    nurse_salt           nvarchar(32) not null,
    nurse_address        nvarchar(150),
    nurse_department     nvarchar(100),
    nurse_specialization nvarchar(100),
    nurse_start          date,
    nurse_end            date,
    bankName             nvarchar(100),
    bankAccount          nvarchar(100),
    routingNumber        nvarchar(100)
);
create table accountants
(
    accountant_id             int primary key auto_increment,
    accountant_firstName      nvarchar(100),
    accountant_lastName       nvarchar(100),
    accountant_birthdate      date,
    accountant_phone          nvarchar(100),
    accountant_email          nvarchar(100) not null,
    accountant_hashPassword   nvarchar(64) not null,
    accountant_salt           nvarchar(32) not null,
    accountant_address        nvarchar(150),
    accountant_department     nvarchar(100),
    accountant_specialization nvarchar(100),
    accountant_start          date,
    accountant_end            date,
    bankName                  nvarchar(100),
    bankAccount               nvarchar(100),
    routingNumber             nvarchar(100)
);
create table department
(
    department_id          int primary key auto_increment,
    department_name        nvarchar(100),
    department_description text
);
select *
from doctors;
select *
from accountants;
select *
from receptionists;
select *
from nurses;
delete
from doctors;
delete
from accountants;
delete
from receptionists;
delete
from nurses;