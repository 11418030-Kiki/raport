package com.gmail.at.agusumbawa.config;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.gmail.at.agusumbawa.dao.*;
import com.gmail.at.agusumbawa.entity.*;
import jxl.Workbook;
import jxl.Sheet;


/**
 * Created by Agus Suhardi on 2/17/2017.
 */
public class SiswaUploadXls {

    private static SiswaDao dao = HibernateUtil.getSiswaDao();
    private static NilaiDao daoNilai = HibernateUtil.getNilaiDao();


    private Workbook excelWorkbook;
    private Sheet excelSheet;

    SiswaUploadXls(String FilePath) throws Exception {
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

    public SiswaUploadXls() {
    }

    //        public static void main(String[] args) throws Exception {
    public static void save(String path) throws Exception {
        SiswaModel dataSiswa = new SiswaModel();
        List<NilaiModel> listNilai = daoNilai.findAll();

        List<String> listData = new ArrayList<>();

        SiswaUploadXls tempExcel;
        tempExcel = new SiswaUploadXls(path);

        for (int i = 2; i < tempExcel.excelSheet.getRows(); i++) {

            for (int j = 0; j < tempExcel.excelSheet.getColumns(); j++) {
                listData.add(j, tempExcel.getString(j, i));
            }

            //set value
            dataSiswa.setNis(listData.get(0));
            dataSiswa.setNama(listData.get(1));
            dataSiswa.setGender(listData.get(2));
            dataSiswa.setAlamat(listData.get(3));
            dataSiswa.setKelas(listData.get(4));
            dataSiswa.setAjaran(listData.get(5));
            dataSiswa.setSmester(Integer.valueOf(listData.get(6)));
            dataSiswa.setSakit(Integer.valueOf(listData.get(7)));
            dataSiswa.setIjin(Integer.valueOf(listData.get(8)));
            dataSiswa.setTk(Integer.valueOf(listData.get(9)));
            dataSiswa.setTanggal(listData.get(10));
            dataSiswa.setLokasi(listData.get(11));
            dataSiswa.setTema(listData.get(12));
            dataSiswa.setNilai_lapangan(Integer.valueOf(listData.get(13)));
            dataSiswa.setWali_kelas(listData.get(14));
            dataSiswa.setNip(listData.get(15));
            dataSiswa.setCatatan(listData.get(16));

            //simpan siswa
            dao.save(dataSiswa);

            //kosongkan object
            listData = new ArrayList<>();
            dataSiswa = new SiswaModel();

        }
    }
}
