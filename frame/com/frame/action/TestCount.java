package com.frame.action;

public class TestCount {
	public static void main(String[] args) {
		CountImpl countImpl = new CountImpl();
		CountProxy proxy = new CountProxy(countImpl);
		proxy.updateCount();
	}
}
