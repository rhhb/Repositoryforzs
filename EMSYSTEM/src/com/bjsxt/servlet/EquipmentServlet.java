package com.bjsxt.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.pojo.Dept;
import com.bjsxt.pojo.EquipTable;
import com.bjsxt.pojo.PageInfo;
import com.bjsxt.service.DeptService;
import com.bjsxt.service.EquipTableService;
import com.bjsxt.service.impl.DeptServiceImpl;
import com.bjsxt.service.impl.EquipTableServiceImpl;
import com.google.gson.Gson;

import net.sf.json.JSONObject;
@WebServlet("/equip")
public class EquipmentServlet extends HttpServlet{
	EquipTableService equiptableservice = new EquipTableServiceImpl(); 
	DeptService deptservice = new DeptServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		//获取操作符
		String oper = req.getParameter("oper");
		//查询全部
		if("showAll".equals(oper)) {
			showEquip(req,resp);
			//条件查询
		}else if("queryequip".equals(oper)) {
			showByEEDPage(req,resp);
			//新增设备
		}else if("addequip".equals(oper)) {
			addEquip(req,resp);
		}else {
			req.getRequestDispatcher("/user/error.jsp").forward(req, resp);
		}
	
	}
	/**
	 * 新增设备
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void addEquip(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		EquipTable equiptable = new EquipTable();;
		//获取数据		
		String unifiedcode = req.getParameter("unifiedcode");	
		if(unifiedcode != null && !unifiedcode.equals("")) {
			List<EquipTable> list = equiptableservice.showUnified();
			for(int i=0;i<list.size();i++) {
				EquipTable etb = list.get(i);
				System.out.println(etb.getUnifiedcode()+",");
				if(!unifiedcode.equals(etb.getUnifiedcode())) {
					unifiedcode = new String(unifiedcode);
				}else {
					req.setAttribute("msg","新增失败,设备编码已存在,请重新输入");
					req.getRequestDispatcher("/equipforward/forward.jsp").forward(req, resp);
					return;
				}
				
			}
			
				
				
		} 
			
		
		String createdate = req.getParameter("createdate");
		if(createdate != null && !createdate.equals("")) { 
			createdate = new String(createdate);
			String[] cd=null;			
			cd=createdate.split("/");
			createdate=cd[2]+"-"+cd[0]+"-"+cd[1];
		}
		
		String equipname = req.getParameter("equipname");
		if(equipname != null && !equipname.equals("")) 
			equipname = new String(equipname);
		String models = req.getParameter("models");
		if(models != null && !models.equals("")) 
			models = new String(models);
		String product = req.getParameter("product");
		if(product != null && !product.equals("")) 
			product = new String(product);
		String supervisory_level = req.getParameter("supervisory_level");
		if(supervisory_level != null && !supervisory_level.equals("")) 
			supervisory_level = new String(supervisory_level);
		String deptname = req.getParameter("deptname");
		if(deptname != null && !deptname.equals("")) 
			deptname = new String(deptname);
		
		String manufacture_number = req.getParameter("manufacture_number");
		if(manufacture_number != null && !manufacture_number.equals("")) 
			manufacture_number = new String(manufacture_number);
		String manufacture_date = req.getParameter("manufacture_date");
		if(manufacture_date != null && !manufacture_date.equals("")) { 
			manufacture_date = new String(manufacture_date);
			String[] md=null;
			md=manufacture_date.split("/");
			manufacture_date=md[2]+"-"+md[0]+"-"+md[1];
		}
		
		String commissioning_date = req.getParameter("commissioning_date");
		if(commissioning_date != null && !commissioning_date.equals("")) { 
			commissioning_date = new String(commissioning_date);
			String[] cmd=null;		
			cmd=commissioning_date.split("/");
			commissioning_date=cmd[2]+"-"+cmd[0]+"-"+cmd[1];
		}
		String use_info = req.getParameter("use_info");
		if(use_info != null && !use_info.equals("")) 
			use_info = new String(use_info);
		String now_status = req.getParameter("now_status");
		if(now_status != null && !now_status.equals("")) 
			now_status = new String(now_status);
		String installation_site = req.getParameter("installation_site");
		if(installation_site != null && !installation_site.equals("")) 
			installation_site = new String(installation_site);

		String original_value1 = req.getParameter("original_value");
		if(original_value1 != null &&!original_value1.equals("") ) {
		String s = new String(original_value1);
			double original_value ;
			original_value  = Double.parseDouble(s);
			
			equiptable.setOriginal_value(original_value);
				
		}
		String depreciation_rate = req.getParameter("depreciation_rate");
		if(depreciation_rate != null && !depreciation_rate.equals("")) 
			depreciation_rate = new String(depreciation_rate);
		String durable_year = req.getParameter("durable_year");
		if(durable_year != null && !durable_year.equals("")) 
			durable_year = new String(durable_year);
		String design_capability = req.getParameter("design_capability");
		if(design_capability != null && !design_capability.equals("")) 
			design_capability = new String(design_capability);
		String equip_use = req.getParameter("equip_use");
		if(equip_use != null && !equip_use.equals("")) 
			equip_use = new String(equip_use);
		String sign = req.getParameter("sign");
		if(sign != null && !sign.equals("")) 
			sign = new String(sign);
		String change_unifiedcode = req.getParameter("change_unifiedcode");
		if(change_unifiedcode != null && !change_unifiedcode.equals("")) 
			change_unifiedcode = new String(change_unifiedcode);
		String technical_paraments = req.getParameter("technical_paraments");
		if(technical_paraments != null && !technical_paraments.equals("")) 
			technical_paraments = new String(technical_paraments);
		
		String accessory_equipment = req.getParameter("accessory_equipment");
		if(accessory_equipment != null && !accessory_equipment.equals("")) 
			accessory_equipment = new String(accessory_equipment);
		String accessory_equipment_change = req.getParameter("accessory_equipment_change");
		if(accessory_equipment_change != null && !accessory_equipment_change.equals("")) 
			accessory_equipment_change = new String(accessory_equipment_change);
		String attach_documentation = req.getParameter("attach_documentation");
		if(attach_documentation != null && !attach_documentation.equals("")) 
			attach_documentation = new String(attach_documentation);
		String change_info = req.getParameter("change_info");
		if(change_info != null && !change_info.equals("")) 
			change_info = new String(change_info);
		String parts_model = req.getParameter("parts_model");
		if(parts_model != null && !parts_model.equals("")) 
			parts_model = new String(parts_model);
		String service_record = req.getParameter("service_record");
		if(service_record != null && !service_record.equals("")) 
			service_record = new String(service_record);
		String scrap_sign = req.getParameter("scrap_sign");
		if(scrap_sign != null && !scrap_sign.equals("")) 
			scrap_sign = new String(scrap_sign);
		String deptno = req.getParameter("deptno");
		if(deptno != null && !deptno.equals("")) 
			deptno = new String(deptno);
		
		
		equiptable.setUnifiedcode(unifiedcode);
		equiptable.setCreatedate(createdate);
		equiptable.setEquipname(equipname);
		equiptable.setModels(models);
		equiptable.setProduct(product);
		equiptable.setSupervisory_level(supervisory_level);
		equiptable.setDeptname(deptname);
		
		equiptable.setManufacture_number(manufacture_number);
		equiptable.setManufacture_date(manufacture_date);
		equiptable.setCommissioning_date(commissioning_date);
		equiptable.setUse_info(use_info);
		equiptable.setNow_status(now_status);
		equiptable.setInstallation_site(installation_site);
		
		equiptable.setDepreciation_rate(depreciation_rate);
		equiptable.setDurable_year(durable_year);
		equiptable.setDesign_capability(design_capability);
		
		equiptable.setEquip_use(equip_use);
		equiptable.setSign(sign);
		equiptable.setChange_unifiedcode(change_unifiedcode);
		equiptable.setTechnical_paraments(technical_paraments);
		equiptable.setAccessory_equipment(accessory_equipment);
		equiptable.setAccessory_equipment_change(accessory_equipment_change);
		equiptable.setAttach_documentation(attach_documentation);
		equiptable.setChange_info(change_info);
		
		equiptable.setParts_model(parts_model);
		equiptable.setService_record(service_record);
		equiptable.setScrap_sign(scrap_sign);
		equiptable.setDeptno(deptno);
		
		int code = equiptableservice.addEquipTable(equiptable);
		if(code>0) {
			req.setAttribute("udc", equiptableservice.showUnified());
			req.setAttribute("msg","新增成功");
			req.getRequestDispatcher("/equipforward/forward.jsp").forward(req, resp);
		}else {
			req.setAttribute("msg","新增失败");
			req.getRequestDispatcher("/equipforward/forward.jsp").forward(req, resp);
			return;
		}
		
	}
	private void showByEEDPage(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String data = req.getParameter("data");
		System.out.println(data);
		JSONObject fromObject = JSONObject.fromObject(data);
		
		String unifiedcode = fromObject.getString("unifiedcode");
			if(unifiedcode != null && !unifiedcode.equals("")) 
				unifiedcode = new String(unifiedcode);
			
		String equipname = fromObject.getString("equipname");
			if(equipname != null && !equipname.equals("")) 
				equipname = new String(equipname);
			
		String deptname = fromObject.getString("deptname");
			if(deptname != null && !deptname.equals("")) 
				deptname = new String(deptname);
			
		
		int pageSize=5;
		String pageSizeStr = fromObject.getString("pageSize");
		if(pageSizeStr!=null&&!pageSizeStr.equals("")) {
			pageSize= Integer.parseInt(pageSizeStr);
		}
		int pageNumber = 1;
		
		String pageNumberStr = fromObject.getString("pageNumber");
		if(pageNumberStr!=null&&!pageNumberStr.equals("")) {
			pageNumber = Integer.parseInt(pageNumberStr);
			System.out.println(pageNumber);
		}
		PageInfo pageinfo = equiptableservice.showByEEDPage(pageNumber, pageSize, unifiedcode, equipname, deptname);
		long count = equiptableservice.selByCount(unifiedcode, equipname, deptname);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", (List<EquipTable>) pageinfo.getList());
		map.put("pageSize", pageinfo.getPageSize());
		map.put("pageNumber", pageinfo.getPageNumber());
		map.put("total", pageinfo.getTotal());
		map.put("count", count);
			//响应处理结果
		resp.getWriter().write(new Gson().toJson(map));
		
//		req.setAttribute("pageinfo", equiptableservice.showByEEDPage(pageNumber, pageSize,unifiedcode,equipname,deptname));
//		req.setAttribute("count",equiptableservice.selByCount(unifiedcode, equipname, deptname));
//		System.out.println("******");
		return;
	}
	/**
	 * 查询全部设备
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void showEquip(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		int pageSize =3;
		String pageSizeStr = req.getParameter("pageSize");
		if(pageSizeStr!=null&&!pageSizeStr.equals("")) {
			pageSize= Integer.parseInt(pageSizeStr);
		}
		int pageNumber = 1;
		String pageNumberStr = req.getParameter("pageNumber");
		if(pageNumberStr!=null&&!pageNumberStr.equals("")) {
			pageNumber = Integer.parseInt(pageNumberStr);
		}
		req.setAttribute("pageinfo", equiptableservice.showPage(pageNumber,pageSize));
		req.setAttribute("count",equiptableservice.selCount());
	
		req.getRequestDispatcher("/equip/showEquip.jsp").forward(req,resp);
		return;
	}
}
