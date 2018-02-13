package com.oneUtil.reflects;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectionDemo2 {
	public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		//加在文件
		Properties properties = new Properties();
		FileReader fileReader = new FileReader("D://class.txt");
		properties.load(fileReader);
		fileReader.close();
		//获取类 和方法
		String className = properties.getProperty("className");
		String methodName = properties.getProperty("methodName");
		Class clazz = Class.forName(className);
		Method[] declaredMethods = clazz.getDeclaredMethods();
		for (Method method : declaredMethods) {
			String name = method.getName();
			if (name.equals(methodName)) {
				method.setAccessible(true);
				method.invoke(clazz.newInstance());
			}
		}
		
	}
}
