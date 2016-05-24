# Screen Manipulation

This project demonstrates how to programmatically manipulate screens in [CUBA](https://www.cuba-platform.com) applications.

* `CustomerEdit` screen controller defines dialog options in its `init()` method.

* `CustomerList` is a controller of the simple screen that contains a drop-down list of customers.

* `OrderEdit` screen controller demonstrates two ways of looking up a `Customer`: from a lookup screen and from an arbitrary screen.

    `OrderEdit` also contains `addOrderLine()` method which is invoked by `addOrderLine` action.
The method opens the products lookup screen (`ProductBrowse`) passing a currently selected customer to it. After a user selects a product, the `QuantityDialog` screen is opened for entering product quantity. When the user closes it, a new instance of `OrderLine` entity is created and added to the table.

* `ProductBrowse` screen modifies its datasource query depending on passed customer. If a customer is provided, the table shows only products for this customer and those without reference to a customer.

Based on CUBA Platform 6.1.5