package Items;

public class ShowerItem {

    private Item item;

    public ShowerItem(Item item)
    {
        this.item = item;
    }

      public void Show()
      {

          System.out.println("\n name = " + item.getName() + "\n href =  " +
                  item.getHref() + "\n img = " + item.getImg_href() + "\n data = " + item.getData());


      }

}
