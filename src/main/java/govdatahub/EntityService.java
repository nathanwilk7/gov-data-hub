package govdatahub;

import java.util.*;
import java.sql.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntityService {
    @Autowired
    private DatabaseService databaseService;

    public List<Entity> listEntities () throws Exception {
        List<Entity> entities = new ArrayList<Entity>();
        Connection conn = databaseService.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM entities");
        while (rs.next()) {
            entities.add(new Entity(rs.getLong("id"), rs.getString("name"), rs.getString("type")));
        }
        rs.close();
        st.close();
        return entities;
    }

    public void createEntity (Entity entity) throws Exception {
        Connection conn = databaseService.getConnection();
        PreparedStatement st = conn.prepareStatement("INSERT INTO entities (name, type) VALUES (?, ?)");
        st.setString(1, entity.getName());
        st.setString(2, entity.getType());
        st.executeUpdate();
        st.close();
    }
}
