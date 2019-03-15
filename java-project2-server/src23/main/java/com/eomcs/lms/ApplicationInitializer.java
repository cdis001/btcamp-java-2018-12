package com.eomcs.lms;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import com.eomcs.lms.context.ApplicationContextException;
import com.eomcs.lms.context.ApplicationContextListener;
import com.eomcs.lms.context.RequestMapping;
import com.eomcs.lms.context.RequestMappingHandlerMapping;
import com.eomcs.lms.context.RequestMappingHandlerMapping.RequestMappingHandler;

public class ApplicationInitializer implements ApplicationContextListener {

  @Override
  public void contextInitialized(Map<String, Object> context) {
    try {
      
      ApplicationContext appCtx = 
          new AnnotationConfigApplicationContext(AppConfig.class);
      
      context.put("applicationContext", appCtx);
      
      context.put("handlerMapping", prepareRequesMappingHandlerMapping(appCtx));
      
    } catch (Exception e) {
      throw new ApplicationContextException(e);
    }
  }

  @Override
  public void contextDestroyed(Map<String, Object> context) {
  }
  
  public RequestMappingHandlerMapping prepareRequesMappingHandlerMapping(
      ApplicationContext iocContainer) {
    RequestMappingHandlerMapping handlerMapping = new RequestMappingHandlerMapping();
    
    Collection<Object> beans = 
        iocContainer.getBeansWithAnnotation(Component.class).values();
    
    for (Object bean : beans) {
      Method[] methods = bean.getClass().getMethods();
      for(Method m : methods) {
        RequestMapping requestMapping = m.getAnnotation(RequestMapping.class);
        if(requestMapping == null) 
          continue;
        
        RequestMappingHandler handler = new RequestMappingHandler(bean, m);
        
        handlerMapping.add(requestMapping.value(), handler);
      }
    }
    return handlerMapping;
  }
}






