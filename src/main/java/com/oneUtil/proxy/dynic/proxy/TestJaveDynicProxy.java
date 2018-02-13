package com.oneUtil.proxy.dynic.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestJaveDynicProxy {
	public static void main(String[] args) {
		final SellSomething sellSomething = new SellSomethingImpl();
		
		
		SellSomething newProxyInstance = (SellSomething) Proxy.newProxyInstance(sellSomething.getClass().getClassLoader(), sellSomething.getClass().getInterfaces(), new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				// TODO Auto-generated method stub
				System.out.println("准备好东西。。。。");
				Object invoke = method.invoke(sellSomething, args);
				System.out.println("卖完东西 准备收摊啦。。。。。。");
				return invoke;
			}
		});
		newProxyInstance.sell();
	}
}
