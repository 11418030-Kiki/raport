package com.gmail.at.agusumbawa.dao;

import com.gmail.at.agusumbawa.entity.SiswaModel;
import org.hibernate.*;

import java.util.List;

/**
 * Created by Agus Suhardi on 2/9/2017.
 */
public class SiswaDaoImpl implements SiswaDao {
    private final SessionFactory sessionFactory;

    public SiswaDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public void save(SiswaModel data) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.beginTransaction();
            session.save(data);
            session.getTransaction();
            transaction.commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    public void update(SiswaModel data) {
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

    public void delete(SiswaModel data) {
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

    public SiswaModel findById(String id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.beginTransaction();
            SiswaModel data = session.get(SiswaModel.class, id);
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

    public List<SiswaModel> findAll() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.beginTransaction();
            List<SiswaModel> list = session.createCriteria(SiswaModel.class).list();
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
    public List<SiswaModel> findAll(String id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String q = "SELECT s FROM SiswaModel s where s.nis='"+id+"'";
        try {
            Query query = session.createQuery(q);
//            query.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            return query.list();
        } catch (Exception e) {
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public List report() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
//        String  q = "select n from NilaiModel n join n.pelajaran as p where n.siswa.nis='"+siswa+"' and p.kategori='"+kategori+"'";
        String q = "SELECT s FROM SiswaModel s JOIN s.bp p";
        try {
            Query query = session.createQuery(q);
//            query.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
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
        String q = "delete from SiswaModel ";
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
