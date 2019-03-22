/* as 로 컬럼에 별명(라벨명) 붙이기  */

/* 출력 라벨명을 변경하기
   => 라벨명을 지정하지 않으면 컬럼명이 라벨명이 된다*/
select rno as room_no, loc as location, name 
from room;

/* as 생략 가능 */
select rno room_no, loc location, name 
from room;

/* 라벨명에 공백을 넣고 싶으면 '' 안에 작성한다.*/
select rno 'room no', loc location, name 
from room;

/* 복잡한 형식으로 출력할 경우 라벨명(별명)을 부여한다. 
    예) 강의실명(지점명)*/
select concat(name, '(', loc, ')')
from room;

select concat(name, '(', loc, ')') title
from room;

/*집합함수이므로 여러개를 뽑으려고 해도 맨 앞의 것만 나옴(결과는 한개값만 나옴)*/
select count(*) 
from room;

select count(*) cnt
from room;

/*억지로 두개를 뽑는 방법*/
select (select count(*) from room where loc = '강남') loc, name from room where name = 5%;




