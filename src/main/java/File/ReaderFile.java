package File;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderFile {

    private String URl_Config;

    public ReaderFile(String URl_Config)
    {
        this.URl_Config = URl_Config;
    }

    public List<String> getListInfo() throws IOException {
        return fillng();
    }


    private List<String> fillng() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(URl_Config));
        String line;
        List<String> lines = new ArrayList<String>();
        while ((line = reader.readLine()) != null)
        {

            lines.add(line);
        }
        reader.close();
        return  lines;

    }


}
