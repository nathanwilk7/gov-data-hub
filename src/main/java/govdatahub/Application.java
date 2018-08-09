package govdatahub;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    private static SessionFactory sessionFactory;
    
    private static void setUp() throws Exception {
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure() // configures settings from hibernate.cfg.xml
            .build();
        try {
            Application.sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        }
        catch (Exception e) {
            System.out.println("NATEE ERROR!!!!");
            System.out.println(e);
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return Application.sessionFactory;
    }
    
    public static void main (String[] args) throws Exception {
        setUp();
        SpringApplication.run(Application.class, args);
    }
}
