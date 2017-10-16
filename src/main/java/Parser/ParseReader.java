package Parser;

import Checker.Checker;
import DB.DBWorker;
import Items.Item;
import Items.ShowerItem;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class ParseReader implements  IReadInfo {

/*      private String Img_way =  ".e2-text-picture-imgwrapper img";
      private String Name_way = ".e2-smart-title a";
      private String Date_way = ".e2-timestamp";
      private String Note_way = ".e2-note";
    private ShowerItem showerItem;



    public ParseReader(String Img_way, String Name_way, String Date_way, String Note_way) {

       this.Date_way = Date_way;
       this.Img_way = Img_way;
       this.Name_way = Name_way;
       this.Note_way = Note_way;


    }
*/
private Checker checker = new Checker();
private DBWorker dbWorker;


   public String URL_config;

    public ParseReader(String URL_config) {

        checker.SetCheckData();
        this.URL_config = URL_config;


    }


    public void Parisng(List<String> Row) throws IOException, SQLException {
        dbWorker = new DBWorker();
        try {
            int n = 0;


            int Late = 30;


            while (n != Row.size()) {


                boolean date = false;
                int page = 1;


                Document doc;
                try {


                    doc = Jsoup.connect(Row.get(n) + "page-" + page).get();
                } catch (org.jsoup.HttpStatusException e) {

                    n++;
                    break;

                }

                Elements EName = doc.select(".e2-smart-title a");
                Elements Img = doc.select(".e2-note");
                Elements Data = doc.select(".e2-timestamp");

                Item item;

                for (int i = 0; i < Img.size(); i++) {

                    item = GetInfo(EName, Img, Data, i);

                        if(!checker.CheckData(item.getData())) {
                            ShowerItem showerItem = new ShowerItem(item);

                            showerItem.Show();

                            dbWorker.AddToDB(item);
                        }
                    date = checker.CheckDate(item.getData(), 30);

                    if (date == true)
                        break;
                        }
                page++;


                n++;
            }
            dbWorker.CloseDBConnection();
        }
        finally {
            dbWorker.CloseDBConnection();

        }
      }

    public Item GetInfo(Elements Ename, Elements Img, Elements Data, int Index) {
        String img_href = "Not exist";

        if (!Img.get(Index).select(".e2-text-picture-imgwrapper img").isEmpty())
            img_href = Img.get(Index).select(".e2-text-picture-imgwrapper img").get(0).absUrl("src");


        return new Item(
                Ename.get(Index).text(),
                Data.get(Index).attr("title"),
                Ename.get(Index).attr("href"),
                img_href
        );
    }


}



