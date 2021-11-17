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
	re_lev number(8) not null,					-- 댓글의 순서
	re_seq number(8) not null					-- 댓글의 레벨(원본글의 댓글이냐, 댓글의 댓글이냐)
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

delete from board where bno = 1 and password = 12345;

select count(*) from board;

-- 더미 데이터 삽입
insert into board(bno, name, password, title, content, re_ref, re_lev, re_seq)
(select board_seq.nextval, name, password, title, content, board_seq.currval, re_lev, re_seq from board);

-- 댓글
select bno, title, re_ref, re_seq, re_lev from board where bno = 735;

-- re_ref : 댓글 작성시 원본글 글번호(그룹번호)
-- re_seq : 댓글의 순서
-- re_lev : 댓글의 레벨(원본글의 댓글이냐, 댓글의 댓글이냐)

-- 735 댓글작성
-- re_ref : 원본글의 re_ref 값
-- re_seq : 원본글의 re_seq+1
-- re_lev : 원본글의 re_lev+1
insert into BOARD(bno, title, content, password, attach, name, re_ref, re_lev, re_seq)
values(board_seq.nextval,'Re : 댓글작성', '댓글을 작성해 봅시다', '12345', 
null, '이하루', 735, 1, 1);

select bno, title, re_ref, re_seq, re_lev from board where re_ref = 735 order by re_seq;

-- 735 두번째 댓글(가장 최신 댓글이 위로 올라와야 한다)
-- 원본글의 re_ref, re_seq, re_lev
update BOARD set re_seq = re_seq + 1 where re_ref = 735 and re_seq > 0;

insert into BOARD(bno, title, content, password, attach, name, re_ref, re_lev, re_seq)
values(board_seq.nextval,'Re : 댓글작성2', '댓글을 작성해 봅시다', '12345', 
null, '김이틀', 735, 1, 1);




