select * from MPJ.GAME_USER;





//ip ����Ȯ��
SELECT IP FROM MPJ.GAME_USER WHERE IP = '192.168.0.5';
SELECT IP FROM MPJ.GAME_USER WHERE IP = '192.168.0.6';

//IP �� �г��Ӱ� Ȯ��
select nickname from MPJ.GAME_USER 
where ip = '192.168.0.5';

//IP, �г��� �Է�
insert into 
MPJ.GAME_USER(no, ip, nickname) 
values(MPJ.num_seq.nextval,'192.168.0.5', 'eunhye');