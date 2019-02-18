package com.eomcs.lms.handler;
import java.util.Scanner;
import com.eomcs.lms.proxy.MemberDaoProxy;

public class MemberDeleteCommand implements Command {
  
  Scanner keyboard;
  MemberDaoProxy memberDaoProxy;
  
  public MemberDeleteCommand(Scanner keyboard, MemberDaoProxy memberDaoProxy) {
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
