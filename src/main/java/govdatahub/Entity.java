package govdatahub;

import java.util.*;

public class Entity {
    private Long id;
    private String name;
    private String type;
    private String description;
    private Integer version;
    private Date startTime;
    private Date endTime;

    public Entity () {}

    public Entity (Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Entity (Long id, String name, String type, String description, Integer version, Date startTime, Date endTime) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
        this.version = version;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Long getId () {
        return this.id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public String getName () {
        return this.name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getType () {
        return this.type;
    }

    public void setType (String type) {
        this.type = type;
    }

    public String getDescription () {
        return this.description;
    }

    public void setDescription () {
        this.description = description;
    }

    public Integer getVersion () {
        return this.version;
    }

    public void setVersion (Integer version) {
        this.version = version;
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

}
