package ch04;
//논리연산자 &&, ||, ^

public class Test11 {
  public static void main(String[] args) {
    //피연산자가 boolean 타입일 때는 &&, ||와 동일하게 수행함
    //and연산
  System.out.println(true & false);
  System.out.println(true & true);
  
    //or연산
  System.out.println(true | false);
  System.out.println(false | false);

  int a = 0xca; // 0000 0000 0000 0000 0000 0000 1100 1010
  int b = 0x66; // 0000 0000 0000 0000 0000 0000 0110 0110
  
  System.out.println(a & b);
          // 0000 0000 0000 0000 0000 0000 0100 0010 -> 둘 다 1이여야 1
  System.out.println(a | b);
          // 0000 0000 0000 0000 0000 0000 1110 1110 -> 둘 중 하나가 1이면 1
   }
}
