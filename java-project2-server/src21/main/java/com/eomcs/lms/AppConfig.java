package com.eomcs.lms;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.eomcs.lms.context.Bean;
import com.eomcs.lms.context.ComponentScan;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.mybatis.DaoFactroy;
import com.eomcs.mybatis.SqlSessionFactoryProxy;
import com.eomcs.mybatis.TransactionManager;

@ComponentScan(basePackages="com.eomcs.lms")
public class AppConfig {

  @Bean
  public SqlSessionFactory sqlSessionFactory() throws Exception {
    return new SqlSessionFactoryProxy(
        new SqlSessionFactoryBuilder().build(
            Resources.getResourceAsStream(
                "com/eomcs/lms/conf/mybatis-config.xml")));
  }

  @Bean
  public TransactionManager transactionManager(
      SqlSessionFactoryProxy sqlSessionFactoryProxy) {

    return new TransactionManager(sqlSessionFactoryProxy);
  }

  @Bean
  public DaoFactroy daoFactory(SqlSessionFactoryProxy sqlSessionFactoryProxy) {
    return new DaoFactroy(sqlSessionFactoryProxy);
  }
  
  @Bean
  public BoardDao boardDao(DaoFactroy daoFactory) {
    return daoFactory.create(BoardDao.class);
  }
  
  @Bean
  public MemberDao memberDao(DaoFactroy daoFactory) {
    return daoFactory.create(MemberDao.class);
  }
  
  @Bean
  public LessonDao lessonDao(DaoFactroy daoFactory) {
    return daoFactory.create(LessonDao.class);
  }
  
  @Bean
  public PhotoBoardDao photoBoardDao(DaoFactroy daoFactory) {
    return daoFactory.create(PhotoBoardDao.class);
  }
  
  @Bean
  public PhotoFileDao photoFileDao(DaoFactroy daoFactory) {
    return daoFactory.create(PhotoFileDao.class);
  }
}
