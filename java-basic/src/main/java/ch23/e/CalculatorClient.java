package ch23.e;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class CalculatorClient {
  
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    int result = 0;
    String id = String.valueOf(System.currentTimeMillis());

    while (true) {
      System.out.print("> ");
      String input = keyboard.nextLine();
      if (input.equalsIgnoreCase("quit")) {
        System.out.println(result);
        break;
      }
      try (Socket socket = new Socket("localhost", 8888);
          PrintStream out = new PrintStream(socket.getOutputStream());
          BufferedReader in = new BufferedReader(
              new InputStreamReader(socket.getInputStream()))) {
        System.out.println("서버와 연결됨! 서버에게 계산 작업 요청중...");
        
        out.println(id);
        out.flush();
        
        out.println(input);
        out.flush();

        String response = in.readLine();
        System.out.println(response);
        result = Integer.parseInt(in.readLine());

      } catch (Exception e) {
        e.printStackTrace();
      }
      System.out.println("서버와 연결 끊어짐");
    } //while end
    
    keyboard.close();
  } //main M end
} //CCclass end




