package ch29.a;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test03_x {
  public static void main(String[] args) {

    ApplicationContext iocContainer = 
        new ClassPathXmlApplicationContext("ch29/a/application-context-03.xml");
    
    Student2 b1 = (Student2) iocContainer.getBean("student2");
    System.out.println(b1);
    
    Student b2 = (Student) iocContainer.getBean("student");
    System.out.println(b2);
    
    System.out.println("실행 완료!");
  }
}






