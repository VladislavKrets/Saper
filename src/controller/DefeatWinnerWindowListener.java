package controller;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Created by lollipop on 04.09.2016.
 */
public class DefeatWinnerWindowListener implements WindowListener{

    private Controller controller;
    private JFrame frame;

    public DefeatWinnerWindowListener(Controller controller, JFrame frame) {
        this.controller = controller;
        this.frame = frame;
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        controller.getModel().restart();
        controller.getView().reGame();
        frame.dispose();
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
