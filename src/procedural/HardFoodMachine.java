package procedural;

import procedural.phone.PhoneServer;

import static procedural.StateMessage.*;

/**
 *  [11, 12, 13]
 *  [21, 22, 23]
 *  [31, 32, 33]
 *
 * @author Burkin A. Yur.
 * @ created 2020-01-09
 */
public class HardFoodMachine {

    public static final String GENERAL = "GENERAL";
    public static final String WEEKEND = "WEEKEND";

    private Cell[] cells = new Cell[9];

    private int cell = -1;
    private int sum;
    private boolean isActive;

    private String message;

    private PhoneServer server;

    public HardFoodMachine() {
        cells[0] = new Cell("Вода без газа", 50);
        cells[1] = new Cell("Печенье с изюмом", 60);
        cells[2] = new Cell("Кисель вишневый", 70);
        cells[3] = new Cell("Молочный шоколад", 80);
        cells[4] = new Cell("Ассорти орехов", 90);
        cells[5] = new Cell("Бутерброд с ветчиной", 100);
        cells[6] = new Cell("Картофель с котлетой", 110);
        cells[7] = new Cell("Бургер с курицей", 120);
        cells[8] = new Cell("Салат с креветками", 130);

        message = CHOOSE_PRODUCT.getText();
    }

    public Cell[] getCells() {
        return cells;
    }

    public void chooseProduct(int number) {
        if (cell != -1) {
            message = CLICK_RESET.getText();
        } else {
            int row = number / 10;
            int pos = number % 10;

            if (row > 3 || pos > 3) {
                message = CHOOSE_ANOTHER_PRODUCT.getText();
            } else {
                int cell = 3 * (row - 1) + (pos - 1);
                if (cells[cell].isEmpty()) {
                    message = CHOOSE_ANOTHER_PRODUCT.getText();
                } else {
                    this.cell = cell;
                    message = PAY_PRODUCT.getText();
                }
            }
        }
    }

    public void dropCoin(int cash) {
        this.sum += cash;

        if (cell == -1) {
            message = PRODUCT_IS_NOT_SELECTED.getText();
        } else {
            if (this.sum >= cells[cell].getPrice()) {
                cells[cell].removeProduct();
                this.sum -= cells[cell].getPrice();

                message = cells[cell].getName() + "\n";
                message += REMAINS.getText() + " " + this.sum;

                reset();
            } else {
                message = SUM_IS.getText() + " " + this.sum;
            }
        }
    }

    public void activateCard() {
        if (cell == -1) {
            message = PRODUCT_IS_NOT_SELECTED.getText();
        } else {
            isActive = true;
            message = PAY_WITH_CARD.getText();
        }
    }

    public void touchCard() {
        if (!isActive) {
            message = CARD_IS_NOT_ACTIVATED.getText();
        } else {
            cells[cell].removeProduct();
            message = cells[cell].getName();
            message += "\n" + REMAINS.getText() + " ";
            message += sum;

            reset();
        }
    }

    public void reset() {
        cell = -1;
        sum = 0;
        isActive = false;
    }

    public void cancel() {
        String s = "";

        if (sum != 0) {
            s += REMAINS.getText() + " " + sum;
        }
        s += "\n" + CHOOSE_PRODUCT.getText();
        message = s;

        sum = 0;
        cell = -1;
    }

    public String getMessage() {
        return message;
    }

    public int getSum() {
        return sum;
    }

    public void setPhoneServer(PhoneServer server) {
        this.server = server;
    }

    public void makeDiscount(String title, String type, boolean isSale) {
        int i = 0;

        while (i < cells.length) {
            Cell cell = cells[i];
            if (cell.getName().equals(title))
                break;

            i++;
        }

        if (i < cells.length) {
            int percent = 0;
            switch (type) {
                case GENERAL:
                    percent = isSale ? 2 * 10 : 10;
                    break;
                case WEEKEND:
                    percent = isSale ? 2 * 30 : 30;
            }

            int newPrice = (int)(cells[i].getPrice() / 100.0 * (100 - percent));
            cells[i].setPrice(newPrice);

            String message = title + " теперь стоит " + newPrice;
            server.sendPush(message);
        }
    }
}
