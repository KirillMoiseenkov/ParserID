package DB;

import java.sql.*;

public class SetConnector {


   private Connection connection;
  private Statement statement;
    private PreparedStatement pst;

    private final static String URL =
            "jdbc:mysql://localhost:3306/mydbtest";
    private final static String URLFIXED =
            "jdbc:mysql://localhost:3306/mydbtest?useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true" +
                    "&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "root";



    public Connection setConnection()
    {



        try {

           connection = DriverManager.getConnection(URLFIXED, USERNAME, PASSWORD);
                   if(!connection.isClosed())
                       System.out.println("true");
            System.out.println("false");

            return  connection;
        } catch (SQLException e) {
            System.out.println("Error connection to DB with adress -" + URLFIXED + " Exeption - " + e );
        }
            return null;
    }
    public Statement setStatement()
    {



        try {

            statement = connection.createStatement();

            return  statement;
        } catch (SQLException e) {
            System.out.println("Error connection to DB with adress -" + URLFIXED + " Exeption - " + e );
        }
        return null;
    }




}
