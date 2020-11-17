package oop.factory.product;

import oop.product.bar.Bar;
import oop.product.bar.ProteinBar;
import oop.product.dessert.Cheesecake;
import oop.product.dessert.Dessert;
import oop.product.fruit.Banana;
import oop.product.fruit.Fruit;
import oop.product.meat.ChickenBreast;
import oop.product.meat.Meat;
import oop.product.pasta.Pasta;
import oop.product.pasta.PastaWithVegetables;
import oop.product.porridge.Porridge;
import oop.product.porridge.RicePorridge;
import oop.product.salad.FreshVegetableSalad;
import oop.product.salad.Salad;
import oop.product.shake.ProteinShake;
import oop.product.shake.Shake;
import oop.product.water.StillWater;
import oop.product.water.Water;

/**
 *
 *
 * @author Burkin A. Yur.
 * @ created 2020-01-15
 */
public class FitnessProductFactory implements ProductFactory {


    /*---------------------------SINGLETON---------------------------*/


    private static FitnessProductFactory factory = new FitnessProductFactory();

    private FitnessProductFactory() {}

    public static FitnessProductFactory getInstance() {
        return factory;
    }


    /*---------------------------ABSTRACT FACTORY---------------------------*/


    @Override
    public Water createWater() {
        return new StillWater();
    }

    @Override
    public Bar createBar() {
        return new ProteinBar();
    }

    @Override
    public Salad createSalad() {
        return new FreshVegetableSalad();
    }

    @Override
    public Fruit createFruit() {
        return new Banana();
    }

    @Override
    public Dessert createDessert() {
        return new Cheesecake();
    }

    @Override
    public Porridge createPorridge() {
        return new RicePorridge();
    }

    @Override
    public Meat createMeat() {
        return new ChickenBreast();
    }

    @Override
    public Pasta createPasta() {
        return new PastaWithVegetables();
    }

    @Override
    public Shake createShake() {
        return new ProteinShake();
    }
}
