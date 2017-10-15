package File;

import java.io.IOException;
import java.util.List;

public class Reader {

    ReaderFile readerFile;

    public  Reader(String URL)
    {
       readerFile = new ReaderFile(URL);
    }


    public List<String> getInfoHref() throws IOException {
      return  readerFile.getListInfo();

    }



}
