package com.oneUtil.proxy.dynic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class ProxyListDemo {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		//创建实际对象
		final List list = new ArrayList();
		  //创建代理对象对list接口做代理
		/*
         * newProxyInstance参数的含义：
         * ClassLoader : 通过要代理的类的Class对象获取类加载器，以便于代理类获取实际类的内部结构
         * Interface[] : 获取代理类的所有接口
         * InvocationHandler : 通过调用处理器接口调用接口的方法。
         */
		List proxy = (List) Proxy.newProxyInstance(list.getClass().getClassLoader(), list.getClass().getInterfaces(), new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				Object object = method.invoke(list, args);
				return object;
			}
		});
		
		proxy.add("hello");
		proxy.add(7);
		System.out.println(proxy);
	}
}
