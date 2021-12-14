package com.ghassan;

import java.sql.*;

public class Main {

    //As we discussed in the previous example that we can execute a query with statement.execute
    //and we get the results by statement.getResultSet
    //There is another way to execute a query and get the results
    //by using statement.executeQuery and it will return a resultSet
    public static final String DB_NAME = "testjava.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:D:\\Java Programming MasterClass " +
            "Java11&java17\\15- Databases\\5- Code Improvement\\"+DB_NAME;
    public static final String TABLE_CONTACTS = "contacts";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_EMAIL = "email";

    public static void main(String[] args) {

        try{
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = conn.createStatement();
            //Create a table if not exits
            statement.execute("DROP TABLE IF EXISTS "+ TABLE_CONTACTS);
            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_CONTACTS
                           + " (" + COLUMN_NAME + " TEXT, "
                                  + COLUMN_PHONE + " INTEGER, "
                                  + COLUMN_EMAIL + " TEXT)");

            //Insert data
            //First entry
            insertContact(statement, "Ghassan",12345, "Ghassan@gmail.com");
            //Second entry
            insertContact(statement, "Fadi",53214413, "Fadi@gmail.com");
            //Third entry
            insertContact(statement, "Rita",232114, "Rita@gmail.com");
            //Fourth entry
            insertContact(statement, "Nanar",252314, "Nanar@gmail.com");


            //Update data
            statement.execute("UPDATE " + TABLE_CONTACTS +
                            " SET " + COLUMN_PHONE + " = 4432342 WHERE " +
                            COLUMN_NAME + " = 'Rita'");

            //Delete data
            statement.execute("DELETE FROM " + TABLE_CONTACTS + " WHERE "
                    + COLUMN_NAME + " = 'Nanar'");

            //Get records
//            statement.execute("SELECT * FROM contacts");
//            ResultSet resultSet = statement.getResultSet();
            //Another way to execute and get the results
            ResultSet resultSet = statement.executeQuery("SELECT * FROM "+ TABLE_CONTACTS);
            while (resultSet.next()){
                System.out.println(resultSet.getString(COLUMN_NAME)+ " "+
                        resultSet.getInt(COLUMN_PHONE)+" " +
                        resultSet.getString(COLUMN_EMAIL));
            }
            statement.close();
            conn.close();
        }catch (SQLException e){
            System.out.println("Something went wrong: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void insertContact(Statement statement, String name, int phone, String email)
            throws SQLException{
        statement.execute("INSERT INTO "+ TABLE_CONTACTS
                +"(" + COLUMN_NAME +","
                + COLUMN_PHONE +","
                + COLUMN_EMAIL + ") "
                + "VALUES ('" +name + "','" + phone +"','" + email +"')");


    }
}
