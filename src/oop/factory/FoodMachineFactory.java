package oop.factory;

import oop.factory.product.ProductFactory;
import oop.machine.FoodMachine;

/**
 *
 *
 * @author Burkin A. Yur.
 * @ created 2020-01-15
 */
public abstract class FoodMachineFactory {


    /*---------------------------FACTORY METHOD---------------------------*/


    protected ProductFactory productFactory;

    public FoodMachineFactory(ProductFactory productFactory) {
        this.productFactory = productFactory;
    }

    public abstract FoodMachine createFoodMachine();
}
