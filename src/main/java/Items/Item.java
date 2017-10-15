package Items;

public class Item {

    private String name;
    private String data;
    private String img_href;
    private String href;


    public Item(String name,
                String data,
                String href,
                String img_href
    )
    {
        this.name = name;
        this.data = data;
        this.href = href;
        this.img_href = img_href;


    }


    public String getName()
    {
        return name;
    }
    public String getImg_href() {return img_href;}
    public  String getData()
    {
        return  data;
    }
    public String getHref() { return  href; }
}
