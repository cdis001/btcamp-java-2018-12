package ch06;

public class Test11 {
  public static void main(String[] args) {
    int value = 100;
    m1(value); //메모리에 저장된 '값'을 넘기기 때문에 main 메서드의 value 변수에는 영향을 끼치지 않음 
    System.out.println(value); //예상값: 100
    
    int[] arr = new int[] {100, 200, 300};
    System.out.println(arr[1]);
    m2(arr); //arr의 값을 넘기지만, arr의 값은 배열의 주소이므로, arr[1]의 값이 변함
    System.out.println(arr[1]);
    
  }
  static void m1(int value) {
    value *= 2;
  }
  
  static void m2(int[] arr) {
    arr[1] = 111;
  }
}

