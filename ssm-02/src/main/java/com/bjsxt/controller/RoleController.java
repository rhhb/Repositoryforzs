package com.bjsxt.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bjsxt.excel.util.ExcelUtil;
import com.bjsxt.pojo.EasyUIDatagrid;
import com.bjsxt.pojo.Menu;
import com.bjsxt.pojo.Role;
import com.bjsxt.service.RoleService;

@Controller
@RequestMapping("page")
public class RoleController {
	@Resource
	private RoleService roleServiceImpl;
	@RequestMapping("showRole")
	@ResponseBody
	public EasyUIDatagrid showRole(@RequestParam(defaultValue="2")int rows,@RequestParam(defaultValue="1")int page){
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
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html,charset=utf-8");
			Collection<Role> dataset = roleServiceImpl.showAll();
			String[] headers = {"id","角色名称","排序id","备注"}; 
			String message = ExcelUtil.exportExcel(request, response, headers, dataset);;				
			if (message.equals("fail")) {
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
}
