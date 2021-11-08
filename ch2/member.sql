-- member 테이블 생성
create table member(
	userid varchar2(15) primary key,
	password varchar2(20) not null,
	name nvarchar2(10) not null,
	gender nvarchar2(2) not null,
	email varchar2(50) not null
);
insert into member values('hong123', 'hong123@', '홍길동','남','hong123@gmail.com');
select * from member where userid='hong' and password='hong';

select * from member;

alter table member modify (gender nvarchar2(10));

-- 비밀번호 변경
update member set password='변경비밀번호';

update member set password='변경비밀번호' where userid='아이디' and password='현재비밀번호';
