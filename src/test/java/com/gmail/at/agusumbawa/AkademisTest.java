package com.gmail.at.agusumbawa;

import com.gmail.at.agusumbawa.config.HibernateUtil;
import com.gmail.at.agusumbawa.dao.NilaiDao;
import com.gmail.at.agusumbawa.entity.NilaiModel;
import org.junit.Test;

import java.util.List;

/**
 * Created by Agus Suhardi on 3/5/2017.
 */
public class AkademisTest {

    NilaiDao dao = HibernateUtil.getNilaiDao();

    @Test
    public void cobaLihat(){
        List<NilaiModel> l = dao.findByNis("151052043", "akademis");

    }
}
