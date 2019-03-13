package com.eomcs.lms;

import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.eomcs.lms.context.ApplicationContext;
import com.eomcs.lms.context.ApplicationContextException;
import com.eomcs.lms.context.ApplicationContextListener;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.mybatis.DaoFactroy;
import com.eomcs.mybatis.SqlSessionFactoryProxy;
import com.eomcs.mybatis.TransactionManager;

public class ApplicationInitializer implements ApplicationContextListener {

  @Override
  public void contextInitialized(Map<String, Object> context) {
    try {
      SqlSessionFactory sqlSessionFactory =
        new SqlSessionFactoryBuilder().build(
            Resources.getResourceAsStream(
                "com/eomcs/lms/conf/mybatis-config.xml"));
      
      SqlSessionFactoryProxy sqlSessionFactoryProxy = 
          new SqlSessionFactoryProxy(sqlSessionFactory);
      
      TransactionManager txManager = new TransactionManager(sqlSessionFactoryProxy);
      
      DaoFactroy daoFactory = new DaoFactroy(sqlSessionFactoryProxy);
      
      BoardDao boardDao = daoFactory.create(BoardDao.class);
      LessonDao lessonDao = daoFactory.create(LessonDao.class);
      MemberDao memberDao = daoFactory.create(MemberDao.class);
      PhotoBoardDao photoBoardDao = daoFactory.create(PhotoBoardDao.class);
      PhotoFileDao photoFileDao = daoFactory.create(PhotoFileDao.class);

      HashMap<String, Object> beans = new HashMap<String, Object>();
      beans.put("boardDao", boardDao);
      beans.put("lessonDao", lessonDao);
      beans.put("memberDao", memberDao);
      beans.put("photoBoardDao", photoBoardDao);
      beans.put("photoFileDao", photoFileDao);
      beans.put("txManager", txManager);
      
      ApplicationContext appCtx = new ApplicationContext("com.eomcs.lms", beans);
      
      context.put("applicationContext", appCtx);
      
    } catch (Exception e) {
      throw new ApplicationContextException(e);
    }
  }

  @Override
  public void contextDestroyed(Map<String, Object> context) {
  }
}






