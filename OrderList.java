package org.eataa;

public class OrderList {
    public ArrayList<OrderedMenuItem> items;

    public static class OrderedMenuItem extends MenuItem {
        // decimal Qty for combined orders
        public float orderedQty;
        public float arrivedQty;
        public OrderedMenuItem(MenuItem i, float qty) {
            super(i);
            this.orderedQty = qty;
            this.arrivedQty = 0.0;
        }
    }
    
    public void addItem(MenuItem i, float qty) {
        items.add(new OrderedMenuItem(i, qty));
    }

    public float getCost() {
        float cost = 0.0;
        for(Iterator it = items.iterator(); it.hasNext();) {
            Object i = it.next();
            cost += (i.cost * i.orderedQty);
        }
        return cost;
    }

}
