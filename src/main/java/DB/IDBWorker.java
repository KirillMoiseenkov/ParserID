package DB;
import Items.Item;

import java.sql.SQLException;

public interface IDBWorker {

    void AddToDB(Item item) throws SQLException;
    void CloseDBConnection() throws SQLException;




}
