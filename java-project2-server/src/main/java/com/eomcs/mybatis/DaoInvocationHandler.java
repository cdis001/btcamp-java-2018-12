package com.eomcs.mybatis;

import java.util.List;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class DaoInvocationHandler implements InvocationHandler {

  SqlSessionFactory sqlSessionFactory;

  public DaoInvocationHandler (SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

    String sqlId = String.format("%s.%s",
        proxy.getClass().getInterfaces()[0].getName(), 
        method.getName());
    Class<?> returnType = method.getReturnType();
    
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      System.out.println(sqlId + "의 SQL을 실행한다.");

      if(returnType == List.class) {
        
        if (args == null)
          return sqlSession.selectList(sqlId);
        
        else 
          return sqlSession.selectList(sqlId, args[0]);
      } else if(returnType == int.class) {
        
        if (args == null)
          return sqlSession.update(sqlId);
        
        else 
          return sqlSession.update(sqlId, args[0]);
      } else {
        
        if (args == null)
          return sqlSession.selectOne(sqlId);
        
        else 
          return sqlSession.selectOne(sqlId, args[0]);
      }
    }
  }

}
