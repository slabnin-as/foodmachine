package oop.discount;

import oop.machine.Cell;

/**
 *
 *
 * @author Burkin A. Yur.
 * @ created 2020-01-14
 */
public class SaleDiscountStrategy implements DiscountStrategy {


    /*---------------------------DECORATOR---------------------------*/


    private DiscountStrategy strategy;

    public SaleDiscountStrategy(DiscountStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public int make(Cell cell) {
        return strategy.make(cell) / 2;
    }
}
