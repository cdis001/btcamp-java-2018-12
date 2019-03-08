package com.eomcs.lms.dao.mariadb;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.util.DataSource;

public class LessonDaoImpl implements LessonDao {

  DataSource dataSource;

  SqlSessionFactory sqlSessionFactory;

  public LessonDaoImpl (DataSource dataSource) {
    this.dataSource = dataSource;
  }

  public LessonDaoImpl (SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  public List<Lesson> findAll() {

    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("LessonMapper.findAll");
    } //resource 자동 해제를 위함
  }

  public void insert(Lesson lesson) {

    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
        sqlSession.insert("LessonMapper.insert", lesson);
        sqlSession.commit();
    }
  }

  public Lesson findByNo(int no) {

    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {

      return sqlSession.selectOne("LessonMapper.findByNo", no);
    }
  }

  public int update(Lesson lesson) {

    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      int count = sqlSession.update("LessonMapper.update", lesson);
      sqlSession.commit();
      return count;
    }
  }

  public int delete(int no) {

    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      int count =  sqlSession.update("LessonMapper.delete", no);
        sqlSession.commit();
      return count;
  }
}
}









