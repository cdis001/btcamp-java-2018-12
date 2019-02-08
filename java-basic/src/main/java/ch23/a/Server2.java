package ch23.a;

import java.net.ServerSocket;
import java.util.Scanner;

public class Server2 {
  public static void main(String[] args) throws Exception {
    Scanner keyboard = new Scanner(System.in);
    
    ServerSocket serverSoket = new ServerSocket(8888, 3);
    System.out.println("서버 소켓 생성 완료");
    System.out.println("클라이언트의 연결 기다림");
    
    keyboard.nextLine();
    
    serverSoket.close();
    System.out.println("서버 소켓 종료");
    
    keyboard.close();
  }
}
