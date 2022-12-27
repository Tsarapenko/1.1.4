package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД

    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public Connection getConnection() {
        Connection connection = null;
        Driver driver;

        {
            try {
                driver = new com.mysql.cj.jdbc.Driver();
                DriverManager.registerDriver(driver);

                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                if (!connection.isClosed()) {
                    System.out.println("Соединение установлено!");
                }
//                connection.close();
            } catch (SQLException e) {
                System.err.println("Не удалось загрузить класс Драйвер!");

            }
        }
        return connection;
    }

}




