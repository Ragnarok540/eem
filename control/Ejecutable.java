package control;

import java.awt.*;
import vista.*;

public class Ejecutable {

	public static void main(String args[]) {
	       EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                new EvilPanel().setVisible(true);
	            }
	        });
	    }
	
}
