package oop.product;

/**
 *
 *
 * @author Burkin A. Yur.
 * @ created 2020-01-14
 */
public abstract class Product {

    private String title;

    public Product(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
