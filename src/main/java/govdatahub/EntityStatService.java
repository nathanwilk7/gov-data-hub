package govdatahub;

import java.util.*;
import java.sql.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntityStatService {
    @Autowired
    private DatabaseService databaseService;

    public EntityStat getEntityStat (Long id) throws Exception {
        Connection conn = databaseService.getConnection();
        PreparedStatement st = conn.prepareStatement("SELECT * FROM entity_stats WHERE id = ?");
        st.setLong(1, id);
        ResultSet rs = st.executeQuery();
        EntityStat entityStat = null;
        if (rs.next()) {
            entityStat = new EntityStat(rs.getLong("id"), rs.getLong("entity_id"), rs.getString("name"), rs.getDouble("value"), rs.getString("str_value"), rs.getDate("start_time"), rs.getDate("end_time"), rs.getString("src"), rs.getString("description"));
        }
        rs.close();
        st.close();
        return entityStat;
    }

    public List<EntityStat> listEntityStats () throws Exception {
        List<EntityStat> entityStats = new ArrayList<EntityStat>();
        Connection conn = databaseService.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM entity_stats");
        while (rs.next()) {
            entityStats.add(new EntityStat(rs.getLong("id"), rs.getLong("entity_id"), rs.getString("name"), rs.getDouble("value"), rs.getString("str_value"), rs.getDate("start_time"), rs.getDate("end_time"), rs.getString("src"), rs.getString("description")));
        }
        rs.close();
        st.close();
        return entityStats;
    }

    public void createEntityStat (EntityStat entityStat) throws Exception {
        Connection conn = databaseService.getConnection();
        PreparedStatement st = conn.prepareStatement("INSERT INTO entity_stats (entity_id, name, value, str_value, start_time, end_time, src, description) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
        st.setLong(1, entityStat.getEntityId());
        st.setString(2, entityStat.getName());
        st.setDouble(3, entityStat.getValue());
        st.setString(4, entityStat.getStrValue());
        java.util.Date startTime = entityStat.getStartTime();
        if (startTime == null) {
            st.setDate(5, null);
        } else {
            st.setDate(5, new java.sql.Date(startTime.getTime()));
        }
        java.util.Date endTime = entityStat.getEndTime();
        if (endTime == null) {
            st.setDate(6, null);
        } else {
            st.setDate(6, new java.sql.Date(endTime.getTime()));
        }
        st.setString(7, entityStat.getSrc());
        st.setString(8, entityStat.getDescription());
        st.executeUpdate();
        st.close();
    }
}
