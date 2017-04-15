package com.gmail.at.agusumbawa.entity;

import com.gmail.at.agusumbawa.config.HibernateUtil;
import com.gmail.at.agusumbawa.dao.BpDao;
import com.gmail.at.agusumbawa.dao.SiswaDao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Agus Suhardi on 3/11/2017.
 */
public class DataBeanList {


    private List<SiswaModel> subReportBeanListSiswa;
    private List<BpModel> subReportBeanListBp;


    public List<SiswaModel> getSubReportBeanListSiswa() {
        return subReportBeanListSiswa;
    }

    public void setSubReportBeanListSiswa(List<SiswaModel> subReportBeanListSiswa) {
        this.subReportBeanListSiswa = subReportBeanListSiswa;
    }

    public List<BpModel> getSubReportBeanListBp() {
        return subReportBeanListBp;
    }

    public void setSubReportBeanListBp(List<BpModel> subReportBeanListBp) {
        this.subReportBeanListBp = subReportBeanListBp;
    }
}