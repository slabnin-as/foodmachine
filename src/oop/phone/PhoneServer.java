package oop.phone;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 *
 * @author Burkin A. Yur.
 * @ created 2020-01-14
 */
public class PhoneServer {

    private Map<String, Phone> phones;

    public PhoneServer() {
        this.phones = new HashMap<>();
    }

    public void addPhone(String number, Phone phone) {
        phones.put(number, phone);
    }

    /**
     * Пакетная отправка push-уведомлений
     * @param message сообщение
     * @param numbers номера телефонов
     */
    public void sendPush(String message, List<String> numbers) {
        for (String number : numbers) {
            Phone phone = phones.get(number);
            phone.pushNotification(message);
        }
    }
}
