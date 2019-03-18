package ch29.d;

import java.util.Date;

public class Car {
  private String maker;
  private String model;
  private int cc;
  private int valve;
  private boolean auto;
  private Date createdDate;
  private BlackBox blackBox;
  
  public Car() {
    System.out.println("ch29.d.Car()");
  }
  
  @Override
  public String toString() {
    return "Car [maker=" + maker + ", model=" + model + ", cc=" + cc + ", valve=" + valve
        + ", auto=" + auto + ", createdDate=" + createdDate + ", blackBox=" + blackBox + "]";
  }
  public BlackBox getBlackBox() {
    return blackBox;
  }
  public void setBlackBox(BlackBox blackBox) {
    System.out.println("ch29.d.Car().setBlackBox");
    this.blackBox = blackBox;
  }
  public Date getCreatedDate() {
    return createdDate;
  }
  public void setCreatedDate(Date createdDate) {
    System.out.println("ch29.d.Car().setCreatedDate");
    this.createdDate = createdDate;
  }
  public String getMaker() {
    return maker;
  }
  public void setMaker(String maker) {
    System.out.println("ch29.d.Car().setMaker");
    this.maker = maker;
  }
  public String getModel() {
    return model;
  }
  public void setModel(String model) {
    System.out.println("ch29.d.Car().setModel");
    this.model = model;
  }
  public int getCc() {
    return cc;
  }
  public void setCc(int cc) {
    System.out.println("ch29.d.Car().setCc");
    this.cc = cc;
  }
  public int getValve() {
    return valve;
  }
  public void setValve(int valve) {
    System.out.println("ch29.d.Car().setValve");
    this.valve = valve;
  }
  public boolean isAuto() {
    return auto;
  }
  public void setAuto(boolean auto) {
    System.out.println("ch29.d.Car().setAuto");
    this.auto = auto;
  }
  
  
}
