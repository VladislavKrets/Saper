package controller;

import view.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by lollipop on 03.09.2016.
 */
public class RestartGameListener implements ActionListener{
    private Controller controller;
    private View view;
    private JFrame frame;

    public RestartGameListener(Controller controller, View view, JFrame frame) {
        this.controller = controller;
        this.view = view;
        this.frame = frame;
    }

    public void actionPerformed(ActionEvent e) {
        controller.getModel().restart();
        view.reGame();
        frame.dispose();
    }
}
