package com.bjsxt.service.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bjsxt.excel.util.ExcelUtil;
import com.bjsxt.mapper.EmpMapper;
import com.bjsxt.pojo.Emp;
import com.bjsxt.service.EmpService;


@Service

public class EmpServiceImpl implements EmpService{
	@Resource
	private EmpMapper empMapper;
	@Override
	public String insInputExcel(InputStream is, String originalFilename) {
		Map<String,Object> ginsengMap = new HashMap<String,Object>();
		List<ArrayList<Object>> list;
		if (originalFilename.endsWith(".xls")) {
			list = ExcelUtil.readExcel2003(is);
			System.out.println(list);
		} else {
			list = ExcelUtil.readExcel2007(is);
		}
		for (int i=0,j=list.size();i<j;i++){	
			List<Object> row = list.get(i);
			ginsengMap.put("id", row.get(0).toString());
			ginsengMap.put("name", row.get(1).toString());
			ginsengMap.put("sex", row.get(2).toString());			
	        ginsengMap.put("email", row.get(3).toString());		       
	        ginsengMap.put("dept_id", row.get(4).toString());
	        empMapper.insInputExcel(ginsengMap);
	        
		}
		return "01";

	}

	@Override
	public List<Emp> selgetAll() {
		System.out.println("调用业务层实现方法");
		return empMapper.selgetAll() ;
		
	}

}
