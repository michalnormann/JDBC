package com.sda.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CatManager {

    private static final String INSERT_INTO_CATS_NAME_BIRTH_YEAR_COLOUR_VALUES = "INSERT INTO cats(name, birth_year, colour) VALUES (?, ?, ? )";

    public void createCats(Connection connection) throws SQLException {
/*
        Statement statement = connection.createStatement();
        statement.executeUpdate("INSERT INTO cats(name, birth_year, colour) VALUES ('Rys', 2000, 'Brown' )");
        statement.executeUpdate("INSERT INTO cats(name, birth_year, colour) VALUES ('Kotlin', 2015, 'Black' )");
*/
        PreparedStatement statement = connection.prepareStatement(INSERT_INTO_CATS_NAME_BIRTH_YEAR_COLOUR_VALUES);
        statement.setString(1,"Rys");
        statement.setInt(2,2000);
        statement.setString(3,"Brown");
        statement.executeUpdate();

    }

    List<Cat> findAllCats(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT c.id as cat_id,c.name as cat_name,c.birth_year as cat_by, c.colour as cat_colour FROM cats c");
        System.out.println("Searching for cats");
        List<Cat> cats = new ArrayList<>();
        while(result.next()) {
            int catId = result.getInt("cat_id");
            String catName = result.getString("cat_name");
            int birthYear = result.getInt("cat_by");
            String colour = result.getString("cat_colour");
            cats.add(new Cat(catId,catName,birthYear,colour));
        }
        return cats;
    }
}
