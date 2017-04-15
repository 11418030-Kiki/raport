package com.gmail.at.agusumbawa.dao;

import com.gmail.at.agusumbawa.entity.TadarusModel;
import org.hibernate.*;

import java.util.List;

/**
 * Created by Agus Suhardi on 2/18/2017.
 */
public class TadarusDaoImpl implements TadarusDao{
    private final SessionFactory sessionFactory;

    public TadarusDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public void save(TadarusModel data) {
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

    public void update(TadarusModel data) {
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

    public void delete(TadarusModel data) {
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

    public TadarusModel findById(String id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.beginTransaction();
            TadarusModel data = session.get(TadarusModel.class, id);
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

    public List<TadarusModel> findAll() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.beginTransaction();
            List<TadarusModel> list = session.createCriteria(TadarusModel.class).list();
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
    public List<TadarusModel> findByNis(String s) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
//        String  q = "from TadarusModel WHERE siswa="+s;
        String q = "select t from TadarusModel t join t.siswa as s where s.nis='"+s+"'";
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
        String q = "delete from TadarusModel ";
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
