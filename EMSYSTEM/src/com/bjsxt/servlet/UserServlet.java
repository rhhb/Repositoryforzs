package com.bjsxt.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bjsxt.pojo.User;
@WebServlet("/user")
public class UserServlet extends HttpServlet {
	
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException{
    	//设置请求编码格式
    	req.setCharacterEncoding("utf-8");
    	//设置相应编码格式
    	resp.setContentType("text/html;charset=utf-8");
    	//获取操作符
    	String oper = req.getParameter("oper");
    	if("login".equals(oper)){
    		//调用登录处理功能
    		checkUserLogin(req,resp);
    	}else if("out".equals(oper)){
    		//调用退出功能
    		userOut(req,resp);
    	}else if("pwd".equals(oper)){
    		//调用修改密码功能
    		userChangePwd(req,resp);
    	}else if("reg".equals(oper)){
    		//调用注册功能
    		userReg(req,resp);
    	}else if("show".equals(oper)){
    		//调用查看所有用户信息功能
    		showUser(req,resp);
    	}else{
    		req.getRequestDispatcher("user/error.jsp").forward(req, resp);
    	}
    	
    	//获取请求信息
    	//处理请求信息
    	//响应处理结果
    	   //直接
    	   //请求转发
    	   //重定向
    	
    	
    	
    	
    }
    /**
     * 查看所有用户信息
     * @param req
     * @param resp
     * @throws Exception 
     */
    private void showUser(HttpServletRequest req, HttpServletResponse resp)  {
    	//获取请求信息
    	List<User> all;
		try {
			all = ServiceFactory.getIUserServiceInstance().showUserService();
			//处理请求信息
	    	if(all!=null){
	    		req.setAttribute("users", all);
	    		//响应处理结果
		    	   //直接
		    	   //请求转发
		    	req.getRequestDispatcher("user/showUser.jsp").forward(req, resp);
		    	return;
		    	   //重定向
	    	}
	    	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
		
	}
	/**
     * 用户注册
     * @param req
     * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 * @throws Exception 
     */
    private void userReg(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	//获取请求信息
    	
    	String uname = req.getParameter("uname");
    	if(uname==null||uname.equals("")){
    		req.setAttribute("msg", "用户名不能为空");
			req.getRequestDispatcher("user/forword.jsp").forward(req, resp);
    	}
    	String pwd = req.getParameter("pwd");
    	
    	int sex = Integer.parseInt(req.getParameter("sex"));
    	int age = req.getParameter("age")!=""?Integer.parseInt(req.getParameter("age")):0;
    	String birth = req.getParameter("birth");
    	String[] bs = null;
    	if(birth!=""){
    		bs = birth.split("/");
    		birth=bs[2]+"-"+bs[0]+"-"+bs[1];
    	}
    	User u = new User(0,uname,pwd,sex,age,birth);
    	
    	
    	System.out.println(sex);
    	System.out.println(birth);
    	//处理请求信息
    	
    	try {
    		if(uname!=null&&!uname.equals("")&&pwd!=null&&!pwd.equals("")){
	    		if(ServiceFactory.getIUserServiceInstance().userRegService(u)){
					//响应处理结果
					req.setAttribute("msg", "注册成功");
				       //直接
				       //请求转发
					req.getRequestDispatcher("user/forword.jsp").forward(req, resp);
				       //重定向
				
	    		}
    		
				}else{
					req.setAttribute("msg", "注册失败");
					req.getRequestDispatcher("user/forword.jsp").forward(req, resp);
					System.out.println("注册失败");
					req.getRequestDispatcher("user/reg.jsp").forward(req, resp);
				}
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    	
    	
	}
    /**
     * 修改用户密码
     * @param req
     * @param resp
     */
	private void userChangePwd(HttpServletRequest req, HttpServletResponse resp) {
    	//获取请求信息
    	
    	String newPwd = req.getParameter("newPwd");
    	System.out.println(newPwd);
    	
    	User u = (User)req.getSession().getAttribute("user");
    	int id = u.getId();
    	//处理请求信息
    	try {
			if(ServiceFactory.getIUserServiceInstance().userChangePwdService(newPwd, uid)){
//				HttpSession hs = req.getSession();
//				hs.setAttribute("msg","密码修改成功！");
				req.setAttribute("msg","密码修改成功！！");
				//请求转发
				req.getRequestDispatcher("/user/forword.jsp").forward(req, resp);
				return;
				//重定向
//				resp.sendRedirect("/EMS/user/forword.jsp");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	//响应处理结果
    	   //直接
    	   //请求转发
    	   //重定向
		
	}
	/**
	 * 退出登录
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	private void userOut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    	//获取请求信息
    	HttpSession hs =req.getSession();
    	//处理请求信息
    	hs.invalidate();
    	//响应处理结果
    	   //直接
    	   //请求转发
    	   
    	   //重定向
		resp.sendRedirect("/EMSYSTEM/index.jsp");
	}
	/**
	 * 用户登录
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	private void checkUserLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取请求信息
		String uname = req.getParameter("uname");
    	String pwd = req.getParameter("pwd");
    	User u = null;
		try {
			//查询用户信息
			u = ServiceFactory.getIUserServiceInstance().checkUserLoginService(uname, pwd);
			
		} catch (Exception e) {			
			e.printStackTrace();
		}
    	if(u != null){ //如果用户存在
    		//获取session对象
    		HttpSession hs = req.getSession();
    		hs.setAttribute("user", u);
    		
    		resp.sendRedirect("/EMS/main/main.jsp");
    		return;
    	}else{
    		//设置标识符到request中
    		req.setAttribute("flag",0);
    		//请求转发
    		req.getRequestDispatcher("/login.jsp").forward(req, resp);
    		return;
    	}
    	//处理请求信息
    	//响应处理结果
    	   //直接
    	   //请求转发
    	   //重定向
		
	}
}
