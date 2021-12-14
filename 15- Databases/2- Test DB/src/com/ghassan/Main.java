package com.ghassan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    //We have two ways to connect a DB and if it doesn't exist it will be created for us
    //We can use DriverManager or Datasource from sql library
    //In this example we use The DriverManger to get the connection to DB and get a Connection object
    //Then we create a statement from the connection.createStatement
    //Then we execute the statement.execute("the statement")
    //DriverManager --> Connection --> Statement --> Execute
    //Don't forget to close the connection when we've done from it
    //statement.close --> connection.close
    //the better way is use try with resources
    public static void main(String[] args) {

        try{
            Connection conn = DriverManager.getConnection(
                    "jdbc:sqlite:D:\\Java Programming MasterClass Java11&java17\\15- Databases\\" +
                            "2- Test DB\\testjava.db");
            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS " +
                    "contacts (name TEXT, phone INTEGER, email TEXT)");
            statement.close();
            conn.close();
        }catch (SQLException e){
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}
