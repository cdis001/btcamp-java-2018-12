insert into lms_lesson(lesson_id, titl, conts, sdt, edt, tot_hr, day_hr)
values(101, '자바 프로그래밍', '자바 프로그래밍 배우기', '2019-01-01', '2019-08-08', '1000', 800);
insert into lms_lesson(lesson_id, titl, conts, sdt, edt, tot_hr, day_hr)
values(102, 'C 프로그래밍', 'C 프로그래밍 배우기', '2019-02-01', '2019-07-08', '800', 4);
insert into lms_lesson(lesson_id, titl, conts, sdt, edt, tot_hr, day_hr)
values(103, '파이썬 프로그래밍', '파이썬 프로그래밍 배우기', '2019-03-01', '2019-06-08', '700', 4);
insert into lms_lesson(lesson_id, titl, conts, sdt, edt, tot_hr, day_hr)
values(104, '웹 프로그래밍', '웹 프로그래밍 배우기', '2019-05-01', '2019-08-08', '300', 3);
insert into lms_lesson(lesson_id, titl, conts, sdt, edt, tot_hr, day_hr)
values(105, 'IOT 프로그래밍', 'IOT 프로그래밍 배우기', '2019-07-01', '2020-07-08', '2100', 8);

insert into lms_member(member_id, name, email, pwd)
values(21, 'uesr1', 'user1@test.com', password('1111'));
insert into lms_member(member_id, name, email, pwd)
values(22, 'user2', 'user2@test.com', password('1111'));
insert into lms_member(member_id, name, email, pwd)
values(23, 'user3', 'user3@test.com', password('1111'));

insert into lms_board(board_id, conts)
values(51,'aaaaa');
insert into lms_board(board_id, conts)
values(52,'bbbbb');
insert into lms_board(board_id, conts)
values(53,'ccccc');
insert into lms_board(board_id, conts)
values(54,'ddddd');
insert into lms_board(board_id, conts)
values(55,'eeeee');

insert into lms_photo(photo_id, lesson_id, titl) values (1, 101, 'aaa');
insert into lms_photo(photo_id, lesson_id, titl) values (2, 101, 'bbb');
insert into lms_photo(photo_id, lesson_id, titl) values (3, 101, 'ccc');
insert into lms_photo(photo_id, lesson_id, titl) values (4, 104, 'ddd');
insert into lms_photo(photo_id, lesson_id, titl) values (5, 104, 'eee');

insert into lms_photo_file(photo_file_id, photo_id, file_path)
values(1, 1, 'a1.gif');
insert into lms_photo_file(photo_file_id, photo_id, file_path)
values(2, 1, 'a2.gif');
insert into lms_photo_file(photo_file_id, photo_id, file_path)
values(3, 1, 'a3.gif');
insert into lms_photo_file(photo_file_id, photo_id, file_path)
values(4, 2, 'b1.gif');
insert into lms_photo_file(photo_file_id, photo_id, file_path)
values(5, 3, 'c1.gif');
insert into lms_photo_file(photo_file_id, photo_id, file_path)
values(6, 3, 'c2.gif');
insert into lms_photo_file(photo_file_id, photo_id, file_path)
values(7, 4, 'd1.gif');
insert int5 lms_photo_file(photo_file_id, photo_id, file_path)
values(8, 5, 'e1.gif');
insert into lms_photo_file(photo_file_id, photo_id, file_path)
values(9, 5, 'e2.gif');
insert into lms_photo_file(photo_file_id, photo_id, file_path)
values(10, 5, 'e3.gif');
insert into lms_photo_file(photo_file_id, photo_id, file_path)
values(11, 5, 'e4.gif');
