package com.bjsxt.excel.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ClassUtil {
//	private static Logger logger = LoggerFactory.getLogger(ClassUtil.class);
	/**
	 * 通过属性取得属性的描述注解
	 * 
	 * @param field
	 * @return
	 */
	public static String getDesc(Field field) {
		String result = null;
		try {
			field.setAccessible(true);
			Annotation[] annotation = field.getAnnotations();
			for (Annotation tag : annotation) {
				if (tag instanceof CustomTag) {
					result = ((CustomTag) tag).desc();
					break;
				}
			}
		} catch (SecurityException e) {
//			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return result;
		// return getAnnotation(DESC, field);
		// return getAnnotation(field);
	}
 
	/**
	 * 通过对象和属性名称取得属性的描述注解
	 * 
	 * @param obj
	 * @param propertyName
	 * @return
	 */
	public static String getDesc(Object obj, String propertyName) {
		String result = null;
		try {
			Field[] fields = obj.getClass().getDeclaredFields();
			for (Field field : fields) {
				field.setAccessible(true);
				if (field.getName().equals(propertyName)) {
					String desc = getDesc(field);
					if (desc != null && !desc.isEmpty()) {
						result = desc;
						break;
					}
				}
			}
		} catch (SecurityException e) {
//			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return result;
	}
 
	
 
	/**
	 * 取得obj所有属性的描述注解，返回值为key为obj的属性名称,value为此属性的描述注解
	 * 
	 * @param obj
	 * @return
	 */
	public static Map<String, String> getAllDesc(Object obj) {
		try {
			Field[] fields = obj.getClass().getDeclaredFields();
			return getResult(fields);
		} catch (SecurityException e) {
//			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
 
	/**
	 * 取得obj所有属性的描述注解，返回值为key为obj的属性名称,value为此属性的描述注解
	 * 
	 * @param obj
	 * @return
	 */
	public static Map<String, String> getAllDesc(String clzName) {
		try {
			Field[] fields = Class.forName(clzName).getDeclaredFields();
			return getResult(fields);
		} catch (SecurityException e) {
//			logger.error(e.getMessage());
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
//			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
 
	/**
	 * 将field[]里的字段名称做为key和字段描述做value放在map中
	 * 
	 * @param fields
	 * @param map
	 */
	private static Map<String, String> getResult(Field[] fields) {
		Map<String, String> result = new HashMap<String, String>();
		for (Field field : fields) {
			field.setAccessible(true);
			if (field.getName().equals("id")) {
				continue;
			}
			String desc = getDesc(field);
			if (desc != null && !desc.isEmpty()) {
				result.put(field.getName(), getDesc(field));
			}
		}
		return result;
	}
	public static String getClassName(Class<?> class1){
		 //获取类上的注解值  
		CustomTagClass anno = class1.getAnnotation(CustomTagClass.class);  
        if(anno != null){  
            Method[] met = anno.annotationType().getDeclaredMethods();  
            for(Method me : met ){  
                if(!me.isAccessible()){  
                    me.setAccessible(true);  
                }  
                try {  
                    return (String) me.invoke(anno, null);  
                } catch (IllegalAccessException e) {  
                    e.printStackTrace();  
                } catch (IllegalArgumentException e) {  
                    e.printStackTrace();  
                } catch (InvocationTargetException e) {  
                    e.printStackTrace();  
                }  
            }  
        } 
        return "";
	}

	
	
}
