package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public final class ConnectDb {

    private static final ConnectDb instance = new ConnectDb();

    private ConnectDb(){}

    public static ConnectDb getInstance(){ return instance;}

    public Connection getDbConnection() {
        Connection c = null;
        try {
            c = DriverManager
                    .getConnection("jdbc:oracle:thin:@localhost:1521:orclcdb","mydb", "mydb");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
        }

        return c;
    }
}
