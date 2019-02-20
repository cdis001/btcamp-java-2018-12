package ch25.a;

import java.sql.DriverManager;
import java.sql.Statement;

public class Test10 {

  public static void main(String[] args) {

    try(java.sql.Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111")) {
      System.out.println("DBMS에 연결됨!");

      try(Statement stmt = con.createStatement()) {
        
        int count = stmt.executeUpdate("update x_board set view_count = view_count + 1"
            + " where board_id > 0 ");
        
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









