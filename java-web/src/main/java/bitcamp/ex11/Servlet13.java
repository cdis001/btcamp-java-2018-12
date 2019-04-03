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
@WebServlet("/ex11/s13")
public class Servlet13 extends HttpServlet {

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    HttpSession session = req.getSession();

    session.setAttribute("age", req.getParameter("age"));

    resp.setContentType("text/html;charset=UTF-8");
    PrintWriter out = resp.getWriter();
    out.println("<html><head><title>페이지3</title></head><body>");
    out.println("<form action='s14' method='post'>");
    out.println("전화: <input type='text' name='tel'><br>");
    out.println("<button>다음</button>");
    out.println("</form>");
    out.println("</body></html>");
  }
}
