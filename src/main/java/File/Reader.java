package File;
import  Checker.*;
import java.io.IOException;
import java.util.List;

public class Reader {

    Checker checker;


    ReaderFile readerFile;

    public  Reader(String URL)
    {
        checker = new Checker();
        readerFile = new ReaderFile(URL);
    }


    public List<String> getInfoHref() throws IOException {
      return  readerFile.getListInfo();

    }



}
