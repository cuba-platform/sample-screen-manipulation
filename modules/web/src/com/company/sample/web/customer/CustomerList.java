package com.company.sample.web.customer;

import com.company.sample.entity.Customer;
import com.haulmont.cuba.gui.components.AbstractWindow;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.Window;
import com.haulmont.cuba.gui.data.CollectionDatasource;

import javax.inject.Inject;
import java.util.Map;
import java.util.UUID;

public class CustomerList extends AbstractWindow {

    @Inject
    protected CollectionDatasource<Customer, UUID> customersDs;

    @Override
    public void init(Map<String, Object> params) {
        customersDs.refresh();
    }

    public void select(Component source) {
        close(Window.COMMIT_ACTION_ID);
    }

    public void cancel(Component source) {
        close(Window.CLOSE_ACTION_ID);
    }

    public Customer getSelectedCustomer() {
        return customersDs.getItem();
    }
}