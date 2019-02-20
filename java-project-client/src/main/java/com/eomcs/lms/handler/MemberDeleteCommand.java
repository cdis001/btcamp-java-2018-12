package com.eomcs.lms.handler;
import java.util.Scanner;
import com.eomcs.lms.dao.MemberDaoImpl;

public class MemberDeleteCommand implements Command {
  
  Scanner keyboard;
  MemberDaoImpl memberDaoProxy;
  
  public MemberDeleteCommand(Scanner keyboard, MemberDaoImpl memberDaoProxy) {
    this.keyboard = keyboard;
    this.memberDaoProxy = memberDaoProxy;
  }
  
  @Override
  public void execute() {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());

    try {
      memberDaoProxy.delete(no);
      System.out.println("데이터 삭제 완료!");
    }catch(Exception e) {
      System.out.printf("데이터 목록 삭제 오류: %s\n",e.getMessage());
    }
}
}
