package oop.factory.product;

import oop.product.bar.Bar;
import oop.product.bar.ChocolateBar;
import oop.product.dessert.Dessert;
import oop.product.dessert.Doughnut;
import oop.product.fruit.Fruit;
import oop.product.fruit.StrawberryWithCream;
import oop.product.meat.Cutlet;
import oop.product.meat.Meat;
import oop.product.pasta.Carbonara;
import oop.product.pasta.Pasta;
import oop.product.porridge.Porridge;
import oop.product.porridge.PorridgeWithJam;
import oop.product.salad.DressedHerring;
import oop.product.salad.Salad;
import oop.product.shake.MilkShake;
import oop.product.shake.Shake;
import oop.product.water.SodaWater;
import oop.product.water.Water;

/**
 *
 *
 * @author Burkin A. Yur.
 * @ created 2020-01-15
 */
public class GeneralProductFactory implements ProductFactory {


    /*---------------------------SINGLETON---------------------------*/


    private static GeneralProductFactory factory = new GeneralProductFactory();

    private GeneralProductFactory() {}

    public static GeneralProductFactory getInstance() {
        return factory;
    }


    /*---------------------------ABSTRACT FACTORY---------------------------*/


    @Override
    public Water createWater() {
        return new SodaWater();
    }

    @Override
    public Bar createBar() {
        return new ChocolateBar();
    }

    @Override
    public Salad createSalad() {
        return new DressedHerring();
    }

    @Override
    public Fruit createFruit() {
        return new StrawberryWithCream();
    }

    @Override
    public Dessert createDessert() {
        return new Doughnut();
    }

    @Override
    public Porridge createPorridge() {
        return new PorridgeWithJam();
    }

    @Override
    public Meat createMeat() {
        return new Cutlet();
    }

    @Override
    public Pasta createPasta() {
        return new Carbonara();
    }

    @Override
    public Shake createShake() {
        return new MilkShake();
    }
}
