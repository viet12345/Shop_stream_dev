package donalduck_library.helper;

import java.sql.*;

public class SqlHelpers {
    public static void main(String[] args) {
        String url = "jdbc:mysql://db-mysql-sgp1-dev-62668-do-user-618346-0.b.db.ondigitalocean.com:25060/keiyo_club";
        String username = "keiyo_club";
        String password = "vuN7vN4pSsA3y3Dn";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connect Successfully " + url);
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM keiyo_club.advertisements where deleted_at is null;");
//            String content=resultSet.getString(3);
//            System.out.println(content);


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }


//    public static void ConnectSql(String url, String username, String password)
//    {
//
//    }
}
