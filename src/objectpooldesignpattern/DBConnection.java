package objectpooldesignpattern;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    Connection mySqlConnection;

    DBConnection (){
        try {
            mySqlConnection  = DriverManager.getConnection("url","username","password");
        } catch (SQLException e) {
            //System.out.println("Error while establishing connection");
        }
    }
}
