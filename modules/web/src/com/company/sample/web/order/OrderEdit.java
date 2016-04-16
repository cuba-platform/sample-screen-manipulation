package com.company.sample.web.order;

import com.company.sample.entity.Customer;
import com.company.sample.entity.Order;
import com.company.sample.entity.OrderLine;
import com.company.sample.entity.Product;
import com.company.sample.web.customer.CustomerList;
import com.haulmont.bali.util.ParamsMap;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.gui.WindowManager;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.PickerField;
import com.haulmont.cuba.gui.data.CollectionDatasource;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Collection;
import java.util.Map;
import java.util.UUID;

public class OrderEdit extends AbstractEditor<Order> {

    @Named("fieldGroup.customer")
    private PickerField customerField;

    @Inject
    private CollectionDatasource<OrderLine, UUID> orderLinesDs;

    @Inject
    private Metadata metadata;

    @Override
    public void init(Map<String, Object> params) {
        customerField.removeAction(PickerField.LookupAction.NAME);
    }

    public void selectCustomerFromLookupScreen(Component source) {
        // Open the customers browser as a lookup screen
        openLookup("sample$Customer.browse", new Lookup.Handler() {
            @Override
            public void handleLookup(Collection items) {
                // When the lookup screen closes, use the selected entity
                if (!items.isEmpty()) {
                    getItem().setCustomer((Customer) items.iterator().next());
                }
            }
        }, WindowManager.OpenType.DIALOG.setWidth(600).setHeight(400)); // Open the lookup screen as a dialog with predefined geometry
    }

    public void selectCustomerFromSimpleScreen(Component source) {
        // Open the customers list screen
        CustomerList window = (CustomerList) openWindow("customer-list", WindowManager.OpenType.DIALOG);
        // Add a listener that will be notified when the screen is closed by action with Window.COMMIT_ACTION_ID
        window.addCloseWithCommitListener(() -> {
            // Get a selected entity from the invoked screen and use it
            getItem().setCustomer(window.getSelectedCustomer());
        });
    }

    public void addOrderLine(Component source) {
        // Open the products browser as a lookup screen
        openLookup("sample$Product.browse",
                new Lookup.Handler() {
                    @Override
                    public void handleLookup(Collection items) {
                        // When the lookup screen closes, open the dialog for entering quantity
                        if (!items.isEmpty()) {
                            openQuantityDialog((Product) items.iterator().next());
                        }
                    }
                },
                WindowManager.OpenType.THIS_TAB,
                ParamsMap.of("customer", getItem().getCustomer()) // Pass Customer to the Products lookup screen
        );
    }

    private void openQuantityDialog(Product product) {
        // Open the dialog for entering product quantity
        QuantityDialog dialog = (QuantityDialog) openWindow("quantity-dialog",
                WindowManager.OpenType.DIALOG.setWidth(300), ParamsMap.of("product", product));
        // Add a listener that will be notified when the dialog is closed by action with Window.COMMIT_ACTION_ID
        dialog.addCloseWithCommitListener(() -> {
            // Creat new OrderLine instance and set its attributes
            OrderLine orderLine = metadata.create(OrderLine.class);
            orderLine.setOrder(getItem());
            orderLine.setProduct(product);
            orderLine.setQuantity(dialog.getQuantity());
            // Add new OrderLine to the datasource, it will be displayed in the table and saved later together with Order
            orderLinesDs.addItem(orderLine);
        });
    }
}