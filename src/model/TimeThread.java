package model;

import controller.Controller;
import view.*;
import view.JButton;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;

/**
 * Created by lollipop on 03.09.2016.
 */
public class TimeThread extends Thread {
    private Controller controller;
    private JLabel label;

    public TimeThread(Controller controller, JLabel label) {
        this.controller = controller;
        this.label = label;
        setDaemon(true);
    }

    public void run() {
        int minutes = 0;
        int seconds = 0;
        while (true) {
            label.setText(String.format("%2.d : %2.d", minutes, seconds));
            label.updateUI();
            seconds++;
            if (seconds == 60) {
                seconds = 0;
                minutes++;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
    private boolean isAll() {
        Component[] components = controller.getView().getPanel().getComponents();
        view.JButton button;
        for (int c = 0; c < components.length; c++) {
            button = (view.JButton) components[c];
            if (!button.isEnabled()) return false;
        }
        return true;
    }
}
