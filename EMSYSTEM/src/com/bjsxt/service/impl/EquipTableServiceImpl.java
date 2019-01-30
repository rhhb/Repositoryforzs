package com.bjsxt.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bjsxt.mapper.EquipTableMapper;
import com.bjsxt.pojo.EquipTable;
import com.bjsxt.pojo.PageInfo;
import com.bjsxt.service.EquipTableService;
import com.oracle.webservices.internal.api.databinding.Databinding.Builder;

public class EquipTableServiceImpl implements EquipTableService{

	@Override
	public int addEquipTable(EquipTable equiptable) throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		
		EquipTableMapper mapper = session.getMapper(EquipTableMapper.class);
		int index = mapper.insEquip(equiptable);
		session.commit();
		session.close();
		return index;
	}

	@Override
	public List<EquipTable> showAll() throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		
		EquipTableMapper mapper = session.getMapper(EquipTableMapper.class);
		List<EquipTable> list = mapper.selAll();
		return list;
	}

	@Override
	public PageInfo showPage(int pageNumber, int pageSize) throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		
		EquipTableMapper mapper = session.getMapper(EquipTableMapper.class);
		Map<String,Object> param = new HashMap<>();
		param.put("pageStart", pageSize*(pageNumber-1));
		param.put("pageSize", pageSize);
		
		List<EquipTable> list = session.selectList("com.bjsxt.mapper.EquipTableMapper.selByPage", param);
		long count = mapper.selCount();
		PageInfo pi = new PageInfo();
		pi.setPageNumber(pageNumber);
		pi.setPageSize(pageSize);
		pi.setList(list);
		pi.setTotal(count%pageSize==0?count/pageSize:count/pageSize+1);
		return pi;
	}

	@Override
	public long selCount() throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		
		EquipTableMapper mapper = session.getMapper(EquipTableMapper.class);
		long count = mapper.selCount();
		return count;
	}

	@Override
	public PageInfo showByEEDPage(int pageNumber,int pageSize,String unifiedcode,String equipname,String deptname) throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		
		EquipTableMapper mapper = session.getMapper(EquipTableMapper.class);
		Map<String,Object> param = new HashMap<>();
		param.put("pageStart", pageSize*(pageNumber-1));
		param.put("pageSize", pageSize);
		param.put("unifiedcode", unifiedcode);
		param.put("equipname", equipname);
		param.put("deptname", deptname);
		
//		PageInfo pi = mapper.selByEnoEnameDept(pageNumber, pageSize,unifiedcode, equipname,deptname);
		List<EquipTable> list = session.selectList("com.bjsxt.mapper.EquipTableMapper.selByEnoEnameDept", param);
//		Map<String,Object> param1 = new HashMap<>();
//		param1.put("unifiedcode", unifiedcode);
//		param1.put("equipname", equipname);
//		param1.put("deptname", deptname);
//		long count = session.selectOne("com.bjsxt.mapper.EquipTableMapper.selByEnoEnameDeptCount",param1);
//		List<EquipTable> list = (List<EquipTable>) pi.getList();
		long count = mapper.selByEnoEnameDeptCount(unifiedcode, equipname, deptname);
		
		PageInfo pi =new PageInfo();
		pi.setPageNumber(pageSize*(pageNumber-1));
		pi.setPageSize(pageSize);
		pi.setList(list);
		pi.setTotal(count%pageSize==0?count/pageSize:count/pageSize+1);
		pi.setCount(count);
		return pi;
		
	}

	@Override
	public long selByCount(String unifiedcode,String equipname,String deptname) throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		
		EquipTableMapper mapper = session.getMapper(EquipTableMapper.class);
		Map<String,Object> param = new HashMap<>();
		param.put("unifiedcode", unifiedcode);
		param.put("equipname", equipname);
		param.put("deptname", deptname);
		long count = session.selectOne("com.bjsxt.mapper.EquipTableMapper.selByEnoEnameDeptCount",param);
//		long count = mapper.selByEnoEnameDeptCount(unifiedcode, equipname, deptname);
		return count;
		
	}
	/**查询设备编码，做重复验证
	 * @throws IOException 
	 * 
	 */
	@Override
	public List<EquipTable> showUnified() throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		
		EquipTableMapper mapper = session.getMapper(EquipTableMapper.class);
		List<EquipTable> list = mapper.selUnifiedcode();
		return list;
	}
	

}
