package design_pattren.command.after;

public class MemberUpdateCommand implements Command {

  @Override
  public void execute() {
      System.out.println("회원 수정 처리!");
  }

}
