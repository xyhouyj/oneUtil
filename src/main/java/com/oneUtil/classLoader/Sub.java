package com.oneUtil.classLoader;

public class Sub extends Super{
	 static{
	 System.out.println("我是Sub静态块");
	 }
	 public Sub(){
	 System.out.println("我是Sub构造方法");
	 }
	 {
	 System.out.println("我是Sub成员块");
	 }
	}