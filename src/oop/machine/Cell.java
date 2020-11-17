package oop.machine;

import oop.product.Product;

import java.util.ArrayDeque;

/**
 *
 *
 * @author Burkin A. Yur.
 * @ created 2020-01-10
 */
public class Cell {

    private static final int DEFAULT_COUNT = 5;

    private int price;
    private int maxSize;

    private ArrayDeque<Product> stack;

    public Cell() {
        this(DEFAULT_COUNT);
    }

    public Cell(int maxSize) {
        this.maxSize = maxSize;
        stack = new ArrayDeque<>(5);
    }

    public boolean addProduct(Product product) {
        if (stack.size() == maxSize) return false;

        stack.push(product);
        return true;
    }

    public Product removeProduct() {
        return stack.pop();
    }

    public String getProductName() {
        return stack.isEmpty() ? null : stack.peek().getTitle();
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public boolean isFull() {
        return stack.size() == maxSize;
    }

    public static int formatCell(int number) {
        int row = number / 10;
        int pos = number % 10;

        if (row > 3 || pos > 3) throw new IllegalArgumentException();
        else return  3 * (row - 1) + (pos - 1);
    }
}
