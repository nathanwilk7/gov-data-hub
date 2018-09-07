package govdatahub;

import java.sql.*;

import org.springframework.stereotype.Service;

@Service
public class DatabaseService {
    private String url = "jdbc:postgresql://localhost/govdatahub";

    public Connection getConnection () throws Exception {
        return DriverManager.getConnection(url);
    }
}
