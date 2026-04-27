package com.rental.videorental;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class RentalPanel extends VBox {
    public RentalPanel() {
        setSpacing(0);
        setPadding(new Insets(20));
        setAlignment(Pos.TOP_CENTER);

        VBox card = new VBox(14);
        card.setMaxWidth(480);

        Label title = new Label("Rental Management");

        Separator sep1 = new Separator();

        ComboBox<Customer> customerCombo = new ComboBox<>();
        customerCombo.setMaxWidth(Double.MAX_VALUE);
        customerCombo.setPromptText("Select customer…");

        ComboBox<Genre> genreCombo = new ComboBox<>();
        genreCombo.setMaxWidth(Double.MAX_VALUE);
        genreCombo.setPromptText("Select genre…");

        ComboBox<Movie> moviesCombo = new ComboBox<>();
        moviesCombo.setMaxWidth(Double.MAX_VALUE);
        moviesCombo.setPromptText("Movies in genre…");

        Button saveRentalbutton = new Button("Save Rental");
        saveRentalbutton.setMaxWidth(Double.MAX_VALUE);

        Label statusLabel = new Label();
        statusLabel.setWrapText(true);

        Separator sep2 = new Separator();

        ComboBox<Movie> borrowedCombo = new ComboBox<>();
        borrowedCombo.setMaxWidth(Double.MAX_VALUE);
        borrowedCombo.setPromptText("Borrowed movies…");

        Button returnbutton = new Button("Return Movie");
        returnbutton.setMaxWidth(Double.MAX_VALUE);

        ComboBox<Movie> returnedCombo = new ComboBox<>();
        returnedCombo.setMaxWidth(Double.MAX_VALUE);
        returnedCombo.setPromptText("Returned movies…");

        card.getChildren().addAll(
                title, sep1,
                row("Customer:", customerCombo),
                row("Genre:", genreCombo),
                row("Movies:", moviesCombo),
                saveRentalbutton,
                statusLabel,
                sep2,
                row("Borrowed:", borrowedCombo),
                returnbutton,
                row("Returned:", returnedCombo)
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
