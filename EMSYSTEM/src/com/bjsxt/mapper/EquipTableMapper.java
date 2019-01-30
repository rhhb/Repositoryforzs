package com.bjsxt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.bjsxt.pojo.EquipTable;
import com.bjsxt.pojo.PageInfo;
import com.bjsxt.pojo.User;

public interface EquipTableMapper {
	/**
	 * 新增设备
	 * @param equiptable
	 * @return
	 */
	int insEquip(EquipTable equiptable);
	/**
	 * 查询全部
	 * @return
	 */
	List<EquipTable> selAll();
	/**
	 * 分页查询功能
	 * @param pageNuber
	 * @param pageSize
	 * @return
	 */
	PageInfo selByPage(int pageNumber, int pageSize); 
	/**
	 * 查询总条数
	 * @return
	 */
	long selCount();
	/**
	 * 根据设备编码||设备名称||部门名称条件进行查询
	 * @param pageNumber 页数
	 * @param pageSize 每页个数
	 * @return
	 */
	PageInfo selByEnoEnameDept(int pageNumber, int pageSize, String unifiedcode, String equipname, String deptname);
	/**
	 * 跟据条件查询的数量
	 * @param unifiedcode
	 * @param equipname
	 * @param deptname
	 * @return
	 */
	long selByEnoEnameDeptCount(@Param("unifiedcode") String unifiedcode,@Param("equipname") String equipname,@Param("deptname") String deptname);
	List<EquipTable> selUnifiedcode();
	
}
