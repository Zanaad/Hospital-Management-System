create
database HospitalManagementSystem;
use
HospitalManagementSystem;
create table admin
(
    id           int primary key auto_increment,
    firstName    nvarchar(100),
    lastName     nvarchar(100),
    email        nvarchar(100),
    address      nvarchar(100),
    passwordHash nvarchar(64),
    salt         nvarchar(32)
);
insert into admins (firstName, lastName)
values ("Zana", "Ademi"),
       ("Fatjeta", "Gashi"),
       ("Adea", "Lluhani"),
       ("Adea", "Tabaku"),
       ("Yllka", "Kastrati");
select *
from admins;
create table doctors
(
    doctor_id           int primary key auto_increment,
    doctor_firstName    nvarchar(100),
    doctor_lastName     nvarchar(100),
    doctor_birthdate    date,
    doctor_phone        nvarchar(100),
    doctor_email        nvarchar(100) not null,
    doctor_hashPassword nvarchar(64) not null,
    doctor_salt         nvarchar(32) not null,
    doctor_address      nvarchar(150),
    doctor_department   nvarchar(100),
    doctor_university   nvarchar(100),
    doctor_start        date,
    doctor_end          date,
    bankName            nvarchar(100),
    bankAccount         nvarchar(100),
    routingNumber       nvarchar(100)
);
create table receptionists
(
    receptionist_id           int primary key auto_increment,
    receptionist_firstName    nvarchar(100),
    receptionist_lastName     nvarchar(100),
    receptionist_birthdate    date,
    receptionist_phone        nvarchar(100),
    receptionist_email        nvarchar(100) not null,
    receptionist_hashPassword nvarchar(64) not null,
    receptionist_salt         nvarchar(32) not null,
    receptionist_address      nvarchar(150),
    receptionist_department   nvarchar(100),
    receptionist_university   nvarchar(100),
    receptionist_start        date,
    receptionist_end          date,
    bankName                  nvarchar(100),
    bankAccount               nvarchar(100),
    routingNumber             nvarchar(100)
);
create table nurses
(
    nurse_id           int primary key auto_increment,
    nurse_firstName    nvarchar(100),
    nurse_lastName     nvarchar(100),
    nurse_birthdate    date,
    nurse_phone        nvarchar(100),
    nurse_email        nvarchar(100) not null,
    nurse_hashPassword nvarchar(64) not null,
    nurse_salt         nvarchar(32) not null,
    nurse_address      nvarchar(150),
    nurse_department   nvarchar(100),
    nurse_university   nvarchar(100),
    nurse_start        date,
    nurse_end          date,
    bankName           nvarchar(100),
    bankAccount        nvarchar(100),
    routingNumber      nvarchar(100)
);

create table department
(
    department_id          int primary key auto_increment,
    department_name        nvarchar(100),
    department_description text
);

create table patients
(
    patient_id        int primary key auto_increment,
    patient_firstName nvarchar(100),
    patient_lastName  nvarchar(100),
    patient_birthdate date,
    patient_phone     nvarchar(100),
    patient_email     nvarchar(100) not null,
    patient_address   nvarchar(150),
    patient_status    nvarchar(100),
    patient_action    nvarchar(100)

);

CREATE TABLE Operation
(
    OperationID INTEGER PRIMARY KEY AUTO_INCREMENT,
    Description TEXT NOT NULL,
    Patient     TEXT NOT NULL,
    Doctor      TEXT NOT NULL,
    Date        TEXT NOT NULL,
    Time        TEXT NOT NULL
);



select *
from doctors;
select *
from accountants;
select *
from receptionists;
select *
from nurses;
select *
from departments;
select *
from patients;
