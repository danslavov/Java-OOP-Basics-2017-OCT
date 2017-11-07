package P02_BookShop;

import java.text.DecimalFormat;

public class Book {
    private String author;
    private String title;
    private double price;

    Book(String author, String title, double price) {
        setAuthor(author);
        setTitle(title);
        setPrice(price);
    }

    private String getAuthor() {
        return this.author;
    }

    private void setAuthor(String author) {
        if (authorIsInvalid(author)) {
            throw new IllegalArgumentException("Author not valid!");
        }
        this.author = author;
    }

    private String getTitle() {
        return this.title;
    }

    private void setTitle(String title) {
        if (title.length() < 3) {
            throw new IllegalArgumentException("Title not valid!");
        }
        this.title = title;
    }

    protected double getPrice() {
        return this.price;
    }

    protected void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price not valid!");
        }
        this.price = price;
    }

    private boolean authorIsInvalid(String author) {
        String[] fullName = author.split("\\s++");
        if (fullName.length > 1) {
            String familyName = fullName[1];
            if (Character.isDigit(familyName.charAt(0))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.0###");
        final StringBuilder sb = new StringBuilder();
        sb.append("Type: ").append(this.getClass().getSimpleName())
                .append(System.lineSeparator())
                .append("Title: ").append(this.getTitle())
                .append(System.lineSeparator())
                .append("Author: ").append(this.getAuthor())
                .append(System.lineSeparator())
                .append("Price: ").append(df.format(this.getPrice()))
                .append(System.lineSeparator());
        return sb.toString();
    }
}
