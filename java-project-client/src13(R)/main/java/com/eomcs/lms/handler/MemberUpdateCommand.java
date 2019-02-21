package com.eomcs.lms.handler;
import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.agent.MemberAgent;
import com.eomcs.lms.domain.Member;

public class MemberUpdateCommand implements Command {
  
  Scanner keymember;
  MemberAgent memberAgent;
  
  public MemberUpdateCommand(Scanner keymember, MemberAgent memberAgent) {
    this.keymember = keymember;
    this.memberAgent = memberAgent;
  }
  
  @Override
  public void execute() {
    System.out.print("번호? ");
    int no = Integer.parseInt(keymember.nextLine());

    try {
      Member member = memberAgent.get(no);
    
      // 기존 값 복제
      Member temp = member.clone();
      
      System.out.printf("내용? ");
      String input = keymember.nextLine();
      if (input.length() > 0) 
        temp.setName(input);
      
      System.out.printf("내용? ");
      input = keymember.nextLine();
      if (input.length() > 0) 
        temp.setEmail(input);
      
      System.out.printf("내용? ");
      input = keymember.nextLine();
      if (input.length() > 0) 
        temp.setPassword(input);
      
      System.out.printf("내용? ");
      input = keymember.nextLine();
      if (input.length() > 0) 
        temp.setPhoto(input);
      
      System.out.printf("내용? ");
      input = keymember.nextLine();
      if (input.length() > 0) 
        temp.setTel(input);
      
      System.out.printf("내용? ");
      input = keymember.nextLine();
      if (input.length() > 0) 
        temp.setRegisteredDate(Date.valueOf(input));
      
      memberAgent.update(temp);
    } catch (Exception e) {
      System.out.println("변경 중 오류 발생!");
    }
  }
}
