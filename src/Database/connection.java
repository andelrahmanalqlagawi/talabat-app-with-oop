package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connection {

    static private Connection c;

    public static Connection con() {

        try {
            c = DriverManager.getConnection("jdbc:sqlite:database.db");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return c;

    }

}
