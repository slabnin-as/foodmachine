package oop.machine;

import oop.product.Product;

import java.util.List;

/**
 *
 *
 * @author Burkin A. Yur.
 * @ created 2020-01-14
 */
public class StatFoodMachine extends FoodMachine {


    /*---------------------------PROXY---------------------------*/


    private int saleCount;
    private int successCount;

    private FoodMachine machine;

    public StatFoodMachine(FoodMachine machine) {
        this.machine = machine;
    }

    @Override
    public List<Product> takeProducts() {
        List<Product> products = super.takeProducts();
        saleCount += products.size();

        return products;
    }

    @Override
    public void paymentSuccess() {
        successCount++;
        super.paymentSuccess();
    }

    public int getSaleCount() {
        return saleCount;
    }

    public int getSuccessCount() {
        return successCount;
    }

    public int loss() {
        return saleCount - successCount;
    }
}
