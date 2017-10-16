import Parser.*;
import Checker.Checker;
import java.io.IOException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws IOException, SQLException, InterruptedException {




        Parser parser = new Parser();
        parser.SetReaderInfo("C:/Users/acer-pc/IdeaProjects/exam/src/test/java/Config.txt");

    for(int i=0;i<5;i++)
     {
         System.out.println("Begin I = " + i);
        Thread.sleep(5000);
        parser.Parsing();
    }

    }


}
