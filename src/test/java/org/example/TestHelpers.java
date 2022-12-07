package org.example;

public class TestHelpers {


    public static void buyCola(VendingMachine machine, Integer limit) {
        int failsafe = 0;
        while (failsafe++ < limit) {
            machine.insertMoney(machine.getProducts().get("Cola").getPrice());
            machine.buyProduct("Cola");
        }
    }

}
