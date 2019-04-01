package bitcamp.ex07;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/ex07/s11_minus")
public class Servlet11_minus extends HttpServlet {

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    PrintWriter out = resp.getWriter();

    int a = Integer.parseInt(req.getParameter("a"));
    int b = Integer.parseInt(req.getParameter("b"));

    out.printf("%d - %d = %d\n", a, b, (a - b));
  }

}
