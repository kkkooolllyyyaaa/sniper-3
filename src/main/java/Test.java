import com.tsypk.sniper3.database.PointsDAO;
import com.tsypk.sniper3.database.SniperPointsDAO;
import com.tsypk.sniper3.model.Point;

import java.util.ArrayList;

/**
 * @author tsypk on 15.11.2021 01:10
 * @project sniper-3
 */
public class Test {
    public static void main(String[] args) {
//        PointsDAO pointsDAO = new SniperPointsDAO();
//        Point point = Point.builder().x(2.0).y(1.0).radius(4.0).time("time").build();
//        System.out.println(pointsDAO.addPoint(point));
//        System.out.println(pointsDAO.addPoint(new Point()));
//        ArrayList<Point> list = pointsDAO.getAll();
//        for (Point p : list) {
//            System.out.println(p);
//        }
        String s = "18:19:13 16.11.2021\t";
        System.out.println(s.length());

//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernate");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        EntityTransaction transaction = entityManager.getTransaction();
//        try {
//            transaction.begin();
//            Query query = entityManager.createQuery("SELECT e FROM Point e");
//            List points = query.getResultList();
//            System.out.println(points.size());
//            transaction.commit();
//        } catch (RuntimeException exception) {
//            if (transaction.isActive()) {
//                transaction.rollback();
//            }
//            throw exception;
//        }
    }
}
