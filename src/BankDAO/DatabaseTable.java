package BankDAO;

import java.sql.*;

public class DatabaseTable {


    static void checkTable(Connection connection, String tableName) {
        String query = "";
        switch(tableName) {
            case "PERSON":
                query = "CREATE TABLE IF NOT EXISTS PERSON (" +
                                "SSN	    INTEGER NOT NULL UNIQUE," +
                                "FNAME	    TEXT, " +
                                "LNAME	    TEXT," +
                                "STREETNUM	INTEGER," +
                                "STREETNAME	TEXT," +
                                "CITY	    TEXT," +
                                "STATE	    TEXT," +
                                "ZIP	    INTEGER," +
                                "PRIMARY KEY(SSN))";
                break;
            case "ACCOUNT":
                query = "CREATE TABLE IF NOT EXISTS ACCOUNT (" +
                                "ACCOUNT_ID	             INTEGER NOT NULL UNIQUE," +
                                "ACCOUNT_TYPE	         TEXT," +
                                "BALANCE	             INTEGER," +
                                "SSN	                 INTEGER NOT NULL," +
                                "FOREIGN KEY (SSN)       REFERENCES PERSON (SSN)," +
                                "PRIMARY KEY (ACCOUNT_ID AUTOINCREMENT))";

                break;
        }
        try {
            connection.prepareStatement(query).execute();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }


    }

}
