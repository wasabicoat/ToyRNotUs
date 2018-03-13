/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.model;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConnectionBuilder {
    Connection conn = null;
    static String test = "";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        String db = "jdbc:mysql://localhost:8889/helloworld";
        String username = "root";
        String password = "root";

        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loaded success");

        conn = DriverManager.getConnection(db, username, password);
        System.out.println("Connected");

        return conn;
    }
    
}
