package com.bjsxt.test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.bjsxt.excel.util.ClassUtil;
import com.bjsxt.excel.util.ExportExcel;
import com.bjsxt.pojo.Model;

public class Test {
	public static void main(String[] args) {
		//初始化数据
    	List<Model> list=new ArrayList<Model>();
    	for (int i = 0; i < 10; i++) {
    		Model model=new Model();
        	model.setMc("测试"+i);
        	model.setRq(new Date());
        	model.setSj(new Timestamp(System.currentTimeMillis()));
        	model.setType("111111111111111");
        	list.add(model);
		}
    	String fileName="D:\\test\\text.xlsx";
    	
    	
    	//自定义excel表格表头展示字段顺序
    	//获取实体类字段
    	Map<String,String> map = ClassUtil.getAllDesc(new Model());
    	Object[] keys  =  map.keySet().toArray();//从实体类中取字段
    	String[]  headers=new String[keys.length];
    	StringBuffer str=new StringBuffer("{");
    	for (int i = 0; i < keys.length; i++) {
    		headers[i]=keys[i].toString();
    		str.append("\""+keys[i].toString()+"\"");
    		if(i<(keys.length-1)){
    			str.append(",");
    		}
		}
    	str.append("}");
    	System.out.println(str.toString());//把打印出来的字符串拷贝到headers=后面，根据需要，调整字段显示的顺序
    	
    	
//    	String[] headers={"type","mc","rq","sj"};
//    	ExportExcel.exportExcelUtil(list,fileName,"1",headers,new Model());
	}

	
}
