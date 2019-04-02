package bitcamp.ex09;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/ex09/s11")
public class Servlet11 extends HttpServlet {

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    ServletContext sc = this.getServletContext();
    sc.setAttribute("v1", "xxx");

    HttpSession session = req.getSession();
    session.setAttribute("v2", "yyy");

    req.setAttribute("v3", "zzz");

    req.getRequestDispatcher("s12").forward(req, resp);

  }

}
