package DB;
import Items.Item;

import java.sql.SQLException;

public interface IDBWorker {

    void addToDB(Item item) throws SQLException;
    void closeDBConnection() throws SQLException;




}
