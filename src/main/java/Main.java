package main.java;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    private MenuBar mainMenuBar;
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception{

        //Create all the menu bar items
        setUpMenu();

        Image logo = new Image("logo.png");
        ImageView logoImage = new ImageView();
        logoImage.setImage(logo);

        BorderPane mainPane = new BorderPane();
        mainPane.setTop(mainMenuBar);
        mainPane.setCenter(logoImage);

        Scene scene = new Scene(mainPane, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("DCNM");
        primaryStage.show();

    }

    public void setUpMenu() {
        mainMenuBar = new MenuBar();

        //Start of all items under the file menu
        Menu menuFile = new Menu("File");
        MenuItem app = new MenuItem("Say Hello");
        app.setOnAction(event -> {
            HelloApp hello = new HelloApp();
            hello.show();
        });
        MenuItem exit = new MenuItem("Exit");
        exit.setOnAction(event -> System.exit(0));
        menuFile.getItems().addAll(app, exit);

        //Start of all items under the help menu
        Menu menuHelp = new Menu("Help");
        MenuItem about = new MenuItem("About");
        about.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("About");
            alert.setHeaderText("DCNM About INFO");
            alert.setContentText("Created by two cool dudes");
            alert.showAndWait();
        });
        menuHelp.getItems().add(about);

        //Add all menus to mainBar
        mainMenuBar.getMenus().addAll(menuFile, menuHelp);
    }
}
