package DB;

import Items.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DBWorker{

       private SetConnector setConnector;
       private Adder adder;
       private CloseConnector closeConnector;

       private Connection connection;
       private Statement statement;
       private PreparedStatement pst;


      public DBWorker()
      {
          setConnector = new SetConnector();


              connection = setConnector.setConnection();
              statement =  setConnector.setStatement();
      }


       public void AddToDB(Item item) throws SQLException {

          adder = new Adder(connection,statement,pst);
          adder.AddToDB(item);


       }

       public void CloseDBConnection() throws SQLException {


            closeConnector = new CloseConnector(connection,statement,pst);

              closeConnector.CloseAllConnection();

       }
}
