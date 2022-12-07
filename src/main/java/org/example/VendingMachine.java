package org.example;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VendingMachine {

    private HashMap<String, Integer> stock;
    private HashMap<String, Item> products;
    private Integer balance;

    /**
     * A vending machine has a stock that tells you how many items you have from each product
     * It also has "products" which is basically the selection you can make
     */
    public VendingMachine() {
        products = new HashMap<>();
        products.put("Cola", new Item("Cola", 200));
        products.put("Fanta", new Item("Fanta", 200));
        products.put("Jupiler", new Item("Jupiler", 300));
        this.stock = new HashMap<>();
        this.resetMachine();
    }

    public Boolean inStock(String product) {

        return this.getStock(product) > 0 ? true : false;
    }

    public HashMap<String, Item> getProducts() {
        return this.products;
    }

    public List<String> getInStockProductArray() {
        List<String> result = new ArrayList<>();
        for (String product : stock.keySet()) {
            if (stock.get(product) > 0) {
                result.add(product);
            }
        }
        return result;
    }

    /**
     * resetMachine sets the machine to it's original state
     * This is the state when someone passed by to give it maintenance
     * Stock is refilled and any change is collected as bonus for the maintainer
     * Products remain the same
     */
    public void resetMachine() {
        this.stock.clear();
        this.balance = 0;
        for (Item item:products.values()) this.stock.put(item.getName(), 3);
    }

    public Integer getBalance() {
        return balance;
    }

    public Integer getPrice(String name) {
        return products.get(name).getPrice();
    }

    public Integer getStock(String name) {
        return stock.getOrDefault(name,0);
    }

    public void insertMoney(Integer i) {
        if( i > 0 )
            this.balance = this.balance + i;
    }

    private void deductMoney(Integer i) {
        balance -= i;
    }

    public Boolean buyProduct(String name) {
        if (!products.containsKey(name)) return false;
        if (stock.get(name) < 1) return false;
        if (this.balance >= this.products.get(name).getPrice()) {
            this.deductMoney(this.products.get(name).getPrice());
            this.stock.put(name, stock.get(name)-1);
            return true;
        }
        return false;
    }

    public Integer askChange() {
        Integer change = this.balance;
        this.balance = 0;
        return change;
    }

}
