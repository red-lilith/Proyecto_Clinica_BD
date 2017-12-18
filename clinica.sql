----sql -> clinica.sql
----Integrantes: 
--Diana​ Garcia​ ​- 	1531722
--David​ Crespo​ - 	​1623100
--Sebastián​ Afanador​ - 	1629587
--Daniel​ Bueno​ ​- 	1530678

----------------------------[CONFIGURACION]--------------------------
set datestyle = dmy;

----------------------------[ AREA ]---------------------------
drop table if exists area cascade;
create table area 

(
cod_area integer not null primary key,
nom_area varchar(30),
descrip_area varchar(200)
);


-----------------------[ CAMA ]--------------------------------
drop sequence if exists num_cama_seq cascade;
drop table if exists cama cascade;

create sequence num_cama_seq increment 10 start 1000;
create table cama

(
num_cama integer not null default nextval('num_cama_seq'::regclass)primary key,
descripcion_cama varchar not null,
cod_area integer not null,
estado varchar(30) not null,

constraint cod_area_fk foreign key (cod_area) references area(cod_area)
);

-------------------------[ PERSONA ]------------------------------
drop table if exists persona cascade;
create table persona

(
id_persona integer not null primary key,
nom_persona varchar (30) not null,
dir_persona varchar (30) not null,
tel_persona varchar (30) not null
);


-------------------------[ EMPLEADO ]------------------------------
drop table if exists empleado cascade;
create table empleado

(
id_empleado integer not null primary key,
cargo_empleado varchar (30) not null,
salario_empleado integer not null,
email_empleado varchar (30) not null,
cod_area integer not null,
id_jefe integer not null,
usuario_empleado varchar (20) not null,
contrasena_empleado varchar (30) not null,

constraint id_empleado_fk foreign key (id_empleado) references persona(id_persona),
constraint cod_area_fk foreign key (cod_area) references area(cod_area),
constraint id_jefe_fk foreign key (id_jefe) references empleado(id_empleado)
);

--------------------------[ MEDICO ]-----------------------------
drop table if exists medico cascade;
create table medico

(
id_medico integer not null primary key,
especial_medico varchar(40) not null,
num_licencia_medico varchar(16) not null,
univ_medico varchar (30) not null,

constraint id_medico_fk foreign key (id_medico) references empleado(id_empleado)
);

---------------------------[ ENFERMERA ]----------------------------
drop table if exists enfermera cascade;
create table enfermera

(
id_enfermera integer not null primary key,
experiencia integer not null,

constraint id_enfermera_fk foreign key (id_enfermera) references empleado(id_empleado)
);

    
--------------------------[ HABILIDADES_ENFERMERA ]-----------------------------
drop table if exists habilidades_enfermera cascade;
create table habilidades_enfermera

(
habilidad varchar (40) not null,
id_enfermera integer not null,

constraint id_enfermera_fk foreign key (id_enfermera) references enfermera(id_enfermera),
primary key(habilidad,id_enfermera)
);

--------------------------[ PACIENTE ]-----------------------------
drop table if exists paciente cascade;
create table paciente

(
id_paciente integer not null primary key,
num_ss_paciente varchar(10) not null,
fecha_nacim_paciente date not null,
act_econom_paciente varchar(40) not null,
    
constraint id_paciente_fk foreign key (id_paciente) references persona(id_persona)
);
-------------------------[ HISTORIA_CLINICA ]------------------------------
drop table if exists historia_clinica cascade;
drop sequence if exists historia_clinica_seq;

create sequence historia_clinica_seq increment 10 start 1000;
create table historia_clinica

(
serial_hist_clin integer not null default nextval('historia_clinica_seq'::regclass) primary key,
id_paciente integer not null,
fecha_apertura date not null,

constraint id_paciente_fk foreign key (id_paciente) references paciente(id_paciente)
);

-----------------------[ CITA ]--------------------------------
drop table if exists cita cascade;
create table cita

(
id_paciente integer not null,
fecha_cita date not null,
hora_cita time not null,
id_medico integer not null,
precio_cita integer not null,

constraint id_paciente_fk foreign key (id_paciente) references paciente(id_paciente),
constraint id_medico_fk foreign key (id_medico) references medico(id_medico),
primary key(id_paciente, fecha_cita, hora_cita, id_medico)
);

