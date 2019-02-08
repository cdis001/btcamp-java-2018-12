package ch23.b;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server2 {
  public static void main(String[] args) {
    try(Scanner keyboard = new Scanner(System.in);
        ServerSocket serverSocket = new ServerSocket(8888);) {

      System.out.println("서버소켓 생성 완료");
      System.out.println("클라이언트와의 연결 기다림");
      try(Socket socket = serverSocket.accept();
          PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
          Scanner in = new Scanner(socket.getInputStream())) {

        System.out.println("대기열에서 클라이언트 정보를 꺼내 소켓을 생성하였음");
        System.out.println("클라이언트와 통신할 입출력 스트림이 준비되었음");

        System.out.println("데이터를 읽기 전에 잠깐 기다림");
        keyboard.nextLine();
        String request = in.nextLine();
        System.out.println(request);
        
        System.out.println("데이터를 보내기 전에 잠깐 기다림");
        
        keyboard.nextLine();
        
        out.println("**" + request + "**");
//        out.flush();
        System.out.println("클라이언트에게 데이터를 보냈음");

        keyboard.nextLine();
      }
      System.out.println("클라이언트와 연결을 끊었음");
      
    } catch(Exception e) {
      e.printStackTrace();
    }
    System.out.println("서버 종료!");
  }
}
