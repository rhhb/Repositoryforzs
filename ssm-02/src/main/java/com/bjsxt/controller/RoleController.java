package com.bjsxt.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bjsxt.excel.util.ExcelUtil;
import com.bjsxt.pojo.EasyUIDatagrid;
import com.bjsxt.pojo.Menu;
import com.bjsxt.pojo.Role;
import com.bjsxt.service.RoleService;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
@Controller
@RequestMapping("page")
public class RoleController {
	@Resource
	private RoleService roleServiceImpl;
	@RequestMapping("showRole")
	@ResponseBody
	public EasyUIDatagrid showRole(@RequestParam(defaultValue="5")int rows,@RequestParam(defaultValue="1")int page){
		return roleServiceImpl.showRole(rows, page);
	}
	
	@RequestMapping("update")
	@ResponseBody
	public int update(Role role){
		int index = roleServiceImpl.update(role);
		return index;
	}
	@RequestMapping("showPrivilege")
	@ResponseBody
	public List<Menu> showPrivilege(int id){
		return roleServiceImpl.showPrivilege(id);
	}
	
	@RequestMapping("role_excel")
	@ResponseBody
	public String roleExportExcel(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		try {
//			request.setCharacterEncoding("UTF-8");
//			response.setCharacterEncoding("UTF-8");
//			response.setContentType("text/html,charset=utf-8");
			Collection<Role> dataset = roleServiceImpl.showAll();
			String[] headers = {"id","角色名称","排序id","备注"}; 
			String message = ExcelUtil.exportExcel(request, response, headers, dataset);
			System.out.println(message);
			if (!message.equals("success")) {
				ServletOutputStream out = response.getOutputStream();
				message = "导出失败，请重试";
				String s = "<!DOCTYPE HTML><html><head><script>alert('" + message + "');</script></head><body></body></html>";
				out.print(s);
			}	
			return message;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}
	
	//角色新增
	@RequestMapping("roleAdd")
	@ResponseBody
	public int insRole(Role role) {
		int index = roleServiceImpl.insRole(role);
		return index;
	}
	@RequestMapping(value="roleRemove")
	@ResponseBody
	public int delRole(HttpServletRequest req, HttpServletResponse resp) {
	//,method = RequestMethod.POST,consumes = "application/json"	
		String obj = req.getParameter("rid");
		if(obj!=null) {
		String[] sp = obj.split(",");
		int in[] = new int[sp.length];
			for (int i = 0; i < sp.length; i++) {
				in[i] = Integer.parseInt(sp[i]);				
				}
			String str = Arrays.toString(in);
		int index = roleServiceImpl.delRole(in);		
		return index;
		}else {
			return 0;
		}
	}
}
