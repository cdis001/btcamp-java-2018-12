package ch14.c;

public class Test01 {

  public static void main(String[] args) {
    Calculator obj = new Calculator();
    
    obj.plus(100);
    obj.plus(20, 30);
    obj.plus(new int[] {30, 30, 20});
    System.out.println(obj.result);
    
    Calculator2 obj2 = new Calculator2();
    
    
  }

}
