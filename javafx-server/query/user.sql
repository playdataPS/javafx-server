select * from GAME_USER;

desc GAME_USER;

insert into 
GAME_USER(no, ip, nickname) 
values(num_seq.nextval,'192.168.0.5', 'eunhye');

select nickname from GAME_USER 
where ip = '192.168.0.5';