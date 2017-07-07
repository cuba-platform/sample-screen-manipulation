package sample.web.orders.order;

import com.haulmont.bali.util.Dom4j;
import com.haulmont.cuba.core.global.TimeSource;
import com.haulmont.cuba.gui.components.AbstractLookup;
import com.haulmont.cuba.gui.components.Filter;
import org.dom4j.Element;

import javax.inject.Inject;
import java.util.Map;

public class OrderBrowse extends AbstractLookup {

    @Inject
    private Filter filter;

    @Inject
    private TimeSource timeSource;

    @Override
    public void init(Map<String, Object> params) {
        // add a listener to get notified when user changes the filter
        filter.addFilterEntityChangeListener(filterEntity -> {
            // get filter XML definition
            String xml = filterEntity.getXml();
            if (xml != null) {
                Element rootEl = Dom4j.readDocument(xml).getRootElement();
                Dom4j.walkAttributesRecursive(rootEl, (element, attribute) -> {
                    // find definitions of parameters of Date type
                    if (element.getName().equals("param")
                            && attribute.getName().equals("javaClass")
                            && attribute.getValue().equals("java.util.Date")) {
                        // extract parameter name
                        String[] paramNameParts = element.attributeValue("name").split("\\.");
                        String paramName = paramNameParts[paramNameParts.length - 1];
                        // set parameter value to the current date
                        filter.setParamValue(paramName, timeSource.currentTimestamp());
                    }
                });
            }
        });
    }
}