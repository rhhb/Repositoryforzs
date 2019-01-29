package com.bjsxt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bjsxt.pojo.User;
import com.bjsxt.service.UserService;
import com.bjsxt.service.impl.UserServiceImpl;
@WebServlet("/check")
public class CheckServlet extends HttpServlet{
	UserService us = new UserServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		User u = us.showUser(user);
				if(u!=null) {
					HttpSession hs = req.getSession();
		    		hs.setAttribute("user", u);		    		
		    		resp.sendRedirect("/EMSYSTEM/main/main.jsp");
		    		return;
//					req.getRequestDispatcher("/main/main.jsp").forward(req, resp);
					
				}else {
					
					req.setAttribute("msg","登录失败,请重新登录");
					req.getRequestDispatcher("/wrong/forward.jsp").forward(req, resp);
				}
	
	}
}
