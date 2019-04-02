package bitcamp.ex09;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/ex09/s1")
public class Servlet01 extends HttpServlet {

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    ServletContext sc = this.getServletContext();
    sc.setAttribute("v1", "aaa");

    HttpSession session = req.getSession();
    session.setAttribute("v2", "bbb");

    req.setAttribute("v3", "ccc");

    resp.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = resp.getWriter();

    out.println("보관소에 값을 넣었습니다! -/ex09/s1");

  }

}
