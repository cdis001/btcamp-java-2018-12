package bitcamp.app1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class controller01_2 {

  @RequestMapping("/c01_2_h1")
  @ResponseBody
  public String handler1() {
    return "c01_2_h1";
  }

  @RequestMapping("/c01_2_h2")
  @ResponseBody
  public String handler2() {
    return "c01_2_h2";
  }

  @RequestMapping("/c01_2/h3")
  @ResponseBody
  public String handler3() {
    return "c01_2/h3";
  }

  @RequestMapping("/c01_2/h4")
  @ResponseBody
  public String handler4() {
    return "c01_2/h4";
  }
}
