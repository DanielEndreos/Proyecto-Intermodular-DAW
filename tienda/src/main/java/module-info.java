module com.intermodular.tienda {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.intermodular.tienda to javafx.fxml;
    exports com.intermodular.tienda;
}