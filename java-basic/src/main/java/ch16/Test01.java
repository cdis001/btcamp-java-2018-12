package ch16;

import java.util.Calendar;
import java.util.Date;

public class Test01 {
  public static void main(String[] args) {
//    String = echo(new String("Hello")); ->리턴타입이 Object이기 때문에 string으로 받을 수 없음
    
    String obj = (String) echo(new String("Hello"));
    
//    Integer obj2 = (Integer) echo(new String("Hello")); ->컴파일러에서는 오류가 나지 않지만, 런타임에서는 오류가 남
    
    Date obj3 = (Date) echo(new Date());
    
    Calendar obj4 = (Calendar) echo(Calendar.getInstance());
  }
  
  public static Object echo(Object obj) {
    return obj;
  }
}
