package oop.factory;

import oop.factory.product.GeneralProductFactory;
import oop.factory.product.ProductFactory;
import oop.machine.FoodMachine;
import oop.machine.GeneralFoodMachine;
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
public class GeneralFoodMachineFactory extends FoodMachineFactory {

    public GeneralFoodMachineFactory() {
        this(GeneralProductFactory.getInstance());
    }

    public GeneralFoodMachineFactory(ProductFactory productFactory) {
        super(productFactory);
    }

    @Override
    public FoodMachine createFoodMachine() {
        GeneralFoodMachine foodMachine = new GeneralFoodMachine();

        List<Water> waters = new ArrayList<>();
        for (int i = 0; i < 4; i++)
            waters.add(productFactory.createWater());
        foodMachine.fillCell(11, waters, 70);

        List<Bar> bars = new ArrayList<>();
        for (int i = 0; i < 4; i++)
            bars.add(productFactory.createBar());
        foodMachine.fillCell(12, bars, 100);

        List<Salad> salads = new ArrayList<>();
        for (int i = 0; i < 4; i++)
            salads.add(productFactory.createSalad());
        foodMachine.fillCell(13, salads, 100);

        List<Porridge> porridges = new ArrayList<>();
        for (int i = 0; i < 4; i++)
            porridges.add(productFactory.createPorridge());
        foodMachine.fillCell(21, porridges, 70);

        List<Fruit> fruits = new ArrayList<>();
        for (int i = 0; i < 4; i++)
            fruits.add(productFactory.createFruit());
        foodMachine.fillCell(22, fruits, 250);

        List<Shake> shakes = new ArrayList<>();
        for (int i = 0; i < 4; i++)
            shakes.add(productFactory.createShake());
        foodMachine.fillCell(23, shakes, 120);

        List<Dessert> desserts = new ArrayList<>();
        for (int i = 0; i < 4; i++)
            desserts.add(productFactory.createDessert());
        foodMachine.fillCell(31, desserts, 90);

        List<Pasta> pastas = new ArrayList<>();
        for (int i = 0; i < 4; i++)
            pastas.add(productFactory.createPasta());
        foodMachine.fillCell(32, pastas, 230);

        List<Meat> meats = new ArrayList<>();
        for (int i = 0; i < 4; i++)
            meats.add(productFactory.createMeat());
        foodMachine.fillCell(33, meats, 140);

        return foodMachine;
    }
}
