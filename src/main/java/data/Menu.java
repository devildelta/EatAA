package org.eataa;

import java.util.List;
import java.util.Map;

public class Menu {
    // place / restaurant
    public String name;
    //{ <category>: [<item>, <item>, ...] }
    public Map<String, List<MenuItem>> category;
    public MenuData() {}

    public static class MenuItem {
        public String id;
        public String name;
        public float cost;
        public MenuItem(MenuItem i) {
            this.id   = i.id;
            this.name = i.name;
            this.cost = i.cost;
        }
    }
}
