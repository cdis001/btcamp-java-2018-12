package com.eomcs.lms.handler;
import java.util.HashMap;
import java.util.List;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.domain.PhotoBoard;

public class PhotoBoardSearchCommand extends AbstractCommand {

  PhotoBoardDao photoBoardDao;

  public PhotoBoardSearchCommand(PhotoBoardDao photoBoardDao) {
    this.photoBoardDao = photoBoardDao;
    this.name = "/photoboard/search";
  }

  @Override
  public void execute(Response response) throws Exception {
    
    HashMap<String, Object> params = new HashMap<>();
    
    try {
      int lessonNo = response.requestInt("레슨 번호?");
      params.put("lessonNo", lessonNo);
    } catch (Exception e) {
    }

    try {
      String keyword = response.requestString("검색어?");
      if (keyword.length() > 0) {
      //SQL에서 검색할 때 사용할 문자열 패턴을 다음과 같이 자바에서 만들어 전달할 수 있다. 
        //params.put("keyword", "%" + keyword + "%");
        
        // 또는 다음과 같이 키워드를 전달한 후 mybatis 쪽에서 패턴을 정의할 수 있다.
        params.put("keyword", keyword);
      }
    } catch (Exception e) {
    }
    
    List<PhotoBoard> boards = photoBoardDao.findAll(params);
    
    response.println("[검색결과]");
    for (PhotoBoard photoboard : boards) {
      response.println(
          String.format("%3d, %-20s, %s, %d, %d", 
              photoboard.getNo(), photoboard.getTitle(), 
              photoboard.getCreatedDate(), photoboard.getViewCount(),
              photoboard.getLessonNo()));
    }
  }
}
