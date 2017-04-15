package com.gmail.at.agusumbawa.entity;

import com.gmail.at.agusumbawa.config.HibernateUtil;
import com.gmail.at.agusumbawa.dao.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Agus Suhardi on 3/11/2017.
 */
public class DataBeanList {

    private SiswaDao siswaDao = HibernateUtil.getSiswaDao();
    private BpDao bpDao = HibernateUtil.getBpDao();
    private NilaiDao nilaiDao = HibernateUtil.getNilaiDao();
    private TadarusDao tadarusDao = HibernateUtil.getTadarusDao();


//    ArrayList<SiswaModel> dataBeanList = new ArrayList<SiswaModel>();

    public ArrayList<SiswaModel> getDataBeanList(String nis) {

        List<SiswaModel> l;


        if (nis.equals("") || nis.equals(null) || nis.isEmpty()){
            l = siswaDao.findAll();
        }else {
            l = siswaDao.findAll(nis);
        }



        ArrayList<SiswaModel> dataBeanList = new ArrayList<SiswaModel>();


        for (int i = 0; i < l.size(); i++) {
            dataBeanList.add(siswaModel(l.get(i).getNis()));
        }


        return dataBeanList;
    }

    private SiswaModel siswaModel(String nis) {
        SiswaModel data = siswaDao.findById(nis);

        //save BP List
        List<BpModel> bpList = bpDao.findByNis(nis);
        data.setBp(bpList);

        //save TADARUS List
        List<TadarusModel> tadarusList = tadarusDao.findByNis(nis);
        data.setTadarus(tadarusList);

        //save Nilai list
        NilaiModel n = new NilaiModel();
        List<NilaiModel> nilaiList = nilaiDao.findByNis(nis);
        for (int i=0; i<nilaiList.size(); i++) {
            n = nilaiList.get(i);

            if (nilaiList.get(i).getNilai()>=nilaiList.get(i).getKkm()){
                n.setKet("Lulus");
            }else {
                n.setKet("Gagal");
            }
            nilaiList.set(i, n);
        }
        data.setNilai(nilaiList);

        return data;
    }



}