package com.eomcs.lms.web.filter;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.eomcs.lms.domain.Member;

@WebFilter("/app/*")
public class AuthFilter implements Filter {

  FilterConfig filterConfig;
  String contextRootPath;

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    this.filterConfig = filterConfig;
    contextRootPath = filterConfig.getServletContext().getContextPath();
  }


  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {

    HttpServletRequest httpReq = (HttpServletRequest) request;
    HttpServletResponse httpResp = (HttpServletResponse) response;

    // String servletPath = httpReq.getServletPath();
    String pathInfo = httpReq.getPathInfo();

    if (pathInfo.endsWith("add") || pathInfo.endsWith("update") || pathInfo.endsWith("delete")
        || (!pathInfo.endsWith("/auth/form") && pathInfo.endsWith("form"))) {
      Member loginUser = (Member) httpReq.getSession().getAttribute("loginUser");
      if (loginUser == null) {
        if (pathInfo.startsWith("/json")) {
          response.setContentType("text/plain;charset=UTF-8");
          PrintWriter out = response.getWriter();
          out.println("{\"status\":\"loginfail\", \"message\": \"로그인 하지 않았습니다.\"}");
        } else {
          httpResp.sendRedirect(contextRootPath + "/app/auth/form");
        }
        return;
      }
    }
    chain.doFilter(request, response);
  }

}
