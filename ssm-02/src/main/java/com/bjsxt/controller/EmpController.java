package com.bjsxt.controller;

import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bjsxt.excel.util.ClassUtil;
import com.bjsxt.excel.util.ExcelUtil;
import com.bjsxt.excel.util.ExportExcel;
import com.bjsxt.pojo.Emp;
import com.bjsxt.pojo.Model;
import com.bjsxt.service.EmpService;

@Controller
public class EmpController {
	
	@Resource
	private EmpService empSericeImpl;
	@RequestMapping("/InputExcel")
	@ResponseBody
	public String InputExcel(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws Exception {
		String flag = "02";// 上传标志
		if (!file.isEmpty()) {
			try {
				
				String originalFilename = file.getOriginalFilename();// 原文件名字
				System.out.println(originalFilename);
				//log.info("文件名：" + originalFilename);
				InputStream is = file.getInputStream();// 获取输入流
				System.out.println(is);
				 flag = empSericeImpl.insInputExcel(is, originalFilename);
				 System.out.println(flag);
				 System.out.println("******");
			} catch (Exception e) {
				flag = "03";// 上传出错
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	@RequestMapping("/OutputExcel")
	@ResponseBody
	public String OutputExcel(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html,charset=utf-8");
		 Collection<Emp> dataset = empSericeImpl.selgetAll();
		 
		System.out.println("控制层*****");
		System.out.println(dataset);
//		String tilte = "emp表";
//		System.out.println("控制层.......");
		String[] headers = {"id","姓名","性别","邮箱","部门编号"};
//		String[] Col = {"id","name","sex","email","depr_id"};
		
		String message = ExcelUtil.exportExcel(request, response, headers, dataset);;
		System.out.println("执行完成....");
		if (message.equals("fail")) {
			ServletOutputStream out = response.getOutputStream();
			message = "导出失败，请重试";
			String s = "<!DOCTYPE HTML><html><head><script>alert('" + message + "');</script></head><body></body></html>";
			out.print(s);
		}
		return null;
	}
}
