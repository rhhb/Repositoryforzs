package com.bjsxt.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bjsxt.pojo.User;
@WebFilter(filterName="SessionFilter",urlPatterns="/main/main.jsp")
public class SessionFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filter)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();
        //判断session是否过期
        if ((User) session.getAttribute("user") == null) {
            String errors = "您还没有登录，或者session已过期。请先登陆!";
            request.setAttribute("msg", errors);
            //跳转至登录页面
            request.getRequestDispatcher("/wrong/forward.jsp").forward(request, response);
            return;
        } else {
            filter.doFilter(request, response);
        }

		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
