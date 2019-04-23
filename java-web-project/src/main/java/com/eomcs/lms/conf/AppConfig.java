package com.eomcs.lms.conf;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ComponentScan(basePackages = "com.eomcs.lms",
    excludeFilters = @Filter(type = FilterType.REGEX, pattern = "com.eomcs.lms.web"))
@ImportResource("classpath:/com/eomcs/lms/conf/tx-context.xml")
@EnableWebMvc
public class AppConfig {

  final static Logger logger = LogManager.getLogger(AppConfig.class);

  public AppConfig() {
    logger.debug("AppConfig 객체 생성...");
  }
}


