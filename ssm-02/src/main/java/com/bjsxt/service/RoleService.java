package com.bjsxt.service;

import java.util.Collection;
import java.util.List;

import com.bjsxt.pojo.EasyUIDatagrid;
import com.bjsxt.pojo.Menu;
import com.bjsxt.pojo.Role;

public interface RoleService {
	EasyUIDatagrid showRole(int pageSize,int pageNumber);
	
	int update(Role role);
	
	
	List<Menu> showPrivilege(int roleid);
	
	Collection<Role> showAll();
	
	int insRole(Role role);
	int delRole(int[] ids);
}
