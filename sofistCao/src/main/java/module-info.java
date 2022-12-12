module App {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.base;

    opens App to javafx.fxml;
    exports App;
    
    opens Controller to javafx.fxml;
    exports Controller;
    
    opens Model to javafx.fxml;
    exports Model;
}
