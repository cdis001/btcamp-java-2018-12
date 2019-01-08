package ch03;

public class Test13 {
  public static void main(String[] args) {

  // 일반 배열 생성
    int[] arr1; 
    arr1 = new int[5];
    arr1[0] = 100;
    arr1[1] = 90; 
    arr1[2] = 80;
    arr1[3] = 70;
    arr1[4] = 60;

  // 레퍼런스 변수를 선언할 때 배열 생성하기
    int[] arr2 = new int[5];
    
  // 레퍼런스 변수를 선언할 때 배열 생성과 값을 초기화시키기
    int[] arr3 = new int[] {100, 100, 90, 90, 60};
    
  // 배열 생성과 동시에 값을 초기화 시킬 때 배열 생성 문법을 생략 가능
    int[] arr4 = {100, 100, 90, 90, 60};
    
  // 레퍼런스를 별도로 선언한 경우에는 위의 방법으로 초기화시킬 수 없음
    int[] arr5;
    arr5 = new int[] {90, 90, 90, 90, 90};
    
  }
  

}
