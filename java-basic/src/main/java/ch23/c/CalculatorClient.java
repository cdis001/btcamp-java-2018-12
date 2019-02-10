package ch23.c;

import java.io.DataInputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class CalculatorClient {
  public static void main(String[] args) {
    try (Scanner keyboard = new Scanner(System.in);
        Socket socket = new Socket("localhost", 8888);
        PrintStream out = new PrintStream(socket.getOutputStream());
        DataInputStream in = new DataInputStream(socket.getInputStream())) {
      System.out.println("계산기 서버에 오신 걸 환영합니다!");

      keyboard.nextLine();
      
      while (true) {
        int a = in.readInt();
        String b = in.readUTF();
        int c = in.readInt();
        int result = 0;

        switch (b) {
          case "+": result = a + c; break;
          case "-": result = a - c; break;
          case "*": result = a * c; break;
          case "/": result = a / c; break;
        }

        if(b.equalsIgnoreCase("quit")) {
          break;
        }
        out.printf("결과는 %d입니다 \n", result);
      }
      out.println("안녕히 가세요!");



    } catch(Exception e) {
      e.printStackTrace();
    }

  }
}
