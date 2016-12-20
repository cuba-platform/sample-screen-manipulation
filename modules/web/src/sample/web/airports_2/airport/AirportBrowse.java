/*
 * TODO Copyright
 */

package sample.web.airports_2.airport;

import com.haulmont.cuba.gui.components.AbstractLookup;
import com.haulmont.cuba.gui.components.actions.CreateAction;
import com.haulmont.cuba.gui.components.actions.EditAction;

import javax.inject.Named;
import java.util.Map;

public class AirportBrowse extends AbstractLookup {

    @Named("airportsTable.create")
    private CreateAction airportsTableCreate;
    @Named("airportsTable.edit")
    private EditAction airportsTableEdit;

    @Override
    public void init(Map<String, Object> params) {
        airportsTableCreate.setWindowId("sample$Airport.edit2");
        airportsTableEdit.setWindowId("sample$Airport.edit2");
    }
}