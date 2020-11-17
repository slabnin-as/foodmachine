package procedural;

/**
 *
 *
 * @author Burkin A. Yur.
 * @ created 2020-01-10
 */
public class Cell {

    public static final int DEFAULT_COUNT = 5;

    private String name;
    private int price;
    private int count;

    public Cell(String name, int price) {
        this.name = name;
        this.price = price;
        this.count = DEFAULT_COUNT;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void removeProduct() {
        this.count--;
    }
}
