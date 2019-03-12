package ch04;

public class Test19 {
  public static void main(String[] args) {
    int d1 = 0x01 | 0x02 | 0x04 | 0x80;
    int d2 = 0x0087;
    
    System.out.println(d1);
    System.out.println(d2);
    
    System.out.printf("Java      : %b\n", (d2 & 0x0001) == 0x0001);
    System.out.printf("C         : %b\n", (d2 & 0x0002) == 0x0002);
    System.out.printf("C++       : %b\n", (d2 & 0x0004) == 0x0004);
    System.out.printf("Python    : %b\n", (d2 & 0x0008) == 0x0008);
    System.out.printf("PHP       : %b\n", (d2 & 0x0010) == 0x0010);
    System.out.printf("Kotlin    : %b\n", (d2 & 0x0020) == 0x0020);
    System.out.printf("Groovy    : %b\n", (d2 & 0x0040) == 0x0040);
    System.out.printf("JavaScript: %b\n", (d2 & 0x0080) == 0x0080);
    System.out.printf("TypeScript: %b\n", (d2 & 0x0100) == 0x0100);
    System.out.printf("Go        : %b\n", (d2 & 0x0200) == 0x0200);
    System.out.printf("SQL       : %b\n", (d2 & 0x0400) == 0x0400);
    System.out.printf("R         : %b\n", (d2 & 0x0800) == 0x0800);
  }
}
