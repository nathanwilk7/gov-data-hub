package govdatahub;

import java.util.*;

public class EntityStat {
    private Long id;
    private Long entityId;
    private String name;
    private Double value;
    private String strValue;
    private Date startTime;
    private Date endTime;
    private String src;
    private String description;

    public EntityStat () {}

    public EntityStat (Long id, Long entityId, String name, Double value, String strValue, Date startTime, Date endTime, String src, String description) {
        this.id = id;
        this.entityId = entityId;
        this.name = name;
        this.value = value;
        this.strValue = strValue;
        this.startTime = startTime;
        this.endTime = endTime;
        this.src = src;
        this.description = description;
    }

    public Long getId () {
        return this.id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public Long getEntityId () {
        return this.entityId;
    }

    public void setEntityId (Long entityId) {
        this.entityId = entityId;
    }

    public String getName () {
        return this.name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public Double getValue () {
        return this.value;
    }

    public void setValue (Double value) {
        this.value = value;
    }

    public String getStrValue () {
        return this.strValue;
    }

    public void setStrValue (String strValue) {
        this.strValue = strValue;
    }

    public Date getStartTime () {
        return this.startTime;
    }

    public void setStartTime (Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime () {
        return this.endTime;
    }

    public void setEndTime (Date endTime) {
        this.endTime = endTime;
    }

    public String getSrc () {
        return this.src;
    }

    public void setSrc (String src) {
        this.src = src;
    }

    public String getDescription () {
        return this.description;
    }

    public void setDescription (String description) {
        this.description = description;
    }

}
