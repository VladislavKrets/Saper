package controller;

import model.Cell;
import model.Model;
import view.View;

/**
 * Created by lollipop on 02.09.2016.
 */
public class Controller {
    private Model model;
    private View view;

    public Controller() {
        model = new Model();
        view = new View(this);
    }
    public Cell[][] getCells() {
        return model.getCell();
    }

    public Model getModel() {
        return model;
    }

    public View getView() {
        return view;
    }
}
