package sample.web.airports_3.airport;

import com.haulmont.bali.util.ParamsMap;
import com.haulmont.cuba.core.global.PersistenceHelper;
import com.haulmont.cuba.gui.components.AbstractLookup;
import com.haulmont.cuba.gui.components.actions.CreateAction;
import com.haulmont.cuba.gui.components.actions.EditAction;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import sample.entity.airports.Airport;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Map;
import java.util.UUID;

public class AirportBrowse extends AbstractLookup {

    @Named("airportsTable.create")
    private CreateAction airportsTableCreate;
    @Named("airportsTable.edit")
    private EditAction airportsTableEdit;

    @Named("terminalsTable.create")
    private CreateAction terminalsTableCreate;
    @Named("terminalsTable.edit")
    private EditAction terminalsTableEdit;

    @Inject
    private CollectionDatasource<Airport, UUID> airportsDs;

    @Override
    public void init(Map<String, Object> params) {
        airportsTableCreate.setWindowId("sample$Airport.edit3");
        airportsTableEdit.setWindowId("sample$Airport.edit3");

        terminalsTableCreate.setWindowId("sample$Terminal.edit2");
        terminalsTableEdit.setWindowId("sample$Terminal.edit2");

        // Disable the terminals "create" action initially
        terminalsTableCreate.setEnabled(false);

        airportsDs.addItemChangeListener(e -> {
            // Get currently selected airport
            Airport airport = e.getItem();
            // Enable terminals "create" action only if an airport is selected
            terminalsTableCreate.setEnabled(airport != null);
            // Pass the currently selected airport to be set to the "airport" attribute of a newly created terminal
            terminalsTableCreate.setInitialValues(ParamsMap.of("airport", airport));
        });
    }
}