package ch28.e;

@MyAnnotation7(
    name="홍길동",
    age=20)
    
public class Test04 {
  public static void main(String[] args) {
    
//    Class<?> clazz = Test04.class;
    MyAnnotation7 anno1 = Test04.class.getAnnotation(MyAnnotation7.class);
    for (String s : anno1.value()) {
      System.out.println("==> " + s);
    }
    System.out.println(anno1.name());
    System.out.println(anno1.age());
    System.out.println(anno1.working());
  }
}