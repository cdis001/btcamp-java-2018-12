package com.eomcs.lms.handler;
import java.sql.Date;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;

public class LessonUpdateCommand extends AbstractCommand {

  LessonDao lessonDao;

  public LessonUpdateCommand(LessonDao lessonDao) {
    this.lessonDao = lessonDao;
    this.name = "/lesson/update";
  }


  @Override
  public void execute(Response response) throws Exception {

    int no = response.requestInt("번호?");
    Lesson lesson = lessonDao.findByNo(no);
    if (lesson == null) {
      response.println("해당 번호의 수업이 없습니다.");
      return;
    }

    Lesson temp = new Lesson();
    temp.setNo(no);

    String input = response.requestString(
        String.format("제목(%s)?", lesson.getTitle()));
    if (input.length() > 0) 
      temp.setTitle(input);

    input = response.requestString(
        String.format("설명(%s)?", lesson.getContents()));
    if (input.length() > 0)
      temp.setContents(input);

    input = response.requestString(
        String.format("시작일(%s)?", lesson.getStartDate()));
    if (input.length() > 0)
      temp.setStartDate(Date.valueOf(input));


    input = response.requestString(
        String.format("종료일(%s)?", lesson.getEndDate()));
    if (input.length() > 0)
      temp.setEndDate(Date.valueOf(input));


    input = response.requestString(
        String.format("총수업시간(%d)?", lesson.getTotalHours()));
    if (input.length() > 0)
      temp.setTotalHours(Integer.parseInt(input));


    input = response.requestString(
        String.format("일수업시간(%d)?", lesson.getDayHours()));
    if (input.length() > 0)
      temp.setDayHours(Integer.parseInt(input));

    if(temp.getTitle() != null 
        || temp.getContents() != null
        || temp.getStartDate() != null
        || temp.getEndDate() != null
        || temp.getTotalHours() > 0
        || temp.getDayHours() > 0) {
      lessonDao.update(temp);
      response.println("변경했습니다.");
    } else {
      response.println("변경을 취소했습니다.");
    }


  }
}
