package com.eomcs.lms.handler;
import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.proxy.MemberDaoProxy;

public class MemberAddCommand implements Command {
  
  Scanner keyboard;
  MemberDaoProxy memberDaoProxy;
  
  public MemberAddCommand(Scanner keyboard, MemberDaoProxy memberDaoProxy) {
    this.keyboard = keyboard;
    this.memberDaoProxy = memberDaoProxy;
  }
  
  @Override
  public void execute() {
    Member member = new Member();
    
    System.out.print("번호? ");
    member.setNo(Integer.parseInt(keyboard.nextLine()));
    
    System.out.print("이름? ");
    member.setName(keyboard.nextLine());
    
    System.out.print("이메일? ");
    member.setEmail(keyboard.nextLine());
    
    System.out.print("암호? ");
    member.setPassword(keyboard.nextLine());
  
    System.out.print("사진? ");
    member.setPhoto(keyboard.nextLine());
  
    System.out.print("전화? ");
    member.setTel(keyboard.nextLine());
  
    member.setRegisteredDate(new Date(System.currentTimeMillis())); 
    
    try {
      memberDaoProxy.insert(member);
        System.out.println("저장하였습니다.");
    } catch (Exception e) {
      System.out.printf("데이터 저장 오류: &s\n",e.getMessage());
    }
  }
    
}
