package com.eomcs.lms.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import com.eomcs.lms.context.RequestMapping;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.domain.PhotoFile;

@Component
public class PhotoBoardCommand {

  PlatformTransactionManager txManager;
  PhotoBoardDao photoBoardDao; // 서버의 BoardDaoImpl 객체를 대행하는 프록시 객체이다.
  PhotoFileDao photoFileDao;

  public PhotoBoardCommand(
      PhotoBoardDao photoBoardDao, 
      PhotoFileDao photoFileDao,
      PlatformTransactionManager txManager) {
    this.photoBoardDao = photoBoardDao;
    this.photoFileDao = photoFileDao;
    this.txManager = txManager;
  }
  
  @RequestMapping("/photoboard/list")
  public void list(Response response) throws Exception {

    List<PhotoBoard> boards = photoBoardDao.findAll(null);

    for (PhotoBoard photoboard : boards) {
      response.println(
          String.format("%3d, %-20s, %s, %d, %d", 
              photoboard.getNo(), photoboard.getTitle(), 
              photoboard.getCreatedDate(), photoboard.getViewCount(),
              photoboard.getLessonNo()));
    }
  }
  
  @RequestMapping("/photoboard/add")
  public void add(Response response) throws Exception {

//    txManager.beginTransaction();
    try {
      PhotoBoard photoboard = new PhotoBoard();
      photoboard.setTitle(response.requestString("사진 제목?"));
      photoboard.setLessonNo(response.requestInt("레슨 번호?"));
      photoBoardDao.insert(photoboard);

      response.println("최소 한 개의 사진 파일을 등록해야 합니다.");
      response.println("파일명 입력 없이 그냥 엔터를 치면 파일 추가를 마칩니다.");


      ArrayList<PhotoFile> files = new ArrayList<PhotoFile>();
      while(true) {

        String filePath = response.requestString("사진 파일?");
        if (filePath.length() == 0) {
          if (files.size() == 0) {
            response.println("최소 한 개의 사진 파일을 등록해야 합니다.");
            continue;
          } else {
            break;
          }
        }
        PhotoFile file = new PhotoFile();
        file.setFilePath(filePath);
        file.setPhotoBoardNo(photoboard.getNo());
        files.add(file);
      }

      photoFileDao.insert(files);
      
      response.println("저장하였습니다.");
//      txManager.commit();
      
    } catch (Exception e) {
      response.println("저장 중 오류가 발생했습니다" + e.getMessage());
//      txManager.rollback();
    }
  }
  
  @RequestMapping("/photoboard/detail")
public void detail(Response response) throws Exception {
    
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
      for (PhotoFile file : files) {
        response.println(String.format("사진파일: %s", file.getFilePath()));
      }
  }
  
  @RequestMapping("/photoboard/update")
  public void update(Response response) throws Exception {

//    txManager.beginTransaction();

    try {

      PhotoBoard board = new PhotoBoard();
      board.setNo(response.requestInt("번호?"));

      PhotoBoard photoBoard = photoBoardDao.findByNo(board.getNo());
      if (photoBoard == null) {
        response.println("해당 번호의 수업이 없습니다.");
        return;
      }

      String input = response.requestString(
          String.format("제목(%s)?", photoBoard.getTitle()));
      if (input.length() > 0) {
        board.setTitle(input);
        photoBoardDao.update(board);
        response.println("변경했습니다.");
      } else {
        response.println("변경을 취소하였습니다.");
      }

      response.println("사진파일: ");
      List<PhotoFile> files = photoFileDao.findByPhotoBoardNo(photoBoard.getNo());
      for (PhotoFile file : files) {
        response.println("> " + file.getFilePath());
      }

      response.println("사진은 일부만 변경할 수 없습니다.");
      response.println("전체를 새로 등록해야 합니다.");
      String input2 = response.requestString("사진을 변경하시겠습니까?(y/N)");
      if(input2.equalsIgnoreCase("y")) {

        photoFileDao.deleteByPhotoBoardNo(board.getNo());

        response.println("최소 한 개의 사진 파일을 등록해야 합니다.");
        response.println("파일명 입력 없이 그냥 엔터를 치면 파일 추가를 마칩니다.");

        ArrayList<PhotoFile> photoFiles = new ArrayList<PhotoFile>();
        while(true) {

          String filePath = response.requestString("사진 파일?");

          if (filePath.length() == 0) {
            if (photoFiles.size() == 0) {
              response.println("최소 한 개의 사진 파일을 등록해야 합니다.");
              continue;
            } else {
              break;
            }
          }
          PhotoFile file = new PhotoFile();
          file.setFilePath(filePath);
          file.setPhotoBoardNo(board.getNo());

          photoFiles.add(file);
        }
        response.println("사진 파일을 변경합니다");
        photoFileDao.insert(photoFiles);
      }

//      txManager.commit();
      response.println("변경했습니다.");
    } catch (Exception e) {
//      txManager.rollback();
      response.println("변경 중 오류 발생" + e.getMessage());
    }
  }
  
  @RequestMapping("/photoboard/delete")
public void delete(Response response) throws Exception {
    
//    txManager.beginTransaction();
    try {

      int no = response.requestInt("번호?");
      
      photoFileDao.deleteByPhotoBoardNo(no);

      if (photoBoardDao.delete(no) == 0) {
        response.println("해당 번호의 게시물이 없습니다.");
        return;
      }
      
      response.println("삭제했습니다.");
//      txManager.commit();

    } catch (Exception e) {
      response.println(String.format("실행 오류! : %s\n", e.getMessage()));
//      txManager.rollback();
    }
  }
  
  @RequestMapping("/photoboard/search")
public void search(Response response) throws Exception {
    
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
