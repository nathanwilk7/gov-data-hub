package govdatahub;

import java.util.*;
import java.sql.*;

import org.hibernate.Session;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataSetController {
    @RequestMapping(value="/datasets", method=RequestMethod.POST)
    public void createDataset (@RequestBody DataSet dataSet) {
        Session session = Application.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(dataSet);
        session.getTransaction().commit();
        session.close();
    }

    @RequestMapping(value="/datasets", method=RequestMethod.GET)
    public List<DataSet> getDatasets () throws Exception {
        String url = "jdbc:postgresql://localhost/test"; //?user=fred&password=secret&ssltrue;
        Connection conn = DriverManager.getConnection(url);
        //        Session session = Application.getSessionFactory().openSession();
        //        session = Application.getSessionFactory().openSession();
        //        session.beginTransaction();
        //        List result = session.createQuery( "from DataSet" ).list();
        //        session.getTransaction().commit();
        //        session.close();
        //        return result;
        return null;
    }
}
