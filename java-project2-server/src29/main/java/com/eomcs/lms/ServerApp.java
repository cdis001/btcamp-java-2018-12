package com.eomcs.lms;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.ServerSocket;
import java.net.Socket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.eomcs.lms.context.RequestMappingHandlerMapping;
import com.eomcs.lms.context.RequestMappingHandlerMapping.RequestMappingHandler;
import com.eomcs.lms.handler.Response;

public class ServerApp {
  
  final static Logger logger = LogManager.getLogger(ServerApp.class);

  ApplicationContext iocContainer;
  
  RequestMappingHandlerMapping handlerMapping;

  public void service() throws Exception {

    try (ServerSocket ss = new ServerSocket(8888)) {
      
      logger.info("서버 실행 중...");

      iocContainer = new AnnotationConfigApplicationContext(AppConfig.class);
      
      handlerMapping = 
          (RequestMappingHandlerMapping) iocContainer.getBean(
              RequestMappingHandlerMapping.class);
      
      printBeans();
      
      while (true) {
        new RequestHandlerThread(ss.accept()).start();
      } // while
    } catch (Exception e) {
      e.printStackTrace();
    } // try(ServerSocket)

  }

  public static void main(String[] args) throws Exception {
    ServerApp app = new ServerApp();

    // App 을 실행한다.
    app.service();
  }

  class RequestHandlerThread extends Thread {

    Socket socket;

    public RequestHandlerThread(Socket socket) {
      this.socket = socket;
    }

    @Override
    public void run() {

      try (Socket socket = this.socket;
          BufferedReader in = new BufferedReader(
              new InputStreamReader(socket.getInputStream()));
          PrintWriter out = new PrintWriter(socket.getOutputStream())) {

        logger.info("클라이언트와 연결되었음!");
        
        String request = in.readLine();

        RequestMappingHandler requestHandler = handlerMapping.get(request);
        
        if (requestHandler == null) {
          out.println("실행할 수 없는 명령입니다.");
          out.println("!end!");
          out.flush();
          return;
        }

        try {
          requestHandler.method.invoke(
              requestHandler.bean, new Response(in, out));
        } catch (Exception e) {
          out.println("실행 오류: " + e.getMessage());
          e.printStackTrace();
        }
        out.println("!end!");
        out.flush();

      } catch (Exception e) {

        logger.error("명령어 실행 중 오류 발생 : " + e.toString());
       StringWriter strWriter = new StringWriter();
        PrintWriter out = new PrintWriter(strWriter);
        e.printStackTrace(out);
        logger.error(strWriter.toString());
      }
      logger.info("클라이언트와 연결 종료");
    }
  }
  
  private void printBeans() {
    logger.debug("--------------------------");
    String names[] = iocContainer.getBeanDefinitionNames();
    for(String name : names) {
      logger.debug(String.format("빈 생성됨 (객체명=%s, 클래스명=%s", name, 
          iocContainer.getBean(name).getClass().getName()));
    }
    logger.debug("--------------------------");
  }
}









