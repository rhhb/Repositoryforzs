package com.bjsxt.service;

import java.io.IOException;
import java.util.List;

import com.bjsxt.pojo.Dept;

public interface DeptService {
	List<Dept> showDept() throws IOException;
}
