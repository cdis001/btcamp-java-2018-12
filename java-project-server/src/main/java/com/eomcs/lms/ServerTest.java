package com.eomcs.lms;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import com.eomcs.lms.domain.Member;

public class ServerTest {

  public static void main(String[] args) {
    
    try (Socket socket = new Socket("localhost", 8888);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
      
      System.out.println("서버와 연결되었음.");
      
      Member member = new Member();
      member.setNo(1); 
      member.setName("홍길동");
      member.setEmail("aaa@email.com");
      member.setPassword("111");
      member.setPhoto("aaa.jpg");
      member.setTel("1111-1111");
      
   // Member 객체를 서버로 serialize하라!
      out.writeObject(member);
      out.flush();
      
      // 또한 서버에서 serialize한 Member 객체를 받아라. 
      String re = in.readLine();
      System.out.println(re);
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("서버와의 연결을 끊었음.");
  }

}
