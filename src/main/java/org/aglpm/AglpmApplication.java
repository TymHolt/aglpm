package org.aglpm;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public final class AglpmApplication extends Application {

    @Override
    public void start(Stage stage) {
        final BorderPane root = new BorderPane();

        final Scene scene = new Scene(root, 1000, 650);
        stage.setScene(scene);
        stage.setTitle("Workspace");
        stage.show();
    }
}
