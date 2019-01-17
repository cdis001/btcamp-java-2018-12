package ch14.b;

public class C extends A {
  @Override public void m1(int a) {
    
    super.m1(a);
  }
  
  public void m4() {
    this.m1(100);
    this.m2("okok", 100);
    super.m2("haha", 200); //C에는 m2가 없으므로 A에 있는 m2를 가지고 오기 때문에 둘의 결과는 같음
  }
  
  public static void main(String[] args) {
    C obj = new C();
    obj.m4();
  }
}
