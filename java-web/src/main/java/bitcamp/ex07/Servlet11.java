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
@WebServlet("/ex07/s11")
public class Servlet11 extends HttpServlet {

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    resp.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = resp.getWriter();

    out.println("------------------------------");

    String op = req.getParameter("op");

    RequestDispatcher reqd = null;

    if (op.equals("+")) {
      reqd = req.getRequestDispatcher("/ex07/s11_plus");
    } else if (op.contentEquals("-")) {
      reqd = req.getRequestDispatcher("/ex07/s11_minus");
    } else {
      reqd = req.getRequestDispatcher("/ex07/s11_error");
    }

    reqd.include(req, resp);

    out.println("------------------------------");
  }

}
