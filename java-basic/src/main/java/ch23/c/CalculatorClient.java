package ch23.c;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class CalculatorClient {
  public static void main(String[] args) {
    try (Socket socket = new Socket("localhost", 8888);
        PrintWriter out = new PrintWriter(socket.getOutputStream());
        Scanner in = new Scanner(socket.getInputStream())) {
      System.out.println("계산기 서버에 오신 걸 환영합니다!");
      while (true) {
      System.out.println("계산식을 입력하세요!");
      System.out.println("예) 23 + 7 ");
      System.out.println("> ");
      String a = keyboard.nextLine();
      if (a.equalsIgnoreCase("quit")) {
        break;
      }
      String request = in.nextLine();
      out.printf("결과는 %d 입니다\n", request);
      out.flush();
      
      keyboard.nextLine();
      
      }
    } catch(Exception e) {
      e.printStackTrace();
    }

  }
}
