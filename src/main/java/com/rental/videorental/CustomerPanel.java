package com.rental.videorental;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class CustomerPanel extends VBox {
    public CustomerPanel(){
        setPadding(new Insets(20));
        setAlignment(Pos.TOP_CENTER);

        VBox card = new VBox(14);
        card.setMaxWidth(440);

        Label title = new Label("Customer Management");
        Separator sep1 = new Separator();

        TextField nameField = textField("Enter customer name");
        TextField phoneField = textField("Enter phone number");
        TextField emailField = textField("Enter email address");

        Button saveButton = new Button("Save Customer");
        saveButton.setMaxWidth(Double.MAX_VALUE);

        Label statusLabel = new Label();
        statusLabel.setWrapText(true);

        Separator sep2 = new Separator();

        ComboBox<Customer> registeredCombo = new ComboBox<>();
        registeredCombo.setMaxWidth(Double.MAX_VALUE);
        registeredCombo.setPromptText("Select a customer…");

        Button removeButton = new Button("Remove Customer");
        removeButton.setMaxWidth(Double.MAX_VALUE);

        card.getChildren().addAll(
                title, sep1,
                row("Name:", nameField),
                row("Phone:", phoneField),
                row("Email:", emailField),
                saveButton,
                statusLabel,
                sep2,
                row("Registered:", registeredCombo),
                removeButton
        );

        getChildren().add(card);
    }

    // ---- Helpers ----
    private TextField textField(String prompt) {
        TextField tf = new TextField();
        tf.setPromptText(prompt);
        tf.setMaxWidth(Double.MAX_VALUE);
        return tf;
    }

    private HBox row(String labelText, javafx.scene.Node field) {
        Label label = new Label(labelText);
        label.setMinWidth(60);
        label.setAlignment(Pos.CENTER_LEFT);
        HBox.setHgrow(field, Priority.ALWAYS);
        return new HBox(12, label, field);
    }
}
