package org.example;

import java.sql.*;

public class DatabaseManager {

    private static Connection conn;

    public static Connection connect() {
        if (conn != null) return conn;
        final String url = "jdbc:sqlite:tasks.db";
        try {
            conn = DriverManager.getConnection(url);
            createTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    private static void createTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS tasks (\n"
                + " id integer PRIMARY KEY,\n"
                + " description text NOT NULL,\n"
                + " status text NOT NULL,\n"
                + " due_date DATE,\n"
                + " priority text\n"
                + ");";

        Statement stmt = conn.createStatement();
        stmt.execute(sql);
    }

    public void createTask(Task task) throws SQLException{
        String sql = "INSERT INTO tasks (description, status, due_date, priority) VALUES (?, ?, ?, ?)";

        try(PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, task.getDescription());
            pstmt.setString(2, task.getStatus().name());
            pstmt.setDate(3, Date.valueOf(task.getDueDate()));
            pstmt.setString(4, task.getPriority().name());

            pstmt.executeUpdate();
        }
    }
}
