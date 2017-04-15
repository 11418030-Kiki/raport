package com.gmail.at.agusumbawa.dao;

import com.gmail.at.agusumbawa.entity.BpModel;
import com.gmail.at.agusumbawa.entity.SiswaModel;
import org.hibernate.*;

import java.util.List;

/**
 * Created by Agus Suhardi on 2/18/2017.
 */
public class BpDaoImpl implements BpDao {

    private final SessionFactory sessionFactory;

    public BpDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public void save(BpModel data) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.beginTransaction();
            session.save(data);
            session.getTransaction();
            transaction.commit();
        } catch (Exception e) {
            System.out.println("kesalahan pada : "+e.getMessage());
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    public void update(BpModel data) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.beginTransaction();
            session.update(data);
            session.getTransaction();
            transaction.commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    public void delete(BpModel data) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.beginTransaction();
            session.delete(data);
            session.getTransaction();
            transaction.commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    public BpModel findById(String id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.beginTransaction();
            BpModel data = session.get(BpModel.class, id);
            session.getTransaction();
            transaction.commit();
            return data;
        } catch (Exception e) {
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
    }

    public List<BpModel> findAll() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.beginTransaction();
            List<BpModel> list = session.createCriteria(BpModel.class).list();
            session.getTransaction().commit();
            return list;
        } catch (Exception e) {
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public List<BpModel> findByNis(String s) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String q = "select  b from BpModel b join b.siswa as s where s.nis='"+s+"'";
        try {
        Query query = session.createQuery(q);
            query.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            return query.list();
        } catch (Exception e) {
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public void deleteAll() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String q = "delete from BpModel ";
        try {
            Query query = session.createQuery(q);
            query.executeUpdate();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }
}
