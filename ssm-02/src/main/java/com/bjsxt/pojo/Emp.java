package com.bjsxt.pojo;

import java.io.Serializable;

import com.bjsxt.excel.util.CustomTag;
import com.bjsxt.excel.util.CustomTagClass;
/**
 * 
 * @author Administrator
 *
 */
@CustomTagClass(name="测试类")
public class Emp  {
	@CustomTag(desc="id")
	private int id;
	@CustomTag(desc="名称")
	private String name;
	@CustomTag(desc="姓名")
	private String sex;
	@CustomTag(desc="邮箱")
	private String email;
	@CustomTag(desc="部门id")
	private String dept_id;
	
	public Emp() {
		super();
	}
	public Emp(int id, String name, String sex, String email, String dept_id) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.email = email;
		this.dept_id = dept_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDept_id() {
		return dept_id;
	}
	public void setDept_id(String dept_id) {
		this.dept_id = dept_id;
	}
	
}
