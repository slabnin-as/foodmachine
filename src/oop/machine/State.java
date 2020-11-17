package oop.machine;

import oop.bank.Card;

/**
 *
 *
 * @author Burkin A. Yur.
 * @ created 2020-01-10
 */
public abstract class State {

    FoodMachine machine;

    State(FoodMachine machine) {
        this.machine = machine;
    }

    abstract void chooseProduct(int number);

    abstract void dropCoin(int cash);

    abstract void activatePaymentCard();

    abstract void touchCard(Card card);
}
