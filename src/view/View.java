package view;

import controller.Controller;
import model.Model;
import controller.ButtonListener;

import javax.swing.*;
import java.awt.*;

/**
 * Created by lollipop on 02.09.2016.
 */
public class View extends JFrame{
    private Controller controller;
    private JPanel panel;
    public View(){
        controller = new Controller();
        setSize(400, 400);
        setName("Сапер");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        panel = new JPanel();
        panel.setBackground(Color.black);
        panel.setLayout(new GridBagLayout());
        drawStart(panel);

        add(panel, BorderLayout.SOUTH);
        setVisible(true);

    }
    public void drawStart(JPanel panel) {
        Model.Cell[][] cells = controller.getCells();
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                JButton button = new JButton(" ");
                button.addActionListener(new ButtonListener(cells, button, panel, i, j));
                panel.add(button, new GridBagConstraints(i, j, 1, 1, 1, 1,
                        GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
            }
        }

    }
    public void reGame() {
        drawStart(panel);
    }
}
