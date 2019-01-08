package ch04;
//비트이동연산

public class Test14 {
  public static void main(String[] args) {
 
    int a = 0xca; // 0000 0000 0000 0000 0000 0000 1100 1010
    System.out.println(Integer.toHexString(a >> 4));
    System.out.println(a >> 4);
    //   00000000_00000000_00000000_11001010
    //-> 00000000_00000000_00000000_00001100_1010 
    //-> 00000000_00000000_00000000_00001100
    System.out.println(Integer.toHexString(a >> 3));
    System.out.println(a >> 3);
    // 기대값: 00000000_0000000_00000000_00011001(_010)
    
    System.out.println(Integer.toHexString(a >> 2));
    System.out.println(a >> 2);
    
    System.out.println(Integer.toHexString(a >> 1));
    System.out.println(a >> 1);
    
    a = -202; //11111111_11111111_11111111_00110110 = 0xff_ff_ff_36
    System.out.println(a >> 1);
    // 11111111_1111111_11111111_0011011(_0) = 0xff_ff_ff_9b
    System.out.println(a >> 2);
    System.out.println(a >> 3);
    System.out.println(a >> 4);
    
  }
}
