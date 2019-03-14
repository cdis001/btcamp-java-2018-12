package ch28.e;

public class Test01 {
  @MyAnnotation(value="okok") 
  int a;
  
  @MyAnnotation("okok") 
  int b;
  
  @MyAnnotation2(value2="okok")
  int c;
  
//  @MyAnnotation2("okok")
  int d;
  
  @MyAnnotation3()
  int f;
  
  @MyAnnotation3
  int g;
  
  
  
}