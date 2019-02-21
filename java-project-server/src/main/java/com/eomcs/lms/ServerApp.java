package com.eomcs.lms;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Set;
import com.eomcs.lms.dao.BoardDaoImpl;
import com.eomcs.lms.dao.LessonDaoImpl;
import com.eomcs.lms.dao.MemberDaoImpl;
import com.eomcs.lms.service.BoardDaoSkel;
import com.eomcs.lms.service.LessonDaoSkel;
import com.eomcs.lms.service.MemberDaoSkel;
import com.eomcs.lms.service.Service;

public class ServerApp {

  static BoardDaoImpl boardDaoImpl;
  static MemberDaoImpl memberDaoImpl;
  static LessonDaoImpl lessonDaoImpl;

  static HashMap<String, Service> serviceMap;
  static Set<String> serviceKeySet;

  public static void main(String[] args) {

    try {
      boardDaoImpl = new BoardDaoImpl("board.bin");
      boardDaoImpl.loadData();
    } catch (Exception e) {
      System.out.println("게시글 데이터 로딩 중 오류 발생!");
    }

    try {
      memberDaoImpl = new MemberDaoImpl("member.bin");
      memberDaoImpl.loadData();
    } catch (Exception e) {
      System.out.println("멤버 데이터 로딩 중 오류 발생!");
    }

    try {
      lessonDaoImpl = new LessonDaoImpl("lesson.bin");
      lessonDaoImpl.loadData();
    } catch (Exception e) {
      System.out.println("수업 데이터 로딩 중 오류 발생!");
    }
    serviceMap = new HashMap<>();
    serviceMap.put("/board/", new BoardDaoSkel(boardDaoImpl));
    serviceMap.put("/member/", new MemberDaoSkel(memberDaoImpl));
    serviceMap.put("/lesson/", new LessonDaoSkel(lessonDaoImpl));

    serviceKeySet = serviceMap.keySet();

    try (ServerSocket serverSocket = new ServerSocket(8888)) { 
      System.out.println("서버 시작!");

      while (true) {
        new RequestProcessorThread(serverSocket.accept()).start();

      }

    } catch (Exception e) {
      e.printStackTrace();

    }

  }

  static void quit(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    try {
      boardDaoImpl.saveData();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

    try {
      lessonDaoImpl.saveData();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

    try {
      memberDaoImpl.saveData();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    out.writeUTF("종료합니다");
  }

  static class RequestProcessorThread extends Thread {
    Socket socket;

    public RequestProcessorThread(Socket socket) {
      this.socket = socket;
    }

    @Override
    public void run() {
      try (Socket socket = this.socket; //close 자동 호출을 위해 넣음
          ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
          ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())) {

        System.out.println("클라이언트와 연결되었음.");

        String request = in.readUTF(); //명령어 읽어옴
        System.out.println(request);

        Service service = GetService(request);

        if(request.equalsIgnoreCase("quit")) {
          quit(in, out);
          out.flush();
        }

        String serviceName = null;
        for(String key : serviceKeySet) {
          if(request.startsWith(key)){
            serviceName = key;
            break;
          }
        }
        if (serviceName == null) {
          out.writeUTF("FAIL");

        } else {
          service.execute(request, in, out);
        }
        out.flush();

      } catch (Exception e) {
        e.printStackTrace();
      }
      System.out.println("클라이언트와의 연결을 끊었음.");
    }

    static Service GetService(String request) {
      for(String key : serviceKeySet) {
        if(request.startsWith(key)){
          return serviceMap.get(key);
        }
      }
      return null;
    }
  }


}