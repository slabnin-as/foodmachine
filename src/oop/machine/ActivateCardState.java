package oop.machine;

import oop.bank.Card;

import static oop.machine.StateMessage.*;

/**
 *
 *
 * @author Burkin A. Yur.
 * @ created 2020-01-10
 */
public class ActivateCardState extends State {

    ActivateCardState(FoodMachine machine) {
        super(machine);
    }

    @Override
    void chooseProduct(int number) {
        machine.setMessage(CLICK_RESET.getText());
    }

    @Override
    void dropCoin(int cash) {
        machine.increaseSum(cash);
    }

    @Override
    void activatePaymentCard() {
        machine.setMessage(PAY_WITH_CARD.getText());
    }

    @Override
    void touchCard(Card card) {
        if (machine.tryToPay(card)) {
            machine.paymentSuccess();
            machine.setState(new NonProductState(machine));
        } else {
            machine.setMessage(NON_SUFFICIENT_FUNDS.getText());
        }
    }
}
