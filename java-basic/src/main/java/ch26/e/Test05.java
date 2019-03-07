package ch26.e;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test05 {

  public static void main(String[] args) throws Exception {

    InputStream inputStream = Resources.getResourceAsStream(
        "ch26/e/mybatis-config.xml");

    SqlSessionFactory sqlSessionFactory = 
        new SqlSessionFactoryBuilder().build(inputStream);

    SqlSession sqlSession = sqlSessionFactory.openSession();

    Board board = new Board();
    board.setNo(5);
    board.setTitle("제목을 바꿉시다");
    board.setContents("내용도 바꿔봅시다");

    int count = sqlSession.update("board.update1", board);
    System.out.println(count);
    System.out.println("--------------------------------");

    sqlSession.commit();

    List<Board> boards = sqlSession.selectList("board.select1");

    for (Board b : boards) {
      System.out.println(b);
    }
    System.out.println("--------------------------------");
  }
}
