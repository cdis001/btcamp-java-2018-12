package ch27.b;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import static java.lang.reflect.Modifier.*;

public class Test05 {

  public static void main(String[] args) throws Exception {
    Class<?> clazz = String.class;
    
    Method[] methods = clazz.getDeclaredMethods();
    for(Method m : methods) {
      System.out.printf("메서드명: %s.%s\n",
          m.getDeclaringClass().getSimpleName(), 
          m.getName());
      
      Parameter[] params = m.getParameters();
      System.out.printf("파라미터: %d\n",m.getParameterCount());
      for(Parameter p : params) {
        System.out.printf("    %s:%s\n",
            p.getName(),
            p.getType().getName());
      }
      
      System.out.println("리턴타입: ");
      System.out.printf("    %s\n", m.getReturnType().getName());
      
      int modifiers = m.getModifiers();
      if((modifiers & PUBLIC) == (PUBLIC)){
        System.out.println("public");
      } else if ((modifiers & PROTECTED) == (PROTECTED)){
        System.out.println("protected");
      } else if ((modifiers & PRIVATE) == (PRIVATE)){
        System.out.println("private");
        
        if((modifiers & STATIC) != 0) {
          System.out.println("  static");
        } 
        if((modifiers & FINAL) != 0)
          System.out.println("  final");
      }
      System.out.println("==========================");
    }
    
  }
}
