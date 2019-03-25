package com.eomcs.lms.handler;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import com.eomcs.lms.context.RequestMapping;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.domain.PhotoFile;
import com.eomcs.lms.service.PhotoBoardService;

@Component
public class PhotoBoardCommand {

  PhotoBoardService photoBoardService;

  public PhotoBoardCommand(PhotoBoardService photoBoardService) {
    this.photoBoardService = photoBoardService;
  }
  
  @RequestMapping("/photoboard/list")
  public void list(Response response) throws Exception {

    List<PhotoBoard> boards = photoBoardService.list(0, null);

    for (PhotoBoard photoboard : boards) {
      response.println(
          String.format("%3d, %-20s, %s, %d, %d", 
              photoboard.getNo(), photoboard.getTitle(), 
              photoboard.getCreatedDate(), photoboard.getViewCount(),
              photoboard.getLessonNo()));
    }
  }
  
  @RequestMapping("/photoboard/add")
  public void add(Response response) {

    try {
      PhotoBoard photoboard = new PhotoBoard();
      photoboard.setTitle(response.requestString("사진 제목?"));
      photoboard.setLessonNo(response.requestInt("레슨 번호?"));

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
        files.add(file);
      }

      photoboard.setFiles(files);
      photoBoardService.add(photoboard);
      response.println("저장하였습니다.");
      
    } catch (Exception e) {
      e.printStackTrace();
      response.println("저장 중 오류가 발생했습니다");
    }
  }
  
  @RequestMapping("/photoboard/detail")
public void detail(Response response) throws Exception {
    
    int no = response.requestInt("번호?");
    
    PhotoBoard photoboard = photoBoardService.get(no);
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
      for (PhotoFile file : files) {
        response.println(String.format("사진파일: %s", file.getFilePath()));
      }
  }
  
  @RequestMapping("/photoboard/update")
  public void update(Response response) throws Exception {

    try {

      PhotoBoard board = new PhotoBoard();
      board.setNo(response.requestInt("번호?"));

      PhotoBoard origin = photoBoardService.get(board.getNo());
      if (origin == null) {
        response.println("해당 번호의 수업이 없습니다.");
        return;
      }

      String input = response.requestString(
          String.format("제목(%s)?", origin.getTitle()));
      if (input.length() > 0) {
        board.setTitle(input);
      } 

      response.println("사진파일: ");
      List<PhotoFile> files = origin.getFiles();
      for (PhotoFile file : files) {
        response.println("> " + file.getFilePath());
      }

      response.println("사진은 일부만 변경할 수 없습니다.");
      response.println("전체를 새로 등록해야 합니다.");
      String input2 = response.requestString("사진을 변경하시겠습니까?(y/N)");
      if(input2.equalsIgnoreCase("y")) {

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
        board.setFiles(photoFiles);
      }
      photoBoardService.update(origin);
      response.println("변경했습니다.");
    } catch (Exception e) {
      response.println("변경 중 오류 발생");
      e.printStackTrace();
    }
  }
  
  @RequestMapping("/photoboard/delete")
public void delete(Response response) throws Exception {
    
    try {
      int no = response.requestInt("번호?");
      if (photoBoardService.delete(no) == 0) {
        response.println("해당 번호의 게시물이 없습니다.");
        return;
      }
      response.println("삭제했습니다.");
      
    } catch (Exception e) {
      response.println(String.format("삭제 중 오류 발생!"));
      e.printStackTrace();
    }
  }
  
  @RequestMapping("/photoboard/search")
public void search(Response response) throws Exception {
    
    int lessonNo = 0;
    
    try {
      lessonNo = response.requestInt("레슨 번호?");
    } catch (Exception e) {
    }
    String searchWord = null; 
    try {
      String keyword = response.requestString("검색어?");
      if (keyword.length() > 0) {
        searchWord = keyword;
      }
    } catch (Exception e) {
    }
    
    List<PhotoBoard> boards = photoBoardService.list(lessonNo, searchWord);
    
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
