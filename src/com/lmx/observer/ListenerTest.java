package com.lmx.observer;

import java.util.ArrayList;
import java.util.List;

public class ListenerTest {
 public static void main(String[] args) {
	
 }
}
interface Listener{
	public void onClick();
}
class Boss{
	private List<Listener> list;

	public Boss() {
		super();
		this.list = new ArrayList();
	}
	public void addListener(Listener listener){
		list.add(listener);
	}
	public void removeListener(Listener listener){
		list.remove(listener);
	}
	public void doSome(){
		for (Listener l : list) {
			l.onClick();
		}
	}
	
}
