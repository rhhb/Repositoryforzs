package com.bjsxt.service;

import java.io.InputStream;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bjsxt.pojo.Emp;



@Service
public interface EmpService {
	String insInputExcel(InputStream is, String originalFilename);
	
	Collection<Emp> selgetAll();
}
