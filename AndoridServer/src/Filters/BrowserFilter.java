package Filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.Filter;

import com.sun.net.httpserver.HttpExchange;

public class BrowserFilter implements Filter {
	public FilterConfig config;

	public void destroy() {
		this.config = null;
		System.out.println("BrowerFilter destroyed");
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse rep = (HttpServletResponse) response;
		String userAgent = req.getHeader("user-agent");
		/*
		 * To do:determine whether should filter the request
		 */
		System.out.println(userAgent);
		chain.doFilter(req, rep);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		config = filterConfig;
	}
}
