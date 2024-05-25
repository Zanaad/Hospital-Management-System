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
    hashPassword nvarchar(64),
    salt         nvarchar(32)
);

insert into admin (firstName, lastName, email)
values ("Zana", "Ademi", "zana@gmail.com"),
       ("Fatjeta", "Gashi", "fatjeta@gmail.com"),
       ("Adea", "Lluhani", "adea@gmail.com"),
       ("Adea", "Tabaku", "adeat@gmail.com"),
       ("Yllka", "Kastrati", "yllka@gmail.com");
select *
from admin;
drop table admin;
create table doctors
(
    id            nvarchar(100) primary key,
    firstName     nvarchar(100),
    lastName      nvarchar(100),
    birthdate     date,
    phone         nvarchar(100),
    email         nvarchar(100) not null,
    hashPassword  nvarchar(64) not null,
    salt          nvarchar(32) not null,
    address       nvarchar(150),
    department    nvarchar(100),
    university    nvarchar(100),
    contractStart date,
    contractEnd   date,
    bankName      nvarchar(100),
    bankAccount   nvarchar(100),
    routingNumber nvarchar(100)
);
create table receptionists
(
    id            nvarchar(100) primary key,
    firstName     nvarchar(100),
    lastName      nvarchar(100),
    birthdate     date,
    phone         nvarchar(100),
    email         nvarchar(100) not null,
    hashPassword  nvarchar(64) not null,
    salt          nvarchar(32) not null,
    address       nvarchar(150),
    department    nvarchar(100),
    university    nvarchar(100),
    contractStart date,
    contractEnd   date,
    bankName      nvarchar(100),
    bankAccount   nvarchar(100),
    routingNumber nvarchar(100)
);
create table nurses
(
    id            nvarchar(100) primary key,
    firstName     nvarchar(100),
    lastName      nvarchar(100),
    birthdate     date,
    phone         nvarchar(100),
    email         nvarchar(100) not null,
    hashPassword  nvarchar(64) not null,
    salt          nvarchar(32) not null,
    address       nvarchar(150),
    department    nvarchar(100),
    university    nvarchar(100),
    contractStart date,
    contractEnd   date,
    bankName      nvarchar(100),
    bankAccount   nvarchar(100),
    routingNumber nvarchar(100)
);
insert into nurses(firstName,lastName,email) values ("Dara","Tabaku","dara@gmail.com");
create table departments
(
    department_id          nvarchar(100) primary key,
    department_name        nvarchar(100),
    department_description text,
    nrDoctors              int,
    nrNurses               int
);

select *
from departments;
create table patients
(
    patient_id         int primary key auto_increment,
    patient_firstName  nvarchar(100),
    patient_lastName   nvarchar(100),
    patient_birthdate  date,
    patient_phone      nvarchar(100),
    patient_email      nvarchar(100) not null,
    patient_address    nvarchar(150),
    patient_department nvarchar(100),
    patient_doctor     nvarchar(100),
    patient_nurse      nvarchar(100),
    patient_date       date,
    patient_payment    nvarchar(100)
);
select *
from doctors;
create table appointments
(
    appointment_id          nvarchar(100),
    appointment_firstName   nvarchar(100),
    appointment_lastName    nvarchar(100),
    appointment_description nvarchar(100),
    appointment_department  nvarchar(100),
    appointment_doctor      nvarchar(100),
    appointment_nurse       nvarchar(100),
    appointment_phone       nvarchar(100),
    appointment_address     nvarchar(100),
    appointment_date        date,
    appointment_hour        nvarchar(100)

);

create table operations
(
    operationID   int primary key auto_increment,
    opDescription nvarchar(100),
    opPatient     nvarchar(100),
    opDoctor      nvarchar(100),
    opDate        date,
    opTime        nvarchar(100)
);

create table births
(
    birthID           int primary key auto_increment,
    birth_description nvarchar(100),
    birth_patient     nvarchar(100),
    birth_newborn     nvarchar(100),
    birth_date        date,
    birth_time        nvarchar(100)
);

create table deaths
(
    deathID           int primary key auto_increment,
    death_description nvarchar(100),
    death_patient     nvarchar(100),
    death_date        date,
    death_time        nvarchar(100)
);

create table others
(
    other_ID          int primary key auto_increment,
    other_description nvarchar(100),
    other_patient     nvarchar(100),
    other_date        date,
    other_time        nvarchar(100)
);

create table donors
(
    donor_ID           int primary key auto_increment,
    donor_patient      nvarchar(100),
    donor_bloodGroup   nvarchar(100),
    donor_age          nvarchar(100),
    donor_gender       nvarchar(100),
    donor_lastDonation date
);

create table beds
(
    bed_ID           int primary key auto_increment,
    bed_patient      nvarchar(100),
    bed_number   nvarchar(100)
);
select * from beds;
drop table donors;
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

SELECT DATE (patient_date) AS patient_date, COUNT (patient_id) AS patient_count
FROM patients
GROUP BY DATE (patient_date)
ORDER BY DATE (patient_date) ASC;


//table doktors

create table pacienti(
PID integer,
emri nvarchar(25),
mbiemri nvarchar(25),
gjinia nvarchar(25),
mosha integer,
ditelindja nvarchar(30),
nrtel integer,
adresa nvarchar(24),
dataeshtrirjes nvarchar(20),
dataelirimit nvarchar(20),
diagnoza  nvarchar(25),
tretmani nvarchar(25),
pershkrimi nvarchar(20),
pagesa integer
);

create table doktori(
ID integer,
emri nvarchar(25),
mbiemri nvarchar(25),
adresa nvarchar(25),
nrtel integer,
specializimi nvarchar(24)
);

create table takimet(
ID integer,
emri nvarchar(25),
mbiemri nvarchar(25),
gjinia nvarchar(25),
mosha integer,
adresa nvarchar(24),
datae nvarchar(20)
);
