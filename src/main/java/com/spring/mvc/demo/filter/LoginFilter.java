package com.spring.mvc.demo.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;

import com.spring.mvc.demo.entity.User;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

@WebFilter(urlPatterns = "/*", dispatcherTypes = {DispatcherType.REQUEST})
public class LoginFilter implements Filter{
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		// Get the request uri first
		String uri = req.getRequestURI();
		

		
        if (uri.indexOf("/user") >= 0) {
        	chain.doFilter(request, response);
        	return;
        }
        User login = (User) session.getAttribute("loginInfo");
		
		if(login != null) {
			chain.doFilter(request, response);
		}else {
			res.sendRedirect(req.getContextPath() + "/user/login");
		}		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
