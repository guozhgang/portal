package com.frame.action;

public class CountProxy implements Count{
	private CountImpl countImpl;
	
	public CountProxy(CountImpl countImpl) {
		this.countImpl = countImpl;
	}

	public void saveCount() {
		System.out.println("事务处理之前");
		countImpl.saveCount();
		System.out.println("事务处理之后");
		
	}

	public void updateCount() {
		// TODO Auto-generated method stub
		System.out.println("事务处理之前");
		countImpl.updateCount();
		System.out.println("事务处理之后");
	}
}
