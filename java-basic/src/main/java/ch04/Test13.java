package ch04;
//비트연산
//

public class Test13 {
  public static void main(String[] args) {
 
    int a = 0xca; // 0000 0000 0000 0000 0000 0000 1100 1010
    int b = 0x66; // 0000 0000 0000 0000 0000 0000 0110 0110
    
    System.out.println(a & b);
            // 0000 0000 0000 0000 0000 0000 0100 0010 -> 둘 다 1이여야 1
    System.out.println(a | b);
            // 0000 0000 0000 0000 0000 0000 1110 1110 -> 둘 중 하나가 1이면 1
    System.out.println(a ^ b);
           // 0000 0000 0000 0000 0000 0000 1010 1100
    System.out.println(~a);
           // 1111 1111 1111 1111 1111 1111 0011 0101
    
    //&활용: 특정 값을 차단하며 특정 값만 통과시킬 때
    int data = 0b1111_1111_1111_1111;
    System.out.println(Integer.toBinaryString(data & 0b0000_1111_1100_0000));
      //Integer.toBinaryString-> 2진수를 문자열로 변환시켜줌
    //기대값: 0000 1111 1100 0000
    
    int pixel = 0x003f4478; //->RGB값 중 특정한 색(빨강이라 가정)
    System.out.println(pixel & 0x0000ffff); //RGB값 중 pixel값을 빼서
    
    
    
    
  }
}
