insert into amministratore values('Mario','Rossi','MarioRossi01');
insert into amministratore values('lollo','Rossi','pass');

insert into docenti values('Alessio','Bruni','ipotetico contenuto del cv',1);
insert into docenti values('Marco','Tanni','ipotetico contenuto del cv',2);
insert into docenti values('Michele','Frello','ipotetico contenuto del cv',3);
insert into docenti values('Gennaro','Sanna','ipotetico contenuto del cv',4);

insert into corsi values(1,'Scienze Matematiche',TO_DATE('2002/01/01 12:00:00', 'yyyy/mm/dd hh24:mi:ss'),TO_DATE('2002/12/30 12:00:00', 'yyyy/mm/dd hh24:mi:ss'),1000,'commenti corso','10', 1);
insert into corsi values(2,'Scienze Fisiche',TO_DATE('2002/01/01 12:00:00', 'yyyy/mm/dd hh24:mi:ss'),TO_DATE('2002/12/30 12:00:00', 'yyyy/mm/dd hh24:mi:ss'),1544,'commenti corso','11', 2);
insert into corsi values(3,'Scienze Chimiche',TO_DATE('2002/01/01 12:00:00', 'yyyy/mm/dd hh24:mi:ss'),TO_DATE('2002/12/30 12:00:00', 'yyyy/mm/dd hh24:mi:ss'),1761,'commenti corso','12', 3);
insert into corsi values(4,'Scienze della Terra',TO_DATE('2002/01/01 12:00:00', 'yyyy/mm/dd hh24:mi:ss'),TO_DATE('2002/12/30 12:00:00', 'yyyy/mm/dd hh24:mi:ss'),1497,'commenti corso','13', 4);
insert into corsi values(5,'Scienze Biologiche',TO_DATE('2002/01/01 12:00:00', 'yyyy/mm/dd hh24:mi:ss'),TO_DATE('2002/12/30 12:00:00', 'yyyy/mm/dd hh24:mi:ss'),1512,'commenti corso','14', 1);
insert into corsi values(6,'Scienze Mediche',TO_DATE('2002/01/01 12:00:00', 'yyyy/mm/dd hh24:mi:ss'),TO_DATE('2002/12/30 12:00:00', 'yyyy/mm/dd hh24:mi:ss'),1346,'commenti corso','15', 2);
insert into corsi values(7,'Scienze Giuridiche',TO_DATE('2002/01/01 12:00:00', 'yyyy/mm/dd hh24:mi:ss'),TO_DATE('2002/12/30 12:00:00', 'yyyy/mm/dd hh24:mi:ss'),1357,'commenti corso','16', 3);
insert into corsi values(8,'Scienze Politiche',TO_DATE('2002/01/01 12:00:00', 'yyyy/mm/dd hh24:mi:ss'),TO_DATE('2002/12/30 12:00:00', 'yyyy/mm/dd hh24:mi:ss'),1687,'commenti corso','17', 4);


insert into CORSISTI values('Max','Rossi',1,1);
insert into CORSISTI values('Mario','Bianchi',2,1);
insert into CORSISTI values('Marta','Rossi',3,1);
insert into CORSISTI values('Paolo','Rossi',4,1);

