package Checker;


import java.util.List;

public class Checker {

  private CheckerHref checkerHref;
  private CheckerDate checkerDate;

        public  Checker()
        {
            checkerDate = new CheckerDate();

            checkerHref = new CheckerHref();

        }




      public  boolean checkDate(String date, int Index)
      {
        return checkerDate.check_date(date, Index);
      }

      public boolean checkHref(String href)
      {
          checkerHref.setIP(href);
          return checkerHref.CheckHref();
      }



}
