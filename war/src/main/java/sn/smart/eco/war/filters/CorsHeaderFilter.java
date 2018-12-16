package sn.smart.eco.war.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CorsHeaderFilter implements Filter {

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    HttpServletRequest r = (HttpServletRequest) request;
    HeaderMapRequestWrapper requestWrapper = new HeaderMapRequestWrapper(r);
    requestWrapper.addHeader("Access-Control-Allow-Origin", "http://localhost:4200");
    requestWrapper.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
    requestWrapper.addHeader("Access-Control-Allow-Headers",
        "Access-Control-*, Origin, X-Requested-With, Content-Type, Accept");
    requestWrapper.addHeader("Access-Control-Expose-Headers", "Access-Control-*");

    HttpServletResponse res = (HttpServletResponse) response;
    res.setHeader("Access-Control-Allow-Origin", "*");
    res.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
    res.setHeader("Access-Control-Max-Age", "3600");
    res.setHeader("Access-Control-Allow-Headers", "*");
    if (!requestWrapper.getMethod().equals("OPTIONS")) {
      chain.doFilter(requestWrapper, res);
    }
    // chain.doFilter(requestWrapper, res);
  }

}
