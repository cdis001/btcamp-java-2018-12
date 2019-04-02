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
@WebServlet("/ex09/s12")
public class Servlet12 extends HttpServlet {

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    ServletContext sc = this.getServletContext();
    String v1 = (String) sc.getAttribute("v1");

    HttpSession session = req.getSession();
    String v2 = (String) session.getAttribute("v2");

    String v3 = (String) req.getAttribute("v3");

    resp.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = resp.getWriter();

    out.println("보관소에 저장한 값을 꺼냈습니다! -/ex09/s12");
    out.printf("v1 = %s\n", v1);
    out.printf("v2 = %s\n", v2);
    out.printf("v3 = %s\n", v3);

  }

}
