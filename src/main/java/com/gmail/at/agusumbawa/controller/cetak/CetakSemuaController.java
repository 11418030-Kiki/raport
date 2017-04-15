package com.gmail.at.agusumbawa.controller.cetak;

import com.gmail.at.agusumbawa.Main;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by Agus Suhardi on 3/5/2017.
 */
public class CetakSemuaController implements Initializable{
    private Main application;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void btnCetakSemua(ActionEvent actionEvent) {
/*
        try {
            File file = new File("D:\\JaspersoftWorkspace\\MyReports\\a.jrxml");
            JasperDesign design = JRXmlLoader.load(file);
            //HashMap hashMap = new HashMap();
            //hashMap.clear();
            JasperReport jasperReport = JasperCompileManager.compileReport(design);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException e) {
            e.printStackTrace();
            System.out.println("Kelasalahn pada "+e.getMessage());
        }
*/


        try {

            File file=new File("D:\\JaspersoftWorkspace\\MyReports\\header.jrxml");
            InputStream stream=new FileInputStream(file);
            JasperDesign design=JRXmlLoader.load(stream);
            JasperReport report=JasperCompileManager.compileReport(design);

            Map<String, Object> params=new HashMap<String, Object>();
            params.put("param1", "data1"); // note here you can add parameters which would be utilized by the report

            JasperPrint print=JasperFillManager.fillReport(report, params,new JREmptyDataSource());
            //use JasperExportManager to export report to your desired requirement
            JasperViewer.viewReport(print, false);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Membuka Laporan","Cetak Laporan",JOptionPane.ERROR_MESSAGE);
        }


    }

    public void setApplication(Main application) {
        this.application = application;
    }
}
