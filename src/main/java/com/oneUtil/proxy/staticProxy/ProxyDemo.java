package com.oneUtil.proxy.staticProxy;


public class ProxyDemo {
	public static void main(String[] args) {
		StaticProduceFactory pf = new StaticProduceFactory();
		pf.sell();
		
		ProxyShop ps = new ProxyShop(pf);
		ps.sell();
		//在编译的时候  ProxyShop就被编译成一个class文件被加载（这与动态代理有很大的区别）
	}
}
