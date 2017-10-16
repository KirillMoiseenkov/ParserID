package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class CloseConnector {

    private Connection connection;
    private Statement statement;
    private PreparedStatement pst;

    public CloseConnector(Connection connection, Statement statement, PreparedStatement pst)
    {
    this.statement = statement;
    this.connection = connection;
    this.pst = pst;
    }

    public void CloseAllConnection() throws SQLException {
        connection.close();
        statement.close();



    }
    public  void CloseAllAppartCon() throws SQLException {
        statement.close();

    }


}
