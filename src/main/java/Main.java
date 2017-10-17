import DB.DBWorker;
import Parser.*;
import Checker.Checker;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, SQLException, InterruptedException {



        Parser parser = new Parser();
        parser.setReaderInfo("C.txt", true);

    for(int i=0;i<100;i++)
     {

         System.out.println("Begin I = " + i);
        Thread.sleep(5000);
        parser.parsing();
    }




    }


}
