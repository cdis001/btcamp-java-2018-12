package bitcamp.app2;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/c03_1")
public class Controller03_1 {

  // http://localhost:8080/java-spring-webmvc/app2/c03_1/h1
  @GetMapping(value = "h1", produces = "text/plain;charset=utf-8")
  @ResponseBody
  public String handler1(HttpSession session) {

    session.setAttribute("name", "홍길동");
    session.setAttribute("age", 20);
    return "세션에 값 보관!";
  }

  // http://localhost:8080/java-spring-webmvc/app2/c03_1/h2
  @GetMapping(value = "h2", produces = "text/plain;charset=utf-8")
  @ResponseBody
  public String handler2(HttpSession session) {

    return String.format("name: %s, age: %s \n", session.getAttribute("name"),
        session.getAttribute("age"));
  }

  // http://localhost:8080/java-spring-webmvc/app2/c03_1/h3
  @GetMapping(value = "h3", produces = "text/plain;charset=utf-8")
  @ResponseBody
  public String handler3(HttpSession session) {

    session.invalidate();
    return "세션을 무효화 시켰음!";
  }
}
