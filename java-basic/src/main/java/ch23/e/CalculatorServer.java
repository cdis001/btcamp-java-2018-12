package ch23.e;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class CalculatorServer {
  public static void main(String[] args) {
    HashMap<String, Integer> map = new HashMap<String, Integer>(); 
    
    try (ServerSocket serverSocket = new ServerSocket(8888)) {
      System.out.println("서버 실행 중...");
      
      while (true) {
        try (Socket socket = serverSocket.accept();
            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
            PrintStream out = new PrintStream(socket.getOutputStream());) {
          
          System.out.println("클라이언트와 연결됨! 요청 처리중...");
          String id = in.readLine();
          int result = 0;
          if (map.get(id) == null ) {
            result = 0;
          } else {
            result = map.get(id);
          }
          
          String[] input = in.readLine().split(" ");
          
          String op = null;
          int b = 0;
          
          try {
            op = input[0];
            b = Integer.parseInt(input[1]);
          } catch (Exception e ) {
            e.printStackTrace();
          }
          switch (op) {
            case "+": result = result + b; break;
            case "-": result = result - b; break;
            case "*": result = result * b; break;
            case "/": result = result / b; break;
            case "%": result = result % b; break;
            default:
              out.printf("%s 연산자를 지원하지 않습니다.\n", op);
              out.flush();
              continue;
          }
          
          out.printf("결과는 %d 입니다.\n", result);
          out.flush();
          out.print(result);
          out.flush();
          
          map.put(id, result);
        } catch (Exception e) {
          System.out.println("클라이언트와 통신중 오류 발생");
        }
        System.out.println("클라이언트와 연결 끊음");
      }
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
