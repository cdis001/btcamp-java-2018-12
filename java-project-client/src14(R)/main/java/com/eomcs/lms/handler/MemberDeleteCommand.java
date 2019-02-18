package com.eomcs.lms.handler;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.proxy.MemberDaoProxy;

public class MemberDeleteCommand implements Command {
  
  Scanner keyboard;
  
  public MemberDeleteCommand(Scanner keyboard) {
    this.keyboard = keyboard;
  }
  
  @Override
  public void execute(ObjectInputStream in, ObjectOutputStream out) {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());

    try {
      MemberDaoProxy.delete(no, in, out);
      System.out.println("데이터 삭제 완료!");
    }catch(Exception e) {
      System.out.printf("데이터 목록 삭제 오류: %s\n",e.getMessage());
    }
}
}
