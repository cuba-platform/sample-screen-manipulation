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

package com.company.sample.web.product;

import com.company.sample.entity.Customer;
import com.company.sample.entity.Product;
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