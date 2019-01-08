package ch04;
//비트이동연산3 <<

public class Test16 {
  public static void main(String[] args) {
 
    int a = 0xc9; //201
    System.out.println(Integer.toHexString(a << 4));
    System.out.println(a << 4);

    System.out.println(Integer.toHexString(a << 3));
    System.out.println(a << 3);
    
    System.out.println(Integer.toHexString(a << 2));
    System.out.println(a << 2);
    
    System.out.println(Integer.toHexString(a << 1));
    System.out.println(a << 1);
    
    a = -0x7f_ff_ff_fa; //부호비트 바로 다음값이 0임
    System.out.println(a << 1);
    System.out.println(a << 2);
    System.out.println(a << 3);
    System.out.println(a << 4);

    
  }
}
