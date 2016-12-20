/*
 * TODO Copyright
 */

package sample.entity.airports;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;
import java.util.List;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

@NamePattern("%s|name")
@Table(name = "SAMPLE_TERMINAL")
@Entity(name = "sample$Terminal")
public class Terminal extends StandardEntity {
    private static final long serialVersionUID = -7745964099760419807L;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "AIRPORT_ID")
    protected Airport airport;

    @Column(name = "NAME")
    protected String name;

    @OrderBy("name")
    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "terminal")
    protected List<MeetingPoint> meetingPoints;

    public void setMeetingPoints(List<MeetingPoint> meetingPoints) {
        this.meetingPoints = meetingPoints;
    }

    public List<MeetingPoint> getMeetingPoints() {
        return meetingPoints;
    }


    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    public Airport getAirport() {
        return airport;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}