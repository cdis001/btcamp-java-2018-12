package test;

import java.util.*;

public class A {
  public static void main(String[] args) {
    Scanner kb = new Scanner(System.in);
    
    System.out.println("숫자를 입력하세요");
    int no = Integer.parseInt(kb.nextLine());
    
    System.out.printf("입력하신 숫자는 10진법으로 %d 입니다.", no);
    System.out.printf("입력하신 숫자는 16진법으로 %x 입니다", no);
    
    Date today = new Date();
    
    System.out.printf("지금 시간은 %1$tH:%1$tm:%1$td 입니다", today);
    
    
    
    kb.close();
    
    // * %1의 필요성?
  }

}
