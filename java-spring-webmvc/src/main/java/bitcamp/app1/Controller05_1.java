package bitcamp.app1;

import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/c05_1")
public class Controller05_1 {

  @GetMapping("h1")
  @ResponseBody
  public String handler1() {
    return "<html><body><h1>abc가각간</h1></body></html>";
  }

  @GetMapping(value = "h2", produces = "text/html;charset=UTF-8")
  @ResponseBody
  public String handler2() {
    return "<html><body><h1>abc가각간</h1></body></html>";
  }

  @GetMapping("h3")
  @ResponseBody
  public String handler3(HttpServletResponse response) {
    response.setContentType("UTF-8");
    return "<html><body><h1>abc가각간</h1></body></html>";
  }

  @GetMapping("h4")
  public HttpEntity<String> handler4() {

    HttpEntity<String> entity = new HttpEntity<String>("<html><body><h1>abc가각간</h1></body></html>");
    return entity;
  }

  @GetMapping(value = "h5", produces = "text/html;charset=UTF-8")
  public HttpEntity<String> handler5() {

    HttpEntity<String> entity = new HttpEntity<String>("<html><body><h1>abc가각간</h1></body></html>");
    return entity;
  }

  @GetMapping("h6")
  public HttpEntity<String> handler6() {

    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Type", "text/html;charset=UTF-8");

    HttpEntity<String> entity =
        new HttpEntity<String>("<html><body><h1>abc가각간</h1></body></html>", headers);
    return entity;
  }

  @GetMapping("h7")
  public ResponseEntity<String> handler7() {

    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Type", "text/html;charset=UTF-8");

    ResponseEntity<String> entity = new ResponseEntity<String>(
        "<html><body><h1>abc가각간</h1></body></html>", headers, HttpStatus.OK);
    return entity;
  }
}
