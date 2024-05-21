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

create table departments
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
    patient_department nvarchar(100),
    patient_doctor    nvarchar(100),
    patient_nurse    nvarchar(100)
    patient_date     date,
    patient_payment   int

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
    patient_department nvarchar(100),
    patient_doctor    nvarchar(100),
    patient_nurse    nvarchar(100)
    patient_date     date,
    patient_payment   int

);
create table appointments
(
    appointment_id        nvarchar(100),
    appointment_firstName nvarchar(100),
    appointment_lastName  nvarchar(100),
    appointment_description nvarchar(100),
    appointment_department nvarchar(100),
    appointment_doctor    nvarchar(100),
    appointment_nurse     nvarchar(100),
    appointment_phone     nvarchar(100),
    appointment_address   nvarchar(100),
    appointment_date          date,
    appointment_hour      nvarchar(100)

);


create table operations (
    operationID              int primary key auto_increment,
    opDescription            nvarchar(100),
    opPatient                nvarchar(100),
    opDoctor                 nvarchar(100),
    opDate                   date,
    opTime                   nvarchar(100)
);

create table births (
    birthID                 int primary key auto_increment,
    birth_description       nvarchar(100),
    birth_patient           nvarchar(100),
    birth_newborn           nvarchar(100),
    birth_date              date,
    birth_time              nvarchar(100)
);

create table deaths (
    deathID                 int primary key auto_increment,
    death_description       nvarchar(100),
    death_patient           nvarchar(100),
    death_date              date,
    death_time              nvarchar(100)
);

create table others (
    other_ID                int primary key auto_increment,
    other_description       nvarchar(100),
    other_patient           nvarchar(100),
    other_date              date,
    other_time              nvarchar(100)
);

create table donors (
    donor_ID                int primary key auto_increment,
    donor_bloodGroup        nvarchar(100),
    donor_age               nvarchar(100),
    donor_gender            nvarchar(100),
    donor_lastDonation      date
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
select *
from births;
select *
from deaths;
select *
from others;
select *
from donors;
