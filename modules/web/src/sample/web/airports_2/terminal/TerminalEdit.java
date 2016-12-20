/*
 * TODO Copyright
 */

package sample.web.airports_2.terminal;

import com.haulmont.cuba.gui.components.AbstractEditor;
import com.haulmont.cuba.gui.components.actions.CreateAction;
import com.haulmont.cuba.gui.components.actions.EditAction;
import sample.entity.airports.Terminal;

import javax.inject.Named;
import java.util.Map;

public class TerminalEdit extends AbstractEditor<Terminal> {

    @Named("meetingPointsTable.create")
    private CreateAction meetingPointsTableCreate;
    @Named("meetingPointsTable.edit")
    private EditAction meetingPointsTableEdit;

    @Override
    public void init(Map<String, Object> params) {
        meetingPointsTableCreate.setWindowId("sample$MeetingPoint.edit2");
        meetingPointsTableEdit.setWindowId("sample$MeetingPoint.edit2");
    }
}