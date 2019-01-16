//Wrapper 클래스와 오토 박싱(auto-boxing)/오토 언박싱(auto-unboxing)
package ch11;

import java.util.Date;

public class Test10 {
  public static void main(String[] args) {
    
    Integer obj1 = Integer.valueOf(100); //boxing
    
    int i1 = obj1.intValue(); //unboxing ->매우 불편하므로 자바에서는 코드 문맥에 따라 자동으로 수행해줌
    
    int i2 = obj1; //auto-unboxing; 내부적으로 obj1.intValue()를 호출함
    Integer obj2 = 200; //auto boxing; 내부적으로 Integer.valueOf(200)을 호출함
    
  }
}
