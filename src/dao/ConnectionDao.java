package com.mySNS.dao;

import java.util.Properties;
import java.io.InputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDao {

  private static Connection conn;

  public static Connection getConnection(){
    if(conn == null){
      try {
        // create and load properties
        Properties properties = new Properties();
        InputStream in = ConnectionDao.class.getClassLoader().getResourceAsStream("/db.properties");
        properties.load(in);
        in.close();

        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");

        Class.forName(driver);
        conn = DriverManager.getConnection(url, user, password);
      } catch (SQLException e) {
        e.printStackTrace();
      } catch (ClassNotFoundException e) {
        e.printStackTrace();
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return conn;
  }
}
