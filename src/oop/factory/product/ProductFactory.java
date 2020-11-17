package oop.factory.product;

import oop.product.bar.Bar;
import oop.product.dessert.Dessert;
import oop.product.fruit.Fruit;
import oop.product.meat.Meat;
import oop.product.pasta.Pasta;
import oop.product.porridge.Porridge;
import oop.product.salad.Salad;
import oop.product.shake.Shake;
import oop.product.water.Water;

/**
 *
 *
 * @author Burkin A. Yur.
 * @ created 2020-01-15
 */
public interface ProductFactory {


    /*---------------------------ABSTRACT FACTORY---------------------------*/


    Water createWater();

    Bar createBar();

    Salad createSalad();

    Fruit createFruit();

    Dessert createDessert();

    Porridge createPorridge();

    Meat createMeat();

    Pasta createPasta();

    Shake createShake();
}
