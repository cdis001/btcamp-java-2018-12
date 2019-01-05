
package bitcamp.lms;

public class App3 {

    public static void main(String[] args) {      
    java.io.InputStream in = System.in;
    java.util.Scanner keyboard = new java.util.Scanner(in);
    
    System.out.println("번호? ");
    int number = keyboard.nextInt();
    keyboard.nextLine();
    
    System.out.println("내용? ");
    String name = keyboard.nextLine();
    
    System.out.printf("번호: %d\n", number);
    System.out.printf("내용: %s\n", name);
    java.util.Date today = new java.util.Date();
    System.out.printf("작성일: %1$tY-%1$tm-%1$td \n",today);
    System.out.println("조회수: ");

    
  
  
    }
}
