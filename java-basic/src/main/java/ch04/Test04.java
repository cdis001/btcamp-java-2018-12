package ch04;
//암시적 형변환

public class Test04 {
  public static void main(String[] args) {
    
    float r = 5 / 2 + 3.2f;
    /*
     * int / int -> int
     *       int + float -> float
     */
    
    System.out.println(r);
  }
}
