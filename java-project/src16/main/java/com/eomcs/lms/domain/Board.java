package com.eomcs.lms.domain;

import java.sql.Date;

public class Board {
  private int no;
  public int getNo() {
    return this.no;
  }
  
  public void setNo(int no) {
    this.no = no;
  }
  
  private String contents;
  
  public String getContents() {
    return contents;
  }
  public void setContents(String contents) {
    this.contents = contents;
  }
  
  private Date createdDate;
  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }

  private int viewCount;
  public int getViewCount() {
    return viewCount;
  }
  
  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
  }
}
