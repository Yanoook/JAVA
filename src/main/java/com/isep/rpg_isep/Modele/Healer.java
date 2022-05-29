package com.isep.rpg_isep.Modele;

import java.util.ArrayList;

/**
 * Class Healer
 */
public class Healer extends SpellCaster {


  public Healer (String nameHero) {
    super(2, nameHero, 70,5,5, new ArrayList<Potion>(), new ArrayList<Food>());
  }

}