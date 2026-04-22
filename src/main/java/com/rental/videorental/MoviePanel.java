package com.rental.videorental;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class MoviePanel extends VBox {
    // private final DataStore store = DataStore.getInstance();

    public MoviePanel() {
        setPadding(new Insets(20));
        setAlignment(Pos.TOP_CENTER);

        VBox card = new VBox(14);
        card.getStyleClass().add("panel-card");
        card.setMaxWidth(440);

        Label title = new Label("Movie Management");
        title.getStyleClass().add("section-title");

        Separator sep1 = new Separator();

        // Genre combo (for linking a new movie)
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

        // Registered: shows movies in selected genre
        ComboBox<Movie> registeredCombo = new ComboBox<>();
        registeredCombo.setMaxWidth(Double.MAX_VALUE);
        registeredCombo.setPromptText("Movies in selected genre…");

        Button removeButton = new Button("Remove Movie");
        removeButton.getStyleClass().add("Button-danger");
        removeButton.setMaxWidth(Double.MAX_VALUE);

        // When genre selection changes, refresh the Registered list
        //genreCombo.valueProperty().addListener((obs, oldVal, newVal) -> refreshRegistered(newVal));

        // Also refresh after saving (data changes)
        /*saveButton.setOnAction(e -> {
            saveMovie();
            refreshRegistered(genreCombo.getValue());
        });

        removeButton.setOnAction(e -> {
            removeMovie();
            refreshRegistered(genreCombo.getValue());
        });*/

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

    /*private void saveMovie() {
        Genre genre = genreCombo.getValue();
        String name = nameField.getText().trim();

        if (genre == null) {
            showStatus("Please select a genre.", false);
            return;
        }
        if (name.isEmpty()) {
            showStatus("Movie name is required.", false);
            return;
        }
        //store.getMovies().add(new Movie(name, genre));
        nameField.clear();
        showStatus("Movie \"" + name + "\" saved under " + genre.getName() + ".", true);
    }

    private void removeMovie() {
        Movie selected = registeredCombo.getValue();
        if (selected == null) {
            showStatus("Please select a movie to remove.", false);
            return;
        }
        //store.getMovies().remove(selected);
        registeredCombo.setValue(null);
        showStatus("Movie \"" + selected.getName() + "\" removed.", true);
    }*/

    /*private void refreshRegistered(Genre genre) {
        ObservableList<Movie> filtered = store.getMoviesByGenre(genre);
        registeredCombo.setItems(filtered);
        registeredCombo.setValue(null);
    }

    private void showStatus(String msg, boolean ok) {
        statusLabel.setText(msg);
        statusLabel.getStyleClass().removeAll("status-ok", "status-err");
        statusLabel.getStyleClass().add(ok ? "status-ok" : "status-err");
    }*/

    private HBox row(String labelText, javafx.scene.Node field) {
        Label label = new Label(labelText);
        //label.getStyleClass().add("field-label");
        label.setMinWidth(60);
        label.setAlignment(Pos.CENTER_LEFT);
        HBox.setHgrow(field, Priority.ALWAYS);
        return new HBox(12, label, field);
    }
}
