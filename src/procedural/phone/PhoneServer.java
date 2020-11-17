package procedural.phone;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * @author Burkin A. Yur.
 * @ created 2020-01-14
 */
public class PhoneServer {

    private List<Phone> phones;

    public PhoneServer() {
        this.phones = new ArrayList<>();
    }

    public void addPhone(Phone phone) {
        phones.add(phone);
    }

    /**
     * Отправка push-уведомлений
     * @param message сообщение
     */
    public void sendPush(String message) {
        for (Phone phone : phones)
            phone.pushNotification(message);
    }
}
