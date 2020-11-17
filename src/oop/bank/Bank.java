package oop.bank;

import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 * @author Burkin A. Yur.
 * @ created 2020-01-13
 */
public class Bank {

    private Map<Card, Integer> amounts;

    public Bank() {
        this.amounts = new HashMap<>();
    }

    public void addCard(Card card, Integer amount) {
        amounts.put(card, amount);
    }

    public boolean withdraw(Card card, int sum) {
        Integer amount = amounts.get(card);

        if (amount == null || amount < sum) return false;

        amounts.put(card, amount - sum);
        return true;
    }
}
