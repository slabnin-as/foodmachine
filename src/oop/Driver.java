package oop;

import oop.factory.FitnessFoodMachineFactory;
import oop.factory.FoodMachineFactory;
import oop.machine.FoodMachine;

/**
 *
 *
 * @author Burkin A. Yur.
 * @ created 2020-01-10
 */
public class Driver {

    public static void main(String[] args) {
        FoodMachineFactory fitnessFactory = new FitnessFoodMachineFactory();
        FoodMachine foodMachine = fitnessFactory.createFoodMachine();


    }
}
