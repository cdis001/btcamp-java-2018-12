package ch03;

public class Test03 {
  public static void main(String[] args) {
    int a = 5;
    int b = 2;
    System.out.println(a / b);
    
    float f1 = 9876.543f;
    float f2 = 12.34567f;
    System.out.println(f1 + f2); //float의 값을 넘어가는 결과가 나오면 나머지 값을 버림
    
    double d1 = 9876.543;
    double d2 = 12.34567;
    System.out.println(d1 + d2);
  }

}
