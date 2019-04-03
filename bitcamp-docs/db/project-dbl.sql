drop table if exists lms_lesson;

drop table if exists lms_member;

drop table if exists lms_board;

drop table if exists lms_photo;

drop table if exists lms_photo_file;


create table lms_lesson( 
  lesson_id int not null auto_increment primary key comment '수업데이터 식별 번호', 
  titl varchar(255) not null comment '수업명', 
  conts text not null comment '수업내용', 
  sdt datetime not null comment '수업 시작일', 
  edt datetime not null comment '수업 종료일', 
  tot_hr int not null comment '총 수업시간', 
  day_hr int not null comment '일 수업시간' 
) comment '수업';

create table lms_member (
  member_id int not null auto_increment primary key comment '회원 데이터 식별 번호',
  name varchar(30) not null comment '이름',
  email varchar(50) not null comment '이메일',
  pwd varchar(255) not null comment '암호',
  rdt datetime default now() comment '등록일', 
  tel varchar(20) comment '전화',
  photo varchar(255) comment '사진'
) comment '회원';

CREATE UNIQUE INDEX UIX_lms_member_email
  ON lms_member(
    email ASC
  );
  
create table lms_board(
  board_id int not null auto_increment primary key comment '게시판 번호',
  conts text not null comment '내용',
  cdt datetime default now() comment '생성일',
  vw_cnt int default 0 comment '조회수'
) comment '게시판';

create table lms_photo(
  photo_id int not null auto_increment primary key comment '사진 게시물 번호',
  lesson_id int not null comment '수업 번호',
  titl varchar(255) not null comment '제목',
  cdt datetime default now() comment '생성일',
  vw_cnt int default 0 comment '조회수',
  constraint fk_photo_to_lesson foreign key (lesson_id)
    references lms_lesson (lesson_id)
) comment '사진게시물';

create table lms_photo_file(
  photo_file_id int not null auto_increment primary key comment '사진 파일 식별 번호',
  file_path varchar(255) not null, 
  constraint fk_photo_file_to_photo foreign key (photo_id)
    references lms_photo (photo_id),
  photo_id int not null
) comment '사진 게시물 첨부파일 테이블';