------------------------[ MEDICAMENTOS ]-------------------------------
drop table if exists medicamento cascade;
drop sequence if exists medicamento_seq;

create sequence medicamento_seq increment 10 start 1000;
create table medicamento

(
cod_medicam integer not null default nextval('medicamento_seq'::regclass) primary key,
nom_medicam varchar(30) not null,
descrip_medicam varchar(40) not null,
costo_medicam integer not null
);

-------------------------[ FORMULA ]------------------------------
drop table if exists formula cascade;
drop sequence if exists formula_seq;

create sequence formula_seq increment 10 start 1000;
create table formula

(
cod_formula integer not null default nextval('formula_seq'::regclass) primary key,
id_medico integer not null,

constraint id_medico_fk foreign key (id_medico) references medico(id_medico)
);


--------------------------[ REGISTRO CONSULTA ]-----------------------------
drop table if exists registro_consulta cascade;
drop sequence if exists registro_consulta_seq;

create sequence registro_consulta_seq increment 10 start 1000;
create table registro_consulta

(
cod_consulta integer not null default nextval('registro_consulta_seq'::regclass),
serial_hist_clin integer not null,
fecha_consulta date not null,
id_medico integer not null,
cod_formula integer,
precio_consulta integer,

constraint id_medico_fk foreign key (id_medico) references medico(id_medico),
constraint serial_hist_clin_fk foreign key (serial_hist_clin) references historia_clinica(serial_hist_clin),
constraint cod_formula_fk foreign key (cod_formula) references formula(cod_formula),
primary key(cod_consulta, serial_hist_clin)
);


--------------------------[ CAUSA ]-----------------------------
drop table if exists causa cascade;
drop sequence if exists causa_seq;

create sequence causa_seq increment 10 start 1000;
create table causa

(
cod_causa integer not null default nextval('causa_seq'::regclass) primary key,
nom_causa varchar(30) not null,
descrip_causa varchar (50) not null
);

-------------------------[ CAUSAS_CONSULTA ]------------------------------
drop table if exists causas_consulta cascade;

create table causas_consulta

(
cod_causa integer not null,
cod_consulta integer not null,

constraint cod_causa_fk foreign key (cod_causa) references causa(cod_causa),
primary key(cod_causa, cod_consulta)
);


------------------------[ FORMULACION_MEDICAMENTO ]-------------------------------
drop table if exists formulacion_medicamento cascade;
create table formulacion_medicamento

(
cod_formula integer not null,
cod_medicam integer not null,
dosis varchar(20) not null,

constraint id_formula_fk foreign key (cod_formula) references formula(cod_formula),
constraint cod_medicam_fk foreign key (cod_medicam) references medicamento(cod_medicam),
primary key(cod_formula, cod_medicam)
);

--------------------------[ ASIGNACION_CAMAS ]-----------------------------
drop table if exists asignacion_camas cascade;

create table asignacion_camas

(
id_paciente integer not null,
num_cama integer not null,
fecha_asignacion date not null,
fecha_salida date,

constraint id_paciente_fk foreign key (id_paciente) references paciente(id_paciente),
constraint num_cama_fk foreign key (num_cama) references cama(num_cama),
primary key(id_paciente, num_cama,fecha_asignacion)
);
--------------------------[ CAMPAÑA_PREVENCION ]-----------------------------
drop table if exists campana_prevencion cascade;
drop sequence if exists campana_prevencion_seq;

create sequence campana_prevencion_seq increment 10 start 1000;
create table campana_prevencion

(
cod_campana integer not null default nextval('campana_prevencion_seq'::regclass) primary key,
nom_campana varchar(30) not null,
objet_campana varchar(40) not null,
fecha_campana date not null,
id_medico integer not null,

constraint id_medico_fk foreign key (id_medico) references medico(id_medico)
);
--------------------------[ ASISTENCIA_CAMPAÑAS ]-----------------------------
drop table if exists asistencia_campanas cascade;

create table asistencia_campanas

(
cod_campana integer not null,
id_paciente integer not null,

constraint id_paciente_fk foreign key (id_paciente) references paciente(id_paciente),
constraint cod_campana_fk foreign key (cod_campana) references campana_prevencion(cod_campana),
primary key(cod_campana, id_paciente)
);


