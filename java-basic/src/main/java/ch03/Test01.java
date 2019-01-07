package ch03;

public class Test01 {
  public static void main(String[] args) {
    //1바이트 정수값을 담을 메모리 준비
    byte b1;
    byte b2;
    
    b1 = -128;
    b2 = 127;
    //b3 = 128; ->
    
    //2바이트 정수값을 담을 메모리 준비
    short s1;
    short s2;
    short s3;
    
    s1 = -32768;
    s2 = 32767;
    //s3 = 32768;
   
    
    //4바이트 정수값을 담을 메모리 준비
    int i1;
    int i2;
    
    i1 = -2100000000;
    i2 = 2100000000;
    //i2 = 2100000000L;->4바이트 값이기 때문에 오류남
    //i3 = 2200000000; ->리터럴 표현 오류! 4바이트 값보다 초과함
    
    //8바이트 정수값을 담을 메모리 준비
    long l1;
    long l2;
    
    l1 = 9000000000000000000L;
    //l2 = 9900000000000000000L; ->리터럴 표현 오류! 8바이트보다 초과
    
    //4바이트 부동소수점 담을 메모리 준비 
    float f1;
    float f2;
    float f3; 
    
    f1 = 9876.543f;
    f2 = 9876.543456789f; //유효 자릿수를 넘어가는 값이더라도 컴파일시 오류는 안 나지만, 짤려서 저장됨
    f3 = f1 + f2; 
    System.out.println(f1);
    System.out.println(f2);
    System.out.println(f3);
    
    //8바이트 부동소수점 담을 메모리 준비
    double d1;
    double d2;
    double d3;
    
    d1 = 9876.543;
    d2 = 9876.54356789;
    d3 = f1 + f2; 
    System.out.println(d1);
    System.out.println(d2);
    System.out.println(d3);
    
    
    //논리 값을 담을 메모리 준비
    boolean bool1;
    boolean bool2;
    boolean bool3;
    
    //문자의 UTF-16코드 값을 담을 메모리 준비
    char c1;
    char c2;
    char c3;
  
  }

}
