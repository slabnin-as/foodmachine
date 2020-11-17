package oop.discount;

import oop.machine.Cell;

/**
 *
 *
 * @author Burkin A. Yur.
 * @ created 2020-01-14
 */
public class WeekendDiscountStrategy implements DiscountStrategy {

    @Override
    public int make(Cell cell) {
        return (int)(cell.getPrice() / 100.0 * 70);
    }
}