---------------------------------[ INSERTS ]------------------------------
insert into area values (0, 'Administrativa', 'Admin');
insert into area values (1, 'Cirugía', 'Se encarga de hacer cirugías a los pacientes');
insert into area values (2, 'Radiología', 'Se encarga de realizar las radiografías a los pacientes');
insert into area values (3, 'Emergencias', 'Atención prioritaria a pacientes en condiciones crónicas que deban ser atendidas inmediatamente');

--------------------------------------------------------------------------------------------------------------------------

insert into persona values (10000000, 'Admin', 'direccion admin', '0000000000'); 

insert into persona values (89045200, 'Medico 00', 'direccion medico 00', '3152156100'); 
insert into persona values (89045201, 'Medico 01', 'direccion medico 01', '3152156101'); 
insert into persona values (89045202, 'Medico 02', 'direccion medico 02', '3152156102'); 
insert into persona values (89045203, 'Medico 03', 'direccion medico 03', '3152156103');
insert into persona values (89045204, 'Medico 04', 'direccion medico 03', '3152156104');
insert into persona values (89045205, 'Medico 05', 'direccion medico 05', '3152156105');
insert into persona values (89045206, 'Medico 06', 'direccion medico 06', '3152156106');
insert into persona values (89045207, 'Medico 07', 'direccion medico 07', '3152156107');
insert into persona values (89045208, 'Medico 08', 'direccion medico 08', '3152156108');

insert into persona values (6788900, 'Enfermera 00', 'direccion enfermera 00', '3208906700');
insert into persona values (6788901, 'Enfermera 01', 'direccion enfermera 01', '3208906701');
insert into persona values (6788902, 'Enfermera 02', 'direccion enfermera 02', '3208906702');
insert into persona values (6788903, 'Enfermera 03', 'direccion enfermera 03', '3208906703');
insert into persona values (6788904, 'Enfermera 04', 'direccion enfermera 04', '3208906704');
insert into persona values (6788905, 'Enfermera 05', 'direccion enfermera 05', '3208906705');
insert into persona values (6788906, 'Enfermera 06', 'direccion enfermera 06', '3208906706');
insert into persona values (6788907, 'Enfermera 07', 'direccion enfermera 07', '3208906707');
insert into persona values (6788908, 'Enfermera 08', 'direccion enfermera 08', '3208906708');

insert into persona values (90833200, 'Paciente 00', 'direccion paciente00', '3016788900');
insert into persona values (90833201, 'Paciente 01', 'direccion paciente01', '3016788901');
insert into persona values (90833202, 'Paciente 02', 'direccion paciente02', '3016788902');
insert into persona values (90833203, 'Paciente 03', 'direccion paciente03', '3016788903');
insert into persona values (90833204, 'Paciente 04', 'direccion paciente04', '3016788904');
insert into persona values (90833205, 'Paciente 05', 'direccion paciente05', '3016788905');
insert into persona values (90833206, 'Paciente 06', 'direccion paciente06', '3016788906');
insert into persona values (90833207, 'Paciente 07', 'direccion paciente07', '3016788907');
insert into persona values (90833208, 'Paciente 08', 'direccion paciente08', '3016788908');
insert into persona values (90833209, 'Paciente 09', 'direccion paciente09', '3016788909');
insert into persona values (90833210, 'Paciente 10', 'direccion paciente10', '3016788910');
insert into persona values (90833211, 'Paciente 11', 'direccion paciente11', '3016788911');

--------------------------------------------------------------------------------------------------------------------------
insert into empleado values (10000000, 'Admin', 1000000, 'admin@gmail.com', 0, 10000000, 'admin', '123');

