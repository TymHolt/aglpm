package org.aglpm;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * The main entry point of this application.
 */
public final class AglpmApplication extends Application {

    @Override
    public void start(Stage stage) {
        final BorderPane root = new BorderPane();

        final VBox sidebar = new VBox();
        sidebar.setPrefWidth(240);
        sidebar.setStyle("-fx-background-color: #1e293b;");

        final TreeView<String> tree = new TreeView<>();
        tree.setShowRoot(false);

        final TreeItem<String> treeRoot = new TreeItem<>("root");
        treeRoot.setExpanded(true);

        final TreeItem<String> dashboard = new TreeItem<>("Dashboard");

        final TreeItem<String> projects = new TreeItem<>("Projects");
        projects.setExpanded(true);
        projects.getChildren().addAll(
                new TreeItem<>("Project A"),
                new TreeItem<>("Project B")
        );

        final TreeItem<String> group1 = new TreeItem<>("Project Group 1");
        group1.getChildren().addAll(
                new TreeItem<>("Project C"),
                new TreeItem<>("Project D")
        );

        final TreeItem<String> group2 = new TreeItem<>("Project Group 2");
        group2.getChildren().addAll(
                new TreeItem<>("Project E"),
                new TreeItem<>("Project F")
        );

        final TreeItem<String> projectGroups = new TreeItem<>("Project Groups");
        projectGroups.setExpanded(true);
        projectGroups.getChildren().addAll(group1, group2);

        treeRoot.getChildren().addAll(dashboard, projects, projectGroups);
        tree.setRoot(treeRoot);
        tree.getSelectionModel().select(dashboard);

        sidebar.getChildren().add(tree);
        VBox.setVgrow(tree, Priority.ALWAYS);

        final StackPane content = new StackPane();
        content.setStyle("-fx-background-color: #f1f5f9;");

        final Label contentLabel = new Label("Dashboard");
        content.getChildren().add(contentLabel);

        tree.getSelectionModel().selectedItemProperty().addListener((observableValue, oldSelection, newSelection) -> {
            if (newSelection == null)
                return;

            contentLabel.setText(newSelection.getValue());
        });

        root.setLeft(sidebar);
        root.setCenter(content);

        final Scene scene = new Scene(root, 1000, 650);
        stage.setScene(scene);
        stage.setTitle("AGLPM");
        stage.show();
    }
}
