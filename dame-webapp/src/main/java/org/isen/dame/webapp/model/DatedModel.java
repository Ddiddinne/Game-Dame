package org.isen.dame.webapp.model;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@MappedSuperclass
public abstract class DatedModel extends Model {

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @PrePersist
    public void create() {
        created = new Date();
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
