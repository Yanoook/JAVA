package com.isep.rpg_isep.Modele;
import java.util.ArrayList;

public class Mage extends Hero {


  public Mage (String nameHero) {
    super(3, nameHero,70,0,10,new ArrayList<Potion>(), new ArrayList<Food>());
  }

}
