import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author tsypk on 15.11.2021 01:10
 * @project sniper-3
 */
public class Test {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure();
        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             final Session session = sessionFactory.openSession()) {
            System.out.println("Ok");
        }
    }
}
