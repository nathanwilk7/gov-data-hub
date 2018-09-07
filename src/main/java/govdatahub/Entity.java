package govdatahub;

public class Entity {
    private Long id;
    private String name;
    private String type;
    private String description;

    public Entity() {}

    public Entity (Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Entity (Long id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public Entity (Long id, String name, String type, String description) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
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
}
