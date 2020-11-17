package oop.factory;

import oop.factory.product.FitnessProductFactory;
import oop.factory.product.ProductFactory;
import oop.machine.FitnessFoodMachine;
import oop.machine.FoodMachine;
import oop.product.bar.Bar;
import oop.product.dessert.Dessert;
import oop.product.fruit.Fruit;
import oop.product.meat.Meat;
import oop.product.pasta.Pasta;
import oop.product.porridge.Porridge;
import oop.product.salad.Salad;
import oop.product.shake.Shake;
import oop.product.water.Water;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * @author Burkin A. Yur.
 * @ created 2020-01-15
 */
public class FitnessFoodMachineFactory extends FoodMachineFactory {

    public FitnessFoodMachineFactory() {
        this(FitnessProductFactory.getInstance());
    }

    public FitnessFoodMachineFactory(ProductFactory productFactory) {
        super(productFactory);
    }

    @Override
    public FoodMachine createFoodMachine() {
        FitnessFoodMachine foodMachine = new FitnessFoodMachine();

        List<Water> waters = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            waters.add(productFactory.createWater());
        foodMachine.fillCell(11, waters, 50);

        List<Bar> bars = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            bars.add(productFactory.createBar());
        foodMachine.fillCell(12, bars, 120);

        List<Salad> salads = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            salads.add(productFactory.createSalad());
        foodMachine.fillCell(13, salads, 70);

        List<Porridge> porridges = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            porridges.add(productFactory.createPorridge());
        foodMachine.fillCell(21, porridges, 70);

        List<Fruit> fruits = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            fruits.add(productFactory.createFruit());
        foodMachine.fillCell(22, fruits, 40);

        List<Shake> shakes = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            shakes.add(productFactory.createShake());
        foodMachine.fillCell(23, shakes, 150);

        List<Dessert> desserts = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            desserts.add(productFactory.createDessert());
        foodMachine.fillCell(31, desserts, 170);

        List<Pasta> pastas = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            pastas.add(productFactory.createPasta());
        foodMachine.fillCell(32, pastas, 150);

        List<Meat> meats = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            meats.add(productFactory.createMeat());
        foodMachine.fillCell(33, meats, 190);

        return foodMachine;
    }
}
