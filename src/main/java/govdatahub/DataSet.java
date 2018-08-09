package govdatahub;

import java.net.URL;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Inheritance;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Inheritance
@Table( name = "datasets" )
public class DataSet {
    private Long id;
    private String name;
    private String description;
    private URL downloadURL;

    public DataSet () {}

    public DataSet (String name, String description, URL downloadURL) {
        this.name = name;
        this.description = description;
        this.downloadURL = downloadURL;
    }

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public String getName () {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getDescription () {
        return this.description;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    public URL getDownloadURL () {
        return this.downloadURL;
    }

    private void setDownloadURL (URL url) {
        this.downloadURL = url;
    }

}
