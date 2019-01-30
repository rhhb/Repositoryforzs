package com.bjsxt.pojo;

import java.util.List;

public class PageInfo {
	private int pageSize;
	private int pageNumber;
	private long total;
	private long count;
	private List<?> list;
	private String unifiedcode;
	private String equipname;
	private String deptname;
	
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	public String getUnifiedcode() {
		return unifiedcode;
	}
	public void setUnifiedcode(String unifiedcode) {
		this.unifiedcode = unifiedcode;
	}
	public String getEquipname() {
		return equipname;
	}
	public void setEquipname(String equipname) {
		this.equipname = equipname;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List<?> getList() {
		return list;
	}
	public void setList(List<?> list) {
		this.list = list;
	}
	
}
