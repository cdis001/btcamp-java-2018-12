package ch03;

public class Test05 {
  public static void main(String[] args) {
    java.util.Date d1 = new java.util.Date();
    java.util.Date d2 = d1;
    
    System.out.println(d1.getDate());
    System.out.println(d2.getDate());
    
    d1.setDate(10);
    
    System.out.println(d1.getDate());
    System.out.println(d2.getDate());
    
    
  }

}
