package bitcamp.ex10;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/ex10_1/s24")
public class Servlet24 extends HttpServlet {

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    Cookie[] cookies = req.getCookies();

    resp.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = resp.getWriter();

    for (Cookie c : cookies) {
      out.printf("%s = %s\n", c.getName(), c.getValue());
    }
  }
}
