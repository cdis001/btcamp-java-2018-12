package ch16;

import java.util.Calendar;
import java.util.Date;

public class Test02 {
  public static void main(String[] args) {
    String obj = echo(new String("Hello"));
    Date obj2 = echo(new Date());
    Calendar obj3 = echo(Calendar.getInstance());
  }
  
  public static String echo(String obj) {
    return obj;
  }
  public static Date echo(Date obj) {
    return obj;
  }
  public static Calendar echo(Calendar obj) {
    return obj;
  }
}
