package design_pattren.command.after;

public class BoardListCommand implements Command {

  @Override
  public void execute() {
      System.out.println("게시물 조회 처리!");
  }

}
