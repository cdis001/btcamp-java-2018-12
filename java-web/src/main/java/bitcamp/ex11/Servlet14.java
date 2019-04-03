package bitcamp.ex11;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/ex11/s14")
public class Servlet14 extends HttpServlet {

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    HttpSession session = req.getSession();

    String tel = req.getParameter("tel");

    resp.setContentType("text/html;charset=UTF-8");
    PrintWriter out = resp.getWriter();
    out.println("<html><head><title>페이지3</title></head><body>");
    out.printf("이름: %s<br>\n", session.getAttribute("name"));
    out.printf("나이: %s<br>\n", session.getAttribute("age"));
    out.printf("전화: %s<br>\n", tel);
    out.println("</body></html>");
  }
}
