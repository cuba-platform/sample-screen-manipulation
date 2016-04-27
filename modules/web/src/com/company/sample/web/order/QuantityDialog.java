/*
 * Copyright (c) 2016 Haulmont
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.company.sample.web.order;

import com.company.sample.entity.Product;
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