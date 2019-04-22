package bitcamp.app2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/c02_1")
public class Controller02_1 {

  @GetMapping("h1")
  @ResponseBody
  public String handler1(String name, int age) {

    return String.format("name: %s, age: %d", name, age);
  }

  @GetMapping("h2/{name}/{age}")
  @ResponseBody
  public String handler2(@PathVariable("name") String name, @PathVariable("age") int age) {
    return String.format("name: %s, age: %d", name, age);
  }


  @GetMapping("h3/{name}_{age}")
  @ResponseBody
  public String handler3(@PathVariable("name") String name, @PathVariable("age") int age) {
    return String.format("name: %s, age: %d", name, age);
  }

  @GetMapping("h4/{name}_{age}")
  @ResponseBody
  public String handler4(@PathVariable String name, @PathVariable int age) {
    return String.format("name: %s, age: %d", name, age);
  }
}
