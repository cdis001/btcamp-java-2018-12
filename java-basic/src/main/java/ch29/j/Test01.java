package ch29.j;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test01 {
  public static void main(String[] args) {

    ApplicationContext iocContainer = 
        new AnnotationConfigApplicationContext(AppConfig1.class);
    
    System.out.println("---------------------------");
    
    String[] names = iocContainer.getBeanDefinitionNames();
    for(String name : names) {
      System.out.printf(
          "%s ==> %s\n",
          name, 
          iocContainer.getBean(name).getClass().getName());
    }
  }
}






