/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;
import model.Item;

/**
 *
 * @author phamd
 */
public class Cart {

    private List<Item> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Item getItemByProductID(int id) {
        for (Item i : items) {
            if (i.getProduct().getId() == id) {
                return i;
            }
        }
        return null;
    }

    public int getQuantityByProductID(int id) {
        return getItemByProductID(id).getQuanlity();
    }

    public void addItemstToCart(Item t) {
        if (getItemByProductID(t.getProduct().getId()) != null) {
            Item m = getItemByProductID(t.getProduct().getId());
            m.setQuanlity(m.getQuanlity() + t.getQuanlity());
        } else {
            items.add(t);
        }
    }

    public void removeItemFromCart(int id) {
        if (getItemByProductID(id) != null) {
            items.remove(getItemByProductID(id));
        }
    }

    public double getTotalPrice() {
        double t = 0;
        for (Item i : items) {
            t += (i.getQuanlity() * i.getProduct().getPrice());
        }
        return t;
    }
}
