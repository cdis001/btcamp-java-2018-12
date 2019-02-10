package ch23.c;

import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class CalculatorServer {

  public static void main(String[] args) {
    try(Scanner keyboard = new Scanner(System.in);
        ServerSocket serverSocket = new ServerSocket(8888);) {
      try(Socket socket = serverSocket.accept();
          DataOutputStream out = new DataOutputStream(socket.getOutputStream());
          Scanner in = new Scanner(socket.getInputStream())) {

        System.out.println("계산기 서버에 오신 걸 환영합니다!");
        while (true) {
          System.out.println("계산식을 입력하세요!");
          System.out.println("예) 23 + 7 ");
          System.out.println("> ");
          out.writeInt(Integer.parseInt(keyboard.nextLine()));

          System.out.println("> ");
          out.writeUTF(keyboard.nextLine());

          System.out.println("> ");
          out.writeInt(Integer.parseInt(keyboard.nextLine()));

          String a = in.nextLine();
          if (a.equalsIgnoreCase("quit")) {
            break;
          }

          out.flush();
          //        
          keyboard.nextLine();

        }
      }

    } catch(Exception e) {
      e.printStackTrace();
    }
    System.out.println("서버 종료!");
  }
}

