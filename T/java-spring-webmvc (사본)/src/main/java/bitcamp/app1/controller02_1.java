package bitcamp.app1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/c02_1")
public class controller02_1 {

  @RequestMapping(method = RequestMethod.GET)
  @ResponseBody
  public String handler1() {
    return "GET";
  }

  @RequestMapping(method = RequestMethod.POST)
  @ResponseBody
  public String handler2() {
    return "POST";
  }

}
