package com.frame.action;

public class TestProxy {
	public static void main(String[] args) {
		BookProxy proxy = new BookProxy();
		IBook bookProxy = (IBook) proxy.bind(new BookImpl());
		bookProxy.addBook();
	}
}
