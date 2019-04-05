package com.eomcs.lms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.service.BoardService;

@WebServlet("/board/add")
@SuppressWarnings("serial")
public class BoardAddServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    request.getRequestDispatcher("/board/form.jsp").include(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    BoardService boardService =
        ((ApplicationContext) this.getServletContext().getAttribute("iocContainer"))
            .getBean(BoardService.class);

    Board board = new Board();
    board.setContents(request.getParameter("contents") + ":" + request.getRemoteAddr());

    boardService.add(board);

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    response.sendRedirect("list");
  }

}


