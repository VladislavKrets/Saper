package view;

/**
 * Created by lollipop on 03.09.2016.
 */
public class JButton extends javax.swing.JButton{
    private int buttonX;
    private int buttonY;

    public JButton(int buttonX, int buttonY) {
        this.buttonX = buttonX;
        this.buttonY = buttonY;
    }

    public int getButtonX() {
        return buttonX;
    }

    public int getButtonY() {
        return buttonY;
    }
}
