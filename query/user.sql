select * from MPJ.GAME_USER;





//ip ����Ȯ��
SELECT IP FROM MPJ.GAME_USER WHERE IP = '192.168.0.5';
SELECT IP FROM MPJ_CURD.GAME_USER WHERE IP = '127.0.0.1';
SELECT count(IP) FROM MPJ_CURD.GAME_USER WHERE IP ='127.0.0.1';

//IP �� �г��Ӱ� Ȯ��
select nickname from MPJ.GAME_USER 
where ip = '192.168.0.5';

//IP, �г��� �Է�
insert into 
MPJ_curd.GAME_USER(no, ip, nickname) 
values(MPJ_curd.num_seq.nextval,'127.0.0.1', 'eunhye');