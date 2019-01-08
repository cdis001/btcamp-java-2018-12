package ch04;
//논리연산자 &&, || vs &, |

public class Test12 {
  public static void main(String[] args) {
    //괄호연산
    int a = 5;
    int r = 10 / (a = 2);
    
    System.out.printf("%d, %d\n", a, r);
    // r = 10 / (a = 2)
    // r = 10 / (a값에 2를 저장한 뒤 리턴함)-> a = 2
    // r = 10 / 2 = 5
    
    boolean b1 = true;
    boolean b2 = false && (b1 = false);
    System.out.printf("b1=%b, b2=%b\n", b1, b2); //true, false
    
    b1 = true;
    b2 = false & (b1 = false);
    System.out.printf("b1=%b, b2=%b\n", b1, b2); //false, false
    
  }
}
