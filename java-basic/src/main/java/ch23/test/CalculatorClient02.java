package ch23.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class CalculatorClient02 {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    long id = 0;
    
    while (true) {
      System.out.print("> ");
      String input = keyboard.nextLine();
      if (input.equalsIgnoreCase("quit")) {
        break;
      }
      try (Socket socket = new Socket("localhost", 8888);
          PrintStream out = new PrintStream(socket.getOutputStream());
          BufferedReader in = new BufferedReader(
              new InputStreamReader(socket.getInputStream()))) {

        System.out.println("서버와 연결됨! 서버에게 계산 작업 요청중...");
        
        out.println(id);
        out.println(input);
        out.flush();
        
        if(id == 0) {
          id = Long.parseLong(in.readLine());
          System.out.printf("세션 ID(%d)를 발급받았습니다.\n", id); 
        }

        String response = in.readLine();
        System.out.println(response);
        

      } catch (Exception e) {
        e.printStackTrace();
      }
      System.out.println("서버와 연결 끊어짐");
    } //while end
    
    keyboard.close();
  } //main M end
} //CCclass end











