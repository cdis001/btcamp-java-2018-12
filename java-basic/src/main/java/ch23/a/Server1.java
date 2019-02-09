package ch23.a;

import java.net.ServerSocket;
import java.util.Scanner;

public class Server1 {
  public static void main(String[] args) throws Exception {
    Scanner keyboard = new Scanner(System.in);
    
    ServerSocket serverSocket = new ServerSocket(8888);
    System.out.println("서버소켓 생성 완료");
    System.out.println("클라이언트와의 연결 기다림");
    
    keyboard.nextLine();
    
    serverSocket.close();
    
    keyboard.close();
  }
}
