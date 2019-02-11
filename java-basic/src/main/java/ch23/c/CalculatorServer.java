package ch23.c;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class CalculatorServer {

  public static void main(String[] args) {
    try(Scanner keyboard = new Scanner(System.in);
        ServerSocket serverSocket = new ServerSocket(8888);) {
      System.out.println("서버 실행중...");
      
      while (true) {
      try(Socket socket = serverSocket.accept();
          PrintStream out = new PrintStream(socket.getOutputStream());
          BufferedReader in = new BufferedReader (
              new InputStreamReader(socket.getInputStream()))) {
        
        String[] input = in.readLine().split(" ");
        
        int a = Integer.parseInt(input[0]);
        String op = input[1];
        int b = Integer.parseInt(input[2]);
        int result = 0;
        
        switch (op) {
          case "+": result = a + b; break;
          case "-": result = a - b; break;
          case "*": result = a * b; break;
          case "/": result = a / b; break;
          case "%": result = a % b; break;
          
          default: 
            out.printf("%s 연산자를 지원하지 않습니다.", op);
            out.flush();
            continue;
        } 

        out.printf("결과는 %d입니다 \n", result);
        out.flush();
        
        }
      } 

    } catch(Exception e) {
      e.printStackTrace();
    }
    System.out.println("서버 종료!");
  }
  static void processRequest (Socket socket) {
    
  }
}

