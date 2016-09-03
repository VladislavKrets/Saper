package controller;

import model.Model;

/**
 * Created by lollipop on 02.09.2016.
 */
public class Controller {
    private Model model;

    public Controller() {
        model = new Model();
    }
    public Model.Cell[][] getCells() {
        return model.getCell();
    }
}
