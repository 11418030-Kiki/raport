package com.gmail.at.agusumbawa.config;

import com.gmail.at.agusumbawa.dao.NilaiDao;
import com.gmail.at.agusumbawa.dao.SiswaDao;
import com.gmail.at.agusumbawa.entity.NilaiModel;
import com.gmail.at.agusumbawa.entity.SiswaModel;
import jxl.Sheet;
import jxl.Workbook;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Agus Suhardi on 2/17/2017.
 */
public class NilaiUploadXls {

    private static NilaiDao dao = HibernateUtil.getNilaiDao();
    private static SiswaDao siswaDao = HibernateUtil.getSiswaDao();



    private Workbook excelWorkbook;
    private Sheet excelSheet;

    NilaiUploadXls(String FilePath) throws Exception {
        File excelFile = new File(FilePath);
        excelWorkbook = Workbook.getWorkbook(excelFile);
        excelSheet = excelWorkbook.getSheet(0);
    }

    public String getString(int x, int y) throws Exception {
        try {
            return excelSheet.getCell(x, y).getContents();

        } catch (Exception ex) {
            throw new Exception("Data tidak ada");
        }
    }

    public NilaiUploadXls() {
    }

//    public static void main(String[] args) throws Exception {
public static void save(String path) throws Exception {
        NilaiModel dataNilai = new NilaiModel();
        List<String> listData = new ArrayList<>();
        List<SiswaModel> listSiswa = siswaDao.findAll();
        SiswaModel d;

        NilaiUploadXls tempExcel;
        tempExcel = new NilaiUploadXls(path);

        for (int ii=0; ii<listSiswa.size(); ii++) {

            for (int i = 1; i < tempExcel.excelSheet.getRows(); i++) {

                for (int j = 0; j < tempExcel.excelSheet.getColumns(); j++) {
                    System.out.print(tempExcel.getString(j, i) + " ");

                    listData.add(j, tempExcel.getString(j, i));
//                System.out.println(listData);
                }

                dataNilai.setPelajaran(listData.get(0));
                dataNilai.setKkm(Integer.parseInt(listData.get(1)));
                dataNilai.setKategori(listData.get(2));
                dataNilai.setNilai(Integer.parseInt(listData.get(3)));
                dataNilai.setSiswa(listSiswa.get(ii));

                dao.save(dataNilai);

                dataNilai = new NilaiModel();
                listData = new ArrayList<>();
            }
        }

    }


}