module todolist {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;

    opens org.example to javafx.fxml;
    exports org.example;
}