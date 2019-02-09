package design_pattren.command.after;

public class BoardUpdateCommand implements Command {

  @Override
  public void execute() {
      System.out.println("게시물 수정 처리!");
  }

}
