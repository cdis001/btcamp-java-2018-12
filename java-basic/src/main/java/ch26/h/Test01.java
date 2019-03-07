package ch26.h;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test01 {

  public static void main(String[] args) throws Exception {

    InputStream inputStream = Resources.getResourceAsStream(
        "ch26/h/mybatis-config.xml");

    SqlSessionFactory sqlSessionFactory = 
        new SqlSessionFactoryBuilder().build(inputStream);

    SqlSession sqlSession = sqlSessionFactory.openSession();

    Scanner keyboard = new Scanner(System.in);
    System.out.print("게시물 번호? ");
    int no = Integer.parseInt(keyboard.nextLine());
    keyboard.close();

    Board board = sqlSession.selectOne("board.selectBoard", no);
    System.out.println(board);
    System.out.println("--------------------------------");

    List<AttachFile> files = sqlSession.selectList("board.selectAttachfile",no);
    System.out.println("[첨부파일]");
    for (AttachFile f : files) {
      System.out.println(f);
    }
  }
}
