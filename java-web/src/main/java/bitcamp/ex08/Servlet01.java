package bitcamp.ex08;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/ex08/s1")
public class Servlet01 extends HttpServlet {

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    resp.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = resp.getWriter();

    out.println("안녕하세요! /ex08/s1입니다!");

    for (int i = 0; i < 1000; i++) {
      out.println(i + "==>가나다라마바사아자차카타파하한글을실컷써봅시다ㅏㅏㅏ");
    }
    resp.setHeader("Refresh", "3;url=s100");
  }

}
