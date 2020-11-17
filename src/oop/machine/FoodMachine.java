package oop.machine;

import oop.bank.Bank;
import oop.bank.Card;
import oop.discount.DiscountStrategy;
import oop.discount.GeneralDiscountStrategy;
import oop.phone.Phone;
import oop.phone.PhoneServer;
import oop.product.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static oop.machine.StateMessage.CHOOSE_PRODUCT;
import static oop.machine.StateMessage.REMAINS;

/**
 *  [11, 12, 13]
 *  [21, 22, 23]
 *  [31, 32, 33]
 *
 * @author Burkin A. Yur.
 * @ created 2020-01-09
 */
public class FoodMachine implements Iterable<Cell> {

    private State state;

    private Cell[] cells;
    private int selectedCell = -1;
    private int sum;
    private List<Product> basket;

    private String message;

    private List<String> phones;

    private PhoneServer server;
    private Bank bank;

    private DiscountStrategy discountStrategy;

    FoodMachine() {
        state = new NonProductState(this);

        cells = new Cell[9];
        for (int i = 0; i < cells.length; i++) {
            cells[i] = new Cell();
        }

        basket = new ArrayList<>();

        message = CHOOSE_PRODUCT.getText();

        phones = new ArrayList<>();

        discountStrategy = new GeneralDiscountStrategy();
    }

    public int getSum() {
        return sum;
    }

    public String getMessage() {
        return message;
    }

    void setMessage(String message) {
        this.message = message;
    }

    public void fillCell(int number, List<? extends Product> products, int price) {
        Cell cell = cells[Cell.formatCell(number)];

        while (!products.isEmpty() && !cell.isFull()) {
            int last = products.size() - 1;
            cell.addProduct(products.remove(last));
        }

        cell.setPrice(price);
    }

    /**
     * Забрать продукты
     * @return список продуктов
     */
    public List<Product> takeProducts() {
        List<Product> products = new ArrayList<>(basket);
        basket.clear();

        return products;
    }

    void setBank(Bank bank) {
        this.bank = bank;
    }


    /*---------------------------STATE---------------------------*/


    void setState(State state) {
        this.state = state;
    }

    boolean tryChooseProduct(int number) {
        int cell = Cell.formatCell(number);

        if (cells[cell].isEmpty()) return false;

        selectedCell = cell;
        return true;
    }

    void increaseSum(int cash) {
        this.sum += cash;
    }

    boolean tryToPay() {
        int price = cells[selectedCell].getPrice();

        if (sum < price) return false;

        sum -= price;
        return true;
    }

    boolean tryToPay(Card card) {
        int price = cells[selectedCell].getPrice();

        return bank.withdraw(card, price);
    }

    void paymentSuccess() {
        Product product = removeProduct();
        basket.add(product);

        StringBuilder sb = new StringBuilder();
        sb.append(product.getTitle());
        sb.append("\n");
        sb.append(REMAINS.getText());
        sb.append(" ");
        sb.append(sum);
        setMessage(sb.toString());
        reset();
    }

    private Product removeProduct() {
        return cells[selectedCell].isEmpty() ? null : cells[selectedCell].removeProduct();
    }

    void reset() {
        sum = 0;
        selectedCell = -1;
    }

    /**
     * Выбрать продукт
     * @param number номер ячейки
     */
    public void chooseProduct(int number) {
        state.chooseProduct(number);
    }

    /**
     * Опустить наличные
     * @param sum сумма
     */
    public void dropCoin(int sum) {
        state.dropCoin(sum);
    }

    /**
     * Активировать карту
     */
    public void activateCard() {
        state.activatePaymentCard();
    }

    /**
     * Расплатиться картой
     */
    public void touchCard(Card card) {
        state.touchCard(card);
    }

    /**
     * Отмена
     */
    public void cancel() {
        StringBuilder sb = new StringBuilder();

        if (sum != 0) {
            sb.append(REMAINS.getText());
            sb.append(" ");
            sb.append(sum);
        }
        sb.append("\n");
        sb.append(CHOOSE_PRODUCT.getText());
        setMessage(sb.toString());

        sum = 0;
        selectedCell = -1;

        setState(new NonProductState(this));
    }


    /*---------------------------OBSERVER---------------------------*/


    void setPhoneServer(PhoneServer server) {
        this.server = server;
    }

    public void makeDiscount(String title) {
        Cell cell = lookupCell(title);

        if (cell != null) {
            int newPrice = discountStrategy.make(cell);

            cell.setPrice(newPrice);

            String message = title + " теперь стоит " + newPrice;
            notifySubscribers(message);
        }
    }

    private Cell lookupCell(String title) {
        if (title == null) return null;

        for (Cell cell : this)
            if (title.equals(cell.getProductName()))
                return cell;

        return null;
    }

    public void subscribe(String phoneNumber) {
        if (phoneNumber == null)
            throw new IllegalArgumentException("phoneNumber must be not null");

        phones.add(phoneNumber);
    }

    public boolean unsubscribe(Phone phone) {
        return phones.remove(phone);
    }

    private void notifySubscribers(String message) {
        server.sendPush(message, new ArrayList<>(this.phones));
    }


    /*---------------------------STRATEGY---------------------------*/


    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }


    /*---------------------------ITERATOR---------------------------*/


    @Override
    public Iterator<Cell> iterator() {
        return new Iterator<Cell>() {

            private int next = 0;

            @Override
            public boolean hasNext() {
                return next < cells.length;
            }

            @Override
            public Cell next() {
                return cells[next++];
            }
        };
    }
}
