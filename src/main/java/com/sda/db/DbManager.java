package com.sda.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DbManager {

    private static final String CREATE_CAT_DB =
            "CREATE TABLE IF NOT EXISTS cats (" +
                    "id INT NOT NULL AUTO_INCREMENT, " +
                    "name VARCHAR(50)  NOT NULL, " +
                    "birth_year INT NOT NULL," +
                    "colour VARCHAR(50) NOT NULL," +
                    "PRIMARY KEY (id));";

    public void createDb (Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute(CREATE_CAT_DB);
        System.out.println("Cat table created.");
    }

    void clearTable(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("DELETE FROM cats");
    }
}
