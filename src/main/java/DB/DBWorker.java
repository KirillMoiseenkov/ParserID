package DB;

import File.ReadDB;
import Items.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DBWorker{

       private SetConnector setConnector;
       private Adder adder;
       private CloseConnector closeConnector;


       private Connection connection;
       private Statement statement;
       private PreparedStatement pst;
       public ReadDB readDB;

      public DBWorker()
      {
             setConnector = new SetConnector();


              connection = setConnector.setConnection();
              statement =  setConnector.setStatement();


      }
       public void setReadDB(boolean mode) throws SQLException {
           readDB = new ReadDB(connection,statement);
            if(mode)
                readDB.createExistListURL();
            else
                readDB.createEmptyListURL();
       }

       public void addToDB(Item item) throws SQLException {

          adder = new Adder(connection,statement,pst);
          adder.addToDB(item);


       }

       public void closeDBConnection() throws SQLException {


            closeConnector = new CloseConnector(connection,statement,pst);

              closeConnector.closeAllConnection();

       }





}
