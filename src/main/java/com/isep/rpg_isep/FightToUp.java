package com.isep.rpg_isep;

import com.isep.rpg_isep.Modele.Hero;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


public class FightToUp {
    private Stage dialogStage;
    private Hero hero;

    @FXML
    private ComboBox choice;

    @FXML
    private void initialize(){
        choice.getItems().addAll(" Augmente son armure ֎ ", "Augmente les dégâts de son arme ⚔", " Offre une potion ☫ et une lembas ☽ ");
    }

    @FXML
    private void confirm(){

        String clasOptionHero = choice.getSelectionModel().getSelectedItem().toString();

        if (!Objects.equals(clasOptionHero, "")){

            switch (clasOptionHero) {
                case  " Augmente son armure ֎ " -> this.hero.upgradeArmor();

                case "Augmente les dégâts de son arme ⚔" -> this.hero.upgradeWeapon();

                case " Offre une potion ☫ et une lembas ☽ " -> this.hero.addRessources();

            }

            dialogStage.close();

        }
    }
    @FXML
    public Button closeButton;
    @FXML
    public void handleCloseButtonAction(ActionEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();

    }
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }


}
