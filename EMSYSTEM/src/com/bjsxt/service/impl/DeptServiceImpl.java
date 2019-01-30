package com.bjsxt.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bjsxt.mapper.DeptMapper;
import com.bjsxt.pojo.Dept;
import com.bjsxt.service.DeptService;

public class DeptServiceImpl implements DeptService {

	@Override
	public List<Dept> showDept() throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		
		DeptMapper mapper = session.getMapper(DeptMapper.class);
		List<Dept> list = mapper.selAll();
		session.close();
		return list;
	}

}
