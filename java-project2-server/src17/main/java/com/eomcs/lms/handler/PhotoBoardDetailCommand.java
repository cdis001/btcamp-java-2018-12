package com.eomcs.lms.handler;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.domain.PhotoFile;

public class PhotoBoardDetailCommand extends AbstractCommand {

  SqlSessionFactory sqlSessionFactory;

  public PhotoBoardDetailCommand(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public void execute(Response response) throws Exception {

    try(SqlSession sqlSession = sqlSessionFactory.openSession()) {

      PhotoBoardDao photoBoardDao = sqlSession.getMapper(PhotoBoardDao.class);

      int no = response.requestInt("번호?");

      PhotoBoard photoboard = photoBoardDao.findByNoWithFile(no);
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
      photoBoardDao.updateVw(no);
      sqlSession.commit();
      for (PhotoFile file : files) {
        response.println(String.format("사진파일: %s", file.getFilePath()));
      }
    }
  }
}
