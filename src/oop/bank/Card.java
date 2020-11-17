package oop.bank;

import java.util.Objects;

/**
 *
 *
 * @author Burkin A. Yur.
 * @ created 2020-01-16
 */
public class Card {

    private String number;

    public Card(String number) {
        this.number = number;
    }

    public String getNumber() {
        return this.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        return Objects.equals(number, card.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
