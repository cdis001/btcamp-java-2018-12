package ch25.b;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class BoardInsertApp {


  // 다음과 같이 게시물을 등록하는 프로그램을 작성하라!
  // ----------------------------
  // 제목? aaa
  // 내용? bbb
  // 등록하시겠습니까?(Y/n)
  // 등록하였습니다.
  //----------------------------
  public static void main(String[] args) {
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111")) {

      try (Statement stmt = con.createStatement();
          Scanner keyboard = new Scanner(System.in)) {

        System.out.println("--------------------");
        
        System.out.print("제목? ");
        String t1 = keyboard.nextLine();

        System.out.print("내용? ");
        String c1 = keyboard.nextLine();

        System.out.print("등록하시겠습니까?(Y/n) ");
        String input = keyboard.nextLine();
        
        if (input.equalsIgnoreCase("n")) {
          
          System.out.println("등록을 취소하셨습니다");
        } else {
          
          stmt.executeUpdate("insert into x_board(title, contents)"
              + " values('" + t1 + "','" + c1 + "')");
          System.out.println("등록하였습니다.");
        }
        System.out.println("--------------------");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
