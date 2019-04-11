package com.eomcs.lms;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ComponentScan(basePackages = "com.eomcs.lms")
@ImportResource("classpath:/com/eomcs/lms/conf/tx-context.xml")
@EnableWebMvc
public class AppConfig {

}
