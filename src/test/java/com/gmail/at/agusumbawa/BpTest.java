package com.gmail.at.agusumbawa;

import com.gmail.at.agusumbawa.config.HibernateUtil;
import com.gmail.at.agusumbawa.dao.BpDao;
import com.gmail.at.agusumbawa.dao.TadarusDao;
import com.gmail.at.agusumbawa.entity.BpModel;
import com.gmail.at.agusumbawa.entity.SiswaModel;
import org.junit.Test;

import java.util.List;

/**
 * Created by Agus Suhardi on 3/5/2017.
 */
public class BpTest {

    private static BpDao dao = HibernateUtil.getBpDao();

    @Test
    public void tampil(){
        List<BpModel> l = dao.findByNis("151052043");

        System.out.println("datanya "+l.get(0).getPristiwa());
    }



    private static TadarusDao tadarusDao = HibernateUtil.getTadarusDao();
    @Test
    public void tadarusTampil(){
        System.out.println("hasil "+tadarusDao.findByNis("151052043").size());
    }


    @Test
    public void haspus(){
        dao.deleteAll();

    }
}
