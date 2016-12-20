/*
 * TODO Copyright
 */

package sample.entity.airports;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;
import java.util.List;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

@Table(name = "SAMPLE_AIRPORT")
@Entity(name = "sample$Airport")
public class Airport extends StandardEntity {
    private static final long serialVersionUID = 731043808044610486L;

    @Column(name = "NAME")
    protected String name;

    @OrderBy("name")
    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "airport")
    protected List<Terminal> terminals;

    public void setTerminals(List<Terminal> terminals) {
        this.terminals = terminals;
    }

    public List<Terminal> getTerminals() {
        return terminals;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}