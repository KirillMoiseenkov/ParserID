package DB;

import Items.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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


    public void addToDB(Item item) throws SQLException {

        pst = connection.prepareStatement(
                "INSERT INTO users (name,data,href,img_href) values (?,?,?,?);");
        pst.setString(1, item.getName());
        pst.setString(2, item.getData());
        pst.setString(3, item.getHref());
        pst.setString(4, item.getImg_href());

        pst.executeUpdate();



    }

}
