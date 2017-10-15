package DB;

import Items.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DBWorker implements IDBWorker{

       private SetConnector setConnector;
       private Adder adder;
       private CloseConnector closeConnector;

       private Connection connection;
       private Statement statement;
       private PreparedStatement pst;


      public DBWorker()
      {
              connection = setConnector.setConnection();
              statement = (Statement)  setConnector.setStatement();
      }


       @Override
       public void AddToDB(Item item) throws SQLException {

              pst = connection.prepareStatement(
                      "INSERT INTO users (name,data,href,img_href) values (?,?,?,?);");
              pst.setString(1, item.getName());
              pst.setString(2, item.getData());
              pst.setString(3, item.getHref());
              pst.setString(4, item.getImg_href());

              pst.executeUpdate();


       }

       @Override
       public void CloseDBConnection() throws SQLException {
              closeConnector.CloseAllConnection();

       }
}
