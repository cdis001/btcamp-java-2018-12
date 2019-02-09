package ch23.b;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import ch22.c.BufferedInputStream;

public class Server3 {
  public static void main(String[] args) {
    try(Scanner keyboard = new Scanner(System.in);
        ServerSocket serverSocket = new ServerSocket(8888);) {

      System.out.println("서버소켓 생성 완료");
      System.out.println("클라이언트와의 연결 기다림");
      try(Socket socket = serverSocket.accept();
          PrintWriter out = new PrintWriter(socket.getOutputStream());
          DataInputStream in = new DataInputStream(
              new BufferedInputStream(socket.getInputStream()))) {

        System.out.println("대기열에서 클라이언트 정보를 꺼내 소켓을 생성하였음");
        System.out.println("클라이언트와 통신할 입출력 스트림이 준비되었음");

        System.out.println("데이터를 읽기 전에 잠깐 기다림");
        
        long fileLen = in.readLong();
        System.out.printf("받는 파일의 크기: %d bite\n", fileLen);
        
        String fileName = in.readUTF();
        System.out.printf("받는 파일의 이름: %s\n", fileName);
        
        File file = new File("temp/download/" + fileName);
        
        try(BufferedOutputStream fileOut = new BufferedOutputStream(
            new FileOutputStream(file))) {
          for (long i = 0; i < fileLen; i++) {
            fileOut.write(in.read());
          }
          fileOut.flush();
          System.out.println("다운로드 완료");
        } catch (Exception e) {
          out.println("fail");
          out.flush();
        }
        out.println("success");
        out.flush();
        System.out.println("클라이언트에게 응답했음");
      } 
      System.out.println("클라이언트와 연결을 끊었음");
      
    } catch(Exception e) {
      e.printStackTrace();
    }
    System.out.println("서버 종료!");
  }
}
