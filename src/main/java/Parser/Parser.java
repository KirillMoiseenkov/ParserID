package Parser;

import File.Reader;

import java.io.IOException;
import java.sql.SQLException;

public class Parser {

   private ParseReader parseReader;
    private Reader reader;

    public void SetReaderInfo(String URL)
    {
        reader = new Reader(URL);
        parseReader = new ParseReader();
    }

    public void Parsing() throws IOException, SQLException {
            parseReader.Parisng(reader.getInfoHref());
    }







}
