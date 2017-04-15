package com.gmail.at.agusumbawa.controller;

import com.gmail.at.agusumbawa.Main;
import com.gmail.at.agusumbawa.config.HibernateUtil;
import com.gmail.at.agusumbawa.dao.BpDao;
import com.gmail.at.agusumbawa.dao.NilaiDao;
import com.gmail.at.agusumbawa.dao.SiswaDao;
import com.gmail.at.agusumbawa.dao.TadarusDao;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * Created by Agus Suhardi on 2/7/2017.
 */
public class HomeController implements Initializable {

    public ImageView imgHome;
    private SiswaDao siswaDao = HibernateUtil.getSiswaDao();
    private NilaiDao nilaiDao = HibernateUtil.getNilaiDao();
    private BpDao bpDao = HibernateUtil.getBpDao();
    private TadarusDao tadarusDao = HibernateUtil.getTadarusDao();


    @FXML
    public MenuItem mnClose;
    @FXML
    MenuItem mnPegawai;
    private Main application;


    public void initialize(URL location, ResourceBundle resources) {


    }


    public void setApplication(Main application) {
        this.application = application;
    }


    public void onClose(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Keluar dari Program?", ButtonType.YES, ButtonType.CANCEL);
        alert.showAndWait();

        if (alert.getResult() == ButtonType.YES) {
            Platform.exit();
        }
    }

    public void showSiswa(ActionEvent actionEvent) {
        this.application.showSiswa();
    }

    public void showPelajaran(ActionEvent actionEvent) {
//        this.application.showPelajaran();
    }

    public void showNilaiSiswa(ActionEvent actionEvent) {
        this.application.showNilaiSiswa();
    }

    public void showLaporan(ActionEvent actionEvent) {
        this.application.showCetak();
    }

    public void showKosongkan(ActionEvent actionEvent) {

        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Hapus");
        dialog.setHeaderText("Yakin Ingin Menghapus Seluruh Data ??\n Ketik *Hapus* untuk jika setuju!");
        dialog.setContentText("");

// Traditional way to get the response value.
        Optional<String> result = dialog.showAndWait();

// The Java 8 way to get the response value (with lambda expression).
        result.ifPresent(name -> hapus(name));






    }
    void hapus(String hapus){
        if (hapus.equals("Hapus")) {
            bpDao.deleteAll();
            tadarusDao.deleteAll();
            nilaiDao.deleteAll();
            siswaDao.deleteAll();

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Informasi");
            alert.setHeaderText("SUKSES");
            alert.setContentText("Data berhasil di hapus");
            alert.showAndWait();


        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Informasi");
            alert.setHeaderText("Teks yang di masukan salah");
            alert.setContentText("Data tidak di hapus");
            alert.showAndWait();
        }
    }
}
