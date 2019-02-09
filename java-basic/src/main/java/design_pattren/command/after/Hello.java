package design_pattren.command.after;

public class Hello implements Command {

  @Override
  public void execute() {
    System.out.println("안녕하세요!");
  }

}
