package com.ibm.emart.buyer.exception;

public class MasterValueNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -1999815713511044214L;

	public MasterValueNotFoundException() {
	}

	public MasterValueNotFoundException(String message) {
		super(message);
	}
}
