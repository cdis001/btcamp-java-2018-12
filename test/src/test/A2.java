//배열, 연산자
package test;

public class A2 {
  public static void main(String[] args) {
    //배열 선언 기본 ;배열 선언시 배열을 선언 한 뒤에 배열의 길이를
    int[] a;
    a = new int[2];
    a[0] = 30;
    a[1] = 20;
    
    System.out.println(a[0]);
    
    //래퍼런스 변수 선언시 배열생성
    int[] a1 = new int[5];
    System.out.println(a1[0]);
    
    //래퍼런스 변수 선언시 배열 생성과 동시에 값 초기화
    int[] a2 = new int[] {100, 90, 30};
    System.out.println(a2[0]);
    
    //배열 생성과 동시에 배열 생성 문법 생략하기
    int[] a3 = {100, 90, 50};
    System.out.println(a3[0]);
    
    //레퍼런스를 먼저 선언 했을 경우 배열 생성 문법은 생략할 수 없다
    int[] a4;
    a4 = new int[] {50, 60, 70};
    System.out.println(a4[0]);
    
    
  }

}
