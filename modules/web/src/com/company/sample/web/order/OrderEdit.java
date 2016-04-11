package com.company.sample.web.order;

import com.company.sample.entity.Customer;
import com.company.sample.web.customer.CustomerList;
import com.haulmont.cuba.gui.WindowManager;
import com.haulmont.cuba.gui.components.*;
import com.company.sample.entity.Order;

import javax.inject.Named;
import java.util.Collection;
import java.util.Map;

public class OrderEdit extends AbstractEditor<Order> {

    @Named("fieldGroup.customer")
    private PickerField customerField;

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
}