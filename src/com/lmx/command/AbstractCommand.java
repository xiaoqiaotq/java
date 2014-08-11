package com.lmx.command;

public abstract class AbstractCommand implements Command {
	protected Receiver receiver;
	public AbstractCommand(Receiver receiver) {
		this.receiver=receiver;
	}

}
