package govdatahub;

import java.util.*;
import java.sql.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntityService {
    @Autowired
    private DatabaseService databaseService;

    public Entity getEntity (Long id) throws Exception {
        Connection conn = databaseService.getConnection();
        PreparedStatement st = conn.prepareStatement("SELECT * FROM entities WHERE id = ?");
        st.setLong(1, id);
        ResultSet rs = st.executeQuery();
        Entity entity = null;
        if (rs.next()) {
            entity = new Entity(rs.getLong("id"), rs.getString("name"), rs.getString("type"), rs.getString("description"), rs.getInt("version"), rs.getDate("start_time"), rs.getDate("end_time"));
        }
        rs.close();
        st.close();
        conn.close();
        return entity;
    }

    public Entity getEntityByNameAndType (String name, String type) throws Exception {
        Connection conn = databaseService.getConnection();
        PreparedStatement st = conn.prepareStatement("SELECT * FROM entities WHERE name = ? AND type = ?");
        st.setString(1, name);
        st.setString(2, type);
        ResultSet rs = st.executeQuery();
        Entity entity = null;
        if (rs.next()) {
            entity = new Entity(rs.getLong("id"), rs.getString("name"), rs.getString("type"), rs.getString("description"), rs.getInt("version"), rs.getDate("start_time"), rs.getDate("end_time"));
        }
        rs.close();
        st.close();
        conn.close();
        return entity;
    }

    public List<Entity> listEntities () throws Exception {
        List<Entity> entities = new ArrayList<Entity>();
        Connection conn = databaseService.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM entities");
        while (rs.next()) {
            entities.add(new Entity(rs.getLong("id"), rs.getString("name"), rs.getString("type"), rs.getString("description"), rs.getInt("version"), rs.getDate("start_time"), rs.getDate("end_time")));
        }
        rs.close();
        st.close();
        conn.close();
        return entities;
    }

    public void createEntity (Entity entity) throws Exception {
        Connection conn = databaseService.getConnection();
        PreparedStatement st = conn.prepareStatement("INSERT INTO entities (name, type, description, version, start_time, end_time) VALUES (?, ?, ?, ?, ?, ?)");
        st.setString(1, entity.getName());
        st.setString(2, entity.getType());
        st.setString(3, entity.getDescription());
        Integer version = entity.getVersion();
        if (version == null) {
            version = 0;
        }
        st.setInt(4, version);
        java.util.Date startTime = entity.getStartTime();
        if (startTime == null) {
            st.setDate(5, null);
        } else {
            st.setDate(5, new java.sql.Date(startTime.getTime()));
        }
        java.util.Date endTime = entity.getEndTime();
        if (endTime == null) {
            st.setDate(6, null);
        } else {
            st.setDate(6, new java.sql.Date(endTime.getTime()));
        }
        st.executeUpdate();
        st.close();
    }

    public List<EntityStat> listEntityStats (long id, Long[] statsToInclude) throws Exception {
        List<EntityStat> entityStats = new ArrayList<EntityStat>();
        Connection conn = databaseService.getConnection();
        PreparedStatement st;
        if (statsToInclude.length == 0) {
            st = conn.prepareStatement("SELECT * FROM entity_stats WHERE entity_id = ?");
        } else {
            st = conn.prepareStatement("SELECT * FROM entity_stats WHERE entity_id = ? and id = ANY (?)");
        }
        st.setLong(1, id);
        if (statsToInclude.length > 0) {
            st.setArray(2, conn.createArrayOf("INTEGER", statsToInclude));
        }
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            entityStats.add(new EntityStat(rs.getLong("id"), rs.getLong("entity_id"), rs.getString("name"), rs.getDouble("value"), rs.getString("str_value"), rs.getDate("start_time"), rs.getDate("end_time"), rs.getString("src"), rs.getString("description")));
        }
        rs.close();
        st.close();
        conn.close();
        return entityStats;
    }

}
