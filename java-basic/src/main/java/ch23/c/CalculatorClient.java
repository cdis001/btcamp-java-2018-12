package ch23.c;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class CalculatorClient {
  public static void main(String[] args) {
    try (Scanner keyboard = new Scanner(System.in);
        Socket socket = new Socket("localhost", 8888);
        PrintStream out = new PrintStream(socket.getOutputStream());
        BufferedReader in = new BufferedReader (
            new InputStreamReader(socket.getInputStream()))) {
      while (true) { 
        System.out.println("> ");
        String input = keyboard.nextLine();

        out.println(input);
        out.flush();

        String response = in.readLine();
        System.out.println(response);

        if (input.equalsIgnoreCase("quit")) {
          break;
        }
      }
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
  
  static void sendGreeting(PrintStream out) {
    
  }
  
  static void doCalculate(String request, PrintStream out) {
    
  }
}
