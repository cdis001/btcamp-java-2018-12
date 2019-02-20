package ch25.a;

import java.sql.DriverManager;
import java.sql.Statement;

public class Test11 {

  public static void main(String[] args) {

    try(java.sql.Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111")) {
      System.out.println("DBMS에 연결됨!");

      try(Statement stmt = con.createStatement()) {
        
        int count = stmt.executeUpdate("delete from x_board where board_id = 8");
        
        System.out.println(count);
        
      } catch (Exception e) {
        e.printStackTrace();
      }
    } catch (Exception e) {
      System.out.println("DBMS에 연결 중 오류 발생!");
      e.printStackTrace();
    }
  }

}









