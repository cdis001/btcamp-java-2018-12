package bitcamp.ex06;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(value = "/ex06/s1", loadOnStartup = 1)
public class Servlet01 extends HttpServlet {

  @Override
  public void init() throws ServletException {
    System.out.println("/ex06/s1 ==> init()");
  }

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    System.out.println("/ex06/s1 ==> service()");
  }

}
