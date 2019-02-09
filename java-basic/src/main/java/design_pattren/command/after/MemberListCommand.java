package design_pattren.command.after;

public class MemberListCommand implements Command {

  @Override
  public void execute() {
      System.out.println("회원 조회 처리!");
  }

}
