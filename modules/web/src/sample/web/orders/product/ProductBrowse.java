package sample.web.orders.product;

import com.haulmont.cuba.gui.components.Filter;
import com.haulmont.cuba.security.entity.FilterEntity;
import sample.entity.orders.Customer;
import sample.entity.orders.Product;
import com.haulmont.cuba.gui.WindowParam;
import com.haulmont.cuba.gui.components.AbstractLookup;
import com.haulmont.cuba.gui.data.CollectionDatasource;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ProductBrowse extends AbstractLookup {

    // Customer passed to the screen from invoking code.
    @WindowParam
    private Customer customer;

    // A list of product IDs already added to an order.
    @WindowParam
    private List<UUID> added;

    @Inject
    private CollectionDatasource<Product, UUID> productsDs;

    @Inject
    private Filter filter;

    @Override
    public void init(Map<String, Object> params) {
        if (customer != null) {
            // Show Products for this Customer and those without reference to a Customer
            productsDs.setQuery(
                    "select e from sample$Product e left join e.customer c " +
                    "where c.id = :param$customer or c is null");
        }
    }

    @Override
    public void ready() {
        // Filters should be added in ready()
        if (added != null && !added.isEmpty()) {
            // Creating a filter for not added products
            FilterEntity filterEntity = new FilterEntity();
            filterEntity.setName("Not added yet");
            filterEntity.setXml("<filter>\n" +
                    "  <and>\n" +
                    "    <c name=\"id\" class=\"java.util.UUID\" inExpr=\"true\" hidden=\"true\" operatorType=\"NOT_IN\" width=\"1\" type=\"PROPERTY\">" +
                    "           <![CDATA[((e.id not in :component$filter.id_list) or (e.id is null)) ]]>\n" +
                    "      <param name=\"component$filter.id_list\" javaClass=\"java.util.UUID\">NULL</param>\n" +
                    "    </c>\n" +
                    "  </and>\n" +
                    "</filter>");
            filter.setFilterEntity(filterEntity);
            filter.setParamValue("id_list", added);
            filter.apply(true);
        }
    }
}
