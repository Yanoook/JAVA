package com.isep.rpg_isep.Modele;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;

/**
 * Class Enemy
 */
abstract public class Enemy{

  //
  // Fields
  //

  private SimpleIntegerProperty classEnemy;
  private IntegerProperty lifePoints;
  private IntegerProperty damagePoint;
  private SimpleStringProperty nameEnemy;



  //
  // Constructors
  //
  public Enemy(int classEnemy, String nameEnemy, int lifePoints, int damagePoint) {
    this.classEnemy = new SimpleIntegerProperty(classEnemy);
    this.lifePoints = new SimpleIntegerProperty(lifePoints);
    this.damagePoint = new SimpleIntegerProperty(damagePoint);
    this.nameEnemy = new SimpleStringProperty(nameEnemy);
  }

  public IntegerProperty enemyDamagePointProperty(){
    return damagePoint;
  }
  public IntegerProperty enemylifePointProperty(){
    return lifePoints;
  }


  public String getName() {
    return this.nameEnemy.get();
  }

  public SimpleStringProperty lifePointProperty(){
    return new SimpleStringProperty(String.valueOf(lifePoints));
  }

  public int getLifePoints () {
    return lifePoints.get();
  }

  public void reduceLifePoints (int number) {
    lifePoints.set(lifePoints.get() - number);

  }
  public int getWeaponDamage() {
    return damagePoint.get();
  }

  public StringProperty nameEnemyProperty(){
    return nameEnemy;
  }

  public StringProperty classEnemyProperty(){

    if(classEnemy.get() == 1){
      return new SimpleStringProperty("Basic");

    } else if (classEnemy.get() == 2) {
      return new SimpleStringProperty("Boss");
    }
    else{
      return null;
    }

  }
}
