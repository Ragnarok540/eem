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

package control;

import vista.*;
import java.awt.*;

public class Ejecutable {

	public static void main(String args[]) {
	       EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                new EvilPanel().setVisible(true);
	            }
	        });
	    }
	
}
