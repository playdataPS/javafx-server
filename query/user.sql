select * from MPJ.GAME_USER;




//ip ����Ȯ��
SELECT IP FROM MPJ.GAME_USER WHERE IP = '192.168.0.5';
SELECT IP FROM MPJ.GAME_USER WHERE IP = '192.168.0.6';
SELECT IP FROM GAME_USER WHERE IP = '192.168.0.5';
//IP �� �г��Ӱ� Ȯ��
select nickname from MPJ.GAME_USER 
where ip = '192.168.0.5';

//insert game_user
insert into 
MPJ.GAME_USER(no, ip, nickname) 
values(MPJ.num_seq.nextval,'192.168.0.5', 'eunhye');

insert into 
GAME_USER(no, ip, nickname) 
values(num_seq.nextval,'192.168.0.5', 'eunhye');


//Insert
insert into dict(no, word) values(DICT_SEQ.nextval, '금강산');
insert into dict(no, word) values(DICT_SEQ.nextval, '오지혜');
insert into dict(no, word) values(DICT_SEQ.nextval, '김다빈');
insert into dict(no, word) values(DICT_SEQ.nextval, '최은혜');
insert into dict(no, word) values(DICT_SEQ.nextval, '배윤희');
insert into dict(no, word) values(DICT_SEQ.nextval, '김건동');
insert into dict(no, word) values(DICT_SEQ.nextval, '자전거');
insert into dict(no, word) values(DICT_SEQ.nextval, '강사님');
insert into dict(no, word) values(DICT_SEQ.nextval, '바닷가');

//select
select * from dict;