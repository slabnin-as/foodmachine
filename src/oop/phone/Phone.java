package oop.phone;

/**
 *
 *
 * @author Burkin A. Yur.
 * @ created 2020-01-14
 */
public class Phone {

    private String number;
    private String screenText;

    public Phone(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getScreenText() {
        return screenText;
    }

    public void pushNotification(String message) {
        screenText = message;
    }
}
