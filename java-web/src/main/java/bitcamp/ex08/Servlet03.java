package bitcamp.ex08;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/ex08/s3")
public class Servlet03 extends HttpServlet {

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    resp.setContentType("text/html;charset=UTF-8");
    PrintWriter out = resp.getWriter();

    out.println("<html><head>");
    out.println("<title>리다이렉트</title>");
    out.println("</head><body>");
    // for (int i = 0; i < 500; i++) {
    out.println("안녕하세요! /ex08/s3입니다!");
    // }
    out.println("</body></html>");

    resp.sendRedirect("s100");
  }

}
