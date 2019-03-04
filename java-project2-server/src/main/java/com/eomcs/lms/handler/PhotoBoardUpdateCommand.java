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

    int no = response.requestInt("번호?");
    PhotoBoard photoBoard = photoBoardDao.findByNo(no);
    if (photoBoard == null) {
      response.println("해당 번호의 수업이 없습니다.");
      return;
    }
    
    PhotoBoard temp = photoBoard.clone();
    
    String input = response.requestString(
        String.format("내용(%s)?\n", photoBoard.getTitle()));
    if (input.length() > 0) 
      temp.setTitle(input);
    
    input = response.requestString(
        String.format("레슨번호(%s)?\n", photoBoard.getLessonNo()));
    if (input.length() > 0) 
      temp.setLessonNo(Integer.parseInt(input));

    photoBoardDao.update(temp);
    
    response.println("사진파일: ");
    List<PhotoFile> files = photoFileDao.findByPhotoBoardNo(photoBoard.getNo());
    for (PhotoFile file : files) {
      response.println("> " + file.getFilePath());
    }
    
    response.println("사진은 일부만 변경할 수 없습니다.");
    response.println("전체를 새로 등록해야 합니다.");
    String input2 = response.requestString("사진을 변경하시겠습니까?(y/N)");
    if(input2.equalsIgnoreCase("y")) {
      
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
        file.setPhotoBoardNo(photoBoard.getNo());

        photoFileDao.insert(file);
        count++;
      }
      
      response.println("사진 파일을 변경합니다");
    }
    

    
    response.println("변경했습니다.");
  }
}
