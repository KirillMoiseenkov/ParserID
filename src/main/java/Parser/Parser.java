package Parser;

import File.Reader;

import java.io.IOException;
import java.sql.SQLException;

public class Parser {

   private ParseReader parseReader;
   private Reader reader;

    public void setReaderInfo(String URL, boolean ExistenceOfDB) throws SQLException {
        reader = new Reader(URL);
        parseReader = new ParseReader(ExistenceOfDB);
    }

    public void parsing() throws IOException, SQLException {
            parseReader.parisng(reader.getInfoHref(),false);
    }







}
