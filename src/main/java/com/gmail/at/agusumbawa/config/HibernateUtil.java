package com.gmail.at.agusumbawa.config;

import com.gmail.at.agusumbawa.dao.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Agus Suhardi on 2/7/2017.
 */
public class  HibernateUtil {

    private static final SessionFactory SESSION_FACTORY;

    private static final SiswaDao SISWA_DAO;
    private static final NilaiDao NILAI_DAO;
    private static final TadarusDao TADARUS_DAO;
    private static final BpDao BP_DAO;






    static {
        try {
            SESSION_FACTORY = new Configuration().configure().buildSessionFactory();

            SISWA_DAO = new SiswaDaoImpl(SESSION_FACTORY);
            NILAI_DAO = new NilaiDaoImpl(SESSION_FACTORY);
            TADARUS_DAO = new TadarusDaoImpl(SESSION_FACTORY);
            BP_DAO = new BpDaoImpl(SESSION_FACTORY);


        } catch (Throwable e) {
            System.out.println("Hibernate util error " + e.getMessage());
            throw new ExceptionInInitializerError(e);
        }
    }


    public static SiswaDao getSiswaDao() {
        return SISWA_DAO;
    }


    public static NilaiDao getNilaiDao() {
        return NILAI_DAO;
    }


    public static TadarusDao getTadarusDao() {
        return TADARUS_DAO;
    }

    public static BpDao getBpDao() {
        return BP_DAO;
    }
}