package ch27.b;

import java.lang.reflect.Method;

public class Test07 {

  public static void main(String[] args) throws Exception {
    Class<?> clazz = String.class;
    
    Method[] methods = clazz.getMethods();
    for (Method m : methods) {
      System.out.printf("메서드명: %s.%s\n",
          m.getDeclaringClass().getSimpleName(),
          m.getName());
      
      System.out.println("------------------------------");
    }
    
  }
}
