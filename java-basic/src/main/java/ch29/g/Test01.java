package ch29.g;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
  public static void main(String[] args) {

    ApplicationContext iocContainer = 
        new ClassPathXmlApplicationContext("ch29/g/application-context-01.xml");
    
    System.out.println("---------------------------");
    
    System.out.println(iocContainer.getBean("c1"));

  }
}






