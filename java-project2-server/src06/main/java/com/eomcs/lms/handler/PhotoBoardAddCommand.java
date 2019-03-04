package com.eomcs.lms.handler;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.domain.PhotoBoard;

public class PhotoBoardAddCommand extends AbstractCommand {

  PhotoBoardDao photoboardDao; // 서버의 BoardDaoImpl 객체를 대행하는 프록시 객체이다.

  public PhotoBoardAddCommand(PhotoBoardDao photoboardDao) {
    this.photoboardDao = photoboardDao;
  }

  @Override
  public void execute(Response response) throws Exception {

    PhotoBoard photoboard = new PhotoBoard();
    photoboard.setTitle(response.requestString("내용?"));
    photoboard.setLessonNo(response.requestInt("레슨번호?"));

    photoboardDao.insert(photoboard);
    response.println("저장하였습니다.");

  }
}
