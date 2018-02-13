package com.oneUtil.reflects;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * 通过反射越过泛型检查  也可知道 泛型检测是在编译时期完成的
 * @author houyunjuan
 *
 */
public class ReflectExcessFanTest {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		ArrayList<String> list = new ArrayList<String>();
		list.add("hello");
		//获取list的class文件
		Class clazz = list.getClass();
		Method method = clazz.getMethod("add", Object.class);
		method.invoke(list, 8);
		
		System.out.println(list);//[hello, 8]
	}
}
