package design_pattren.command.after;

public class MemberDetailCommand implements Command {

  @Override
  public void execute() {
      System.out.println("회원 상세조회 처리!");
  }

}
