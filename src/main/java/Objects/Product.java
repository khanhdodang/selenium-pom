package Objects;

public class Product {
    String title;
    String desc;
    String price;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append("Title = '");
//        sb.append(title);
//        sb.append("'; Desc = '");
//        sb.append(desc);
//        sb.append("'; Price = '");
//        sb.append(price);
//        sb.append("'");

        String output = String.format("Title = '%s'; Desc = '%s'; Price = '%s'", title, desc, price);
//        return "Title = '" + title + "'; Desc = '" + desc + "'; Price = '" + price + "'";
        return output;
//        return sb.toString();
    }
}
