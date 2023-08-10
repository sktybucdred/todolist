package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ListController {
    @FXML
    private ListView<String> taskListView;

    @FXML
    public void initialize() {
        loadTasksFromDatabase();
    }

    private void loadTasksFromDatabase() {
        Connection conn = DatabaseManager.connect();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT description FROM tasks")) {
            while (rs.next()) {
                String description = rs.getString("description");
                taskListView.getItems().add(description);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
