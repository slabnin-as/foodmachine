package oop.machine;

import oop.bank.Bank;
import oop.factory.FitnessFoodMachineFactory;
import oop.factory.GeneralFoodMachineFactory;
import oop.phone.PhoneServer;

/**
 *
 *
 * @author Burkin A. Yur.
 * @ created 2020-01-16
 */
public class FoodMachineBuilder {


    /*---------------------------BUILDER---------------------------*/


    private static FoodMachineBuilder builder;

    private PhoneServer server;
    private Bank bank;

    private FoodMachineBuilder() {
    }

    public static FoodMachineBuilder createBuilder() {
        builder = new FoodMachineBuilder();
        return builder;
    }

    public FoodMachineBuilder setServer(PhoneServer server) {
        builder.server = server;
        return builder;
    }

    public FoodMachineBuilder setBank(Bank bank) {
        builder.bank = bank;
        return builder;
    }

    public FoodMachine buildGeneral() {
        GeneralFoodMachineFactory factory = new GeneralFoodMachineFactory();
        FoodMachine machine = factory.createFoodMachine();

        machine.setPhoneServer(builder.server);
        machine.setBank(builder.bank);

        return machine;
    }

    public FoodMachine buildFitness() {
        FitnessFoodMachineFactory factory = new FitnessFoodMachineFactory();
        FoodMachine machine = factory.createFoodMachine();

        machine.setPhoneServer(builder.server);
        machine.setBank(builder.bank);

        return machine;
    }
}
