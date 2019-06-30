package com.sda.db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cats?createDatabaseIfNotExist=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","adminadmin");

        DbManager dbManager = new DbManager();
        dbManager.createDb(connection);
        dbManager.clearTable(connection);

        CatManager catManager = new CatManager();
        catManager.createCats(connection);

        List<Cat> cats = catManager.findAllCats(connection);
        System.out.println(cats);
        

    }
}
