package oop.machine;

import oop.bank.Card;

import static oop.machine.StateMessage.*;

/**
 *
 *
 * @author Burkin A. Yur.
 * @ created 2020-01-10
 */
public class ProductState extends State {

    ProductState(FoodMachine machine) {
        super(machine);
    }

    @Override
    void chooseProduct(int number) {
        machine.setMessage(CLICK_RESET.getText());
    }

    @Override
    void dropCoin(int cash) {
        machine.increaseSum(cash);

        if (machine.tryToPay()) {
            machine.paymentSuccess();
            machine.setState(new NonProductState(machine));
        } else {
            machine.setMessage(SUM_IS.getText() + " " + machine.getSum());
        }
    }

    @Override
    void activatePaymentCard() {
        machine.setState(new ActivateCardState(machine));
        machine.setMessage(PAY_WITH_CARD.getText());
    }

    @Override
    void touchCard(Card card) {
        machine.setMessage(CARD_IS_NOT_ACTIVATED.getText());
    }
}
