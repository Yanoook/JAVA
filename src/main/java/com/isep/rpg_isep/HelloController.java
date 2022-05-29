package com.isep.rpg_isep;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private Label duText;
    @FXML
    public Button closeButton;
    @FXML
    protected void Begin() {
        welcomeText.setText("<| Mini RPG 3000  |>");
    }
    @FXML
    protected void addHero() {
        duText.setText("Choisissez le nombre de hero :");
    }
    @FXML
    public void handleCloseButtonAction(ActionEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }


        public void switchToaddHero(ActionEvent event) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("ADD_hero.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }
        public void switchToBegin(ActionEvent event) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

}