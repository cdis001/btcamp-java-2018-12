package design_pattren.proxy.rmi.server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RemoteObjectServer {

  public static void main(String[] args) {
//    if (System.getSecurityManager() == null) {
//      System.setSecurityManager(new SecurityManager());
//    }
    
    try {
      Calculator calcObj = new CalculatorImpl();
      
      Calculator stub = (Calculator) UnicastRemoteObject.exportObject(calcObj, 0);//0으로 지정할 경우 임의의 유효한 포트번호 리턴
      
      Registry registry = LocateRegistry.getRegistry("study.bitcamp.co.kr");
      
      registry.rebind("calc", stub);
      
      System.out.println("Calculrator 객체의 프록시(stub)가 RMI Registry 서버에 등록되었습니다");
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
