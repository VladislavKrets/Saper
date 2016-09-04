package view;

import controller.Controller;
import controller.DefeatWinnerWindowListener;
import controller.RestartGameListener;

import javax.swing.*;
import java.awt.*;

/**
 * Created by lollipop on 03.09.2016.
 */
public class DefeatView extends JFrame{
    private Controller controller;
    public DefeatView(Controller controller) {
        this.controller = controller;
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLayout(new GridBagLayout());
        setSize(300, 150);
        setResizable(false);
        setLocationRelativeTo(new Component() {
            public String getName() {
                return "Сапер";
            }
        });
        setName("Поражение");
        JLabel label = new JLabel("<html><div style='text-align: center;'> Поражение </html>");
        javax.swing.JButton button = new javax.swing.JButton("Ок");
        Component[] components = controller.getView().getPanel().getComponents();
        JButton jButton;
        for(int i = 0; i < components.length; i++) {
            jButton = (JButton) components[i];
            jButton.setEnabled(false);
        }
        button.addActionListener(new RestartGameListener(controller, controller.getView(), this));

        addWindowListener(new DefeatWinnerWindowListener(controller, this));
        add(label, new GridBagConstraints(0, 0, 3, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        add(button, new GridBagConstraints(0, 1, 3, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        setVisible(true);
    }


}
