package com.eomcs.lms.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;

import com.eomcs.lms.domain.Member;
import com.eomcs.lms.service.MemberService;

@WebServlet("/auth/login")
@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {

  static final String REFERER_URL = "refererURL";

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    HttpSession session = request.getSession();
    session.setAttribute(REFERER_URL, request.getHeader("Referer"));

    Cookie[] cookies = request.getCookies();
    String email = "";
    if (cookies != null) {
      for (Cookie c : cookies) {
        if (c.getName().equals("email")) {
          email = c.getValue();
          break;
        }
      }
    }

    request.setAttribute("email", email);
    response.setContentType("text/html;charset=UTF-8");
    request.getRequestDispatcher("/auth/login.jsp").include(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    Cookie cookie;
    if (request.getParameter("saveEmail") != null) {
      cookie = new Cookie("email", request.getParameter("email"));
      cookie.setMaxAge(60 * 60 * 24 * 15);
    } else {
      cookie = new Cookie("email", "");
      cookie.setMaxAge(0);
    }
    response.addCookie(cookie);

    System.out.println(request.getHeader("Referer"));

    MemberService memberService =
        ((ApplicationContext) this.getServletContext().getAttribute("iocContainer"))
            .getBean(MemberService.class);

    Member member =
        memberService.get(request.getParameter("email"), request.getParameter("password"));

    if (member == null) {
    	response.setContentType("text/html;charset=UTF-8");
    	
    	request.setAttribute("error.title", "로그인 실패");
        request.setAttribute("error.content", "이메일 또는 암호가 맞지 않습니다.");

        request.getRequestDispatcher("/error.jsp").forward(request, response);
      return;
    }

    HttpSession session = request.getSession();

    session.setAttribute("loginUser", member);


    String refererUrl = (String) session.getAttribute(REFERER_URL);

    if (refererUrl == null) {
      response.sendRedirect("../");
    } else {
      response.sendRedirect(refererUrl);
    }


  }

}


