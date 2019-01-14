package ch09;

public class Test05 {
  public static void main(String[] args) {

    //식 1 :2 * 3 - 2 + 7
    //식 2 :6 / 2 + 8
    Calculator3 c1 = new Calculator3();
    Calculator3 c2 = new Calculator3();
    
    Calculator3.plus(c1, 2);
    Calculator3.plus(c2, 6);
    
    Calculator3.multiple(c1, 3);
    Calculator3.divide(c2, 2);
    
    Calculator3.minus(c1, 2);
    Calculator3.plus(c2, 8);
    
    Calculator3.plus(c1, 7);
        
    System.out.println(c1.result); //c1값은 Calculator3의 주소값이므로 c1의 result값을 불러와야 함
    System.out.println(c2.result);
    
  }
  
}
