package com.eomcs.lms.web;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.service.MemberService;

@Controller
@RequestMapping("/auth")
public class AuthController {

  final static Logger logger = (Logger) LogManager.getLogger(AuthController.class);

  static final String REFERER_URL = "refererURL";

  @Autowired
  MemberService memberService;
  @Autowired
  ServletContext servletContext;

  @GetMapping("form")
  public void form(@RequestHeader(value = "Referer", required = false) String refererUrl,
      HttpSession session) throws Exception {
    logger.debug("refererURL: " + refererUrl);

    if (refererUrl != null) {
      session.setAttribute(REFERER_URL, refererUrl);
    } else {
      session.removeAttribute(REFERER_URL);
    }
  }

  @PostMapping("login")
  public String login(String email, String password, String saveEmail, HttpServletResponse response,
      HttpSession session) throws Exception {

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
      return "auth/fail";
    }

    session.setAttribute("loginUser", member);

    String refererUrl = (String) session.getAttribute(REFERER_URL);

    if (refererUrl != null && !refererUrl.endsWith("/auth/login")) {
      return "redirect:/";
    } else {
      // response.sendRedirect(refererUrl);
      // return null;
      return "redirect:" + refererUrl;
    }
  }

  @GetMapping("logout")
  public String logout(HttpSession session) throws Exception {

    logger.debug("세션 무효화 시킴!");
    session.invalidate();
    return "redirect:/";
  }

}


