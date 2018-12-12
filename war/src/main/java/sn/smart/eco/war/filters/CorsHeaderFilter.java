package sn.smart.eco.war.filters;

import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class CorsHeaderFilter extends GenericFilterBean {

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    HttpServletRequest r = (HttpServletRequest) request;
    HeaderMapRequestWrapper requestWrapper = new HeaderMapRequestWrapper(r);
    requestWrapper.addHeader("Access-Control-Allow-Origin", "*");
    requestWrapper.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
    chain.doFilter(requestWrapper, response);
  }

}
