package com.isep.rpg_isep.Modele;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Historical {

    private StringProperty before;


    public Historical(String before){
        this.before = new SimpleStringProperty(before);
    }


    public StringProperty beforeProperty() {
        return before;
    }
}
