package ch18.c;

public class Tool2 implements ProtocolA, ProtocolC {

  @Override
  public void m1() {
    System.out.println("Tool.m1();");
  }@Override
  public void m2() {
    System.out.println("Tool.m2();"); //ProtocolB와 C가 리턴타입이 다르기 때문에 오버로딩 규칙에 따라 메서드를 중복해서 만들 수 없음
  }@Override
  public void m3() {
    System.out.println("Tool.m3();");
}
}