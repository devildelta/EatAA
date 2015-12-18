package org.eataa;

import java.util.ArrayList;

public class OrderList {
    public ArrayList<OrderedMenuItem> items;
    public OrderList() {
        items = new ArrayList<OrderedMenuItem>();
    }
    public void addItem(MenuItem i, float qty) {
        items.add(new OrderedMenuItem(i, qty));
    }
    public void removeItem(OrderedMenuItem i) {
        items.remove(i);
    }
    public float getCost() {
        float coat = 0.0;
        for(Iterator it=items.iterator(); it.hasNext();) {
            OrderedMenuItem i = (OrderedMenuItem) it.next();
            cost += (i.orderedQty * i.cost);
        }
        return cost;
    }
    public static class OrderedMenuItem extends MenuItem {
        public float orderedQty;
        public float arrivedQty;
        public OrderedMenuItem(MenuItem i, float qty) {
            super(i);
            orderedQty = qty;
            arrivedQty = 0.0;
        }
    }
}