insert into empleado values (89045200, 'Médico', 9000000, 'medico00@gmail.com', 1, 89045200, 'medico00', 'medico00');
insert into empleado values (89045201, 'Médico', 9000000, 'medico01@gmail.com', 1, 89045200, 'medico01', 'medico01');
insert into empleado values (89045202, 'Médico', 9000000, 'medico02@gmail.com', 1, 89045200, 'medico02', 'medico02');
insert into empleado values (89045203, 'Médico', 9000000, 'medico03@gmail.com', 2, 89045203, 'medico03', 'medico03');
insert into empleado values (89045204, 'Médico', 9000000, 'medico04@gmail.com', 2, 89045203, 'medico04', 'medico04');
insert into empleado values (89045205, 'Médico', 9000000, 'medico05@gmail.com', 2, 89045203, 'medico05', 'medico05');
insert into empleado values (89045206, 'Médico', 9000000, 'medico06@gmail.com', 3, 89045206, 'medico06', 'medico06');
insert into empleado values (89045207, 'Médico', 9000000, 'medico07@gmail.com', 3, 89045206, 'medico07', 'medico07');
insert into empleado values (89045208, 'Médico', 9000000, 'medico08@gmail.com', 3, 89045206, 'medico08', 'medico08');

insert into empleado values (6788900, 'Enfermera', 3000000, 'enfermera00@gmail.com', 1, 6788900, 'enfermera00', 'enfermera00');
insert into empleado values (6788901, 'Enfermera', 3000000, 'enfermera01@gmail.com', 1, 6788900, 'enfermera01', 'enfermera01');
insert into empleado values (6788902, 'Enfermera', 3000000, 'enfermera02@gmail.com', 1, 6788900, 'enfermera02', 'enfermera02');
insert into empleado values (6788903, 'Enfermera', 3000000, 'enfermera03@gmail.com', 2, 6788903, 'enfermera03', 'enfermera03');
insert into empleado values (6788904, 'Enfermera', 3000000, 'enfermera04@gmail.com', 2, 6788903, 'enfermera04', 'enfermera04');
insert into empleado values (6788905, 'Enfermera', 3000000, 'enfermera05@gmail.com', 2, 6788903, 'enfermera05', 'enfermera05');
insert into empleado values (6788906, 'Enfermera', 3000000, 'enfermera06@gmail.com', 3, 6788906, 'enfermera06', 'enfermera06');
insert into empleado values (6788907, 'Enfermera', 3000000, 'enfermera07@gmail.com', 3, 6788906, 'enfermera07', 'enfermera07');
insert into empleado values (6788908, 'Enfermera', 3000000, 'enfermera08@gmail.com', 3, 6788906, 'enfermera08', 'enfermera08');

----------------------------------------------------------------------------------------------------------------------------
insert into medico values (89045200, 'Especialidad Medica 00', '23498756100', 'Universidad del Valle');
insert into medico values (89045201, 'Especialidad Medica 00', '23498756101', 'Universidad del Valle');
insert into medico values (89045202, 'Especialidad Medica 01', '23498756102', 'Universidad del Valle');
insert into medico values (89045203, 'Especialidad Medica 01', '23498756103', 'Universidad del Valle');
insert into medico values (89045204, 'Especialidad Medica 02', '23498756104', 'Universidad del Valle');
insert into medico values (89045205, 'Especialidad Medica 02', '23498756105', 'Universidad del Valle');
insert into medico values (89045206, 'Especialidad Medica 03', '23498756106', 'Universidad del Valle');
insert into medico values (89045207, 'Especialidad Medica 03', '23498756107', 'Universidad del Valle');

insert into enfermera values (6788900, 20);
insert into enfermera values (6788901, 03);
insert into enfermera values (6788902, 04);
insert into enfermera values (6788903, 15);
insert into enfermera values (6788904, 06);
insert into enfermera values (6788905, 07);
insert into enfermera values (6788906, 19);
insert into enfermera values (6788907, 04);
insert into enfermera values (6788908, 02);

insert into habilidades_enfermera values('Administracion', 6788900);
insert into habilidades_enfermera values('Administracion', 6788903);
insert into habilidades_enfermera values('Administracion', 6788906);
insert into habilidades_enfermera values('Inyectologia', 6788900);
insert into habilidades_enfermera values('Inyectologia', 6788901);
insert into habilidades_enfermera values('Inyectologia', 6788902);
insert into habilidades_enfermera values('Inyectologia', 6788903);
insert into habilidades_enfermera values('Inyectologia', 6788904);
insert into habilidades_enfermera values('Inyectologia', 6788905);
insert into habilidades_enfermera values('Inyectologia', 6788906);
insert into habilidades_enfermera values('Inyectologia', 6788907);
insert into habilidades_enfermera values('Curacion magica', 6788900);
insert into habilidades_enfermera values('Curacion magica', 6788901);
insert into habilidades_enfermera values('Curacion magica', 6788902);
insert into habilidades_enfermera values('Curacion magica', 6788903);
insert into habilidades_enfermera values('Curacion magica', 6788904);
insert into habilidades_enfermera values('Curacion magica', 6788905);
insert into habilidades_enfermera values('Curacion magica', 6788906);
insert into habilidades_enfermera values('Curacion magica', 6788907);

