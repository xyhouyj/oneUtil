package com.oneUtil.proxy.staticProxy;


public class ProxyShop implements SellSomething {
	//获取生产厂家的对象
	StaticProduceFactory factory;
	
	
	
	public ProxyShop(StaticProduceFactory factory) {
		this.factory = factory;
	}


	//代理类来代替生产厂家卖东西
	@Override
	public void sell() {
		// TODO Auto-generated method stub
		//在卖之前处理。。。。
		this.factory.sell();
		//在卖之后处理
	}

}
