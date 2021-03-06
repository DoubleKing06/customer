package com.kkliu.customer;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

public class SessionFilter extends OncePerRequestFilter {
	
	private static final String[] notFilter = new String[] { "main.html", "/check","/js","/img","/images","/css"};
	
	@Override
	protected void doFilterInternal(HttpServletRequest request,
	         HttpServletResponse response, FilterChain filterChain)
	         throws ServletException, IOException {
		String uri = request.getRequestURI();
	 
		if (needFilter(uri)) {
			Object obj = request.getSession().getAttribute("username");
			if (null != obj) {
				filterChain.doFilter(request, response);
			} else {
				response.sendRedirect("/main.html");
			}
		} else {
			filterChain.doFilter(request, response);
		}
	}
	
	private boolean needFilter(String uri) {
		if (null != uri) {
			for (String s : notFilter) {
			     if (uri.indexOf(s) >= 0) {
			    	 return false;
			     }
			}
			
			return true;
		}
		
		return false;
	}
}
