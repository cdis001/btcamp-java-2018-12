package ch18.c;

public class Tool implements ProtocolA, ProtocolB {

  @Override
  public void m1() {
    System.out.println("Tool.m1();");
  }@Override
  public void m2() {
    System.out.println("Tool.m2();"); //ProtocolB와 A가 중복되지만, 구별해서 쓸 수 있는 방법은 없으며 하나로 합쳐서 써야 함
  }@Override
  public void m3() {
    System.out.println("Tool.m3();");
}
}