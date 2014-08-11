package com.lmx.command;

public class Invoker {
	public void invoke(Command c) {
		c.execute();
	}
}
