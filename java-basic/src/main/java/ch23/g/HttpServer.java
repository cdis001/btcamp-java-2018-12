package ch23.g;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class HttpServer {

  public static void main(String[] args) {
    try(ServerSocket serverSocket = new ServerSocket(8888);){
      System.out.println("서버 실행 중...");
      while(true) {
        try(Socket socket = serverSocket.accept();
            PrintStream out = new PrintStream(socket.getOutputStream());
            Scanner in = new Scanner(socket.getInputStream())){

          System.out.println("클라이언트와 연결됨");
          while (true) {
          String request = in.nextLine();
          System.out.println(request);
          if(request.length() == 0)
            break;
          }
          out.println("HTTP/1.1 200 ok");
          out.println("Content-Type: text/html;charset=UTF-8");
          out.println();
          out.println("<html><body><h1>aaa</h1></body></html>");
          out.flush();
          
        } catch (Exception e) {
          e.printStackTrace();
        }  
      }
    } catch (Exception e1) {
      e1.printStackTrace();
    }
  }
}

