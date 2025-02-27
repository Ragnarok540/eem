package control;

import java.awt.EventQueue;
import vista.EvilPanel;

public class Main {
    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EvilPanel().setVisible(true);
            }
        });
    }
}
