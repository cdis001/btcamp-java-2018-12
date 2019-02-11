package ch23.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class CalculatorServer01 {
  public static void main(String[] args) throws Exception {
    try(ServerSocket serverSocket = new ServerSocket(8888);) {
      System.out.println("서버 실행중...");

        Socket socket = null;
        PrintStream out = null;
        BufferedReader in = null; 
        
      while(true) {
          try {
            socket = serverSocket.accept();
            out = new PrintStream(socket.getOutputStream());
            in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));

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
                out.println("지원하지 않는 계산식입니다");
                out.flush();
                continue;
            }
            out.printf("결과는 %d입니다.\n", result);
            out.flush();
          }catch(Exception e) {
            try {
            out.println("식의 형식이 잘못되었습니다");
            out.flush();
            } catch(Exception e2) {
            e2.printStackTrace(); 
            }
          }finally {
            try {socket.close();} catch(Exception e) {}
            try {out.close();} catch(Exception e) {}
            try {in.close();} catch(Exception e) {}
          }
      } 
    }catch (Exception e) {
      System.out.println("서버 연결중 오류가 발생했습니다");
      e.printStackTrace();
    }
  }
}

