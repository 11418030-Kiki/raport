package com.gmail.at.agusumbawa;

import com.gmail.at.agusumbawa.config.HibernateUtil;
import com.gmail.at.agusumbawa.dao.NilaiDao;
import com.gmail.at.agusumbawa.dao.SiswaDao;
import com.gmail.at.agusumbawa.entity.NilaiModel;
import com.gmail.at.agusumbawa.entity.SiswaModel;
import org.junit.Test;

import java.util.List;

/**
 * Created by Agus Suhardi on 3/5/2017.
 */
public class SiswaTest {

    public static SiswaDao dao = HibernateUtil.getSiswaDao();
    private static NilaiDao nilaiDao= HibernateUtil.getNilaiDao();

    @Test
    public void getData(){
        List<SiswaModel> l =  dao.findAll();


        for (int i=0; i<l.size(); i++)
            System.out.println(l.get(i).getBp().get(0).getPristiwa());

        //System.out.println(l.get(1).getNilai().get(1).getNilai());

    }



    @Test
    public void getNilai(){
        List<NilaiModel> nilaiList = nilaiDao.findByNis("151052043");
        System.out.println("data real "+nilaiList.get(0).getPelajaran());
    }


}
