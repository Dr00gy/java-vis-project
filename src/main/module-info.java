module master {
    requires java.sql;
    requires org.json;
    requires transitive javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    opens lab to javafx.fxml;
    exports lab;
}