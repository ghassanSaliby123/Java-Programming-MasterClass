package com.ghassan;

import java.sql.*;

public class Main {

    //DriverManager.getConnection --> Connection.createStatement --> Statement.execute --> Execute
    //statement.close --> connection.close
    //the better way is use try with resources
    //After each executing each statement we have to commit, this process is called a transaction
    //The DriverManager has an autocommit function to commit each statement
    //We can turn it off or on

    //When we want to do a query and process the results. we use the getResultSet method
    //ResultSet = statement.getResultSet
    //That will return a single or multiple records. The statement object has a cursor that point
    //to the first returned record and when we call next the cursor points to the other record and so on
    public static void main(String[] args) {

        try{
            Connection conn = DriverManager.getConnection(
                    "jdbc:sqlite:D:\\Java Programming MasterClass Java11&java17\\15- Databases\\" +
                            "3- Insert- Update - Delete\\testjava.db");
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
            statement.execute("SELECT * FROM contacts");
            ResultSet resultSet = statement.getResultSet();
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
