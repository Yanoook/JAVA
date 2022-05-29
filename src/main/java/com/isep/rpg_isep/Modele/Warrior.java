package com.isep.rpg_isep.Modele;
import java.util.ArrayList;

public class Warrior extends Hero {


  public Warrior (String nameHero) {
    super(4, nameHero, 80, 20, 10, new ArrayList<Potion>(), new ArrayList<Food>());
  }


}
