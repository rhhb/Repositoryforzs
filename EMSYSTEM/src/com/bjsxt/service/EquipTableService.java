package com.bjsxt.service;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bjsxt.pojo.EquipTable;
import com.bjsxt.pojo.PageInfo;

public interface EquipTableService {
	/**
	 * 新增设备信息
	 * @param equiptable
	 * @return
	 * @throws IOException
	 */
	int addEquipTable(EquipTable equiptable) throws IOException;
	/**
	 * 查询全部
	 * @return
	 * @throws IOException 
	 */
	List<EquipTable> showAll() throws IOException;
	/**
	 * 分页查询
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 * @throws IOException
	 */
	PageInfo showPage(int pageNumber,int pageSize) throws IOException;
	long selCount() throws IOException;
	/**
	 * 根据设备编码||设备名称||部门名称条件进行分页查询
	 * @param pageNumber 页数
	 * @param pageSize 每页个数
	 * @return
	 * @throws IOException
	 */
	PageInfo showByEEDPage( int pageNumber,int pageSize,String unifiedcode,String equipname,String deptname) throws IOException;
	long selByCount(String unifiedcode,String equipname,String deptname) throws IOException;
	/**
	 * 查询设备编码，做重复验证
	 * @return
	 * @throws IOException 
	 */
	List<EquipTable> showUnified() throws IOException;
}
