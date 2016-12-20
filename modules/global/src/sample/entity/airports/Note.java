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

@NamePattern("%s|text")
@Table(name = "SAMPLE_NOTE")
@Entity(name = "sample$Note")
public class Note extends StandardEntity {
    private static final long serialVersionUID = -1972286685727517136L;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "MEETING_POINT_ID")
    protected MeetingPoint meetingPoint;

    @Column(name = "TEXT")
    protected String text;

    public void setMeetingPoint(MeetingPoint meetingPoint) {
        this.meetingPoint = meetingPoint;
    }

    public MeetingPoint getMeetingPoint() {
        return meetingPoint;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }


}