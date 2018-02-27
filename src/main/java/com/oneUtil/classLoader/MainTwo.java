package com.oneUtil.classLoader;

public class MainTwo {
	 public static void main(String[] args){
		 System.out.println("我是main方法，我输出Super的类变量i："+Sub.i);
		 System.out.println("dddddddddddddddddd");
		 Sub sub = new Sub();
		 }
	 //静态代码块和静态变量的赋值 是 先于 main方法的调用执行的。
	//静态代码块和静态变量的赋值是按顺序执行的。
	//子类调用父类的类变量成员，是不会触发子类本身的初始化操作的。
	//使用new方式创建子类，对于类加载而言，是先加载父类、再加载子类（注意：此时由于父类已经在前面初始化了一次，所以，这一步，就只有子类初始化，父类不会再进行初始化）
	//不论成员块放在哪个位置，它都 先于 类构造方法执行。
}