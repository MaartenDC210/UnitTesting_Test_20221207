package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestStock {

    private final VendingMachine machine = new VendingMachine();

    @Test
    public void testExistingProductStock() {
        machine.resetMachine();
        assertTrue(machine.inStock("Cola"));
    }

    @Test
    public void testFalseProductStock() {
        machine.resetMachine();
        assertFalse(machine.inStock("Wine"));
    }

    @Test
    public void testEmptyStock() {
        machine.resetMachine();
        TestHelpers.buyCola(machine, 10);
        assertFalse(machine.inStock("Cola"));
    }

    @Test
    public void testSingleBuy() {
        machine.resetMachine();
        machine.insertMoney(1000);
        machine.buyProduct("Cola");
        assertTrue(machine.inStock("Cola"));
    }

    @Test
    public void testBuyHasNoImpactOnOtherProducts() {
        machine.resetMachine();
        TestHelpers.buyCola(machine, 10);
        assertTrue(machine.inStock("Fanta"));
        assertTrue(machine.inStock("Jupiler"));
    }




}
