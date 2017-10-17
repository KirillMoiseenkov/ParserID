package Parser;

import Checker.Checker;
import DB.DBWorker;
import File.ReadDB;
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
private Checker checker;
private DBWorker dbWorker;



    public ParseReader(boolean ExistenceOfDB) throws SQLException {

        checker = new Checker();
        dbWorker = new DBWorker();
        dbWorker.setReadDB(true);


    }


    public void parisng(List<String> Row, boolean mode) throws IOException, SQLException {


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

                    System.out.println(Row.get(n) + "page-" + page + "Is not working");
                    n++;
                    break;

                }

                Elements EName = doc.select(".e2-smart-title a");
                Elements Img = doc.select(".e2-note");
                Elements Data = doc.select(".e2-timestamp");

                Item item;

                for (int i = 0; i < Img.size(); i++) {

                    item = getInfo(EName, Img, Data, i);

                  //  System.out.println(dbWorker.readDB.addToListURL(item.getData()));



                       if(dbWorker.readDB.addToListURL(item.getData())) {

                            ShowerItem showerItem = new ShowerItem(item);

                            showerItem.Show();

                            dbWorker.addToDB(item);
                       }

                    date = checker.checkDate(item.getData(), 30);

                    if (date == true)
                        break;
                        }
                page++;


                n++;
            }
            dbWorker.closeDBConnection();
        }
        finally {
            dbWorker.closeDBConnection();

        }
        mode = false;
      }

    public Item getInfo(Elements Ename, Elements Img, Elements Data, int Index) {
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



