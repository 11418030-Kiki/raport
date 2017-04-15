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
public class UploadXls {
    private static SiswaDao dao = HibernateUtil.getSiswaDao();
    private static KelasDao kelasDao = HibernateUtil.getKelasDao();
    private static NilaiDao nilaiDao = HibernateUtil.getNilaiDao();
    private static AjaranDao ajaranDao = HibernateUtil.getAjaranDao();
    private static SmesterDao smesterDao = HibernateUtil.getSmesterDao();
    private static PelajaranDao pelajaranDao = HibernateUtil.getPelajaranDao();

    private Workbook excelWorkbook;
    private Sheet excelSheet;

    UploadXls(String FilePath) throws Exception{
        File excelFile= new File(FilePath);
        excelWorkbook = Workbook.getWorkbook(excelFile);
        excelSheet = excelWorkbook.getSheet(0);
    }

    public String getString(int x, int y) throws Exception{
        try {
            return excelSheet.getCell(x,y).getContents();

        }catch (Exception ex){
            throw new Exception("Data tidak ada");
        }
    }

    public UploadXls() {
    }

    //    public static void main(String[] args) throws Exception {
public void save(String path) throws Exception {
        SiswaModel s = new SiswaModel();
        NilaiModel n = new NilaiModel();
        List<String> listData = new ArrayList<>();


        UploadXls tempExcel;
        tempExcel = new UploadXls(path);

        for (int i = 1; i < tempExcel.excelSheet.getRows(); i++) {

            for (int j = 0; j < tempExcel.excelSheet.getColumns(); j++) {
                //System.out.print(tempExcel.getString(j, i)+ " ");

                listData.add(j, tempExcel.getString(j, i));
                System.out.println(listData);



            }

            KelasModel k = kelasDao.findById(listData.get(11).trim());
            AjaranModel ajaran = ajaranDao.findById(listData.get(12).trim());
            SmesterModel smester = new SmesterModel();
            smester.setSmester(1);


            System.out.println("data ku");
            System.out.println(k.getKelas());
            System.out.println(ajaran.getAjaran());
//            System.out.println(smester.getSmester());

            if (k != null && ajaran !=null) {


                s.setNis(listData.get(0));
                s.setNama(listData.get(1));
                s.setTempatLahir(listData.get(2));
                s.setTanggalLahir(listData.get(3));
                s.setGender(listData.get(4));
                s.setAsal_sekolah(listData.get(5));
                s.setCitaCita(listData.get(6));
                s.setJumlahSaudara(Integer.parseInt(listData.get(7)));
                s.setNamaAyah(listData.get(8));
                s.setAlamat(listData.get(9));
                s.setAgama(listData.get(10));
                s.setKelas(k);

                dao.save(s);

                List<PelajaranModel> listPelajaran = pelajaranDao.findAll();
                for(int u=0; u<listPelajaran.size(); u++) {

                    n.setSiswa(s);
                    n.setAjaran(ajaran);
                    n.setPelajaran(pelajaranDao.findById(listPelajaran.get(0).getPelajaran()));
                    n.setNilai(0);
                    n.setSmester(smester);
                    nilaiDao.save(n);
                    n = new NilaiModel();
                }





                s = new SiswaModel();
                listData = new ArrayList<>();
            }else {
                System.out.println("data kelas belum ada");
            }
        }

    }







}
