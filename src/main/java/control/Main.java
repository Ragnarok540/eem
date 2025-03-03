package control;

import java.awt.EventQueue;
import vista.EvilPanel;

public final class Main {
    private Main() { }

    public static void main(final String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EvilPanel().setVisible(true);
            }
        });
    }
}
