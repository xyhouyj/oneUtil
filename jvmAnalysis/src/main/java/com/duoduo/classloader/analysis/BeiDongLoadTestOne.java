package com.duoduo.classloader.analysis;

/**
 *
 */
class Father{
	
	public static int a = 1;
	static{
//		a = 2;
		System.out.println(a);
		//静态语句块中只能访问到定义在静态语句块之前的变量，定义在它之后的变量，在前面的静态语句中可以赋值，但是不能访问。
		m = 44;//可以对m进行赋值操作 但是不能够访问
	}
	public static int m = 33;
	
	static{
		System.out.println("父类初始化");
	}
}

class Child extends Father{
	static{
		System.out.println("子类初始化");
	}
}
public class BeiDongLoadTestOne {
	public static void main(String[] args) {
		//通过子类引用父类中的静态字段，这时对子类的引用为被动引用，因此不会初始化子类，只会初始化父类
		System.out.println(Child.m);
	}
}