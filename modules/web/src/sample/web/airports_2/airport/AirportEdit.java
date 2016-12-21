/*
 * TODO Copyright
 */

package sample.web.airports_2.airport;

import com.haulmont.bali.util.ParamsMap;
import com.haulmont.cuba.core.global.PersistenceHelper;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.haulmont.cuba.gui.components.actions.CreateAction;
import com.haulmont.cuba.gui.components.actions.EditAction;
import sample.entity.airports.Airport;

import javax.inject.Named;
import java.util.Map;

public class AirportEdit extends AbstractEditor<Airport> {

    @Named("terminalsTable.create")
    private CreateAction terminalsTableCreate;
    @Named("terminalsTable.edit")
    private EditAction terminalsTableEdit;

    @Override
    public void init(Map<String, Object> params) {
        terminalsTableCreate.setWindowId("sample$Terminal.edit2");
        terminalsTableEdit.setWindowId("sample$Terminal.edit2");

        // Disable notification on saving entity without closing the screen
        setShowSaveNotification(false);
    }

    @Override
    protected void postInit() {
        // Get currently edited airport
        Airport airport = getItem();
        // Enable "create" action only if the edited airport is saved to the database
        terminalsTableCreate.setEnabled(!PersistenceHelper.isNew(airport));
        // Pass the currently edited airport to be set to the "airport" attribute of a newly created terminal
        terminalsTableCreate.setInitialValues(ParamsMap.of("airport", airport));
    }
}