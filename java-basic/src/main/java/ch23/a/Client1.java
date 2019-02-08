package ch23.a;

import java.net.Socket;

public class Client1 {

  public static void main(String[] args) throws Exception {
    Socket scocket = new Socket("localhost", 8888);
    
    System.out.println("서버와 연결됨");
    
    
  }

}
