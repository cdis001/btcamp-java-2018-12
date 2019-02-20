package ch25.a;

import java.sql.DriverManager;
import java.sql.Statement;

public class Test06 {

  public static void main(String[] args) {
    
    try(java.sql.Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111")) {
      System.out.println(con);
      
      try(Statement stmt = con.createStatement()) {
        
        int count = stmt.executeUpdate("insert into x_board(title, contents)"
            + " values('제목10','내용')");
        
        System.out.println(count);
        System.out.println("입력성공!");
        
      } catch (Exception e) {
        e.printStackTrace();
      }
      
    } catch (Exception e) {
      System.out.println("DBMS에 연결 중 오류 발생!");
      e.printStackTrace();
    }
  }

}









