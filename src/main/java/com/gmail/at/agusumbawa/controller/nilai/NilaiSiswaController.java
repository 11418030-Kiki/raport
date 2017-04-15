package com.gmail.at.agusumbawa.controller.nilai;

import com.gmail.at.agusumbawa.Main;
import com.gmail.at.agusumbawa.config.HibernateUtil;
import com.gmail.at.agusumbawa.config.NilaiUploadXls;
import com.gmail.at.agusumbawa.dao.SiswaDao;
import com.gmail.at.agusumbawa.entity.SiswaModel;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Agus Suhardi on 3/5/2017.
 */
public class NilaiSiswaController implements Initializable {


    public TableView<SiswaModel> tblSiswa;
    public TableColumn<SiswaModel, String> columnNis;
    public TableColumn<SiswaModel, String> columnNama;
    public TextField txtNis;
    public TextField txtNama;
    public Button btnBP;
    public Button btnTadarus;
    public Button btnNilai;
    public TextField txtFile;
    public Button btnUpload;

    private BpController bpController;



    SiswaDao dao = HibernateUtil.getSiswaDao();
    private Main application;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadData();
        columnNis.setCellValueFactory(new PropertyValueFactory<SiswaModel, String>("nis"));
        columnNama.setCellValueFactory(new PropertyValueFactory<SiswaModel, String>("nama"));

        tblSiswa.getSelectionModel().selectedItemProperty()
                .addListener((ObservableValue<? extends SiswaModel> values, SiswaModel oldValue, SiswaModel newValue) -> {
                    setField(newValue);
                });

        btnUpload.setDisable(true);
    }
    public void setField(SiswaModel data) {
        txtNis.setText(data.getNis());
        txtNama.setText(data.getNama());
        btnBP.setDisable(false);
        btnNilai.setDisable(false);
        btnTadarus.setDisable(false);
    }



    public void loadData() {
        tblSiswa.getItems().clear();
        tblSiswa.getItems().addAll(dao.findAll());
        btnBP.setDisable(true);
        btnNilai.setDisable(true);
        btnTadarus.setDisable(true);
    }

    public void setApplication(Main application) {
        this.application = application;
    }


    public void doBack(ActionEvent actionEvent) {
        this.application.showHome();
    }

    public void showNilai(ActionEvent actionEvent) {
        this.application.showNilai(txtNis.getText());
    }

    public void showTadarus(ActionEvent actionEvent) {
        this.application.showTadarus(txtNis.getText());
    }

    public void showBP(ActionEvent actionEvent) {
        this.application.showBP(txtNis.getText());
    }

    public void doOpen(MouseEvent mouseEvent) {
        //select file
        FileChooser chooser = new FileChooser();
        File file = chooser.showOpenDialog(null);
        if (file != null){
            txtFile.setText(file.getAbsolutePath());
            btnUpload.setDisable(false);
        }
    }

    public void doUpload(ActionEvent actionEvent) throws Exception {

        NilaiUploadXls u = new NilaiUploadXls();
        u.save(txtFile.getText());

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Sukses");
        alert.setHeaderText("Nilai");
        alert.setContentText("Daftar Nilai Siswa berhasil di upload");

        alert.showAndWait();

        loadData();
    }
}
