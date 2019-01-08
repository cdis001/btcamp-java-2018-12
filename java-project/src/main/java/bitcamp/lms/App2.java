package bitcamp.lms;
import java.util.*;
import java.sql.Date;

public class App2 {

  public static void main(String[] args) {
    Scanner kb = new Scanner (System.in);
    int a1 = 200;
    String[] b = new String[a1]; //max 200
    int a2 = 0; 
    java.util.Date date = new java.util.Date();
    
    while (a2 < a1) {

      int no;
      String name;
      String mail;
      String pass;
      String pic;
      int phone;
      
      
      System.out.println("번호? ");
      no = Integer.parseInt(kb.nextLine());

      System.out.println("이름? ");
      name = kb.nextLine();

      System.out.println("이메일? ");
      mail = kb.nextLine();

      System.out.println("암호? ");
      pass = kb.nextLine();

      System.out.println("사진? ");
      pic = kb.nextLine();

      System.out.println("전화번호? ");
      phone = Integer.parseInt(kb.nextLine());
      
      

      System.out.println("계속하시겠습니까? (Y/n)");
      String str = kb.nextLine(); 

      if (!str.equalsIgnoreCase("y") && !str.equalsIgnoreCase("")) {
        break;

        
      }
      a2++;
      while (a1 < 200) {
        System.out.println();
        System.out.printf("%d. ", no);
        System.out.printf("%s: ", name);
        System.out.printf("%s ~ %s, ", mail);
        System.out.printf("%d, ", phone);
        //System.out.printf("%s/n", );
        
          break;
    }
  }
    kb.close();
}
}
  