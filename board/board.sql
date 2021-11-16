create table board(								-- 게시글
	bno number(8),								-- 번호
	title nvarchar2(50) not null,				-- 제목
	content	nvarchar2(1000) not null,			-- 내용
	password varchar2(20) not null,				-- 비밀번호
	attach nvarchar2(100),						-- 파일첨부
	readcount number(8) default 0,				-- 조회수
	name nvarchar2(10) not null,				-- 작성자
	regdate date default sysdate,				-- 작성날짜
	re_ref number(8) not null,					-- 댓글 작성시 원본글 글번호
	re_lev number(8) not null,					-- 댓글의 레벨(원본글의 댓글이냐, 댓글의 댓글이냐)
	re_seq number(8) not null					-- 댓글의 순서
);

-- pk 규칙 정의
alter table board add constraint pk_board primary key(bno);

-- 시퀀스 정의(bno 필드에 사용)
create sequence board_seq;

insert into BOARD(bno, title, content, password, attach, name, re_ref, re_lev, re_seq)
values(board_seq.nextval,'게시판 작성', '게시판을 작성해 봅시다', '12345', null, '홍길동', board_seq.currval, 0, 0);

select * from board;
select bno, title, name, regdate, readcount from board;

update board set readcount = readcount+1 where bno=1;