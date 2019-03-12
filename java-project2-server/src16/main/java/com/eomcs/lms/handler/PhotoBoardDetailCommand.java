package com.eomcs.lms.handler;
import java.util.List;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.domain.PhotoFile;

public class PhotoBoardDetailCommand extends AbstractCommand {
  
  PhotoBoardDao photoboardDao;
  PhotoFileDao photofileDao;
  
  public PhotoBoardDetailCommand(PhotoBoardDao photoboardDao,
      PhotoFileDao photofileDao) {
    this.photoboardDao = photoboardDao;
    this.photofileDao = photofileDao;
  }

  @Override
  public void execute(Response response) throws Exception {
    
    int no = response.requestInt("번호?");
    
    PhotoBoard photoboard = photoboardDao.findByNoWithFile(no);
      if (photoboard == null) {
        response.println("해당 번호의 게시물이 없습니다.");
        return;
      }
      response.println(String.format("내용: %s", photoboard.getTitle()));
      response.println(String.format("작성일: %s", photoboard.getCreatedDate()));
      response.println(String.format("조회수: %d", photoboard.getViewCount()));
      response.println(String.format("수업: %s(%s ~ %s)",
          photoboard.getLesson().getTitle(),
          photoboard.getLesson().getStartDate(),
          photoboard.getLesson().getEndDate()));
      
      List<PhotoFile> files = photoboard.getFiles();
      photoboardDao.updateVw(no);
      for (PhotoFile file : files) {
        response.println(String.format("사진파일: %s", file.getFilePath()));
      }

  }
}
