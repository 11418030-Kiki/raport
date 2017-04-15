package com.gmail.at.agusumbawa.config;

import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.stage.Stage;

/**
 * Created by Agus Suhardi on 1/27/2017.
 */
public interface BootInitializable extends Initializable {

    public void initContruct();
    public void stage(Stage primaryStage);

    public Node initView();
}
