package ch19.d;

public class Test01 {
  public static void main(String[] args) {
    Product p = new Product();
    p.maker = "비트컴퓨터";
    p.title = "비트 마우스";
    p.price = 98000;
    p.category = Category.computer.mouse.bluetooth;
  }
}
