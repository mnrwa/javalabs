package ru.bahanov.pracJava.task13;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/javalabs13";
    private static final String USER = "postgres";
    private static final String PASSWORD = "dbpass";

    private static Connection connection = null;

    private DBConnection() {
    }

    public static Connection getConnection() {
        if (connection == null) {
            synchronized (DBConnection.class) {
                if (connection == null) {
                    try {
                        connection = DriverManager.getConnection(URL, USER, PASSWORD);
                        System.out.println("Соединение с базой данных установлено.");
                    } catch (SQLException e) {
                        e.printStackTrace();
                        throw new RuntimeException("Ошибка подключения к базе данных");
                    }
                }
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Соединение с базой данных закрыто.");
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
