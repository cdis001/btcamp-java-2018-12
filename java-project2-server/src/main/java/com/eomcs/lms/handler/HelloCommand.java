package com.eomcs.lms.handler;

import org.springframework.stereotype.Component;
import com.eomcs.lms.context.RequestMapping;

@Component
public class HelloCommand {

  public HelloCommand() {
  }

  @RequestMapping("/hello")
  public void Hello(ServletResponse response) throws Exception {
      response.println("안녕하세요!");
  }
}
