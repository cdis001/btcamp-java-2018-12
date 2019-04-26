package com.eomcs.lms.dao;

import java.util.List;
import java.util.Map;
import com.eomcs.lms.domain.PhotoBoard;

public interface PhotoBoardDao {

  int insert(PhotoBoard photoboard);

  List<PhotoBoard> findAll(Map<String, Object> params);

  PhotoBoard findByNo(int no);

  void updateVw(int no);

  public PhotoBoard findByNoWithFile(int no);

  int update(PhotoBoard photoboard);

  int delete(int no);

  int countAll();
}
