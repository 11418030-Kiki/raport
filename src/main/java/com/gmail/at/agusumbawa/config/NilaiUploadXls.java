package com.gmail.at.agusumbawa.config;

import jxl.Sheet;
import jxl.Workbook;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Agus Suhardi on 2/17/2017.
 */
public class PelajaranUploadXls {

    private static PelajaranDao dao = HibernateUtil.getPelajaranDao();


    private Workbook excelWorkbook;
    private Sheet excelSheet;

    PelajaranUploadXls(String FilePath) throws Exception {
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

    public PelajaranUploadXls() {
    }

//    public static void main(String[] args) throws Exception {
public static void save(String path) throws Exception {
        PelajaranModel pelajaranData = new PelajaranModel();
        List<String> listData = new ArrayList<>();


        PelajaranUploadXls tempExcel;
        tempExcel = new PelajaranUploadXls(path);

        for (int i = 1; i < tempExcel.excelSheet.getRows(); i++) {

            for (int j = 0; j < tempExcel.excelSheet.getColumns(); j++) {
                //System.out.print(tempExcel.getString(j, i)+ " ");

                listData.add(j, tempExcel.getString(j, i));
//                System.out.println(listData);
            }

            pelajaranData.setPelajaran(listData.get(0));
            pelajaranData.setKkm(Integer.parseInt(listData.get(1)));
            pelajaranData.setKategori(listData.get(2));
            pelajaranData.setUrutan_kategori(Integer.parseInt(listData.get(3)));


            dao.save(pelajaranData);
            pelajaranData = new PelajaranModel();
            listData = new ArrayList<>();
        }

    }


}
