package bitcamp.app1;

import java.io.PrintWriter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/c04_3")
public class Controller04_3 {

  @GetMapping("h1")
  @ResponseBody
  public void handler1(PrintWriter out, String model, String maker, int capacity, boolean auto,
      Car car, Engine engine) {

    out.printf("model: %s\n", model);
    out.printf("maker: %s\n", maker);
    out.printf("capacity: %s\n", capacity);
    out.printf("auto: %s\n", auto);
    out.printf("car: %s\n", car);
  }

}
