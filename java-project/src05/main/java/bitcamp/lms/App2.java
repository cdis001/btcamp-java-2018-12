
package bitcamp.lms;

public class App2 {

    public static void main(String[] args) {      
    java.io.InputStream in = System.in;
    java.util.Scanner keyboard = new java.util.Scanner(in);
    
    System.out.println("번호? ");
    int number = keyboard.nextInt();
    keyboard.nextLine();
    
    System.out.println("이름? ");
    String name = keyboard.nextLine();
    
    System.out.println("이메일? ");
    String email = keyboard.nextLine();
    
    System.out.println("암호? ");
    int passward = keyboard.nextInt();
    keyboard.nextLine();
    
    System.out.println("사진? ");
    String photo = keyboard.nextLine();
    
    System.out.println("전화번호? ");
    int phone = keyboard.nextInt();
    keyboard.nextLine();
    
    System.out.printf("번호: %d\n", number);
    System.out.printf("이름: %s\n", name);
    System.out.printf("이메일: %s\n", email);
    System.out.printf("비밀번호: %s\n", passward);
    System.out.printf("사진: %s\n", photo);
    System.out.printf("전화번호: %d\n", phone);
    
    
  
  
    }
}
