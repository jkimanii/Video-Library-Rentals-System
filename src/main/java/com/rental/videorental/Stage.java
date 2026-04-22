package com.rental.videorental;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;

public class Stage extends Application {
    @Override
    public void start(javafx.stage.Stage primaryStage) throws Exception {
        TabPane tabPane = new TabPane();
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        Tab customerTab = new Tab("Customers", new CustomerPanel());
        Tab movieTab    = new Tab("Movies",    new MoviePanel());
        Tab rentalTab   = new Tab("Rentals",   new RentalPanel());

        tabPane.getTabs().addAll(customerTab, movieTab, rentalTab);

        Scene scene = new Scene(tabPane, 560, 620);

        primaryStage.setTitle("Video Library Rentals System");
        primaryStage.setScene(scene);
        primaryStage.setResizable(true);
        Image icon = new Image(getClass().getResourceAsStream("icon.png"));
        primaryStage.getIcons().add(icon);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
