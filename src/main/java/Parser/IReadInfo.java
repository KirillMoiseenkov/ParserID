package Parser;

import Items.Item;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IReadInfo {



    public Item GetInfo(Elements Ename, Elements Img, Elements Data, int Index);
    public void Parisng(List<String> Row) throws IOException, SQLException;

}
