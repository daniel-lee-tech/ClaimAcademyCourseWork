package controllers;


import views.InputView;
import views.OutputView;

public class Controller {
    protected final OutputView outputs;
    public Controller() {
        this.outputs = new OutputView();
    }
}
