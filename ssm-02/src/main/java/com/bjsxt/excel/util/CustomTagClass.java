package com.bjsxt.excel.util;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
 /**
  * 实体类class名称注解类
  * @author xgf
  *
  */
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomTagClass {
	//字段的描述注解
    String name();
}
