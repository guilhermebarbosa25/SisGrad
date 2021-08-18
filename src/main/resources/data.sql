create table IF NOT EXISTS dbSisGrad.usuario(matricula varchar(255),cpf varchar(255),datanasc varchar(255),email varchar(255),nome varchar(255),senha varchar(255),usertype varchar(255));

insert into dbSisGrad.usuario(matricula, cpf, datanasc, email, nome, senha, usertype)
Select 'U00000','000.000.000-00', '01/01/2000', 'adm@sisgrad.com', 'admin', 'admin', 'Administrativo'
where not exists (select * from dbSisGrad.usuario where email='adm@sisgrad.com');