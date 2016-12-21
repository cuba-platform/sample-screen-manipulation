package sample.web.orders.order;

import sample.entity.orders.Product;
import com.haulmont.chile.core.datatypes.Datatypes;
import com.haulmont.cuba.gui.WindowParam;
import com.haulmont.cuba.gui.components.*;

import javax.inject.Inject;
import java.util.Map;

public class QuantityDialog extends AbstractWindow {

    @Inject
    private Label lab;

    @Inject
    private TextField field;

    // Product passed to the screen from invoking code.
    // This is the same as getting the parameter in init() method
    @WindowParam
    private Product product;

    @Override
    public void init(Map<String, Object> params) {
        lab.setValue("Enter quantity for " + product.getName());

        // The field is not connected to an entity attribute, so assign the data type
        field.setDatatype(Datatypes.get(Double.class));
    }

    /**
     * Returns the value entered by user.
     */
    public Double getQuantity() {
        return field.getValue();
    }

    public void confirm(Component source) {
        close(Window.COMMIT_ACTION_ID);
    }

    public void cancel(Component source) {
        close(Window.CLOSE_ACTION_ID);
    }
}
