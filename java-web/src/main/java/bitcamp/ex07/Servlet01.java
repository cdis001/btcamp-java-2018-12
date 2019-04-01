package bitcamp.ex07;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(value = "/ex07/s1")
public class Servlet01 extends HttpServlet {

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    resp.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = resp.getWriter();

    out.println("더하기 계산 결과!");

    String op = req.getParameter("op");
    if (!op.equals("+")) {
      RequestDispatcher reqd = req.getRequestDispatcher("/ex07/s2");
      reqd.forward(req, resp);
    }

    int a = Integer.parseInt(req.getParameter("a"));
    int b = Integer.parseInt(req.getParameter("b"));

    out.printf("%d + %d = %d\n", a, b, a + b);
  }

}
