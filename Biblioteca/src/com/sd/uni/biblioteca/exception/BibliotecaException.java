package com.sd.uni.biblioteca.exception;

import java.text.ParseException;

public class BibliotecaException extends Exception {

	public BibliotecaException(String string, ArrayIndexOutOfBoundsException e) {
		super(string, e);
	}

	public BibliotecaException(String string) {
		super(string);
	}

	public BibliotecaException(String string, Exception e) {
		super(string, e);
	}

	private static final long serialVersionUID = 1L;

}
