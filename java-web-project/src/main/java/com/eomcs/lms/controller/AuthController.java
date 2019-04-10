package com.eomcs.lms.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.eomcs.lms.context.RequestMapping;
import com.eomcs.lms.context.RequestParam;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.service.MemberService;

@Controller
public class AuthController {

  static final String REFERER_URL = "refererURL";

  @Autowired
  MemberService memberService;
  @Autowired
  ServletContext servletContext;

  @RequestMapping("/auth/form")
  public String form(HttpServletRequest request, HttpSession session) throws Exception {
    session.setAttribute(REFERER_URL, request.getHeader("Referer"));
    return "/auth/login.jsp";
  }

  @RequestMapping("/auth/login")
  public String login(@RequestParam("email") String email,
      @RequestParam("password") String password, @RequestParam("saveEmail") String saveEmail,
      HttpServletResponse response, HttpSession session) throws Exception {

    Cookie cookie;
    if (saveEmail != null) {
      cookie = new Cookie("email", email);
      cookie.setMaxAge(60 * 60 * 24 * 15);
    } else {
      cookie = new Cookie("email", "");
      cookie.setMaxAge(0);
    }

    response.addCookie(cookie);

    Member member = memberService.get(email, password);

    if (member == null) {
      return "/auth/fail.jsp";
    }

    session.setAttribute("loginUser", member);

    String refererUrl = (String) session.getAttribute(REFERER_URL);

    if (refererUrl == null) {
      return "redirect:" + servletContext.getContextPath();
    } else {
      return "redirect:" + refererUrl;
    }
  }

  @RequestMapping("/auth/logout")
  public String logout(HttpSession session) throws Exception {

    session.invalidate();
    return "redirect:" + servletContext.getContextPath();
  }

}


