package ch27.b;

public class Test09 extends C {

  public static void main(String[] args) throws Exception {
    Class<?> clazz = Test09.class;
    
    Class<?> supers = clazz.getSuperclass();
    
    System.out.println(supers.getName());
    
  }
}
