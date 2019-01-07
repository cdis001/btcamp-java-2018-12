package ch04;
//산술연산자

public class Test03 {
  public static void main(String[] args) {
    
    float r = 5 / 2; //변수에 값을 저장하기 전에 이미 값이 2로 나옴
    System.out.println(r);
    
    float r2 = (float)5 / (float)2;
    System.out.println(r2);
    
    float r3 = 5 / (float)2;
    
    byte b1 = 20;
    byte b2 = 30;
    //byte b3 = b1 + b2; ->결과가 int로 임시 메모리에 저장되었기 때문에 결과가 int임
    int x1 = b1 + b2;
    
    short s1 = 20;
    short s2 = 30;
    //short s3= s1 + s2;
    int x2 = s1 + s2;
    
    char c1 = 20;
    char c2 = 30;
    //char c3 = c1 + c2;
    int x3 = c1 + c2;
    
    int i1 = 100;
    float f1 = 200.5f;
    //int i2 = i1 + f1;
    float f2 = i1 + f1;
    
    float f3 = 9876.543f;
    float f4 = 12.34567f;
    double d1 = f3 + f4; //d1에 저장되기 전에 자릿수를 초과한 값은 오차값으로 저장됨
        System.out.println(d1);
        
    double d2 = (double)f3 + (double)f4;
     //=> float를 double로 형변환 시 오차가 이미 생김
     //부동소수점을 다룰 때 생기는 오차. 개발자가 제어할 수 없음
    
    
    double d7 = 9876.543;
    double d8 = 12.34567;
    double d9 = d7 + d8;
    System.out.println(d9);
     
    
  }
}
