package com.game;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;

public class DBConnection {
    void createConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection(
                    "jdbc:mysql:localhost:3306/java_hero", "jeremy", "Tekila963");
            System.out.println("Connected !");

        } catch (ClassNotFoundException e){
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE,null, e);
        } catch (SQLException e) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
        }
    }
}
