package com.bjsxt.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.pojo.Dept;
import com.bjsxt.service.DeptService;
import com.bjsxt.service.impl.DeptServiceImpl;
@WebServlet("/dept")
public class DeptServlet extends HttpServlet{
	DeptService deptservice = new DeptServiceImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		String oper = req.getParameter("oper");
		if("equipAdd".equals(oper)) {
			equipAdd(req,resp);
			
		}else if("queryEquip".equals(oper)) {
			queryEquip(req,resp);
		}
		
		
	}

	private void queryEquip(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		List<Dept> list = deptservice.showDept();
		req.setAttribute("list", list);
		req.getRequestDispatcher("/equip/queryEquip.jsp").forward(req, resp);
		
	}

	private void equipAdd(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		List<Dept> list = deptservice.showDept();
		req.setAttribute("list", list);
		req.getRequestDispatcher("/equip/add_equip.jsp").forward(req, resp);
		
	}
}
