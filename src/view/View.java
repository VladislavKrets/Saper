package view;

import controller.Controller;
import controller.CellClickButtonListener;
import model.Cell;
import model.TimeThread;

import javax.swing.*;
import java.awt.*;

/**
 * Created by lollipop on 02.09.2016.
 */
public class View extends JFrame {
    private Controller controller;
    private JPanel panel;
    public View(Controller controller){
        this.controller = controller;
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
        Cell[][] cells = controller.getCells();
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                view.JButton button = new view.JButton(j, i);
                button.setText(" ");
                button.setSize(44, 26);
                button.setFocusable(false);
                button.setFocusPainted(false);
                button.setBorderPainted(false);

                button.addMouseListener(new CellClickButtonListener(controller, i, j));
                panel.add(button, new GridBagConstraints(i, j, 1, 1, 1, 1,
                        GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
                panel.updateUI();
            }
        }

    }
    public void checkAllBombs() {
        Cell[][] cells = controller.getCells();
        Component[] components = panel.getComponents();
        int count = 0;
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                for (int c = 0; c < components.length; c++) {
                    view.JButton button = (view.JButton) components[c];
                    if (cells[i][j].isBomb() && button.getButtonX() == i && button.getButtonY() == j &&
                            button.getText().equals("x")) {
                        count++;
                        System.out.println(button);
                    }
                }
            }
        }
        if (count == controller.getModel().getCountOfBombs()) {
            new WinnerView(controller);
        }
        System.out.println(count + " " + controller.getModel().getCountOfBombs());

    }
    public void reGame() {
        panel.removeAll();
        drawStart(panel);
        panel.updateUI();
    }

    public JPanel getPanel() {
        return panel;
    }
}
