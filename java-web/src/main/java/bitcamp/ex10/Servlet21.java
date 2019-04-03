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
@WebServlet("/ex10/s21")
public class Servlet21 extends HttpServlet {

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    Cookie c1 = new Cookie("v1", "aaa");

    Cookie c2 = new Cookie("v2", "bbb");
    c2.setPath("/java-web/ex10/a");

    Cookie c3 = new Cookie("v3", "ccc");
    c3.setPath("/java-web");

    resp.addCookie(c1);
    resp.addCookie(c2);
    resp.addCookie(c3);

    resp.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = resp.getWriter();

    out.println("쿠키를 보냈습니다! -/ex10/s21");
  }
}
