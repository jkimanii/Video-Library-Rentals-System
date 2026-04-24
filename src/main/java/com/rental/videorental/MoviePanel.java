package com.rental.videorental;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class MoviePanel extends VBox {
    public MoviePanel() {
        setPadding(new Insets(20));
        setAlignment(Pos.TOP_CENTER);

        VBox card = new VBox(14);
        card.getStyleClass().add("panel-card");
        card.setMaxWidth(440);

        Label title = new Label("Movie Management");
        title.getStyleClass().add("section-title");

        Separator sep1 = new Separator();

        ComboBox<Genre> genreCombo = new ComboBox<>();
        genreCombo.setMaxWidth(Double.MAX_VALUE);
        genreCombo.setPromptText("Select genre…");

        TextField nameField = new TextField();
        nameField.setPromptText("Enter movie title");
        nameField.setMaxWidth(Double.MAX_VALUE);

        Button saveButton = new Button("Save Movie");
        saveButton.getStyleClass().add("Button-primary");
        saveButton.setMaxWidth(Double.MAX_VALUE);

        Label statusLabel = new Label();
        statusLabel.setWrapText(true);

        Separator sep2 = new Separator();

        ComboBox<Movie> registeredCombo = new ComboBox<>();
        registeredCombo.setMaxWidth(Double.MAX_VALUE);
        registeredCombo.setPromptText("Movies in selected genre…");

        Button removeButton = new Button("Remove Movie");
        removeButton.getStyleClass().add("Button-danger");
        removeButton.setMaxWidth(Double.MAX_VALUE);

        card.getChildren().addAll(
                title, sep1,
                row("Genre:", genreCombo),
                row("Name:", nameField),
                saveButton,
                statusLabel,
                sep2,
                row("Registered:", registeredCombo),
                removeButton
        );

        getChildren().add(card);
    }

    private HBox row(String labelText, javafx.scene.Node field) {
        Label label = new Label(labelText);
        label.setMinWidth(60);
        label.setAlignment(Pos.CENTER_LEFT);
        HBox.setHgrow(field, Priority.ALWAYS);
        return new HBox(12, label, field);
    }
}
