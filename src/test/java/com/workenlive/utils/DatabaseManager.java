package com.workenlive.utils;

import com.workenlive.base.TestBase;

import java.sql.*;
import java.util.List;
import java.util.Map;

public class DatabaseManager extends TestBase {
    private static DatabaseManager instance;
    private Connection connection;
    private String url = configread.getDBUrl();
    private String username = configread.getDBUsername();
    private String password = configread.getDBPassword();

    private DatabaseManager() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static DatabaseManager getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseManager();
        } else if (instance.getConnection().isClosed()) {
            instance = new DatabaseManager();
        }

        return instance;
    }

    public static ResultSet executeSelectQuery(String table, List<String> columnList, Map<String, ?> whereConditionMap) {
        ResultSet resultSet = null;
        String query = "";
        query += "SELECT ";
        for(int counter = 0; counter < columnList.size(); counter++) {
            if(counter != columnList.size() - 1) {
                query += columnList.get(counter) + ",";
            } else {
                query += columnList.get(counter);
            }
        }
        query += " FROM " + table;
        int index = 0;
        for(Map.Entry<String, ?> entry : whereConditionMap.entrySet()) {
            if(index == 0) {
                query += " WHERE " + entry.getKey() + "=" + entry.getValue();
            } else {
                query += ", " + entry.getKey() + "=" + entry.getValue();
            }
            index++;
        }

        try (Statement statement = DatabaseManager.getInstance().getConnection().createStatement()) {
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public static void executeInsertQuery(String table, Map<String, ?> columnValuesMap) {
        String query = "";
        query += "INSERT INTO " + table;
        int index = 0;
        for(String key : columnValuesMap.keySet()) {
            if(index == 0) {
                query += "(" + key;
            } else if(index == columnValuesMap.size() - 1){
                query += ", " + key + ")";
            } else {
                query += ", " + key;
            }
            index++;
        }

        query += " VALUES ";
        index = 0;
        for(String key : columnValuesMap.keySet()) {
            if(index == 0) {
                query += "('" + columnValuesMap.get(key) + "'";
            } else if(index == columnValuesMap.size() - 1){
                query += ", '" + columnValuesMap.get(key) + "')";
            } else {
                query += ", '" + columnValuesMap.get(key) + "'";
            }
            index++;
        }
        try (Statement statement = DatabaseManager.getInstance().getConnection().createStatement()) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeUpdateQuery() {

    }

    public void executeDeleteQuery(String table, Map<String, ?> whereConditionMap) {
        String query = "";
        query += "DELETE FROM " + table;
        int index = 0;
        for(Map.Entry<String, ?> entry : whereConditionMap.entrySet()) {
            if(index == 0) {
                query += " WHERE " + entry.getKey() + "=" + entry.getValue();
            } else {
                query += ", " + entry.getKey() + "=" + entry.getValue();
            }
            index++;
        }
        try (Statement statement = DatabaseManager.getInstance().getConnection().createStatement()) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
