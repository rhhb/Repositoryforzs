package com.bjsxt.pojo;


import java.sql.Timestamp;
import java.util.Date;

import com.bjsxt.excel.util.CustomTag;
import com.bjsxt.excel.util.CustomTagClass;
 
/**
 * 实体类
 * @author xgf
 *
 */
@CustomTagClass(name="测试类")
public class Model {
	@CustomTag(desc="名称")
	private String mc;
	@CustomTag(desc="日期")
	private Date rq;
	@CustomTag(desc="时间")
	private Timestamp sj;
	@CustomTag(desc="类别")
	private String type;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMc() {
		return mc;
	}
	public void setMc(String mc) {
		this.mc = mc;
	}
	public Date getRq() {
		return rq;
	}
	public void setRq(Date rq) {
		this.rq = rq;
	}
	public Timestamp getSj() {
		return sj;
	}
	public void setSj(Timestamp sj) {
		this.sj = sj;
	}
}
