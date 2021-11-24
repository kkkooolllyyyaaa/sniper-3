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
    private final EntityManager em;

    public SniperPointsDAO() {
        PortForwarder.connect();

        EntityManagerFactory entityManagerFactory = Persistence.
                createEntityManagerFactory(PropertyManager.getProperty("persistence-unit"));
        em = entityManagerFactory.createEntityManager();
    }

    @Override
    public boolean addPoint(Point point) {
        try {
            begin();
            em.persist(point);
            em.flush();
            end();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Point> getAll() {
        try {
            begin();
            @SuppressWarnings("unchecked")
            List<Point> resultList = em.createQuery("SELECT point FROM Point point").getResultList();
            end();
            return resultList;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @Override
    public List<Point> head(int count) {
        if (count > 0) {
            try {
                begin();
                @SuppressWarnings("unchecked")
                List<Point> resultList = em.createQuery("SELECT point FROM Point point").setMaxResults(count).getResultList();
                end();
                return resultList;
            } catch (Exception e) {
                return new ArrayList<>();
            }
        } else {
            throw new RuntimeException("Count must be positive");
        }
    }

    @Override
    public void clear() {
        try {
            begin();
            Query query = em.createQuery("delete FROM Point");
            query.executeUpdate();
            end();
        } catch (Exception unexpected) {
            unexpected.printStackTrace();
        }
    }

    private void begin() {
        em.getTransaction().begin();
    }

    private void end() {
        if (em.getTransaction().isActive()) {
            em.getTransaction().commit();
        } else {
            throw new RuntimeException("Inactive transaction");
        }
    }
}
