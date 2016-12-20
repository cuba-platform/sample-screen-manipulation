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

        terminalsTableCreate.setEnabled(false);

        airportsDs.addItemChangeListener(e -> {
            Airport airport = e.getItem();
            terminalsTableCreate.setEnabled(airport != null);
            terminalsTableCreate.setInitialValues(ParamsMap.of("airport", airport));
        });
    }
}