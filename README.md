# Screen Manipulation

This project demonstrates some aspects of working with UI screens in CUBA applications and consists of two parts: 

1. Programmatic manipulation with screens. 

2. Working with deeply nested structures of entities.

## Programmatic manipulation

* [CustomerEdit](https://github.com/cuba-platform/sample-screen-manipulation/blob/master/modules/web/src/sample/web/orders/customer/CustomerEdit.java) screen controller defines some dialog options in its `init()` method.

* [customer-browse.xml](https://github.com/cuba-platform/sample-screen-manipulation/blob/master/modules/web/src/sample/web/orders/customer/customer-browse.xml) screen has a simple custom filter instead of default generic filter component. It is based on the datasource's [query filter](https://doc.cuba-platform.com/manual-latest/datasource_query_filter.html) feature.

* [CustomerList](https://github.com/cuba-platform/sample-screen-manipulation/blob/master/modules/web/src/sample/web/orders/customer/CustomerList.java) is a controller of a simple screen that contains a drop-down list of customers. It is invoked by the `selectCustomerFromSimpleScreen()` method of the [OrderEdit](https://github.com/cuba-platform/sample-screen-manipulation/blob/master/modules/web/src/sample/web/orders/order/OrderEdit.java) controller.

* [OrderEdit](https://github.com/cuba-platform/sample-screen-manipulation/blob/master/modules/web/src/sample/web/orders/order/OrderEdit.java) screen controller demonstrates two ways of looking up a `Customer`: from a lookup screen and from an arbitrary screen.

    OrderEdit also contains `addOrderLine()` method which is invoked by `addOrderLine` action. The method opens a products lookup screen passing a currently selected customer to it. After a user selects a product, the [QuantityDialog](https://github.com/cuba-platform/sample-screen-manipulation/blob/master/modules/web/src/sample/web/orders/order/QuantityDialog.java) screen is opened for entering product quantity. When the user closes it, a new instance of `OrderLine` entity is created and added to the table.

* [ProductBrowse](https://github.com/cuba-platform/sample-screen-manipulation/blob/master/modules/web/src/sample/web/orders/product/ProductBrowse.java) screen modifies its datasource query depending on passed customer. If a customer is provided, the table shows only products for this customer and those without reference to a customer.

## Deeply nested structures

Editing of nested entity structures can be implemented with the help of the CUBA [compositions](https://doc.cuba-platform.com/manual-latest/composition_recipe.html) feature.

### One level of nesting

Let's start from a not particularly deep structure: an **Airport** and its **Terminals**. Studio can implement editing of such structure automatically if you define the relation as COMPOSITION (see the [Airport](https://github.com/cuba-platform/sample-screen-manipulation/blob/master/modules/global/src/sample/entity/airports/Airport.java) entity). The inner working is explained in the [documentation](https://doc.cuba-platform.com/manual-latest/composition_impl_recipe.html), so we will not dwell on it.   

### Two levels of nesting

Let's add an entity to the bottom level, so the structure will look as follows: **Airport > Terminal > Meeting Point**. A meeting point is a location at the terminal where a taxi can pick you up, and you may want to edit it together with the terminal and the airport. So make the relation between the terminal and meeting points a COMPOSITION, and Studio will again do the most of the work when you create an editor screen for terminal - it will automatically include the table of meeting points.

But, as described in the [Deep Composition](https://doc.cuba-platform.com/manual-latest/composition_deep_recipe.html) section, in order to edit terminals and meeting points together with the airport, you have to do the following things manually:

1. In the airport view that is used in the airport editor, define loading of the whole structure, i.e. terminals and nested meeting points. See [airport-terminals-meetingPoints-view](https://github.com/cuba-platform/sample-screen-manipulation/blob/207de471a3e099be373c8f132caddf9c03f6e020/modules/global/src/sample/views.xml#L59-L64).

2. In the airport editor, define an additional nested datasource for meeting points. It is not connected to visual components, but used for saving data received from nested editor screens. See [airport-edit.xml](https://github.com/cuba-platform/sample-screen-manipulation/blob/master/modules/web/src/sample/web/airports_1/airport/airport-edit.xml). 

The whole structure of screens for this case is located in the `sample.web.airports_1` package of the `web` module and is available via the *Airports > Airports (1)* menu item in the running application.

### Three levels of nesting

Imagine that you need an additional entity that contains some details of the meeting point: **Note**. So the whole structure looks as follows: **Airport > Terminal > Meeting Point > Note**. 

CUBA can handle compositions with up to 2 levels of nesting. Here we have 3 levels, so we should limit the depth either from the top or from the bottom. Below we consider two different approaches (from the user experience perspective) of excluding the airport from the composition. Both of them solve the same problem: as now terminals are saved to the database independently from the airport, you cannot save a terminal for a newly created airport which is not saved to the database yet. 
 
1. In the first approach, the airport browser and editor look the same as above, but the editor has additional *Save* button to save a new airport without closing the screen. A user cannot create terminals until the new airport is saved. 

    See the source code in the `sample.web.airports_2` package and working screens in the *Airports > Airports (2)* menu item of the running application. Consider the following source code elements:

    * [airport-edit.xml](https://github.com/cuba-platform/sample-screen-manipulation/blob/master/modules/web/src/sample/web/airports_2/airport/airport-edit.xml) contains a standalone datasource for terminals instead of the nested one. This standalone datasource is linked to the airport datasource and thus loads terminals for the edited airport. Besides, airport editor contains `extendedEditWindowActions` frame which allows a user to save airport without closing the screen. 
    
    * In the `postInit()` method of the [AirportEdit](https://github.com/cuba-platform/sample-screen-manipulation/blob/master/modules/web/src/sample/web/airports_2/airport/AirportEdit.java) controller, we manage the `enabled` state of the terminal's *Create* action and pass the current airport instance to initialize the `airport` attribute of a created terminal.
        
2. In the second approach, we have split the airport browser into two panels: one for the list of airports and another for the dependent list of terminals. That is the list of terminals is now outside of the airport editor. The terminal's *Create* action is disabled until an airport is selected.

    See the source code in the `sample.web.airports_3` package and working screens in the *Airports > Airports (3)* menu item of the running application. Consider the following source code elements:
    
    * [airport-browse.xml](https://github.com/cuba-platform/sample-screen-manipulation/blob/master/modules/web/src/sample/web/airports_3/airport/airport-browse.xml) contains a standalone datasource for the list of terminals. It is linked to the airports datasource and thus loads terminals for a selected airport. 

    * In the `init()` method of the [AirportBrowse](https://github.com/cuba-platform/sample-screen-manipulation/blob/master/modules/web/src/sample/web/airports_3/airport/AirportBrowse.java) controller, we manage the `enabled` state of the terminal's *Create* action and pass the currently selected airport instance to initialize the `airport` attribute of a created terminal.

Based on CUBA Platform 6.4.1
