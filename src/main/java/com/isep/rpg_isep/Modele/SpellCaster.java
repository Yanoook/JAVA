package com.isep.rpg_isep.Modele;
import java.util.ArrayList;
/**
 * Class SpellCaster
 */
abstract public class SpellCaster extends Hero {

  private int manaPoints;

  public SpellCaster(int classHero, String name, int lifepoints, int armor, int weaponsDamage, ArrayList<Potion> potions, ArrayList<Food> lembas) {
    super(classHero, name, lifepoints, armor, weaponsDamage,potions, lembas);
  }

}
