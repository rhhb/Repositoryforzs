package com.bjsxt.mapper;

import java.util.Collection;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.bjsxt.pojo.Role;

public interface RoleMapper {
	@Select("select * from role limit #{0},#{1}")
	List<Role> selByPage(int pageStart,int pageSize);
	
	@Select("select count(*) from role")
	int selCount();
	
	@Update("update role set name=#{name},sort=#{sort},remark=#{remark} where id=#{id}")
	int updRole(Role role);
	
	@Select("select * from role")
	Collection<Role> showAll();
	
	@Insert("insert into role values(default,#{name},#{sort},#{remark})")
	int insRole(Role role);
	
	int delRole(int[] ids);
	
}
