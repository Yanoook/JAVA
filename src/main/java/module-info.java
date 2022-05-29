module com.isep.rpg_isep {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.testng;
    requires junit4;


    opens com.isep.rpg_isep to javafx.fxml;
    exports com.isep.rpg_isep;
}