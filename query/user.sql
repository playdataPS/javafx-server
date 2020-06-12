select * from MPJ.GAME_USER;





//ip 유무확인
SELECT IP FROM MPJ.GAME_USER WHERE IP = '192.168.0.5';
SELECT IP FROM MPJ.GAME_USER WHERE IP = '192.168.0.6';

//IP 로 닉네임값 확인
select nickname from MPJ.GAME_USER 
where ip = '192.168.0.5';

//IP, 닉네임 입력
insert into 
MPJ.GAME_USER(no, ip, nickname) 
values(MPJ.num_seq.nextval,'192.168.0.5', 'eunhye');