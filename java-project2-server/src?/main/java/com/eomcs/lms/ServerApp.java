package com.eomcs.lms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import com.eomcs.lms.context.ApplicationContextListener;
import com.eomcs.lms.handler.Command;

public class ServerApp {

  ArrayList<ApplicationContextListener> listeners = new ArrayList<>();

  Scanner keyboard = new Scanner(System.in);
  Stack<String> commandHistory = new Stack<>();
  Queue<String> commandHistory2 = new LinkedList<>();

  public void addApplicationContextListner(ApplicationContextListener listener) {
    listeners.add(listener);
  }

  public void service() throws Exception {

    try(ServerSocket ss = new ServerSocket(8888)) {

      HashMap<String, Object> context = new HashMap<String, Object>();
      context.put("keyboard", keyboard);

      for (ApplicationContextListener listener : listeners) {
        listener.contextInitialized(context);
      }
      
      System.out.println("서버 실행 중...");

      while (true) {

        try (Socket socket = ss.accept();
            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream())) {

          String request = in.readLine();
          
          out.println("ok");
          out.println("!end!");
          out.flush();
          
          if (request.equals("quit")) {
            System.out.println("종료합니다.");
            break;
            
/*
          commandHistory.push(command);
          commandHistory2.offer(command);


          } else if (command.equals("history")) {
            printCommandHistory();
            continue;

          } else if (command.equals("history2")) {
            printCommandHistory2();
            continue;
          } 

          // 사용자가 입력한 명령으로 Command 객체를 찾는다.
          Command commandHandler = (Command) context.get(command);
          if (commandHandler == null) {
            System.out.println("실행할 수 없는 명령입니다.");
            continue;
          }

          // stateful을 stateless로 전환할 때 주의할 점!
          // => 가능한 서버에 요청하는 시점에 서버와 연결하라!
          // => 이 클래스에서 서버와 연결하지 않고 
          //    데이터를 요청하는 일을 하는 객체(*Agent)에 서버 연결을 맡긴다. 
          try {
            commandHandler.execute();
            System.out.println(); 

          } catch (Exception e) {
            System.out.println("명령어 실행 중 오류 발생 : " + e.toString());
            e.printStackTrace();
          } */
        } // try(Socket)
      } // while

      keyboard.close();

      for (ApplicationContextListener listener : listeners) {
        listener.contextDestroyed(context);
      }
    } catch (Exception e) {
      e.printStackTrace();
    } //try(serversocket)-catch

  }

  @SuppressWarnings("unchecked")
  private void printCommandHistory() {
    Stack<String> temp = (Stack<String>) commandHistory.clone();

    while (temp.size() > 0) {
      System.out.println(temp.pop());
    }
  }

  @SuppressWarnings("unchecked")
  private void printCommandHistory2() {
    Queue<String> temp = (Queue<String>) ((LinkedList<String>) commandHistory2).clone();

    while (temp.size() > 0) {
      System.out.println(temp.poll());
    }
  }

  private String prompt() {
    System.out.print("명령> ");
    return keyboard.nextLine().toLowerCase();
  }

  public static void main(String[] args) throws Exception {
    ServerApp app = new ServerApp();

    app.addApplicationContextListner(new ApplicationInitializer());

    // App 을 실행한다.
    app.service();
  }
}
