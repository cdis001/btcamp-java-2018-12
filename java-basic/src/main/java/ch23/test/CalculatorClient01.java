package ch23.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class CalculatorClient01 {
  public static void main(String[] args) {

    try(Scanner keyboard = new Scanner(System.in);
        Socket socket = new Socket("localhost", 8888);
        PrintStream out = new PrintStream(socket.getOutputStream());
        BufferedReader in = new BufferedReader(
            new InputStreamReader(socket.getInputStream()))) {


      while(true) {
        System.out.println();
        System.out.println("계산기 서버에 오신걸 환영합니다!");
        System.out.println("계산식을 입력해주세요");
        System.out.println("예: 25 + 30");
        System.out.print("> ");
        String input = keyboard.nextLine();
        if(input.equalsIgnoreCase("quit")) {
          System.out.println("계산기를 종료합니다.");
          break;
        }
        out.println(input);
        out.flush();

        String response = in.readLine();
        System.out.println(response);
      }
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
}
