package com.eomcs.lms.handler;
import java.util.Scanner;
import com.eomcs.lms.dao.MemberDaoImpl;
import com.eomcs.lms.domain.Member;

public class MemberDetailCommand implements Command {
  
  Scanner keyboard;
  MemberDaoImpl memberDaoProxy;
  
  public MemberDetailCommand(Scanner keyboard, MemberDaoImpl memberDaoProxy) {
    this.keyboard = keyboard;
  }
  
  @Override
  public void execute() {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());

    try {
     
    Member member = memberDaoProxy.findByNo(no);

    System.out.printf("이름: %s\n", member.getName());
    System.out.printf("이메일: %s\n", member.getEmail());
    System.out.printf("암호: %s\n", member.getPassword());
    System.out.printf("사진: %s\n", member.getPhoto());
    System.out.printf("전화: %s\n", member.getTel());
    System.out.printf("가입일: %s\n", member.getRegisteredDate());
  }catch (Exception e) {
    System.out.printf("게시글 상세정보 출력 오류: &s\n",e.getMessage());
  }
  }
}
