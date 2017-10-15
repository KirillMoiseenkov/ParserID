package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Adder {

    private Connection connection;
    private Statement statement;
    private PreparedStatement pst;

    public Adder( Connection connection,Statement statement, PreparedStatement pst)
    {
        this.statement = statement;
        this.connection = connection;
        this.pst = pst;
    }


    public void AddToDB()
    {



    }

}
