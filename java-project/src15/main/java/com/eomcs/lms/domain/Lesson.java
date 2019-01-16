package com.eomcs.lms.domain;

import java.sql.Date;

public class Lesson {
  private int no;
  public void setNo(int no) {
    this.no = no;
  }
  public int getNo() {
    return no;
  }
  
  private String title;
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  
  private String contents;
  public void setContents(String contents) {
    this.contents = contents;
  }
  public String getContents() {
    return contents;
  }
  
  private Date startDate;
  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }
  public Date getStartDate() {
    return startDate;
  }
  
  private Date endDate;
  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }
  public Date getEndDate() {
    return endDate;
  }
  
  private int totalHours;
  public int getTotalHours() {
    return totalHours;
  }
  public void setTotalHours(int totalHours) {
    this.totalHours = totalHours;
  }

  private int dayHours;
  public int getDayHours() {
    return dayHours;
  }
  public void setDayHours(int dayHours) {
    this.dayHours = dayHours;
  }
}
