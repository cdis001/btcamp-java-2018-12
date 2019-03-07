package ch26.f;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test03 {

  public static void main(String[] args) throws Exception {

    InputStream inputStream = Resources.getResourceAsStream(
        "ch26/f/mybatis-config.xml");

    SqlSessionFactory sqlSessionFactory = 
        new SqlSessionFactoryBuilder().build(inputStream);

    SqlSession sqlSession = sqlSessionFactory.openSession();

    Scanner keyboard = new Scanner(System.in);
    
    HashMap<String, Object> params = new HashMap<>();
    
    System.out.print("게시물 번호? ");
    String value = keyboard.nextLine();
    try {
      params.put("no", Integer.parseInt(value));
    } catch(Exception e) {
    }

    System.out.print("제목? ");
    value = keyboard.nextLine();
    if(value.length() > 0) {
      params.put("title", value);
    }
    
    System.out.print("내용? ");
    value = keyboard.nextLine();
    if(value.length() > 0) {
      params.put("contents", value);
    }

    keyboard.close();


    List<Board> boards = null;

    try {
      boards = sqlSession.selectList("board.select3", params);
    } catch (Exception e) {
      boards = sqlSession.selectList("board.select3");
    }

    for (Board b : boards) {
      System.out.println(b);
    }
    System.out.println("--------------------------------");

  }
}
