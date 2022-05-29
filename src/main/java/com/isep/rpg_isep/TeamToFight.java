package com.isep.rpg_isep;

import com.isep.rpg_isep.Modele.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class TeamToFight {
    private ObservableList<Hero> heroDat = FXCollections.observableArrayList();
    private ObservableList<Enemy> enemyDat = FXCollections.observableArrayList();
    private ObservableList<Historical> historicalDat = FXCollections.observableArrayList();


    private Scene scene;

    @FXML
    private TableView<Hero> heroTable;
    @FXML
    private TableColumn<Hero, String> heroNameColumn;
    @FXML
    private TableColumn<Hero, String> herotypeColumn;
    @FXML
    private TextField textfieldHunter;
    @FXML
    private TextField textfieldHealer;
    @FXML
    private TextField textfieldMage;
    @FXML
    private TextField textfieldWarrior;
    @FXML
    private TableColumn<Hero, Integer> herolifePoints;
    @FXML
    private TableColumn<Hero, Integer> heroArmor;
    @FXML
    private TableColumn<Hero, Integer> heroweaponsDamage;
    @FXML
    private TableColumn<Hero, Integer> heroLembas;
    @FXML
    private TableColumn<Hero, Integer> heroPotions;
    protected static Stage stage;


    public TeamToFight(){
    }
    @FXML
    private void initialize(){
        heroNameColumn.setCellValueFactory(dataName->dataName.getValue().nameHeroProperty());
        herotypeColumn.setCellValueFactory(dataType->dataType.getValue().classHeroProperty());
        herolifePoints.setCellValueFactory(datalife->datalife.getValue().lifePointsProperty().asObject());
        heroArmor.setCellValueFactory(dataarmor->dataarmor.getValue().heroArmorProperty().asObject());
        heroweaponsDamage.setCellValueFactory(dataweaponDamage->dataweaponDamage.getValue().heroweaponDamageProperty().asObject());
        heroLembas.setCellValueFactory(dataLembas -> dataLembas.getValue().getSizeLembas().asObject());
        heroPotions.setCellValueFactory(dataPotions -> dataPotions.getValue().getSizeOfPotions().asObject());

    }

    @FXML
    public void addHunter(){
        if (!Objects.equals(textfieldHunter.getText(), "")){
            this.getHeroDat().add(new Hunter(textfieldHunter.getText()));
            heroTable.setItems(this.getHeroDat());
        }
    }
    @FXML
    public void addHealer(){
        if (!Objects.equals(textfieldHealer.getText(), "")){
            this.getHeroDat().add(new Healer(textfieldHealer.getText()));
            heroTable.setItems(this.getHeroDat());
        }

    }
    @FXML
    public void addMage(){
        if (!Objects.equals(textfieldMage.getText(), "")){
            this.getHeroDat().add(new Mage(textfieldMage.getText()));
            heroTable.setItems(this.getHeroDat());
        }

    }
    @FXML
    public void addWarrior(){
        if (!Objects.equals(textfieldWarrior.getText(), "")){
            this.getHeroDat().add(new Warrior(textfieldWarrior.getText()));
            heroTable.setItems(this.getHeroDat());
        }

    }

    public ObservableList<Hero> getHeroDat() {
        return heroDat;
    }
    public ObservableList<Enemy> getEnemyDat() {
        return enemyDat;
    }
    public ObservableList<Historical> getHistoricalDat() {
        return historicalDat;
    }

    @FXML
    public void switchToFight(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("helloFight.fxml"));
        Parent root = fxmlLoader.load();
        Fight fight = fxmlLoader.getController();
        generatEnemies();
        fight.setData(this);
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void generatEnemies()  {
        int  min = 1;
        int max = 10;
        int lim = max - min + 1;
        for (int i=0; i<getHeroDat().size();i++) {
            int pikaboss = (int)(Math.random() * lim) + min;
            if (pikaboss == 1 || pikaboss == 2 || pikaboss ==  3){
                String nameBoss = "Boss N°" + Integer.toString(i);
                getEnemyDat().add(new Boss(nameBoss));
            }else{
                String nameBasic = "Basic N°" + Integer.toString(i);
                getEnemyDat().add(new Basic(nameBasic));
            }
        }
    }

    public void switchToBegin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void handleCloseButtonAction(ActionEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }


    @FXML
    public Button closeButton;

}
