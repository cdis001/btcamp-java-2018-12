package ch09;

public class Test06 {
  public static void main(String[] args) {

    //식 1 :2 * 3 - 2 + 7
    //식 2 :6 / 2 + 8
    Calculator4 c1 = new Calculator4();
    Calculator4 c2 = new Calculator4();
    
    c1.plus(2);
    c2.plus(6);
    
    c1.multiple(3);
    c2.divide(2);
    
    c1.minus(2);
    c2.plus(8);
    
    c1.plus(7);
        
    System.out.println(c1.result); //c1값은 Calculator3의 주소값이므로 c1의 result값을 불러와야 함
    System.out.println(c2.result);
    
  }
  
}
