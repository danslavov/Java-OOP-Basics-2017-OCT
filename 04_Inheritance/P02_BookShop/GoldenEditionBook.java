package P02_BookShop;

public class GoldenEditionBook extends Book {

    public GoldenEditionBook(String author, String title, double price) {
        super(author, title, price);
    }

    @Override
    protected double getPrice() {
        return super.getPrice() * 1.3;
    }
}
