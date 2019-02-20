package ch25.a;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test09 {

  public static void main(String[] args) {

    try(java.sql.Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111")) {
      System.out.println("DBMS에 연결됨!");

      try(Statement stmt = con.createStatement()) {

        try(ResultSet rs = stmt.executeQuery(
            "select * from x_board order by board_id desc");) {

          while(rs.next()) {

            System.out.printf("%s, %s, %s, %s, %s \n", 
                rs.getString("board_id"), rs.getString("title"), rs.getString("contents"),
                rs.getString("created_date"), rs.getString("view_count"));
          }
        }
      } catch (Exception e) {
        
        e.printStackTrace();
      }
    } catch (Exception e) {
      
      System.out.println("DBMS에 연결 중 오류 발생!");
      e.printStackTrace();
    }
  }

}









