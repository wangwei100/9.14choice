package com.demohot.subject.utils;

public class MyException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String describe;

	public MyException(String describe) {
		super(describe);
		this.describe = describe;
	}

	public String getDescribe() {
		return describe;
	}

}
