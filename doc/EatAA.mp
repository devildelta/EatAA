input metauml;
beginfig(1);
% external classes
Class.RoboActivity("RoboActivity")()();
Class.RoboFragment("RoboFragment")()();
Class.FragmentPagerAdaptor("FragmentPagerAdaptor")()();
% view classes
Class.Main("Main")("pager:ViewPager")();
Class.Aggregator("Aggregator")("pager:ViewPager")();
Class.AAPagerAdaptor("AAPagerAdaptor")("fragments:ArrayList<AAFragment>")();
Class.AAFragment("AAFragment")()("getTitle():String");
Class.MenusFragment("MenusFragment")()();
Class.ConnectFragment("ConnectFragment")()();
Class.AggregrateFragment("AggregrateFragment")()();
Class.ClientFragment("ClientFragment")()();
Class.MenuBuilder("MenuBuilder")()();
Class.AAClient("AAClient")()();
% logic classes
Class.MenuLoader("MenuLoader")(
        "menus:ArrayList<MenuData>")();
Class.ConnectManager("ConnectManager")()();
% position
leftToRight(60)(RoboActivity, Main, AAPagerAdaptor, AAFragment, MenusFragment);
topToBottom.left(40)(Main, Aggregator, MenuBuilder, AAClient);
topToBottom(40)(FragmentPagerAdaptor, AAPagerAdaptor);
topToBottom(40)(RoboFragment, AAFragment);
topToBottom.left(40)(MenusFragment, ConnectFragment, AggregrateFragment, ClientFragment);
leftToRight(40)(MenuBuilder, MenuLoader);
leftToRight(120)(AAClient, ConnectManager);

% draw
drawObjects(RoboActivity, Main, AAPagerAdaptor, AAFragment,
        Aggregator, MenuBuilder, AAClient,
        FragmentPagerAdaptor, RoboFragment,
        MenusFragment, ConnectFragment, AggregrateFragment, ClientFragment,
        MenuBuilder, AAClient, MenuLoader, ConnectManager);

% external links
link(inheritance)(RoboActivity.e -- Main.w);
link(inheritance)(RoboActivity.e -- Aggregator.nw);
link(inheritance)(RoboActivity.se -- MenuBuilder.nw);
link(inheritance)(RoboActivity.se -- AAClient.nw);
link(inheritance)(FragmentPagerAdaptor.s -- AAPagerAdaptor.n);
link(inheritance)(RoboFragment.s -- AAFragment.n);
% links
link(composition)(Main.e -- AAPagerAdaptor.w);
link(composition)(Aggregator.e -- AAPagerAdaptor.sw);
link(association)(AAPagerAdaptor.e -- AAFragment.w);
item(iAssoc)("1")(obj.nw = AAPagerAdaptor.e);
item(iAssoc)("1..*")(obj.ne = AAFragment.w);
link(inheritance)(AAFragment.e -- MenusFragment.w);
link(inheritance)(AAFragment.e -- ConnectFragment.nw);
link(inheritance)(AAFragment.se -- AggregrateFragment.nw);
link(inheritance)(AAFragment.se -- ClientFragment.nw);
link(dependency)(MenuBuilder.e -- MenuLoader.w);
link(dependency)(MenusFragment.sw -- MenuLoader.ne);
link(dependency)(AAClient.e -- ConnectManager.w);
link(dependency)(ConnectFragment.sw -- ConnectManager.ne);
link(dependency)(AggregrateFragment.sw -- ConnectManager.e);

endfig;
beginfig(2);
% data classes
Class.Menu("Menu")(
        "+name:String",
        "+category:Map<String, List<MenuItem>>")();
Class.MenuItem("MenuItem")(
        "+id:String",
        "+name:String",
        "+cost:float")();
Class.OrderList("OrderList")(
        "items:ArrayList<OrderedMenuItem>")(
        "addItem(i:MenuItem, qty:float)",
        "removeItem(i:OrderedMenuItem)",
        "getCost():float");
Class.OrderedMenuItem("OrderedMenuItem")(
        "orderedQty:float",
        "arrivedQty:float")();
% position
leftToRight(140)(MenuItem, OrderedMenuItem);
topToBottom(40)(MenuItem, Menu);
topToBottom(40)(OrderedMenuItem, OrderList);
drawObjects(MenuItem, OrderedMenuItem, Menu, OrderList);
% links
link(inheritance)(MenuItem.e -- OrderedMenuItem.w);
link(association)(MenuItem.s -- Menu.n);
item(iAssoc)("0..*")(obj.nw = MenuItem.s);
item(iAssoc)("1")(obj.sw = Menu.n);
link(association)(OrderedMenuItem.s -- OrderList.n);
item(iAssoc)("0..*")(obj.nw = OrderedMenuItem.s);
item(iAssoc)("1")(obj.sw = OrderList.n);
endfig;
end


