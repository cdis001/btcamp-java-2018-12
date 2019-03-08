package com.eomcs.lms.handler;
import java.util.List;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.domain.PhotoFile;

public class PhotoBoardUpdateCommand extends AbstractCommand {

  PhotoBoardDao photoBoardDao;
  PhotoFileDao photoFileDao;

  public PhotoBoardUpdateCommand(
      PhotoBoardDao photoBoardDao, PhotoFileDao photoFileDao) {
    this.photoBoardDao = photoBoardDao;
    this.photoFileDao = photoFileDao;
    }

  @Override
  public void execute(Response response) throws Exception {

    PhotoBoard board = new PhotoBoard();
    board.setNo(response.requestInt("번호?"));
    
    PhotoBoard photoBoard = photoBoardDao.findByNo(board.getNo());
    if (photoBoard == null) {
      response.println("해당 번호의 수업이 없습니다.");
      return;
    }
    
    String input = response.requestString(
        String.format("제목(%s)?", photoBoard.getTitle()));
    if (input.length() > 0) 
      board.setTitle(input);
    
    input = response.requestString(
        String.format("레슨번호(%s)?", photoBoard.getLessonNo()));
    if (input.length() > 0) 
      board.setLessonNo(Integer.parseInt(input));

    if (board.getTitle() != null
        ||board.getLessonNo() > 0) {
      
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
      
      int count = 0;
      while(true) {

        String filePath = response.requestString("사진 파일?");

        if (filePath.length() == 0) {
          if (count == 0) {
            response.println("최소 한 개의 사진 파일을 등록해야 합니다.");
            continue;
          } else {
          break;
          }
        }
        PhotoFile file = new PhotoFile();
        file.setFilePath(filePath);
        file.setPhotoBoardNo(board.getNo());

        photoFileDao.insert(file);
        count++;
      }
      
      response.println("사진 파일을 변경합니다");
    }
    

    
    response.println("변경했습니다.");
  }
}
