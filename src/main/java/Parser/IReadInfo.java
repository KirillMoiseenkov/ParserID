package Parser;

import Items.Item;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IReadInfo {



    public Item getInfo(Elements Ename, Elements Img, Elements Data, int Index);
    public void parisng(List<String> Row, boolean mode) throws IOException, SQLException;

}
