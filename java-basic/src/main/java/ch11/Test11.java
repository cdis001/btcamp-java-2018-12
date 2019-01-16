//Wapper 클래스 생성자
package ch11;

import java.util.Date;

public class Test11 {
  public static void main(String[] args) {
    Integer obj1 = new Integer(100);
    Integer obj2 = new Integer(100);
    
    if (obj1 == obj2)
      System.out.println("같다!");
    else 
      System.out.println("다르다!"); //new연산자를 활용하여 heap에 생성되었기 때문
    
    if (obj1.equals(obj2))
      System.out.println("같다!");
    else 
      System.out.println("다르다!"); //equals() 는 값을 비교하는 연산이기 때문에 같다고 나옴
    
    Integer obj3 = Integer.valueOf(100);
    Integer obj4 = Integer.valueOf(100);
    
    if (obj3 == obj4)
      System.out.println("같다!");
    else 
      System.out.println("다르다!");
  }
}
