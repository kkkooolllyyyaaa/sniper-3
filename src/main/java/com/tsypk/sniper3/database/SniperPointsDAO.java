package com.tsypk.sniper3.database;

import com.tsypk.sniper3.model.Point;
import com.tsypk.sniper3.utils.PropertyManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tsypk on 11.11.2021 04:28
 * @project sniper-3
 */
public class SniperPointsDAO implements PointsDAO {
    private final EntityManagerFactory entityManagerFactory = Persistence.
            createEntityManagerFactory(PropertyManager.getProperty("persistence-unit"));

    private final EntityManager em = entityManagerFactory.createEntityManager();

    @Override
    public boolean addPoint(Point point) {
        try {
            em.getTransaction().begin();
            em.merge(point);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            if (em == null) {
                System.out.println("null");
            }
            em.getTransaction().rollback();
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public ArrayList<Point> getAll() {
        try {
            em.getTransaction().begin();
            List resultList = em.createQuery("SELECT point FROM Point point")
                    .getResultList();
            em.getTransaction().commit();
            return (ArrayList<Point>) resultList;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @Override
    public ArrayList<Point> head(int count) {
        if (count > 0) {
            try {
                em.getTransaction().begin();
                List resultList = em.createQuery("SELECT point FROM Point point")
                        .setMaxResults(count)
                        .getResultList();
                em.getTransaction().commit();
                return (ArrayList<Point>) resultList;
            } catch (Exception e) {
                return new ArrayList<>();
            }
        } else {
            throw new RuntimeException("Count must be positive");
        }
    }

    @Override
    public boolean clear() {
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("delete FROM Point");
            query.executeUpdate();
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
