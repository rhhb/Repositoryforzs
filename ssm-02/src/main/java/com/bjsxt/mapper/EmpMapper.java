package com.bjsxt.mapper;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.bjsxt.pojo.Emp;

public interface EmpMapper {
	
	int insInputExcel(Map<String, Object> ginsengMap);
	Collection<Emp> selgetAll();
}
