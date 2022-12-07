package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestBalance {

    private final VendingMachine machine = new VendingMachine();

    @Test
    public void getEmptyBalance() {
        machine.resetMachine();
        assertTrue(machine.getBalance() == 0);
    }

    @Test
    public void testAddMoneyOnce() {
        machine.resetMachine();
        machine.insertMoney(100);
        assertTrue(machine.getBalance() == 100);
    }

    @Test
    public void testAddMoneyMultiple() {
        machine.resetMachine();
        machine.insertMoney(100);
        machine.insertMoney(300);
        assertTrue(machine.getBalance() == 400);
    }

    @Test
    public void testNegativeMoney() {
        machine.resetMachine();
        machine.insertMoney(-100);
        assertTrue(machine.getBalance() == 0);
    }


    @Test
    public void testAskChange() {
        machine.resetMachine();
        machine.insertMoney(200);
        assertEquals(machine.askChange(), 200);
    }

    @Test
    public void testAskChangeTwice() {
        machine.resetMachine();
        machine.insertMoney(100);
        machine.askChange();
        assertEquals(machine.askChange(), 0);
    }

    @Test
    public void testAskChangeAfterBuy() {
        machine.resetMachine();
        machine.insertMoney(300);
        machine.buyProduct("Cola");
        assertEquals(machine.askChange(), 100);
    }
}
