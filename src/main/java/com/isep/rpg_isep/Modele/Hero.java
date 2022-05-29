package com.isep.rpg_isep.Modele;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;

import static java.lang.Math.abs;

/**
 * Class Hero
 */
abstract public class Hero{


  private final StringProperty nameHero;
  private final IntegerProperty classHero;
  private IntegerProperty lifePoints;
  private IntegerProperty armor;
  private IntegerProperty weaponsDamage;
  private ArrayList<Potion> potions;
  private ArrayList<Food> lembas;
  private IntegerProperty sizePotions;
  private IntegerProperty sizeLembas;







  public Hero (int classHero, String nameHero,int lifePoints, int armor, int weaponsDamage,ArrayList<Potion> potions, ArrayList<Food> lembas) {
    this.classHero = new SimpleIntegerProperty(classHero);
    this.nameHero = new SimpleStringProperty(nameHero);
    this.lifePoints = new SimpleIntegerProperty(lifePoints);
    this.armor = new SimpleIntegerProperty(armor);
    this.weaponsDamage = new SimpleIntegerProperty(weaponsDamage) ;
    this.potions = potions;
    this.sizePotions = new SimpleIntegerProperty(potions.size());
    this.lembas = lembas;
    this.sizeLembas = new SimpleIntegerProperty(lembas.size());
  }


  public StringProperty classHeroProperty(){
    if(classHero.get() == 1){
      return new SimpleStringProperty("Hunter");

    } else if (classHero.get() == 2) {
      return new SimpleStringProperty("Healer");
    }else if (classHero.get() == 3) {
      return new SimpleStringProperty("Mage");
    }else if (classHero.get() == 4) {
      return new SimpleStringProperty("Warrior");
    }else{
      return null;
    }

  }
  public StringProperty nameHeroProperty(){
    return nameHero;
  }

  public String getName() {
    return this.nameHero.get();
  }

  public int getweaponDamage(){
    return weaponsDamage.get();
  }
  public int getLifePoints() {
    return lifePoints.get();
  }
  public IntegerProperty lifePointsProperty(){
    return lifePoints;
  }

  public int getAmor(){
    return armor.get();
  }


  public int attack(){
    return this.weaponsDamage.get();
  }

  public void  eat(){
    lifePoints.set(lifePoints.get() + 5);
    int index = this.lembas.size() - 1;
    this.lembas.remove(index);
    sizeLembas.set(lembas.size());
  }

  public void heal(){
    lifePoints.set(lifePoints.get() + 10);
    int index = this.potions.size() - 1;
    this.potions.remove(index);
    sizePotions.set(potions.size());
  }
  public IntegerProperty getWeaponDamage() {
    return weaponsDamage;
  }

  public void upgradeArmor(){
    armor.set(armor.get() + 15);
  }

  public void upgradeWeapon(){
    weaponsDamage.set(weaponsDamage.get() + 20);
  }


  public IntegerProperty getSizeOfPotions() {
    return sizePotions;
  }

  public IntegerProperty getSizeLembas() {
    return sizeLembas;
  }


  public void deleteLifePoints(int number) {
    if (armor.get() - number >= 0){
      armor.set(armor.get() - number);
    }else if (armor.get() - number < 0){
    number = abs(armor.get() - number);
    armor.set(0);
      lifePoints.set(lifePoints.get() - number);
    }


  }

  public void addRessources(){
    this.potions.add(new Potion());
    this.lembas.add(new Food());
    this.sizePotions.set(this.potions.size());
    this.sizeLembas.set(this.lembas.size());
  }

  public IntegerProperty heroArmorProperty(){
    return armor;
  }
  public IntegerProperty heroweaponDamageProperty(){
    return weaponsDamage;
  }


}
