package com.gmail.at.agusumbawa.dao;

import com.gmail.at.agusumbawa.entity.NilaiModel;
import org.hibernate.*;

import java.util.List;

/**
 * Created by Agus Suhardi on 2/9/2017.
 */
public class NilaiDaoImpl implements NilaiDao {
    private final SessionFactory sessionFactory;

    public NilaiDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public void save(NilaiModel data) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.beginTransaction();
            session.save(data);
            session.getTransaction();
            transaction.commit();
        } catch (Exception e) {
            System.out.println("kesalahan pada : " + e.getMessage());
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    public void update(NilaiModel data) {
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

    public void delete(NilaiModel data) {
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

    public NilaiModel findById(String id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.beginTransaction();
            NilaiModel data = session.get(NilaiModel.class, id);
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

    public List<NilaiModel> findAll() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.beginTransaction();
            List<NilaiModel> list = session.createCriteria(NilaiModel.class).list();
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
    public NilaiModel findByKategory(String kategori) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.beginTransaction();
            NilaiModel data = session.get(NilaiModel.class, kategori);
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

    @Override
    public List<NilaiModel> findByNis(String siswa, String kategori) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String q = "select n from NilaiModel as n join n.siswa as s where s.nis='" + siswa + "' and n.kategori='" + kategori + "'";
        try {
            Query query = session.createQuery(q);
            //query.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            return query.list();
        } catch (Exception e) {
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public List<NilaiModel> findByNis(String siswa) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String q = "select n from NilaiModel n  where n.siswa.nis='" + siswa + "'";
        try {
            Query query = session.createQuery(q);
            //query.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            return query.list();
        } catch (Exception e) {
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public List<NilaiModel> findKategori() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String q = "select n from NilaiModel n group by n.kategori";
        try {
            Query query = session.createQuery(q);
            //query.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
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
        String q = "delete from NilaiModel ";
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