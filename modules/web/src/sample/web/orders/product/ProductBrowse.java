/*
 * TODO Copyright
 */

package sample.web.orders.product;

import sample.entity.orders.Customer;
import sample.entity.orders.Product;
import com.haulmont.cuba.gui.WindowParam;
import com.haulmont.cuba.gui.components.AbstractLookup;
import com.haulmont.cuba.gui.data.CollectionDatasource;

import javax.inject.Inject;
import java.util.Map;
import java.util.UUID;

public class ProductBrowse extends AbstractLookup {

    // Customer passed to the screen from invoking code.
    // This is the same as getting the parameter in init() method
    @WindowParam
    private Customer customer;

    @Inject
    private CollectionDatasource<Product, UUID> productsDs;

    @Override
    public void init(Map<String, Object> params) {
        if (customer != null) {
            // Show Products for this Customer and those without reference to a Customer
            productsDs.setQuery(
                    "select e from sample$Product e left join e.customer c " +
                    "where c.id = :param$customer or c is null");
        }
    }
}