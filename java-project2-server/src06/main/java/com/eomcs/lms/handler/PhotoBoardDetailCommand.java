package com.eomcs.lms.handler;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.domain.PhotoBoard;

public class PhotoBoardDetailCommand extends AbstractCommand {
  
  PhotoBoardDao photoboardDao;
  
  public PhotoBoardDetailCommand(PhotoBoardDao photoboardDao) {
    this.photoboardDao = photoboardDao;
  }

  @Override
  public void execute(Response response) throws Exception {
    
    int no = response.requestInt("번호?");
    
    PhotoBoard photoboard = photoboardDao.findByNo(no);
      if (photoboard == null) {
        response.println("해당 번호의 게시물이 없습니다.");
        return;
      }
      response.println(String.format("내용: %s\n", photoboard.getTitle()));
      response.println(String.format("작성일: %s\n", photoboard.getCreatedDate()));
      response.println(String.format("조회수: %d\n", photoboard.getViewCount()));
      response.println(String.format("레슨번호: %d\n", photoboard.getLessonNo()));

  }
}
