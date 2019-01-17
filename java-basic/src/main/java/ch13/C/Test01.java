package ch13.C;

public class Test01 {

  public static void main(String[] args) {
    B obj = new B();
    
    obj.m1();
    obj.m2(); //복제해온것이 아닌, 사용권을 획득해왔기 때문에 super클래스가 없으면, 실행 불가능함
  }

}
