package com.ghassan;

import java.sql.*;

public class Main {

   //As we discussed in the previous example that we can execute a query with statement.execute
    //and we get the results by statement.getResultSet
    //There is another way to execute a query and get the results
    //by using statement.executeQuery and it will return a resultSet
    public static void main(String[] args) {

        try{
            Connection conn = DriverManager.getConnection(
                    "jdbc:sqlite:D:\\Java Programming MasterClass Java11&java17\\15- Databases\\" +
                            "4- Queries and Results\\testjava.db");
//            conn.setAutoCommit(false);
            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS " +
                    "contacts (name TEXT, phone INTEGER, email TEXT)");
            //Insert data
//            statement.execute("INSERT INTO contacts (name, phone, email) "
//            + "VALUES ('Joe', 00000, 'Joe@gmail.com')");
//            statement.execute("INSERT INTO contacts (name, phone, email) "
//                    + "VALUES ('Jane', 23432511, 'Jane@gmail.com')");
//            statement.execute("INSERT INTO contacts (name, phone, email) "
//                    + "VALUES ('Fido', 5463442, 'Fido@gmail.com')");

            //Update data
//            statement.execute("UPDATE contacts SET phone = 4432342 WHERE name = 'Joe'");

            //Delete data
//            statement.execute("DELETE FROM contacts WHERE name = 'Fido'");

            //Get records
//            statement.execute("SELECT * FROM contacts");
//            ResultSet resultSet = statement.getResultSet();
            //Another way to execute and get the results
            ResultSet resultSet = statement.executeQuery("SELECT * FROM contacts");
            while (resultSet.next()){
                System.out.println(resultSet.getString("name")+ " "+
                        resultSet.getInt("phone")+" " +
                        resultSet.getString("email"));
            }
            statement.close();
            conn.close();
        }catch (SQLException e){
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}
