package bitcamp.app1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/c01_3")
@Controller
public class controller01_3 {

  @RequestMapping("h1")
  @ResponseBody
  public String handler1() {
    return "h1";
  }

  @RequestMapping("/h2")
  @ResponseBody
  public String handler2() {
    return "/h2";
  }

  @RequestMapping("h3")
  @ResponseBody
  public String handler3() {
    return "h3";
  }

  @RequestMapping("h4")
  @ResponseBody
  public String handler4() {
    return "h4";
  }
}
