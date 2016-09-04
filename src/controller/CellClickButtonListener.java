package controller;

import model.Cell;
import view.DefeatView;

import view.JButton;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by lollipop on 03.09.2016.
 */
public class CellClickButtonListener implements MouseListener {

    private Cell[][] cells;
    private Controller controller;
    private int X;
    private int Y;


    public CellClickButtonListener(Controller controller, int x, int y) {
        this.controller = controller;
        cells = controller.getCells();
        X = y;
        Y = x;
    }

    public void mouseClicked(MouseEvent e) {
        switch (e.getButton()) {
            case MouseEvent.BUTTON1:
                leftClick(e);
                break;
            case MouseEvent.BUTTON3:
                rightClick(e);
                controller.getView().checkAllBombs();
                break;
        }
    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    private void leftClick(MouseEvent e) {
        view.JButton button = (view.JButton) e.getSource();
        if (!button.getText().equals("x")) {
            if (cells[X][Y].isBomb()) {
                button.setText("*");
                new DefeatView(controller);
                button.setEnabled(false);
                //   System.out.println(button.getLocation() + " " + button.getLocation());
            } else if (cells[X][Y].getBombsNumber() == 0) {
                openEmptyCells(button);
                /*button.setBackground(Color.black);
                button.setEnabled(false);*/
                //   System.out.println(button.getLocation() + " " + button.getLocation());
            } else {
                button.setText(String.valueOf(cells[X][Y].getBombsNumber()));
                button.setEnabled(false);
                // System.out.println(button.getLocation() + " " + button.getLocation());
            }
        }
    }

    private void rightClick(MouseEvent e) {
        view.JButton button = (view.JButton) e.getSource();
        if (button.getText().equals(" ")) button.setText("x");
        else if (button.getText().equals("x")) button.setText(" ");
    }

    private void openEmptyCells(JButton button) {
        if (!button.isEnabled()) return;
        Component[] components = controller.getView().getPanel().getComponents();
        int i = button.getButtonX();
        int j = button.getButtonY();
        if (cells[i][j].getBombsNumber() == 0) {
            button.setBackground(Color.black);
            button.setEnabled(false);
        } else {
            button.setText(String.valueOf(cells[i][j].getBombsNumber()));
            button.setEnabled(false);
            return;
        }
        JButton compButton;
        for (int c = 0; c < components.length; c++) {

            if (components[c] instanceof JButton) {
                compButton = (JButton) components[c];
                if (compButton.getButtonX() == i + 1 &&
                        compButton.getButtonY() == j + 1 &&
                        i + 1 != cells.length &&
                        j + 1 != cells[i].length)
                    if (cells[i + 1][j + 1].getBombsNumber() == 0) {
                        openEmptyCells(compButton);
                    } else {
                        compButton.setText(String.valueOf(cells[i + 1][j + 1].getBombsNumber()));
                        compButton.setEnabled(false);

                    }

                else if (compButton.getButtonX() == i + 1 &&
                        compButton.getButtonY() == j - 1 &&
                        i + 1 != cells.length &&
                        j != 0)
                    if (cells[i + 1][j - 1].getBombsNumber() == 0) {
                        openEmptyCells(compButton);
                    } else {
                        compButton.setText(String.valueOf(cells[i + 1][j - 1].getBombsNumber()));
                        compButton.setEnabled(false);


                    }
                else if (compButton.getButtonX() == i - 1 &&
                        compButton.getButtonY() == j + 1 &&
                        i != 0 &&
                        j + 1 != cells[i].length)
                    if (cells[i - 1][j + 1].getBombsNumber() == 0) {
                        openEmptyCells(compButton);
                    } else {
                        compButton.setText(String.valueOf(cells[i - 1][j + 1].getBombsNumber()));
                        compButton.setEnabled(false);

                    }
                else if (compButton.getButtonX() == i - 1 &&
                        compButton.getButtonY() == j - 1 &&
                        i != 0 &&
                        j != 0)
                    if (cells[i - 1][j - 1].getBombsNumber() == 0) {
                        openEmptyCells(compButton);
                    } else {
                        compButton.setText(String.valueOf(cells[i - 1][j - 1].getBombsNumber()));
                        compButton.setEnabled(false);

                    }
                else if (compButton.getButtonX() == i &&
                        compButton.getButtonY() == j + 1 &&
                        j + 1 != cells[i].length)
                    if (cells[i][j + 1].getBombsNumber() == 0) {
                        openEmptyCells(compButton);
                    } else {
                        compButton.setText(String.valueOf(cells[i][j + 1].getBombsNumber()));
                        compButton.setEnabled(false);

                    }
                else if (compButton.getButtonX() == i + 1 &&
                        compButton.getButtonY() == j &&
                        i + 1 != cells.length)
                    if (cells[i + 1][j].getBombsNumber() == 0) {
                        openEmptyCells(compButton);
                    } else {
                        compButton.setText(String.valueOf(cells[i + 1][j].getBombsNumber()));
                        compButton.setEnabled(false);

                    }
                else if (compButton.getButtonX() == i - 1 &&
                        compButton.getButtonY() == j &&
                        i != 0)
                    if (cells[i - 1][j].getBombsNumber() == 0) {
                        openEmptyCells(compButton);
                    } else {
                        compButton.setText(String.valueOf(cells[i - 1][j].getBombsNumber()));
                        compButton.setEnabled(false);


                    }
                else if (compButton.getButtonX() == i &&
                        compButton.getButtonY() == j - 1 &&
                        j != 0)
                    if (cells[i][j - 1].getBombsNumber() == 0) {
                        openEmptyCells(compButton);
                    } else {
                        compButton.setText(String.valueOf(cells[i][j - 1].getBombsNumber()));
                        compButton.setEnabled(false);

                    }
            }
        }

   }


    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }
}
