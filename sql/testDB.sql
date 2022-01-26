create database artezio_project; 
use artezio_project;
create table academic_groups(
group_id int auto_increment not null primary key,
name_group varchar(15) not null,
faculty varchar(45),
date_start year,
qt_year int
);
create table students(
student_id int auto_increment not null primary key,
surname varchar(45) not null,
name varchar(30) not null,
patronymic varchar(30),
age int,
group_id int,
phone varchar(11),
email varchar(100),
foreign key (group_id) references artezio_project.academic_groups(group_id) on delete cascade
);
insert into academic_groups
values(1, 'ПИМ-17', 'ФЕМиКН', 2017, 4),
       (2, 'ИСТ-17','ФЕМиКН', 2017, 4),
       (3, 'ПИМ-18', 'ФЕМиКН', 2018, 4),
       (4, 'ИСТ-18','ФЕМиКН', 2018, 4),
       (5, 'ИО-15','ФГН', 2015, 5),
       (6,'ИП-20','ФГН', 2020, 4),
       (7,'ИР-17','ФГН', 2017, 5),
       (8,'СП-16','ФПиП', 2016, 5),
       (9,'ФК-18','ФФКиС', 2018, 4),
       (10,'ФР-19','ФФКиС', 2019, 5);
insert into students
values(1,'Николаева','Марина','Анатольевна',20,3,'89469930267','nikolina@gmail.com'),
      (2,'Веселов','Андрей','Викторович',18,1,'89027746011','tester99@mail.ru'),
      (3,'Никитин','Евгений','Евгеньевич',26,3,'89548803716','potato54@gmail.com'),
      (4,'Степанова','Екатерина','Андреевна',21,5,'85600126732','stepanovakaty@mail.ru'),
      (5,'Углова','Ангелина','Николаевна',31,2,'82103285640','gelialina@outlook.com'),
      (6,'Шишкин','Сергей','Михайлович',18,8,'89046789182','0superman0@gmail.com'),
      (7,'Никитина','Елизавета','Семеновна',21,5,'84230489060','lizzzka123@mail.ru'),
      (8,'Краснов','Александр','Дмитриевич',24,10,'87653003861','krasnov.ad@gmail.com'),
      (9,'Гаврилов','Максим','Николаевич',18,3,'89087443021','gavr.max@mail.ru'),
      (10,'Иванова','Светлана','Игоревна',19,7,'89541014583','svetik007@mail.ru')