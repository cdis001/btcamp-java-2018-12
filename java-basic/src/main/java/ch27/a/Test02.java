package ch27.a;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test02 {

  public static void main(String[] args) {
//    String s = "hello";
//    Class<?> c1 = String.class;
//    Class<?> c2 = s.getClass();
//    Class<?> c3 = Class.forName("java.lang.String");
    
    Object proxy = Proxy.newProxyInstance(
        Test02.class.getClassLoader(), 
        new Class[] {Calculator.class, Calculator2.class, Calculator3.class},
        new InvocationHandler() {
          @Override
          public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            int a = (int) args[0];
            int b = (int) args[1];
            
            switch(method.getName()) {
              
              case "plus": 
                return a + b;
              case "minus": 
                return a - b;
              case "multiple":
                return a * b;
              case "divide":
                return a / b;
              case "mod":
                return a % b;
            }
            return 0;
          }
          });
    Calculator c1 = (Calculator) proxy;
    Calculator2 c2 = (Calculator2) proxy;
    Calculator3 c3 = (Calculator3) proxy;
    
    System.out.println(((Calculator) proxy).plus(10, 20));
    System.out.println(c1.minus(20, 10));
    System.out.println(c2.multiple(20, 10));
    System.out.println(c2.divide(20, 10));
    System.out.println(c3.mod(20, 10));
    
  }
}
