
import view.Frame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(()->{
            Frame controller = new Frame();
            controller.show();
        });
    }
}