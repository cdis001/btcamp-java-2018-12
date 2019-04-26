package com.eomcs.lms.service.impl;

import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Service;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.domain.PhotoFile;
import com.eomcs.lms.service.PhotoBoardService;

@Service
public class PhotoBoardServiceImpl implements PhotoBoardService {

  PhotoBoardDao boardDao;
  PhotoFileDao fileDao;

  public PhotoBoardServiceImpl(PhotoBoardDao boardDao, PhotoFileDao fileDao) {
    this.boardDao = boardDao;
    this.fileDao = fileDao;
  }

  @Override
  public List<PhotoBoard> list(int lessonNo, String searchWord, int pageNo, int pageSize) {


    HashMap<String, Object> params = new HashMap<>();
    params.put("size", pageSize);
    params.put("rowNo", (pageNo - 1) * pageSize);

    if (lessonNo <= 0 && searchWord == null) {
      return boardDao.findAll(params);
    } else {
      if (lessonNo > 0) {
        params.put("lessonNo", lessonNo);
      }
      if (searchWord != null) {
        params.put("keyword", searchWord);
      }
      return boardDao.findAll(params);
    }
  }

  @Override
  public int add(PhotoBoard photoBoard) {

    int count = boardDao.insert(photoBoard);

    List<PhotoFile> files = photoBoard.getFiles();
    for (PhotoFile f : files) {
      f.setPhotoBoardNo(photoBoard.getNo());
    }
    fileDao.insert(photoBoard.getFiles());
    return count;

  }

  @Override
  public PhotoBoard get(int no) {
    PhotoBoard board = boardDao.findByNoWithFile(no);
    if (board != null) {
      boardDao.updateVw(no);
    }
    return board;
  }

  @Override
  public int update(PhotoBoard photoBoard) {

    if (photoBoard.getTitle() != null) {
      boardDao.update(photoBoard);
    }

    List<PhotoFile> photoFiles = photoBoard.getFiles();
    if (photoFiles != null) {
      // 먼저 기존 첨부 파일을 삭제한다.
      fileDao.deleteByPhotoBoardNo(photoBoard.getNo());
      fileDao.insert(photoFiles);
    }
    return 1;
  }

  @Override
  public int delete(int no) {

    fileDao.deleteByPhotoBoardNo(no);
    return boardDao.delete(no);
  }

  @Override
  public int size() {
    return boardDao.countAll();
  }

}
