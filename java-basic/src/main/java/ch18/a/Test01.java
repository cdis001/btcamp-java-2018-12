package ch18.a;

public class Test01 {
  public static void main(String[] args) {
    use(new ToolA());
    use(new ToolB());
    
//    use(new String("Hello")) ->A의 규칙(인터페이스)에 따르지 않았으므로 컴파일 오류
  }
  
  static void use(A tool) {
    
    tool.m1();
  }

}
