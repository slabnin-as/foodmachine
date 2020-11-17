package oop.machine;

/**
 *
 *
 * @author Burkin A. Yur.
 * @ created 2020-01-12
 */
public enum StateMessage {

    PRODUCT_IS_NOT_SELECTED("Продукт не выбран"),
    CHOOSE_PRODUCT("Выберите продукт"),
    CHOOSE_ANOTHER_PRODUCT("Выберите другой продукт"),
    CLICK_RESET("Нажмите reset для выбора нового продукта"),
    PAY_PRODUCT("Оплатите продукт"),
    CARD_IS_NOT_ACTIVATED("Оплата картой не активирована"),
    PAY_WITH_CARD("Приложите карту"),
    NON_SUFFICIENT_FUNDS("Недостаточно средств"),
    SUM_IS("Сумма:"),
    REMAINS("Сдача:");

    private String text;

    StateMessage(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
