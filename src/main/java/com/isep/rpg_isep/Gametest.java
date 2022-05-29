package com.isep.rpg_isep;

import static org.junit.Assert.assertEquals;

import com.isep.rpg_isep.Modele.*;
import javafx.beans.property.IntegerProperty;
import org.junit.Test;

public class Gametest  {

    ////// HUNTER

    @Test
    public void testHunt() {
        Hero hunter = new Hunter("");
        hunter.getLifePoints();
        assertEquals(80,hunter.getLifePoints());
    }

    @Test
    public void testHuntWthArw() { //// degat avec une fleche de plus (fait plus mal)
        Hero hunter = new Hunter("");
        hunter.getWeaponDamage();
        assertEquals(20,hunter.getweaponDamage() + 10);
    }

    @Test
    public void testHuntWthtArw() { //// degat sans la fleche de plus
        Hero hunter = new Hunter("");
        hunter.getWeaponDamage();
        assertEquals(10,hunter.getweaponDamage());
    }

    @Test
    public void testHunterArmur() {
        Hero hunter = new Hunter("");
        hunter.getAmor();
        assertEquals(0,hunter.getAmor());
    }

    ///////Healer

    @Test
    public void testHealer() {
        Hero healer = new Healer("");
        healer.getLifePoints();
        assertEquals(70,healer.getLifePoints());
    }

    @Test
    public void testHealerDamage() { //// degat sans la fleche de plus
        Hero healer = new Healer("");
        healer.getWeaponDamage();
        assertEquals(5,healer.getweaponDamage());
    }

    @Test
    public void testHealerArmur() {
        Hero healer = new Healer("");
        healer.getAmor();
        assertEquals(5,healer.getAmor());
    }

    ///////Mage

    @Test
    public void testMage() {
        Hero mage = new Mage("");
        mage.getLifePoints();
        assertEquals(70,mage.getLifePoints());
    }

    @Test
    public void testMageDamage() { //// degat sans la fleche de plus
        Hero mage = new Mage("");
        mage.getWeaponDamage();
        assertEquals(10,mage.getweaponDamage());
    }

    @Test
    public void testMageArmur() {
        Hero mage = new Mage("");
        mage.getAmor();
        assertEquals(0,mage.getAmor());
    }

    /////// Warrior

    @Test
    public void testWarriorDamage() { //// degat sans la fleche de plus
        Hero warrior = new Warrior("");
        warrior.getWeaponDamage();
        assertEquals(10,warrior.getweaponDamage());
    }

    @Test
    public void testWarriorArmur() {
        Hero warrior = new Warrior("");
        warrior.getAmor();
        assertEquals(20,warrior.getAmor());
    }

    @Test
    public void testWarrior() {
        Hero warrior = new Warrior("");
        warrior.getLifePoints();
        assertEquals(80,warrior.getLifePoints());
    }

}