package com.oneUtil.classLoader;

public class Super {
	 {
		 System.out.println("我是Super成员块");
		 }
		 public Super(){
		 System.out.println("我是Super构造方法");
		 }
		 {
		 int j = 123;
		 System.out.println("我是Super成员块中的变量j："+j);
		 }
		 static{
		 System.out.println("我是Super静态块");
		 i = 123;
		 }
		 protected static int i = 1;
}
