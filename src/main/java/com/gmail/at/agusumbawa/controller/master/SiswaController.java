package com.gmail.at.agusumbawa.controller.master;

import com.gmail.at.agusumbawa.Main;
import com.gmail.at.agusumbawa.config.HibernateUtil;
import com.gmail.at.agusumbawa.config.SiswaUploadXls;
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
public class SiswaController implements Initializable {
    public TableView<SiswaModel> tblSiswa;
    public TableColumn<SiswaModel, String> columnNis;
    public TableColumn<SiswaModel, String> columnNama;
    public TextField txtNis;
    public TextField txtNama;
    public TextArea areaAlamat;
    public TextField txtGender;
    public TextField txtKelas;
    public TextField txtFile;
    public Button btnUpload;


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
        txtGender.setText(data.getGender());
        txtKelas.setText(data.getKelas());
        areaAlamat.setText(data.getAlamat());
    }


    public void loadData() {
        tblSiswa.getItems().clear();
        tblSiswa.getItems().addAll(dao.findAll());
    }

    public void setApplication(Main application) {
        this.application = application;
    }


    public void doBack(ActionEvent actionEvent) {
        this.application.showHome();
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

        SiswaUploadXls u = new SiswaUploadXls();
        u.save(txtFile.getText());


        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Sukses");
        alert.setHeaderText("Siswa");
        alert.setContentText("Daftar Siswa berhasil di upload");

        alert.showAndWait();











        loadData();
    }
}