----------------------------------------------------------------------------------------------------------------
insert into cama values (nextval('num_cama_seq'),'cama hidraulica vivo modelo 2018',1,'Libre');
insert into cama values (nextval('num_cama_seq'),'cama hidraulica vivo modelo 2018',1,'Libre');
insert into cama values (nextval('num_cama_seq'),'cama hidraulica vivo modelo 2018',1,'Libre');
insert into cama values (nextval('num_cama_seq'),'cama hidraulica vivo modelo 2018',1,'Libre');
insert into cama values (nextval('num_cama_seq'),'cama hidraulica vivo modelo 2018',2,'Libre');
insert into cama values (nextval('num_cama_seq'),'cama hidraulica vivo modelo 2018',2,'En uso');
insert into cama values (nextval('num_cama_seq'),'cama hidraulica vivo modelo 2018',2,'En uso');
insert into cama values (nextval('num_cama_seq'),'cama hidraulica vivo modelo 2018',2,'En uso');
insert into cama values (nextval('num_cama_seq'),'cama hidraulica vivo modelo 2018',3,'En uso');
insert into cama values (nextval('num_cama_seq'),'cama hidraulica vivo modelo 2018',3,'En uso');
insert into cama values (nextval('num_cama_seq'),'cama hidraulica vivo modelo 2018',3,'En uso');
insert into cama values (nextval('num_cama_seq'),'cama hidraulica vivo modelo 2018',3,'En uso');

insert into campana_prevencion values(nextval('campana_prevencion_seq'),'Campaña de Prevencion 00','Prevenir Causa 00','07/04/2012',89045200);
insert into campana_prevencion values(nextval('campana_prevencion_seq'),'Campaña de Prevencion 01','Prevenir Causa 01','07/04/2013',89045201);
insert into campana_prevencion values(nextval('campana_prevencion_seq'),'Campaña de Prevencion 02','Prevenir Causa 02','07/04/2014',89045202);
insert into campana_prevencion values(nextval('campana_prevencion_seq'),'Campaña de Prevencion 03','Prevenir Causa 03','07/04/2015',89045203);
insert into campana_prevencion values(nextval('campana_prevencion_seq'),'Campaña de Prevencion 04','Prevenir Causa 04','07/04/2016',89045204);
insert into campana_prevencion values(nextval('campana_prevencion_seq'),'Campaña de Prevencion 05','Prevenir Causa 05','07/04/2017',89045204);

insert into medicamento values(nextval('medicamento_seq'), 'Medicamento 00', 'descripcion de medicamento', 03000);
insert into medicamento values(nextval('medicamento_seq'), 'Medicamento 01', 'descripcion de medicamento', 30000);
insert into medicamento values(nextval('medicamento_seq'), 'Medicamento 02', 'descripcion de medicamento', 04000);
insert into medicamento values(nextval('medicamento_seq'), 'Medicamento 03', 'descripcion de medicamento', 00700);
insert into medicamento values(nextval('medicamento_seq'), 'Medicamento 04', 'descripcion de medicamento', 54000);
insert into medicamento values(nextval('medicamento_seq'), 'Medicamento 05', 'descripcion de medicamento', 03000);
insert into medicamento values(nextval('medicamento_seq'), 'Medicamento 06', 'descripcion de medicamento', 07600);
insert into medicamento values(nextval('medicamento_seq'), 'Medicamento 07', 'descripcion de medicamento', 06000);
insert into medicamento values(nextval('medicamento_seq'), 'Medicamento 08', 'descripcion de medicamento', 04000);
insert into medicamento values(nextval('medicamento_seq'), 'Medicamento 09', 'descripcion de medicamento', 30300);


