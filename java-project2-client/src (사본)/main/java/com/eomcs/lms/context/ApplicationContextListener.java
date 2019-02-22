package com.eomcs.lms.context;

import java.util.Map;

public interface ApplicationContextListener {
  void contextInitialized(Map<String,Object> context) throws AplicationContextException;
  void contextDestroyed(Map<String,Object> context) throws AplicationContextException;
}
