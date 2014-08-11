package com.lmx.command;

public class Client {
	public static void main(String[] args) {
		Invoker invoker=new Invoker();
		final Computer c=new Computer();
		Command eat=new AbstractCommand(c) {
			public void execute() {
				c.eat();
			}
		};
		Command sum=new AbstractCommand(c) {
			public void execute() {
				c.sum();
			}
		};
		invoker.invoke(eat);
		invoker.invoke(sum);
	}
}
