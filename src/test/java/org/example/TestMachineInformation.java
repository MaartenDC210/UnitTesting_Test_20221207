package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestMachineInformation {

    private final VendingMachine machine = new VendingMachine();

    @Test
    public void testGetProducts() {
        machine.resetMachine();
        HashMap<String, Item> products = machine.getProducts();
        assertTrue(products.containsKey("Cola"));
        assertTrue(products.containsKey("Fanta"));
        assertTrue(products.containsKey("Cola"));
    }

    @Test
    public void testAvailableProducts() {
        machine.resetMachine();
        machine.insertMoney(1000);
        TestHelpers.buyCola(machine, 10);
        List<String> stock = machine.getInStockProductArray();
        for (String s : stock) {
            assertFalse(s.equals("Cola"));
        }
    }

}
