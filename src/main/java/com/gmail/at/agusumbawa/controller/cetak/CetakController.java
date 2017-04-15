package com.gmail.at.agusumbawa.controller.cetak;

import com.gmail.at.agusumbawa.Main;
import com.gmail.at.agusumbawa.config.HibernateUtil;
import com.gmail.at.agusumbawa.dao.BpDao;
import com.gmail.at.agusumbawa.dao.NilaiDao;
import com.gmail.at.agusumbawa.dao.SiswaDao;
import com.gmail.at.agusumbawa.entity.*;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

import java.net.URL;
import java.util.*;

/**
 * Created by Agus Suhardi on 3/5/2017.
 */
public class CetakController implements Initializable {
    public TextField txtNis;
    private Main application;


    private SiswaDao dao = HibernateUtil.getSiswaDao();
    private NilaiDao dao_nilai = HibernateUtil.getNilaiDao();
    private BpDao bpDao = HibernateUtil.getBpDao();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void doBack(ActionEvent actionEvent) {
        this.application.showHome();
    }

    public void setApplication(Main application) {
        this.application = application;
    }

    public void btnCetak(ActionEvent actionEvent) {


        String masterReportFileName = "Main.jrxml";
        String subBp = "Bp.jrxml";
        String subTadarus = "Tadarus.jrxml";
        String subAkademis = "Akademis.jrxml";

        String destFileName = "Main.JRprint";

        DataBeanList DataBeanList = new DataBeanList();
        ArrayList<SiswaModel> dataList = DataBeanList.getDataBeanList(txtNis.getText());
        JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataList);

        try {
         /* Compile the master and sub report */
            JasperReport jasperMasterReport = JasperCompileManager.compileReport(masterReportFileName);
            JasperReport jasperSubBp = JasperCompileManager.compileReport(subBp);
            JasperReport jasperSubTadarus = JasperCompileManager.compileReport(subTadarus);
            JasperReport jasperSubAkademis = JasperCompileManager.compileReport(subAkademis);

            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("bp", jasperSubBp);
            parameters.put("tadarus", jasperSubTadarus);
            parameters.put("nilai", jasperSubAkademis);


            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperMasterReport, parameters, beanColDataSource);


            JasperViewer.viewReport(jasperPrint, false);

        } catch (JRException e) {

            e.printStackTrace();
        }
        System.out.println("Done filling!!! ...");
    }


}




