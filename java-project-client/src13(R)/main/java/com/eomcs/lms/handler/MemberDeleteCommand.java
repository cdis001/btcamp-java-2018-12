package com.eomcs.lms.handler;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import com.eomcs.lms.agent.MemberAgent;

public class MemberDeleteCommand implements Command {
  
  Scanner keyboard;
  MemberAgent memberAgent;
  
  public MemberDeleteCommand(Scanner keyboard, MemberAgent memberAgent) {
    this.keyboard = keyboard;
    this.memberAgent = memberAgent;
  }
  
  @Override
  public void execute(ObjectInputStream in, ObjectOutputStream out) {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());

    try {
      memberAgent.delete(no);
      System.out.println("데이터 삭제 완료!");
    }catch(Exception e) {
      System.out.printf("데이터 목록 삭제 오류: %s\n",e.getMessage());
    }
}
}
