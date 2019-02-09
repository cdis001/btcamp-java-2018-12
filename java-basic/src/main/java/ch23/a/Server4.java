package ch23.a;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server4 {
  public static void main(String[] args) throws Exception {
    Scanner keyboard = new Scanner(System.in);
    
    ServerSocket serverSoket = new ServerSocket(8888, 3);
    System.out.println("서버 소켓 생성 완료");
    System.out.println("클라이언트의 연결 기다림");
    
    while(true) {
    String input = keyboard.nextLine();
    if (input.equalsIgnoreCase("q")) {
      break;
    }
    Socket socket = serverSoket.accept();
    System.out.println("클라이언트와 연결되었음");
    }
    serverSoket.close();
    System.out.println("서버 소켓 종료");
    
    keyboard.close();
  }
}
