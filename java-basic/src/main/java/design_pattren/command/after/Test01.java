package design_pattren.command.after;

import java.util.HashMap;
import java.util.Scanner;

public class Test01 {

  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    
    HashMap<String, Command> commandMap = new HashMap<>();
    commandMap.put("/board/add", new BoardAddCommand());
    commandMap.put("/board/detail", new BoardDetailCommand());
    commandMap.put("/board/list", new BoardListCommand());
    commandMap.put("/board/update", new BoardUpdateCommand());
    commandMap.put("/board/delete", new BoardDeleteCommand());
    
    commandMap.put("/member/add", new BoardAddCommand());
    commandMap.put("/member/detail", new BoardDetailCommand());
    commandMap.put("/member/list", new BoardListCommand());
    commandMap.put("/member/update", new BoardUpdateCommand());
    commandMap.put("/member/delete", new BoardDeleteCommand());
    
    commandMap.put("hello", new Hello());
    
    while (true) {
      String input = keyboard.nextLine();
      System.out.println("명령> ");
      Command command = commandMap.get(input);
      
      if("quit".equals(input)) {
        System.out.println();
        break;
      } else {
        System.out.println("처리할 수 없는 명령입니다");
      }
      System.out.println();
    }
    keyboard.close();
  }

}
