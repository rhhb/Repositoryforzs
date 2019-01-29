package com.bjsxt.excel.util;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/**
 * 实体类class字段名称注解类
 * @author xgf
 *
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomTag {
	//字段的描述注解
    String desc();
}
