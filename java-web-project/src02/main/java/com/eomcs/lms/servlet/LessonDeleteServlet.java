package com.eomcs.lms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.eomcs.lms.InitServlet;
import com.eomcs.lms.service.LessonService;

@WebServlet("/lesson/delete")
@SuppressWarnings("serial")
public class LessonDeleteServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    LessonService lessonService = InitServlet.iocContainer.getBean(LessonService.class);

    int no = Integer.parseInt(request.getParameter("no"));

    if (lessonService.delete(no) > 0) {
      response.sendRedirect("list");
      return;
    }

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<html><head>" + "<title>수업 정보 삭제</title>"
        + "<meta http-equiv='Refresh' content='1;url=list'>" + "</head>");
    out.println("<body><h1>수업 정보 삭제</h1>");

    out.println("</body></html>");
  }

}
