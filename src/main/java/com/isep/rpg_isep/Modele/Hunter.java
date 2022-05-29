package com.isep.rpg_isep.Modele;
import java.util.ArrayList;
/**
 * Class Hunter
 */
public class Hunter extends Hero {


  public Hunter (String nameHero) {
    super(1, nameHero, 80,0,10, new ArrayList<Potion>(), new ArrayList<Food>());
  }
}
