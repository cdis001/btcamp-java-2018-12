package ch10;
import java.util.Calendar;

public class Test16 {
  public static void main(String[] args) throws Exception {
    Calendar c1;
//    c1 = new Calendar;
    //Calendar 클래스의 생성자가 protected이기 때문에 공개되지 않아, 접근이 불가능함
    c1 = Calendar.getInstance();
    
    System.out.println(c1.get(Calendar.YEAR));
  }  
}
