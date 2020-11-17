package oop.machine;

import oop.bank.Card;

import static oop.machine.StateMessage.*;

/**
 *
 *
 * @author Burkin A. Yur.
 * @ created 2020-01-10
 */
public class NonProductState extends State {

    NonProductState(FoodMachine machine) {
        super(machine);
    }

    @Override
    void chooseProduct(int number) {
        if (machine.tryChooseProduct(number)) {
            machine.setState(new ProductState(machine));
            machine.setMessage(PAY_PRODUCT.getText());
        } else {
            machine.setMessage(CHOOSE_ANOTHER_PRODUCT.getText());
        }
    }

    @Override
    void dropCoin(int cash) {
        machine.setMessage(PRODUCT_IS_NOT_SELECTED.getText());
        machine.increaseSum(cash);
    }

    @Override
    void activatePaymentCard() {
        machine.setMessage(PRODUCT_IS_NOT_SELECTED.getText());
    }

    @Override
    void touchCard(Card card) {
        machine.setMessage(CARD_IS_NOT_ACTIVATED.getText());
    }
}
