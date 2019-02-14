package com.eomcs.lms.handler;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.agent.MemberAgent;
import com.eomcs.lms.domain.Member;

public class MemberUpdateCommand implements Command {
  
  Scanner keymember;
  
  public MemberUpdateCommand(Scanner keymember, List<Member> list) {
    this.keymember = keymember;
  }
  
  @Override
  public void execute(ObjectInputStream in, ObjectOutputStream out) {
    System.out.print("번호? ");
    int no = Integer.parseInt(keymember.nextLine());

    try {
      Member member = MemberAgent.get(no, in, out);
    
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
      
      MemberAgent.update(temp, in, out);
    } catch (Exception e) {
      System.out.println("변경 중 오류 발생!");
    }
  }
}
