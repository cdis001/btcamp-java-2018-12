package ch02;

public class Test06 {
  static final float f = 12.375f;
  public static void main(String[] args) {
    System.out.println(0.1f * 0.1f); //부동소수점 방식의 대표적 오류 
    //부동소수점을 2진수로 바꿀 때 오차가 있을 수 있음
    
    //해결방안
    // => 예상값의 오차 범위가 부동소수점에서 인정하는 오차 이하의 값이면 같은 것으로 취급
    System.out.println((0.1f * 0.1f - 0.01f) <= Float.POSITIVE_INFINITY);
  }

}
