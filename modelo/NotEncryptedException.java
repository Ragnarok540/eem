/*
 * Copyright 2012 NovaSoft.
 *
 * Licensed under the zlib License, Version 1.2.7 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://zlib.net/zlib_license.html
 * 
 * Edgar Nova
 * ragnarok540@gmail.com
 * 
 */

package modelo;

/**
 * @author Nova
 *
 */
public class NotEncryptedException extends Exception {

	private static final long serialVersionUID = -5088497026094375773L;

	/**
	 * See {@link #NotEncryptedException(String)}
	 * */
	public NotEncryptedException () {
		super();
	}
	
	/**
	 * Constructs an instance of NotEncryptedException
	 * with the specified detail message. A detail 
	 * message is an instance of String that describes 
	 * this particular exception.
	 * 
	 * @param message the detail message
	 * */
	public NotEncryptedException (String message) {
		super(message);
	}
	
}
