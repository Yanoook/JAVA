package com.isep.rpg_isep;

import com.isep.rpg_isep.Modele.Enemy;
import com.isep.rpg_isep.Modele.Hero;
import com.isep.rpg_isep.Modele.Historical;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Fight {

    private TeamToFight data;
    @FXML
    private TableView<Enemy> enemyTable;
    @FXML
    private TableView<Hero> heroTable;
    @FXML
    private TableView<Historical> historical;
    @FXML
    private TableColumn<Hero, String> heroNameColumn;
    @FXML
    private TableColumn<Hero, String> herotypeColumn;
    @FXML
    private TableColumn<Hero, Integer> herolifePoints;
    @FXML
    private TableColumn<Hero, Integer> heroArmor;
    @FXML
    private TableColumn<Hero, Integer> heroweaponsDamage;
    @FXML
    private TableColumn<Enemy, Integer> enemyDamagePoint;
    @FXML
    private TableColumn<Enemy, Integer> enemylifePoint;
    @FXML
    private TableColumn<Historical, String> historic;
    @FXML
    private TableColumn<Hero, Integer> heroLembas;
    @FXML
    private TableColumn<Hero, Integer> heroPotions;


    private boolean whileFight = false;

    public void setData(TeamToFight data) {
        this.data = data;
        enemyTable.setItems(data.getEnemyDat());
        heroTable.setItems(data.getHeroDat());
        historical.setItems(data.getHistoricalDat());
    }

    @FXML
    private void initialize() {

        enemyNameColumn.setCellValueFactory(dataName -> dataName.getValue().nameEnemyProperty());
        enemytypeColumn.setCellValueFactory(dataType -> dataType.getValue().classEnemyProperty());
        enemyDamagePoint.setCellValueFactory(dataType -> dataType.getValue().enemyDamagePointProperty().asObject());
        enemylifePoint.setCellValueFactory(dataType -> dataType.getValue().enemylifePointProperty().asObject());
        /////hero affichage
        heroNameColumn.setCellValueFactory(dataName -> dataName.getValue().nameHeroProperty());
        herotypeColumn.setCellValueFactory(dataType -> dataType.getValue().classHeroProperty());
        herolifePoints.setCellValueFactory(datalife -> datalife.getValue().lifePointsProperty().asObject());
        heroArmor.setCellValueFactory(dataarmor -> dataarmor.getValue().heroArmorProperty().asObject());
        heroweaponsDamage.setCellValueFactory(dataweaponDamage -> dataweaponDamage.getValue().heroweaponDamageProperty().asObject());
        heroLembas.setCellValueFactory(dataLembas -> dataLembas.getValue().getSizeLembas().asObject());
        heroPotions.setCellValueFactory(dataPotions -> dataPotions.getValue().getSizeOfPotions().asObject());

        historic.setCellValueFactory(histo -> histo.getValue().beforeProperty());
        choice.getItems().addAll("Attack", "Potions", "Lembas");

    }

    @FXML
    public void handleCloseButtonAction(ActionEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();

    }

    @FXML
    private TableColumn<Enemy, String> enemyNameColumn;
    @FXML
    private TableColumn<Enemy, String> enemytypeColumn;
    @FXML
    private Button startFight;
    @FXML
    private Button confirm;
    @FXML
    private ComboBox choice;

    private int playerTurn;
    private Hero fightHero;
    private Enemy fightenemy;
    private String action;
    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    void actionButtonEvent(ActionEvent event) throws IOException {

        if (event.getSource().equals(confirm)) {

            if (this.playerTurn == 0) {
                if (Objects.equals(choice.getSelectionModel().getSelectedItem().toString(), "Attack")) {
                    action = "Attack";
                } else if (Objects.equals(choice.getSelectionModel().getSelectedItem().toString(), "Potions")) {
                    action = "Potions";
                } else if (Objects.equals(choice.getSelectionModel().getSelectedItem().toString(), "Lembas")) {
                    action = "Lembas";
                }

            }

           if (Objects.equals(action, "Attack")){
               if (data.getHeroDat().size() != 0) {
                   if (fightHero.getLifePoints() <= 0) {
                       data.getHistoricalDat().add(new Historical(fightHero.getName() + " eliminated ..."));
                       data.getHeroDat().remove(fightHero);
                       if (data.getHeroDat().size() != 0) {
                           whileFight = false;
                           fightbegin();
                       } else {
                          heroUPButtonEvent(fightHero);
                       }
                   } else {
                       data.getHistoricalDat().add(new Historical(fightHero.getName() + " attacks ..."));
                       fightenemy.reduceLifePoints(fightHero.attack());
                       playerTurn = 1;
                       if (data.getEnemyDat().size() != 0) {
                           if (fightenemy.getLifePoints() <= 0) {
                               data.getHistoricalDat().add(new Historical(fightenemy.getName() + " eliminated ..."));
                               data.getEnemyDat().remove(fightenemy);
                               //getAward();
                               heroUPButtonEvent(fightHero);
                               if (data.getEnemyDat().size() != 0) {
                                   whileFight = false;
                                   fightbegin();
                               } else {
                                   heroUPButtonEvent(fightHero);
                               }
                           } else {
                               data.getHistoricalDat().add(new Historical(fightenemy.getName() + " attacks ..."));
                               fightHero.deleteLifePoints(fightenemy.getWeaponDamage());
                               playerTurn = 0;
                           }
                       }
                   }
               }
           }else if (Objects.equals(action, "Potions")){
               if (fightHero.getSizeOfPotions().get() != 0){
                   if (data.getHeroDat().size() != 0) {
                       if (fightHero.getLifePoints() <= 0) {
                           data.getHistoricalDat().add(new Historical(fightHero.getName() + " eliminated ..."));
                           data.getHeroDat().remove(fightHero);
                           if (data.getHeroDat().size() != 0) {
                               fightbegin();
                           } else {
                               Stage stage = (Stage) closeButton.getScene().getWindow();
                               stage.close();
                           }
                       } else {

                           data.getHistoricalDat().add(new Historical(fightHero.getName() + " heals ..."));
                           fightHero.heal();

                           playerTurn = 1;
                           if (data.getEnemyDat().size() != 0) {
                               if (fightenemy.getLifePoints() <= 0) {
                                   data.getHistoricalDat().add(new Historical(fightenemy.getName() + " eliminated ..."));
                                   data.getEnemyDat().remove(fightenemy);
                                   //getAward();
                                   if (data.getEnemyDat().size() != 0) {
                                       fightbegin();
                                   } else {
                                       heroUPButtonEvent(fightHero);
                                   }
                               } else {

                                   data.getHistoricalDat().add(new Historical(fightenemy.getName() + " attacks ..."));
                                   fightHero.deleteLifePoints(fightenemy.getWeaponDamage());
                                   playerTurn = 0;
                               }
                           } else {
                               heroUPButtonEvent(fightHero);
                           }
                       }
                   }
               }

           }else if(Objects.equals(action, "Lembas")){
               if (fightHero.getSizeLembas().get() != 0){
                   if (data.getHeroDat().size() != 0) {
                       if (fightHero.getLifePoints() <= 0) {
                           data.getHistoricalDat().add(new Historical(fightHero.getName() + " eliminated ..."));
                           data.getHeroDat().remove(fightHero);
                           if (data.getHeroDat().size() != 0) {
                               fightbegin();
                           } else {
                               Stage stage = (Stage) closeButton.getScene().getWindow();
                               stage.close();
                           }
                       } else {
                           data.getHistoricalDat().add(new Historical(fightHero.getName() + " heals ..."));
                           fightHero.eat();
                           playerTurn = 1;
                           if (data.getEnemyDat().size() != 0) {
                               if (fightenemy.getLifePoints() <= 0) {
                                   data.getHistoricalDat().add(new Historical(fightenemy.getName() + " eliminated ..."));
                                   data.getEnemyDat().remove(fightenemy);
                                   heroUPButtonEvent(fightHero);
                                   System.out.println(fightHero.getSizeLembas());
                                   if (data.getEnemyDat().size() != 0) {
                                       fightbegin();
                                   } else {
                                       Stage stage = (Stage) closeButton.getScene().getWindow();
                                       stage.close();
                                   }
                               } else {
                                   data.getHistoricalDat().add(new Historical(fightenemy.getName() + " attacks ..."));
                                   fightHero.deleteLifePoints(fightenemy.getWeaponDamage());
                                   playerTurn = 0;
                               }
                           } else {
                               Stage stage = (Stage) closeButton.getScene().getWindow();
                               stage.close();
                           }
                       }
                   }
               }


           }
        }
    }

    private int clasOptionHero;


    public void heroUPButtonEvent(Hero hero) throws IOException {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("hero-LvlUP.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(stage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            FightToUp controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setHero(hero);
            dialogStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    

    @FXML
    public void fightbegin() {
        if (!whileFight){
            generateCombat();
            data.getHistoricalDat().add(new Historical(fightHero.getName() + " against " + fightenemy.getName() + " ..."));
            if (playerTurn == 0) { //le héros commence
                data.getHistoricalDat().add(new Historical(fightHero.getName() + " starts ..."));
            } else if (playerTurn == 1) { //l'énemi commence
                data.getHistoricalDat().add(new Historical(fightenemy.getName() + " starts ..."));
                data.getHistoricalDat().add(new Historical(fightenemy.getName() + " attacks ..."));
                fightHero.deleteLifePoints(fightenemy.getWeaponDamage());
                playerTurn = 0;
            }
            whileFight = true;
        }
    }

    public void generateCombat() {
        playerTurn = (int) (Math.random() * 2);
        int randomHero = (int)(Math.random() * data.getHeroDat().size());
        int randomEnemy = (int)(Math.random() * data.getEnemyDat().size());
        fightenemy = data.getEnemyDat().get(randomEnemy);
        fightHero = data.getHeroDat().get(randomHero);
    }



    @FXML
    public Button closeButton;

}