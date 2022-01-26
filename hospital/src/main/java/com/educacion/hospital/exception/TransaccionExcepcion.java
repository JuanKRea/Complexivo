package com.educacion.hospital.exception;

import javax.ejb.ApplicationException;


@ApplicationException(rollback = true)
public class TransaccionExcepcion extends Exception {

	
	private static final long serialVersionUID = 1364771548226999183L;

	public TransaccionExcepcion() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 */
	public TransaccionExcepcion(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 */
	public TransaccionExcepcion(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public TransaccionExcepcion(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

}
