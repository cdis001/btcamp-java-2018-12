package ch15;

class My11 {
  }

public class Test12 {
  public static void main(String[] args) {
    My11 obj1 = new My11();
    
    Class classinfo = obj1.getClass();
    
    System.out.println(classinfo.getName());
    System.out.println(classinfo.getSimpleName());
}
}
