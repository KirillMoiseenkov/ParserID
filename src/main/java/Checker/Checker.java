package Checker;

import Checker.CheckerData.CheckerData;

public class Checker {

  private CheckerHref checkerHref;
  private CheckerDate checkerDate;
  private CheckerData checkerData;

        public  Checker()
        {
            checkerDate = new CheckerDate();
            checkerHref = new CheckerHref();
            checkerData = new CheckerData();

        }

        public  void SetCheckData()
        {
            checkerData.set();
        }

        public boolean CheckData(String URL)
        {

          return   checkerData.Search(URL);

        }


      public  boolean CheckDate(String date, int Index)
      {
        return checkerDate.Check_date(date, Index);
      }

      public boolean CheckHref(String href)
      {
          checkerHref.setIP(href);
          return checkerHref.CheckHref();
      }



}
